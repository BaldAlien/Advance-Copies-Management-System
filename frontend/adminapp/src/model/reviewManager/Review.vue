<template>
<div id="review">
  <div class="search">
    <el-input
      v-model="input"
      class="w-50 m-2"
      size="large"
      placeholder="Please Input"
      :suffix-icon="Search"
        @change="search()"
    />
  </div>
  <div id="show">
    <el-card class="box-card displayClass 刑事科学技术" shadow="hover">
    <template #header>
        <div class="card-header">
        <span class="productId">产品ID：{{1}}</span>
        <span class="titleBox">书名：<span class="title">{{"刑事科学技术"}}</span></span>
        <span class="userId">用户ID：{{2}}</span>
        <span class="userName">用户名：{{"qjj"}}</span>
        </div>
    </template>
    <div class="card-content">
        <div class="content-descript">
            {{"发现文字错误，书中第66页第二段第一句话中，“刑势”二字应改为“刑事”。"}}
        </div>
    </div>
    </el-card>
    <el-card class="box-card displayClass 刑事科学技术" shadow="hover">
    <template #header>
        <div class="card-header">
        <span class="productId">产品ID：{{1}}</span>
        <span class="titleBox">书名：<span class="title">{{"刑事科学技术"}}</span></span>
        <span class="userId">用户ID：{{10}}</span>
        <span class="userName">用户名：{{"test"}}</span>
        </div>
    </template>
    <div class="card-content">
        <div class="content-descript">
            {{"测试用书评，start......"}}<br/>
            {{"......"}}<br/>
            {{"......"}}<br/>
            {{"......"}}<br/>
            {{"......"}}<br/>
            {{"......"}}<br/>
            {{"......end"}}
        </div>
    </div>
    </el-card>
    <el-card class="box-card displayClass 有机化学" shadow="hover">
    <template #header>
        <div class="card-header">
        <span class="productId">产品ID：{{31}}</span>
        <span class="titleBox">书名：<span class="title">{{"有机化学"}}</span></span>
        <span class="userId">用户ID：{{2}}</span>
        <span class="userName">用户名：{{"qjj"}}</span>
        </div>
    </template>
    <div class="card-content">
        <div class="content-descript">
            {{"xxxxxxxxxxxxxxxx"}}
        </div>
    </div>
    </el-card>
  </div>
</div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { Search } from '@element-plus/icons-vue'
const input1 = ref('')
</script>

<script lang="ts">
export default {
  data() {
    return {
        input:"",
    };
  },
  methods: {
    search() {
      let dom1 =document.getElementsByClassName("box-card");
      console.log(dom1)
      let dom = document.getElementsByClassName(this.input);
      for (var i = 0; i < dom1.length; i++) {
          dom1[i].classList.add("displayClass");
        }
      for (var i = 0; i < dom.length; i++) {
          dom[i].classList.remove("displayClass");
        }
    },

  },
};
</script>


<style lang="scss" scoped>
.displayClass{
    display: none;
}
#review{
    width: 100%;
    .search{
        margin: 60px auto 60px;
        width: 70%;
    }
    #show{
        margin: 0 auto;
        width: 70%;
        text-align: left;
        .box-card{
            margin: 50px auto;
            .titleBox{
                margin-left: 30px;
                .title{
                    font-size: 22px;
                    color: rgb(231, 155, 13);
                }
            }
            .userId{
                margin-left: 30px;
            }
            .userName{
                margin-left: 30px;
            }
        }
    }
}
</style>
