<template>
    <el-container id="container">
        <el-header id="header">某出版社样书管理系统</el-header>
        <el-container>
            <el-aside width="200px" id="aside">
                <Aside/>
            </el-aside>
            <el-main id="main">
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script  setup lang="ts">
 import Aside from '../model/main/LayOurAside.vue'
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style lang="scss" scoped>
#container{
    width: 100%;
    height: 100%;
    margin-top: -60px;
    #header{
        z-index: 10;
        border-bottom: 1px solid rgb(217, 234, 238);
        line-height: 60px;
        font-size: 24px;
        text-align: left;
    }
    #aside {
        height: 100vh;
        z-index: 9;
        background-color: rgb(84, 92, 100);
    }
    #main{
        padding: 0;
        height: calc(100vh - 60px);
        overflow: auto;
    }
}
</style>