<template>
  <div id="personal-data">
    <div id="header">
      <div id="title">个人中心</div>
    </div>
    <div id="container">
      <!-- <el-affix target="#container" :offset="80" id="side-menu-wrapper">
        <div id="side-menu">
          <div class="menu-item" @click="goAnchor('account')">
            <i class="el-icon-user-solid"></i>
            <div class="menu-item-descript">基本信息</div>
          </div>
          <div class="menu-item" @click="goAnchor('purchase')">
            <i class="el-icon-s-goods"></i>
            <div class="menu-item-descript">历史申请</div>
          </div>
        </div>
      </el-affix> -->

      <div id="list-wrapper">
        <div class="list-item">
          <div class="anchor" id="account"></div>
          <div class="item-header">
            <div class="title">基本信息</div>
            <el-button @click="enterEdit" id="edit-button">编辑</el-button>
          </div>
          <el-divider></el-divider>
          <el-descriptions title="" :column="columnSize" border>
            <el-descriptions-item label="用户名">
              <span>{{ userInfo.userName }}</span>
            </el-descriptions-item>
            <el-descriptions-item label="邮箱">
              <span>{{ userInfo.email }}</span>
            </el-descriptions-item>
            <el-descriptions-item label="收货人">
              <span>{{ userInfo.consignee }}</span>
            </el-descriptions-item>
            <el-descriptions-item label="联系电话">
              <span>{{ userInfo.phoneNum }}</span>
            </el-descriptions-item>
            <el-descriptions-item label="收货地址">
              <span>{{ userInfo.address }}</span>
            </el-descriptions-item>
            <el-descriptions-item label="教师认证">
              <span>{{ userInfo.certify }}</span>
              <!-- <el-button round size="small" @click="enterCertify">前往认证</el-button> -->
            </el-descriptions-item>
          </el-descriptions>

          <div class="account-item-footer">
            <div class="balance-wrapper">
              <span class="balance-descript"> 剩余积分：  </span>
              <span class="balance-number">{{points}}</span>
            </div>
          </div>
        </div>

        <div class="list-item card-show" id="purchase-wrapper">
          <div class="anchor" id="purchase"></div>
          <div class="item-header">
            <div class="title">历史申请</div>
          </div>
          <!-- <el-divider></el-divider> -->
          <el-empty
            description="您还未申请过样书"
            :image-size="64"
            v-if="history.length === 0"
          ></el-empty>
          <div class="product-list-wrapper">
            <div
              class="product-list-item"
              v-for="(pItem, pIndex) in history"
              :key="pIndex"
            >
              <el-card class="box-card" shadow="hover">
                <template #header>
                  <div class="card-header">
                    <span>{{ pItem.title }}</span>
                    <span class="count">        ×{{pItem.count}}</span>
                    <span class="sum">   {{pItem.count*pItem.points}}积分</span>
                  </div>
                </template>
                <div class="card-content">
                  <div class="content-descript">
                    订单号： {{ pItem.historyId }}
                  </div>
                  <div class="content-time">
                    <span>申请时间： </span>{{ pItem.transactionTime }}
                  </div>
                </div>
                <div class="card-button">
                    <el-button round class="cardButton" style="margin-left:45%">查看物流</el-button>
                    <el-button round class="cardButton" @click="submitReview(pItem.bookId,pItem.historyId)">提交书评</el-button>
                </div>
              </el-card>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div id="dialog-wrapper">
    <el-dialog
      title="修改信息"
      v-model="infoEdit"
      :width="dialogWidth"
      :fullscreen="dialogFull"
    >
      <el-form
        :model="info"
        :label-position="labelPosition"
        :rules="rules"
        ref="info"
      >
        <el-form-item label="邮箱" :label-width="formLabelWidth" prop="email">
          <el-input v-model="info.email"></el-input>
        </el-form-item>
        <el-form-item label="收货人" :label-width="formLabelWidth" prop="consignee">
          <el-input v-model="info.consignee"></el-input>
        </el-form-item>
        <el-form-item
          label="联系电话"
          :label-width="formLabelWidth"
          prop="phone_num">
          <el-input v-model="info.phone_num"></el-input>
        </el-form-item>
        <el-form-item label="收货地址" :label-width="formLabelWidth" prop="address">
          <el-input v-model="info.address"></el-input>
        </el-form-item>
      </el-form>

      <div id="dialog-footer">
        <div>
          <el-button @click="cancelEdit">取 消</el-button>
        </div>
        <div>
          <el-button type="primary" @click="editForm('info')">确 定</el-button>
        </div>
      </div>
    </el-dialog>

    <el-dialog
      title="提交书评"
      v-model="reviewInfo"
      :width="dialogWidth"
      :fullscreen="dialogFull"
    >
      <el-form
        :model="reviewData"
        :label-position="labelPosition"
        :rules="rules"
        ref="reviewData"
      >
        <el-input
          v-model="reviewData"
          :rows="6"
          type="textarea"
          placeholder="Please input"
          style="margin-bottom:30px"
        />
      </el-form>

      <div id="dialog-footer">
        <div>
          <el-button @click="cancelSubmitReview">取 消</el-button>
        </div>
        <div>
          <el-button type="primary" @click="submitReviewFrom()">确 定</el-button>
        </div>
      </div>
    </el-dialog>
    <el-dialog
      title="教师身份认证"
      v-model="certify"
      :width="dialogWidth"
      :fullscreen="dialogFull"
    >
      <div id="topUpWrapper">
        <el-form
          :model="certifyInfo"
          :label-position="labelPosition"
          ref="certifyInfo"
        >
          <el-form-item label="姓名" :label-width="formLabelWidth" prop="sex">
            <el-input v-model="info.email"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="certify = false">取 消</el-button>
          <el-button type="primary" @click="isTopUP = false">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const textarea = ref('')
