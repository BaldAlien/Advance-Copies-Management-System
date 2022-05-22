<template>
  <div id="presentation">
    <div id="container"></div>
    <div id="banner" >
      <div id="content">
        <div id="title">某出版社样书申请系统</div>
      </div>
    </div>
    <div id="search-box">
      <el-input v-model="inputSearch" class="search" placeholder="书名/作者/ISBN" size="large"  @change="onSearch()">
        <template #suffix>
          <i class="el-icon-search" @click="onSearch()"></i>
        </template>
      </el-input>
    </div>
    <div id="container-main">
      <div id="main-product-container">
        <div class="product" @click="clickProduct(1)">
          <img src="src\assets\images\modules\presentation\bookIcon1.png" class="imgIcon"/>
          <div class="product-descript">教育用书</div>
        </div>
        <div class="product" @click="clickProduct(2)">
          <img src="src\assets\images\modules\presentation\bookIcon2.png" class="imgIcon"/>
          <div class="product-descript">学术著作</div>
        </div>
        <div class="product" @click="clickProduct(3)">
          <img src="src\assets\images\modules\presentation\bookIcon3.png" class="imgIcon"/>
          <div class="product-descript">社会读物</div>
        </div>
        <div class="product" @click="clickProduct(4)">
          <img src="src\assets\images\modules\presentation\periodicalIcon1.png" class="imgIcon"/>
          <div class="product-descript">期刊</div>
        </div>
      </div>
      <div id="main-check">
        <router-link to="/edumall">需要帮助<i>></i></router-link>
      </div>
    </div>
    <div id="footer">
      <div class="record">某出版社版权所有</div>
      <div class="record">京ICP备xxxxxxxx号 京公网安备xxxxxxxxxxxxxx</div>
    </div>
  </div>
</template>

<script>
import banner from "../../../assets/images/modules/presentation/banner-2.png";
import store from '../../../store';
export default {
  name: "Presentation",
  data() {
    return {
      banner,
      inputSearch:"",
    };
  },
  methods: {
    clickProduct(index) {
      // this.$router.push(`/edumall/${index}`);
      switch(index){
        case 1:this.$router.push(`/edumall`);break;
        case 2:this.$router.push(`/academicmall`);break;
        case 3:this.$router.push(`/socialmall`);break;
        case 4:this.$router.push(`/journalmall`);break;
      }
    },
    onSearch(){
      store.state.searchInfo=this.inputSearch;
      this.$router.push(`/searchProducts`);
    }
  },
  components: {},

  mounted() {},
};
</script>

<style  lang="scss" scoped>
#presentation {
  text-align: center;
  height: 100%;
  background: #f7f8fa;
  #banner {
    height: 220px;
    margin-top: 50px;
    background-repeat: no-repeat;
    background-size: cover;
    background-position: 50% 50%;
    @media screen and (max-width: 720px) {
      height: 180px;
    }
    #content {
      #title {
        font-weight: 800;
        font-size: 38px;
        padding-bottom: 10px;
        @media screen and (max-width: 720px) {
          font-size: 28px;
        }
      }
      padding-top: 120px;
      @media screen and (max-width: 720px) {
        padding-top: 50px;
        padding-left: 40px;
        padding-right: 20px;
      }
    }
  }
  #search-box{
    width: 70%;
    margin: 0 auto;
  }
  #container-main {
    padding-bottom: 40px;
    #main-title {
      font-size: 38px;
      text-align: center;
    }
    #main-check {
      margin-top: 50px;
      @media screen and (max-width: 720px) {
        margin-top: 0;
      }
      text-align: center;
      cursor: pointer;
      a {
        text-decoration: none;
        color: #2c3e50;
        &:hover {
          color: #409eff;
          transition-duration: 0.2s;
          transition-timing-function: ease-in-out;
        }
      }

      i {
        text-align: right;
        width: 20px;
        font-weight: 800;
        display: inline-block;
        transition-duration: 0.2s;
        transition-timing-function: ease-in-out;
      }

      &:hover i {
        width: 40px;
      }
    }
    #main-product-container {
      width: 80%;
      margin: auto;
      margin-top: 50px;
      display: flex;
      flex-flow: wrap;
      justify-content: space-around;
      @media screen and (max-width: 720px) {
        width: 90%;
      }
      .imgIcon{
        width: 120px;
        height: 120px;
      }
      .product {
        flex: 22%;
        @media screen and (max-width: 720px) {
          flex:40%;
        }
        height: 180px;
        text-align: center;
        cursor: pointer;
        font-size: 72px;

        &:hover {
          color: #88c3ff;
          transition-duration: 0.2s;
          transition-timing-function: ease-in-out;
        }
        &:hover i {
          color: #409eff;
          transition-duration: 0.2s;
          transition-timing-function: ease-in-out;
          font-size: 80px;
        }
        @media screen and (max-width: 720px) {
          width: 33.3%;
        }
        .product-descript {
          font-size: 21px;
        }
      }
    }
  }
  #footer {
    font-size: 15px;
    margin-top: 10px;
    text-align: center;
    line-height: 30px;
    @media screen and (min-height: 830px) {
      position: absolute;
      bottom: 10px;
      width: 380px;
      left: calc(50% - 190px);
    }
    span {
      cursor: pointer;
      &:hover {
        color: #409eff;
        transition-duration: 0.2s;
        transition-timing-function: ease-in-out;
      }
    }
    .record {
      font-size: 13px;
      color: rgba(65, 65, 65, 0.8);
    }
  }
}
</style>