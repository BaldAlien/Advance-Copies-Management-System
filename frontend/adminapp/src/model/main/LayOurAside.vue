<template>
    <el-row class="tac">
        <el-col>
        <el-menu
            active-text-color="#ffd04b"
            background-color="#545c64"
            class="el-menu-vertical-demo"
            default-active="2"
            text-color="#fff"
            @open="handleOpen"
            @close="handleClose"
            @select="handleSelect"
        >
            <el-sub-menu index="1">
            <template #title>
                <el-icon><management /></el-icon>
                <span>样书产品管理</span>
            </template>

            <el-menu-item index="1-1">产品列表</el-menu-item>
            <el-menu-item index="1-2">添加产品</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="2">
            <template #title>
                <el-icon><list /></el-icon>
                <span>申请订单管理</span>
            </template>
            <el-menu-item index="2-1">历史订单</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="3">
            <template #title>
                <el-icon><stamp /></el-icon>
                <span>教师认证管理</span>
            </template>
            <el-menu-item index="3-1">人工认证</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="4">
                <template #title>
                    <el-icon><tickets /></el-icon>
                    <span>书评管理</span>
                </template>
                <el-menu-item index="4-1">查看书评</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="5">
                <template #title>
                    <el-icon><user /></el-icon>
                    <span>账号管理</span>
                </template>
                <el-menu-item index="5-1">普通用户账号管理</el-menu-item>
            </el-sub-menu>
        </el-menu>
        </el-col>
    </el-row>
</template>

<script lang="ts" setup>
import {
  Document,
  Menu as IconMenu,
  Management,
  List,
  Stamp,
  Tickets,
  User,
  Setting,
} from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
const router = useRouter();
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

const  mapper= {
        "1-1": "/list",
        "1-2": "/addProduct",
        "2-1": "/history",
        "3-1": "/certify",
        "4-1": "/review",
        "5-1": "/user",
}
const handleSelect=(key:string)=> {
    console.log(key)
    if (mapper[key] !== undefined) {
        router.push(mapper[key]);
    }
}
</script>