</script>

<script lang="ts">
import { ElMessage } from "element-plus";
import {
  _getUserInfo,
  _updateUserInfo,
  _getUserPoints,
  _getUserHistory,
} from "../../../api/user/user";
import alipay from "../../../assets/images/modules/top-up/alipay.jpg";

import store from "../../../store";
export default {
  name: "PersonalData",
  data() {
    let validatePhone = (rule, value, callback) => {
      if (!/^\d+$/.test(value)) {
        callback(new Error("请输入数字值"));
      } else {
        if (value.length != 11) {
          callback(new Error("手机必须为11位"));
        } else {
          callback();
        }
      }
    };
    let validateEmail = (rule, value, callback) => {
      let myreg =
        /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
      if (!myreg.test(value)) {
        callback(new Error("邮箱格式不对"));
      } else {
        callback();
      }
    };
    return {
      alipay,
      certify: false,
      infoEdit: false,
      reviewInfo:false,
      columnSize: 1,
      dialogWidth: "60%",
      dialogFull: false,
      labelPosition: "right",
      formLabelWidth: "80px",
      points: 0,
      bookId:0,
      historyId:0,
      info: {
        email: "",
        consignee:"",
        phone_num: "",
        address: "",
      },
      reviewData:"",
      history: [],
      userInfo: {},
      trial: [],
      rules: {
        phone_num: [{ validator: validatePhone, trigger: "blur" }],
        email: [{ validator: validateEmail, trigger: "blur" }],
      },
      infoBackup: {},
    };
  },
  components: {},
  methods: {
    submitReviewFrom(){
      let reviewFrom={
        bookId:this.bookId,
        userId:this.userInfo.userId,
        historyId:this.historyId,
        review:this.reviewData,
      }
      console.log(reviewFrom);
      this.reviewInfo = false;
    },
    editForm(info) {
      this.$refs[info].validate((valid) => {
        if (valid) {
          let userInfoDto = {
            email: this.info.email,
            consignee:this.info.consignee,
            phone_num: this.info.phone_num,
            address:this.info.address
          };
          _updateUserInfo(userInfoDto)
            .then((res) => {
              if (res.code === 0) {
                ElMessage.success({
                  offset: 60,
                  message: res.data.message,
                  type: "success",
                });
                this.infoEdit = false;
              } else {
                ElMessage.error({
                  offset: 60,
                  message: res.data.message,
                  type: "error",
                });
              }
            })
            .catch((err) => {
              ElMessage.error({
                offset: 60,
                message: "更新个人信息失败！",
                type: "error",
              });
            });
            this.$router.go(0);
            } else {
              console.log("error submit!!");
            }
          });
    },
    goAnchor(index) {
      let anchor = document.getElementById(index);
      if (anchor !== null) anchor.scrollIntoView();
    },
    // 获取用户信息
    getInfo() {
      if (localStorage.getItem("token") === null) {
        this.$router.push({
          path: "/login",
          query: { return: this.$route.path },
        });
        return;
      }
      _getUserInfo().then((res) => {
        if (res.code === 0) {
          console.log(res.data);
          this.userInfo = res.data.infoList[0];
          this.info.email=this.userInfo.email;
          this.info.consignee=this.userInfo.consignee;
          this.info.phone_num=this.userInfo.phoneNum;
          this.info.address=this.userInfo.address;
        } else {
          throw err;
        }
      });
      _getUserHistory().then((res) => {
        if (res.code === 0) {
          console.log(res.data);
          this.history = res.data.historyList;
        } else {
          throw err;
        }
      });
      _getUserPoints().then((res) => {
        if (res.code === 0) {
          console.log(res.data.message);
          this.points = res.data.points;
        } else {
          throw err;
        }
      });
    },

    setDialogSize(width) {
      if (width < 720) {
        this.labelPosition = "top";
        this.dialogFull = true;
      } else {
        this.labelPosition = "right";
        this.dialogFull = false;
      }
    },
    enterEdit() {
      this.infoEdit = true;
      this.infoBackup = JSON.parse(JSON.stringify(this.info));
    },
    enterCertify() {
      this.certify = true;
      // this.infoBackup = JSON.parse(JSON.stringify(this.info));
    },
    cancelEdit() {
      this.infoEdit = false;
      this.info = this.infoBackup;
    },
    submitReview(bookId,history){
      this.bookId=bookId;
      this.historyId=history;
      this.reviewInfo = true;
    },
    cancelSubmitReview() {
      this.reviewInfo = false;
      this.info = this.infoBackup;
    },
  },
  mounted() {
    // this.getUserInfo();
    this.getInfo();
    this.setDialogSize(window.innerWidth);
  },
  computed: {
    getWidth() {
      return store.state.width;
    },
  },
  watch: {
    getWidth(width) {
      this.setDialogSize(width);
    },
  },
};
</script>
<style lang="scss">
#topUpWrapper {
  background: #f7f8fa;
  .imgWrapper {
    background-position: 50% 50%;
    height: 50vh;
    background-size: contain;
    background-repeat: no-repeat;
  }
}
</style>
<style  lang="scss" scoped>
* {
  background: #f7f8fa;
}
#personal-data {
  background: #f7f8fa;
  height: 100%;
  box-sizing: border-box;
  #header {
    line-height: 48px;
    font-size: 36px;
    font-weight: bold;
    display: flex;
    justify-content: space-between;
    padding: 0 15% 40px 15%;
    @media screen and(max-width:1080px) {
      padding: 10px 20px 40px 20px;
    }
    @media screen and(max-width:720px) {
      padding: 10px 0 40px 10px;
    }
  }

  padding: 40px;
  @media screen and (max-width: 720px) {
    padding: 20px;
  }
  @media screen and (max-width: 360px) {
    padding: 10px;
  }
  #container {
    padding: 0px 15% 40px 15%;
    box-sizing: border-box;
    display: flex;
    justify-content: space-between;
    @media screen and(max-width:1080px) {
      padding: 0 20px 40px 20px;
    }
    @media screen and(max-width:720px) {
      padding: 0 0 40px 0;
    }
    #side-menu-wrapper {
      width: 300px;
      height: 360px;
      flex-shrink: 0;
      @media screen and(max-width:1080px) {
        width: 200px;
      }
      @media screen and(max-width:720px) {
        width: 50px;
      }
      #side-menu {
        width: 100%;
        .menu-item {
          height: 60px;
          background-color: rgb(250, 250, 250);
          display: flex;
          align-items: center;
          cursor: pointer;
          @media screen and(max-width:720px) {
            justify-content: center;
          }
          i {
            font-size: 32px;
            transition-duration: 0.2s;
            transition-timing-function: ease-in-out;
          }
          .menu-item-descript {
            padding-left: 20px;
            transition-duration: 0.2s;
            transition-timing-function: ease-in-out;
            @media screen and(max-width:720px) {
              display: none;
            }
          }
          &:hover {
            color: #409eff;
          }
          &:hover .menu-item-descript {
            padding-left: 28px;
          }
        }
      }
    }

    #list-wrapper {
      flex-grow: 1;
      .list-item {
        padding: 10px;
        margin-bottom: 20px;
        .anchor {
          position: relative;
          top: -20px;
        }
        .item-header {
          display: flex;
          height: 60px;
          align-items: center;
          .title {
            width: 100%;
            height: 30px;
            line-height: 30px;
            font-size: 26px;
          }
        }
      }
    }
    .account-item-footer {
      width: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 80px;
      .balance-number {
        font-size: 24px;
        font-weight: 500;
      }
      .el-button {
        flex-basis: 30%;
      }
    }
    .card-show {
      .product-list-wrapper {
        display: flex;
        flex-wrap: wrap;
        .product-list-item {
          cursor: pointer;
          flex-basis: 50%;
          padding: 10px;
          box-sizing: border-box;
          @media screen and(max-width:1080px) {
            flex-basis: 100%;
          }
          .box-card {
            .card-header {
              background: white;
              width: 100%;
              font-weight: bold;
              font-size: 20px;
              line-height: 20px;
              .count {
                background: white;
                color: red;
              }
              .sum {
                color: orange;
                background: white;
                float: right;
                font-size: 24px;
                line-height: 24px;
              }
            }
          }
          .card-content {
            background: white;
            color: #555555;
            .content-descript {
              margin-bottom: 10px;
              background: white;
            }
            .content-time {
              background: white;
              span {
                font-size: 14px;
              }
            }
          }
          .card-button {
            margin-top: 12px;
            background: white;
            .cardButton {
              margin-left: 15px;
            }
          }
        }
      }
    }
  }
}

#dialog-wrapper {
  background: #f7f8fa;
  #dialog-footer {
    display: flex;
    justify-content: flex-end;
    div {
      margin-left: 10px;
    }
  }
}
</style>