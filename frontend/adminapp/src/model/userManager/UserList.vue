<template>
  <el-table :data="filterTableData" stripe style="width: 100%" height="100%">
    <el-table-column label="用户ID" prop="userId" sortable />
    <el-table-column label="用户名" prop="userName" />
    <el-table-column label="账号状态" prop="permission" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="Type to search" />
      </template>
      <template #default="scope">
        <el-button size="small" @click="handleLift(scope.$index, scope.row)"
          >解封</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleBan(scope.$index, scope.row)"
          >封禁</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</template>


<script lang="ts">
import { _getUser } from "../../api/userList/userList";
import { computed, reactive, ref } from "vue";
import { ElMessage } from 'element-plus'
export default {
  data() {
    return {
      tableData: [],
      infoBackup: {},
      infoEdit: false,
      dialogFormVisible: ref(false),
      search: "",
    };
  },
  computed: {
    filterTableData: function () {
      return this.tableData.filter(
        (data) =>
          !this.search ||
          data.userName.toLowerCase().includes(this.search.toLowerCase()) ||
          data.userId.toLowerCase().includes(this.search.toLowerCase()) ||
          data.permission.toLowerCase().includes(this.search.toLowerCase())
      );
    },
  },
  methods: {
    handleLift(index,row){
      row.permission="正常";
    ElMessage({
      showClose: true,
      message: '解封账户成功！',
    })
    },
    handleBan(index,row){
      row.permission="封禁";
    ElMessage({
      showClose: true,
      message: '封禁账户成功！',
    })
    },
    getUserList() {
      _getUser()
        .then((res) => {
          this.tableData = res.data.data.userList;
          console.log(res.data.data.userList);
        })
        .catch((err) => {
          console.log("err!");
        });
    },
    // handleEdit(index,row){
    //     console.log(row);
    //     // this.infoEdit = true;
    //     this.dialogFormVisible = true;
    //     this.form = row;
    // },
  },
  mounted() {
    this.getUserList();
  },
};
</script>

<style lang="scss" scoped>
.ban {
  color: red;
}
</style>