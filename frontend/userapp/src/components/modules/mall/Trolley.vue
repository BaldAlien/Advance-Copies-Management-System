<template>
     <!-- :style="{ backgroundImage: 'url(' + trolleyImg + ')' }"
      style="background-size: cover"  -->
  <div id="trolley-wrapper">
    <div
      id="trolley-button"
      @click="isTrolleyShow = true"
      class="trobutton"
    >
    <el-icon :size="35" style="vertical-align: middle" class="elicon"><Document /></el-icon>
    </div>

    <el-drawer
      v-model="isTrolleyShow"
      :direction="direction"
      :with-header="false"
      :size="trolleySize"
      destroy-on-close
    >
      <div class="trolley-header">
        <div>
          <el-icon :size="16" style="vertical-align: middle"><Document /></el-icon>
        </div>
        <div class="title">样书申请列表</div>
        <div class="close-button" @click="isTrolleyShow = false">
        </div>
      </div>
      <div class="trolley-container">
        <div class="list-wrapper">
          <div class="list-item" v-for="(item, index) in trolley" :key="index">
            <el-card shadow="hover">
              <div class="list-item-container">
                <div class="container-main">
                  <img :src="item.imgSrc" class="list_img"/>
                  <div class="list-item-title">
                    {{ item.title }}
                  </div>
                  <div class="list-item-content">
                    <div class="description">
                      {{ item.specification_name }}
                    </div>
                    <div class="price"> {{ item.points }}积分/本 </div>
                  </div>
                </div>
                <div class="num-button">
                  <i class="el-icon-minus" @click="subNum(item, index)"></i>
                  <span class="num-counts"> {{ item.count }}</span>
                  <i class="el-icon-plus" @click="addNum(item)"></i>
                </div>
              </div>
            </el-card>
          </div>
        </div>
      </div>
      <div class="trolley-footer">
        <div class="total-price">
          合计：
          <span> {{ totalPrice }}积分 </span>
        </div>
        <div class="pay"><el-button @click="doSettlement">申请</el-button></div>
      </div>
    </el-drawer>
  </div>
</template>

<script lang="ts" setup>
import {Document} from "@element-plus/icons-vue";
</script>

<script lang="ts">
import { ElMessage } from "element-plus";
import { _updateShoppingCart, _getShoppingCart } from "../../../api/mall/mall";
import trolleyImg from "../../../assets/images/modules/mall/list-transparent.png";
import store from "../../../store";
export default {
  data() {
    return {
      isTrolleyShow: false,
      trolleyImg,
      trolleySize: "380px",
      direction: "rtl",
      sum: 0,
      money: 0,

      trolley: [

      ],
    };
  },
  props: ["productInCart"],

  methods: {
    addNum(item) {
      item.count++;
      this.updateShoppingCart();
    },
    subNum(item, index) {
      item.count--;
      if (item.count <= 0) {
        this.trolley.splice(index, 1);
      }
      this.updateShoppingCart();
    },
    setTrolleySize(width) {
      if (width < 480) {
        this.trolleySize = "100%";
      } else {
        this.trolleySize = "380px";
      }
    },
    getTrolley() {
      let temp = JSON.parse(localStorage.getItem("trolley"));
      if (temp !== null) {
        this.trolley = temp.trolley;
      }
      _getShoppingCart()
        .then((res) => {
          if (res.code === 0) {
            console.log(res.data.message);
            this.trolley = res.data.trolley;
            console.log(res.data.trolley);
          } else {
            console.log(res.data.message);
          }
        })
        .catch((err) => {
          console.log("获取购物车失败！");
        });
    },
    saveTrolley() {
      let trolleyWrapper = {
        trolley: this.trolley,
      };
      localStorage.setItem("trolley", JSON.stringify(trolleyWrapper));
    },
    doSettlement() {
      if (this.totalPrice !== 0) {
        this.$router.push({
          path: "/settlement",
          query: { return: this.$route.path },
        });
      } else {
        ElMessage.warning({
          message: "你还没有选入任何商品",
          type: "warning",
        });
      }
    },
    updateShoppingCart() {
      this.saveTrolley();
      let trolleyDto = {
        trolley: this.trolley,
      };
      _updateShoppingCart(trolleyDto)
        .then((res) => {
          if (res.code === 0) {
            console.log(res.data.message);
          } else {
            console.log(res.data.message);
          }
        })
        .catch((err) => {
          console.log("更新购物车失败！");
        });
    },
  },
  computed: {
    totalPrice() {
      let sum = 0;
      for (let item of this.trolley) {
        sum += item.count * item.points;
      }
      return sum;
    },
    getWidth() {
      return store.state.width;
    },
  },
  mounted() {
    this.getTrolley();
  },
  watch: {
    getWidth(width) {
      this.setTrolleySize(width);
    },
    productInCart(val) {
      if (localStorage.getItem("token") === null) {
        this.$router.push({
          path: "/login",
          query: { return: this.$route.path },
        });
        return;
      }
      console.log(this.trolley);
      for (let item of this.trolley) {
        if (item.bookId === val.bookId ) {
          item.count++;
          this.isTrolleyShow = true;
          this.updateShoppingCart();
          return;
        }
      }
      console.log(val);
      let item = {
        bookId: val.bookId,
        title: val.title,
        imgSrc:val.imgSrc,
        count: 1,
        points: val.points,
      };
      this.trolley.push(item);
      console.log(this.trolley);
      this.isTrolleyShow = true;
      this.updateShoppingCart();
    },
  },
};
</script>

