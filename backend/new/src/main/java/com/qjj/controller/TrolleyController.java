package com.qjj.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qjj.model.entity.*;
import com.qjj.constant.Constant;
import com.qjj.service.*;
import com.qjj.utils.DateUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qjj.utils.JWTUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "申请清单接口")
@Slf4j
@RestController
@RequestMapping("/mall")
public class TrolleyController {

    @Autowired
    private TrolleyService trolleyService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private PointsService pointsService;

    @Autowired HistoryService historyService;

    @RequestMapping(path = "/cart", method = {RequestMethod.GET})
    @ResponseBody
    public Object getShoppingCart(@RequestHeader("token") String token) {
        //创建响应类
        Response res = new Response();

        int user_id = JWTUtils.getUserId(token);
//        int user_id =1;
        try {
            List<TrolleyShow> list = trolleyService.entry(user_id);
//            log.info("{}",list);
            res.code = 0;
            res.data.put("message", "成功");
            ArrayList<TrolleyShow> TrolleyShowArrayList = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                TrolleyShow showObj = list.get(i);
                sum = sum + showObj.getCount() * showObj.getPoints();
                TrolleyShowArrayList.add(showObj);
            }
            res.data.put("trolley", TrolleyShowArrayList);
            res.data.put("sum", sum);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 1;
            res.data.put("message", "失败");
        }
        return res;
    }


    /*
     * 更新购物车
     * */
    @RequestMapping(path = "/cart", method = {RequestMethod.POST})
    @ResponseBody
    public Object updateShoppingCart(@RequestHeader("token") String token, @RequestBody JSONObject jsonObj) {

        Response res = new Response();
        int user_id = JWTUtils.getUserId(token);
        //    定义购物车对象数组
        ArrayList<Trolley> cartObjList = new ArrayList<Trolley>();
        //   获取商品数组
        JSONArray jsonArray = jsonObj.getJSONArray("trolley");
        for (int i = 0; i < jsonArray.size(); i++) {        //遍历申请列表数据
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int book_id = jsonObject.getIntValue("bookId");
            int count = jsonObject.getIntValue("count");
            cartObjList.add(new Trolley(user_id, book_id, count));
        }
        try {
            trolleyService.deleteProductsByUserId(user_id);
        } catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_UPDATE_SHOPPING_CART;
            res.data.put("message", "更新购物车失败");
        }
        try {
            for (Trolley trolley : cartObjList) {
                Trolley checkCart = trolleyService.checkCart(trolley); //当前数据库中用户申请列表是否为空
                if (checkCart == null) {
                    trolleyService.insertCart(trolley);
                }else {
                    trolleyService.updateProduct(trolley);
                }
            }
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "更新购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_UPDATE_SHOPPING_CART;
            res.data.put("message", "更新购物车失败");
        }
        return res;
    }


    @RequestMapping(path = "/cart/settlement", method = {RequestMethod.GET})
    @ResponseBody
    public Object ClearCart(@RequestHeader("token") String token) {
        Response res = new Response();
        int user_id = JWTUtils.getUserId(token);
        int amount = 0;
        int remanentPoints = trolleyService.checkPoints(user_id);
        if(remanentPoints<=0){
            res.code=1;
            res.data.put("message","账户剩余积分不足");
            return res;
        }
        try{
            List<TrolleyShow> trolley = trolleyService.entry(user_id);      //获取用户的样书申请列表
            for (TrolleyShow i : trolley) {
                amount = amount + i.getCount() * i.getPoints();    //遍历申请列表算总共所需要积分
            }
            if(amount>remanentPoints){
                res.code = 1;
                res.data.put("message", "账户剩余积分不足");
                return res;
            }
            //     创建历史样书申请记录
            for (TrolleyShow i : trolley) {
                History history=new History(user_id,i.getBookId(),i.getTitle(),i.getCount(),i.getPoints(), DateUtils.getCurrentDatetime());
                try {
                    historyService.createHistory(history);
                }catch (Exception e) {
                    e.printStackTrace();
                    res.code = 1;
                    res.data.put("message","创建历史记录失败");
                    return res;
                }
                Trolley trolley1 = new Trolley(user_id,i.getBookId(),i.getCount());
                trolleyService.deleteProduct(trolley1);     //清空申请列表
            }
            Points points=new Points(user_id,remanentPoints - amount);
            try {
                pointsService.updatePointsById(points);     //更新用户积分
            }catch (Exception e) {
                e.printStackTrace();
                res.code = 1;
                res.data.put("message","更新剩余积分失败");
                return res;
            }

        }catch (Exception e) {
            e.printStackTrace();
            res.code = 1;
            res.data.put("message", "申请失败");
        }


        res.code = 0;
        res.data.put("message", "申请成功");
        return res;
    }

    @RequestMapping(path = "/checkPoints", method = {RequestMethod.GET})
    @ResponseBody
    public Object RemanentPoints(@RequestHeader("token") String token) {
        Response res = new Response();

        int user_id = JWTUtils.getUserId(token);

        try {
            int points = trolleyService.checkPoints(user_id);

            res.code = 0;

            res.data.put("message","查询余额成功");
            res.data.put("balance",points);

        } catch (Exception e) {

            res.code = 1;
            res.data.put("message","查询余额失败");
            res.data.put("balance",null);
            e.printStackTrace();

        }

        return res;
    }

}
