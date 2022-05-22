<template>
  <div id="mall">
  <trolley :productInCart="productInCart"></trolley>
    <div id="banner">
      <el-carousel :interval="4000" type="card" height="350px" trigger="click">
        <el-carousel-item v-for="item in 3" :key="item">
          <img
            :src="'src/assets/images/modules/mall/PublicityImg' + item + '.png'"
            style="min-height: 80%; min-width: 80%"
          />
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="big-title"><h3>{{type}}</h3></div>
    <div id="container-main">
      <el-affix target="#container-main" :offset="80" id="side-menu-wrapper">
        <div id="side-menu">
          <div class="menu-item">
            <div class="product-descript" @click="getProductsList(type,0)">全部</div>
          </div>
          <div v-for="(item1,index1) in TypeGrade">
            <div v-for="(item2,key1) in item1">
              <div class="menu-item">
                <div class="grade" :class="`${key1}`+'-'+`${index1+1}`" @click="plusonclick(`${key1}`+'-'+`${index1+1}`,`${key1}`+'-'+`${index1+1}`+'-'+`${index1+1}`)">
                  +
                </div>
                <div class="grade display" :class="`${key1}`+'-'+`${index1+1}`"  @click="minonclick(`${key1}`+'-'+`${index1+1}`,`${key1}`+'-'+`${index1+1}`+'-'+`${index1+1}`)">
                  -
                </div>
                <div class="product-descript" @click="getProductsList(key1,1)">
                  {{key1}}
                </div>
              </div>
              <div v-for="(item3,index2) in item2">
                <div v-for="(item4,key2) in item3">
                  <div class="menu-item sub-item sub-display" :class="`${key1}`+'-'+`${index1+1}`+'-'+`${index1+1}`">
                    <div class="grade" :class="`${key2}`+'-'+`${index2+1}`" @click="plusonclick(`${key2}`+'-'+`${index2+1}`,`${key2}`+'-'+`${index2+1}`+'-'+`${index2+1}`)">+</div>
                    <div class="grade display" :class="`${key2}`+'-'+`${index2+1}`"  @click="minonclick(`${key2}`+'-'+`${index2+1}`,`${key2}`+'-'+`${index2+1}`+'-'+`${index2+1}`)">-</div>
                    <div class="product-descript"  @click="getProductsList(key2,2)">{{key2}}</div>
                  </div>

                  <div v-for="(item5,index3) in item4" class="bottom-grade">
                    <div class="menu-item sub-item2 sub-display " :class="`${key2}`+'-'+`${index2+1}`+'-'+`${index2+1}`">
                      <div class="product-descript"  @click="getProductsList(item5,3)">{{item5}}</div>
                    </div>
                  </div>
                </div>
            </div>
            </div>
          </div>
      <div>

        </div>
        </div>
      </el-affix>

      <div id="product-list-wrapper">
        <div
          class="product-list-group"
          v-for="(item, index) in products"
          :key="index"
        >
          <div class="productbox">
            <img :src="item.imgsrc" class="product-img" @click="viewDetails(item)">
            <div class="product-info">
              <div class="booktitle">{{item.title}}</div>
              <div class="author">{{item.author}}</div>
              <div class="productbox-foot">
                <div class="foot">
                  <span>{{item.points}}积分</span>
                </div>
                <div class="foot">
                  <el-button size="small" round><el-icon :size="16" style="vertical-align: middle"  @click="addToCart(item)"><DocumentAdd /></el-icon></el-button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
  <el-dialog v-model="dialogFormVisible" title="样书详细信息">
  <el-descriptions
    direction="vertical"
    :column="4"
    :size="larger"
    border
  >
    <el-descriptions-item label="书名" :span="2">{{detailsFrom.title}}</el-descriptions-item>
    <el-descriptions-item label="作者" :span="2">{{detailsFrom.author}}</el-descriptions-item>
    <el-descriptions-item label="一级分类" :span="1">{{detailsFrom.type}}</el-descriptions-item>
    <el-descriptions-item label="二级分类">
      <!-- <el-tag size="small">{{detailsFrom.grade1}}</el-tag> -->
      {{detailsFrom.grade1}}
    </el-descriptions-item>
    <el-descriptions-item label="三级分类"
      >{{detailsFrom.grade2}}
    </el-descriptions-item>
    <el-descriptions-item label="三级分类"
      >{{detailsFrom.grade2}}
    </el-descriptions-item>
    <el-descriptions-item label="ISBN"
      >{{detailsFrom.ISBN}}
    </el-descriptions-item>
    <el-descriptions-item label="出版时间"
      >{{detailsFrom.publication_time}}
    </el-descriptions-item>
    <el-descriptions-item label="版面字数"
      >{{detailsFrom.word_count}}
    </el-descriptions-item>
    <el-descriptions-item label="页数"
      >{{detailsFrom.page_count}}
    </el-descriptions-item>
    <el-descriptions-item label="开本"
      >{{detailsFrom.format}}
    </el-descriptions-item>
    <el-descriptions-item label="装帧形式"
      >{{detailsFrom.bookbinding}}
    </el-descriptions-item>
    <el-descriptions-item label="语言"
      >{{detailsFrom.language}}
    </el-descriptions-item>
    <el-descriptions-item label="申请每本所需积分"
      >{{detailsFrom.points}}
    </el-descriptions-item>
  </el-descriptions>

  </el-dialog>
  <router-view />
