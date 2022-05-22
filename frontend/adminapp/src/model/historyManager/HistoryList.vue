<template>
  <el-table :data="filterTableData" stripe height="100%" style="width: 100%">
    <el-table-column prop="historyId" label="申请订单号" />
    <el-table-column prop="userName" label="用户名" width="180"/>
    <el-table-column prop="title" label="书名" width="250"/>
    <el-table-column prop="count" label="申请数量" width="120"/>
    <el-table-column prop="points" label="积分/本" width="120"/>
    <el-table-column prop="sum" label="使用积分" width="150"/>
    <el-table-column prop="transactionTime" label="申请时间"/>
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="Type to search" />
      </template>

    </el-table-column>
  </el-table>
</template>

<script lang="ts">
import { _getHistory} from '../../api/history/history';
import {computed,  reactive, ref } from 'vue'
export default {
    data(){
        return{
            tableData:[],
            infoBackup: {},
            search : "",
        }
    },
    computed:{
        filterTableData : function () {
            return this.tableData.filter(
                (data) =>
                !this.search ||
                data.title.toLowerCase().includes(this.search.toLowerCase())||
                data.transactionTime.toLowerCase().includes(this.search.toLowerCase())||
                data.userName.toLowerCase().includes(this.search.toLowerCase())||
                data.historyId.toLowerCase().includes(this.search.toLowerCase())
            )
        }
    },
    methods:{
        getHistoryList(){
            _getHistory()
                .then((res) => {
                this.tableData=res.data.data.historyList;
                console.log(res.data.data.historyList)
                })
                .catch((err) => {
                    console.log("err!");
                });
        },
    },
    mounted(){
        this.getHistoryList();
    },
}
</script>