<style  lang="scss" scoped>
/*滚动条bai整体*/
::-webkit-scrollbar{
width:5px; /*滚动条宽度*/
}
/*滚动条按钮*/
// ::-webkit-scrollbar-button {
// }
::-webkit-scrollbar-track{
background-color:#F3F3F3; /*滑道全部*/
}
::-webkit-scrollbar-track-piece{
background-color:#F3F3F3; /*滑道*/
border-radius:4px; /*滑道圆角宽度*/
}
::-webkit-scrollbar-thumb{
background-color:#F3F3F3; /*滑动条表面*/
border:solid 0.5px #C0C0C0; /*滑动条边框*/
border-radius:4px; /*滑动条圆角宽度*/
}
/*横竖滚动条交角*/
::-webkit-scrollbar-corner {
background-color: #F3F3F3;
}
/*横竖滚动条交角图案*/
::-webkit-resizer {
/*background-image: url(/public/img/resizer-inactive.png);*/
background-repeat: no-repeat;
background-position: bottom right;
}
/*鼠标滑过滑动条*/
::-webkit-scrollbar-thumb:hover{
background-color:#F3F3E0;
}
#trolley-wrapper {
  .trobutton{
    text-align: center;
    line-height: 64px;
    .elicon{
      margin: 0 auto;
    }
  }
  position: relative;
  #trolley-button {
    position: fixed;
    right: 5%;
    bottom: 15%;
    width: 64px;
    height: 64px;
    border-radius: 50%;
    background-size: 40%;
    background-repeat: no-repeat;
    background-position: 50% 50%;
    box-shadow: 0px 3px 3px rgb(167, 160, 160);
    z-index: 5;
    background-color: #fff;
    cursor: pointer;
    &:hover {
      background-color: #bbddffb9;
      color: white;
      transition: 0.25s;
    }
  }

  .trolley-header {
    display: flex;
    font-size: 32px;
    padding: 30px;
    background-color: rgb(250, 250, 250);
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
    position: relative;
    i {
      font-size: 42px;
    }
    .close-button {
      position: absolute;
      right: 40px;
      cursor: pointer;
      @media screen and (min-width: 480px) {
        display: none;
      }
      &:hover {
        color: #409eff;
        transition-duration: 0.2s;
        transition-timing-function: ease-in-out;
      }
    }
  }
  .trolley-container {
    height: calc(100vh - 105px);
  }
  .list-wrapper {
    overflow: auto;
    height: 100%;
    overflow: auto;
    padding-bottom: 85px;
    box-sizing: border-box;
    .list-item {
      padding: 10px;
      box-sizing: border-box;
      .list-item-container {
        display: flex;
        .container-main {
          flex-basis: 70%;
          .list_img{
            width: 200px;
            height: 180px;
          }
          .list-item-title {
            font-size: 22px;
            margin-bottom: 5px;
          }
          .list-item-content {
            font-size: 16px;
            .description {
              color: #808080;
              margin-bottom: 5px;
            }
            .price {
              font-size: 18px;
            }
          }
        }

        .num-button {
          display: flex;
          justify-content: center;
          align-items: center;
          flex-basis: 30%;
          i {
            cursor: pointer;
            font-size: 24px;
            &:hover {
              color: #409eff;
              transition-duration: 0.2s;
              transition-timing-function: ease-in-out;
            }
          }
          .num-counts {
            font-size: 26px;
            margin-left: 10px;
            margin-right: 10px;
          }
        }
      }
    }
  }
  .trolley-footer {
    position: absolute;
    display: flex;
    justify-content: space-between;
    align-items: center;
    bottom: 0;
    display: flex;
    font-size: 20px;
    width: 100%;
    padding: 20px 20px 20px 20px;
    background-color: rgb(250, 250, 250);
    box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
    .total-price span {
      color: #ff6a00;
      font-size: 22px;
    }
  }
}

#trolleyHead {
  background-color: rgb(71, 70, 70);
  color: white;
  height: 40px;
  text-align: left;
  display: inline block;
}
#trolleyBody {
  height: 80%;
  display: inline block;
  text-align: left;
}
#trolleyFoot {
  height: 20%;
  display: flex;
  text-align: left;
}
#IMG {
  width: auto;
  height: 70%;
  margin-top: 5px;
  margin-left: 7px;
}
.totalMoney {
  line-height: 110px;
  width: 150px;
  height: 100%;
  flex: 0 0 65%;
}

.sumButton {
  border-radius: 50%;
  width: 15px;
  height: 15px;
  text-align: center;
  line-height: 15px;
  border: 1px solid black;
}
.produces {
  width: 90%;
  height: 100px;
  margin-top: 15px;
  display: flex;
  border: 1px solid black;
}
.Sum {
  width: 100%;
  height: 32%;
  margin-top: 18px;
  display: flex;
}
.money {
  width: 100%;
  height: 50%;
  line-height: 50px;
}
.producesName {
  width: 50%;
  height: 100%;
  text-align: center;
  line-height: 100px;
}
.producesSum {
  width: 50%;
  height: 100%;
}
</style>