</template>

<script lang="ts">
import trolley from "./Trolley.vue";
import {DocumentAdd} from "@element-plus/icons-vue"
import { ElMessage } from "element-plus";
import { _getProducts, _getG1, _getG2 } from "../../../api/mall/mall";
import banner from "../../../assets/images/modules/mall/banner.jpg";
export default {
  data() {
    return {
      banner,
      productInCart: {},
      products: [],
      pagenum:1,
      pagesize:800,
      TypeGrade:[],
      type:"学术著作",
      dialogFormVisible:false,
      detailsFrom:{
        title:"",
        author:"",
        type:"",
        grade1:"",
        grade2:"",
        grade3:"",
        ISBN:"",
        publication_time:"",
        word_count:"",
        format:"",
        page_count:"",
        bookbinding:"",
        language:"",
        points:"",
      }
    };
  },
  components: {
    trolley,
    DocumentAdd,
  },
  methods: {
    viewDetails(item){
      this.dialogFormVisible=true;
      this.detailsFrom.title=item.title;
      this.detailsFrom.author=item.author;
      this.detailsFrom.page_count=item.pageCount;
      this.detailsFrom.bookbinding=item.bookbinding;
      this.detailsFrom.language=item.language;
      this.detailsFrom.points=item.points;
      this.detailsFrom.type=item.type;
      this.detailsFrom.grade1=item.grade1;
      this.detailsFrom.grade2=item.grade2;
      this.detailsFrom.grade3=item.grade3;
      this.detailsFrom.ISBN=item.isbn;
      this.detailsFrom.publication_time=item.publicationTime;
      this.detailsFrom.word_count=item.wordCount;
      this.detailsFrom.format=item.format;
    },
    getG1(){
      let params={type:this.type};
      _getG1(params)
      .then((res)=>{
        this.TypeGrade=res.data.list;
      })
      .catch((err) => {
          ElMessage.error({
            offset: 50,
            message: "error！",
            type: "error",
          });
        });
    },
    getProductsList(grade:String,level:number){
      let params;
      switch(level){
        case 0:  params={pageNumber:1,pageSize:this.pagesize,type:this.type};break;
        case 1:  params={pageNumber:1,pageSize:this.pagesize,type:this.type,grade1:grade};break;
        case 2:  params={pageNumber:1,pageSize:this.pagesize,type:this.type,grade2:grade};break;
        case 3:  params={pageNumber:1,pageSize:this.pagesize,type:this.type,grade3:grade};break;
      }
      _getProducts(params)
        .then((res) => {
          this.pagenum = 1;
          this.products=res.records;
        })
        .catch((err) => {
          ElMessage.error({
            offset: 50,
            message: "error！",
            type: "error",
          });
        });
    },
    plusonclick(grade, val) {
      let dom = document.getElementsByClassName(val);
      let signdom=document.getElementsByClassName(grade);
      let botgrade=document.getElementsByClassName("bottom-grade");
      if (signdom !== null) {
        for (var i = 0; i < dom.length; i++) {
          dom[i].classList.remove("sub-display");
        }
        for (let i = 0; i < signdom.length; i++) {
          signdom[i].classList.toggle("display");
        }
        for (let i = 0; i < botgrade.length; i++) {
          botgrade[i].classList.remove("sub-display");
        }
      }
    },
    minonclick(grade, val) {
      let dom = document.getElementsByClassName(val);
      let signdom=document.getElementsByClassName(grade);
      let botgrade=document.getElementsByClassName("bottom-grade");
      if (signdom !== null) {
        for (var i = 0; i < dom.length; i++) {
          dom[i].classList.add("sub-display");
        }
        for (let i = 0; i < signdom.length; i++) {
          signdom[i].classList.toggle("display");
        }
        for (let i = 0; i < botgrade.length; i++) {
          botgrade[i].classList.add("sub-display");
        }
      }
    },
    addToCart(item) {
      this.productInCart = {
        bookId: item.bookId,
        // specification_id: item.specification_id,
        title: item.title,
        imgSrc:item.imgsrc,
        // specification_name: item.specification_name,
        add_number: 1,
        points: 1,
      };
    },
    goAnchor(index) {
      let anchor = document.getElementById(`item${index}`);
      if (anchor !== null) anchor.scrollIntoView();
    },
    clickProduct(index) {
      this.$router.push(`/product/${index}`);
    },
    getProducts() {
      const par={pageNumber:this.pagenum,pageSize:this.pagesize,type:this.type};
      _getProducts(par)
        .then((res) => {
          this.products=res.records;
          console.log(this.products);
        })
        .catch((err) => {
          ElMessage.error({
            offset: 50,
            message: "error！",
            type: "error",
          });
        });
    },
  },
  mounted() {
    this.getG1();
    this.getProducts();
  },
};
</script>
<style  lang="scss" scoped>
.el-descriptions {
  margin-top: 20px;
}
.example-pagination-block + .example-pagination-block {
  margin-top: 10px;
}
.example-pagination-block .example-demonstration {
  margin-bottom: 16px;
}
.sub-display {
  display: none;
}
.display{
  position: absolute;
  left:-3000%;
  bottom:-3000%;
}
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
#mall {
  height: 100%;
  background: #f7f8fa;
  #banner {
    height: 350px;
    width: 90%;
    margin: 20px auto 0;
    @media screen and (max-width: 720px) {
      height: 200px;
    }
    .el-carousel__item:nth-child(2n) {
      background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n + 1) {
      background-color: #d3dce6;
    }
  }
  .big-title {
    padding: 40px 5% 20px 5%;
    text-align: center;
    font-size: 32px;
    margin-bottom: 20px;
    @media screen and(max-width:720px) {
      padding: 40px 20px 40px 40px;
    }
  }
  #container-main {
    padding: 0px 8% 40px 8%;
    box-sizing: border-box;
    display: flex;
    @media screen and(max-width:720px) {
      padding: 0px 20px 40px 20px;
    }
    .sub-item {
      margin-left: 15px;
    }
    .sub-item2{
      margin-left: 30px;
    }
    #side-menu-wrapper {
      width: 280px;
      flex-grow: 0;
      flex-shrink: 0;
      height: 360px;
      @media screen and(max-width:1080px) {
        width: 150px;
      }
      @media screen and(max-width:720px) {
        width: 50px;
      }
      #side-menu {
        height: 90vh;
        overflow-y: auto;
        overflow-x: hidden;
        .menu-item {
          height: 60px;
          background-color: rgb(250, 250, 250);
          align-items: center;
          cursor: pointer;
          @media screen and(max-width:720px) {
            justify-content: center;
          }
          .grade {
            display: inline;
            &:hover {
              color: #409eff;
            }
            &:hover .product-descript {
              padding-left: 28px;
            }
          }
          .product-descript {
            display: inline;
            padding-left: 20px;
            transition-duration: 0.2s;
            &:hover {
              color: #409eff;
            }
            &:hover .product-descript {
              padding-left: 28px;
            }
            transition-timing-function: ease-in-out;
            @media screen and(max-width:720px) {
              display: none;
            }
          }
        }
      }
    }
    #product-list-wrapper {
      width: 100%;
      display: flex;
      flex-wrap: wrap;
      .product-list-group {
        width: 30%;
        height: 370px;
        margin: 20px 15px 40px;
        background: white;
        .anchor {
          position: relative;
          top: -30px;
        }
        .title-type {
          width: 100%;
          height: 30px;
          line-height: 30px;
          font-size: 30px;

          margin-left: 15px;
          margin-bottom: 15px;
        }
        .productbox{
          text-align: center;
          box-shadow:0 0 1px 0.5px #000; 
            .product-img{
              width: 100%;
              height: auto;
            }
            .product-info{
              .booktitle{
                font-size: 18px;
                margin: 5px auto;
              }
              .author{
                font-size: 13px;
                margin: 11px auto 15px;
              }
              .productbox-foot{
                padding-bottom: 20px;
                display: flex;
                .foot{
                  width: 50%;
                  height: 40px;
                  line-height: 40px;
                  span{
                    margin-right: 20px;
                  }
                }
              }
            }
        }
        .product-list-item {
          padding: 10px;
          cursor: pointer;
          box-sizing: border-box;
          &:hover .card-header {
            color: #409eff;
            transition-duration: 0.2s;
            transition-timing-function: ease-in-out;
          }
          @media screen and(max-width:1080px) {
            width: 100%;
          }
          .card-header {
            font-weight: bold;
          }
          .card-content {
            font-size: 15px;
            color: #555555;
            line-height: 23px;
          }
        }
      }
    }
  }
}
</style>
 