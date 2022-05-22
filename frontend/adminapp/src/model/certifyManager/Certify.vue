<template>
  <el-table :data="filterTableData" stripe style="width: 100%" height="100%">
    <el-table-column type="expand">
      <template #default="props">
        <p class="detail">姓名:  {{ props.row.name }} </p>
        <p class="detail">性别: {{ props.row.sex }}</p>
        <p class="detail">身份证号: {{ props.row.IDnumber }}</p>
        <p class="detail">执教学校: {{ props.row.school }}</p>
        <p class="detail">教职工号: {{ props.row.teacherNumber }}</p>
      </template>
    </el-table-column>
    <el-table-column label="用户ID" prop="userId" sortable />
    <el-table-column label="用户名" prop="userName" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="Type to search" />
      </template>
      <template #default="scope">
        <el-button size="small" @click="handleLift(scope.$index, scope.row)"
          >通过</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleBan(scope.$index, scope.row)"
          >不通过</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</template>


<script lang="ts">
import { _getUser } from "../../api/userList/userList";
import { ElMessage } from 'element-plus'
import { computed, reactive, ref } from "vue";
export default {
  data() {
    return {
      tableData: [
        {
            userId:1,
            userName:"qwe",
            name:"张三",
            sex:"男",
            IDnumber:"123456789098765432",
            school:"电子科技大学",
            teacherNumber:"10104321"
        },
        {
            userId:3,
            userName:"xxxx",
            name:"李四",
            sex:"女",
            IDnumber:"098765432123456789",
            school:"电子科技大学",
            teacherNumber:"10111234"
        },
        {
            userId:9,
            userName:"学习我所欲也",
            name:"王五",
            sex:"男",
            IDnumber:"657483920192837465",
            school:"电子科技大学",
            teacherNumber:"10111230"
        },
        {
            userId:10,
            userName:"test",
            name:"王五",
            sex:"男",
            IDnumber:"657483920192837465",
            school:"电子科技大学",
            teacherNumber:"10111230"
        },
      ],
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
      this.tableData.splice(index, 1)
      ElMessage({
    showClose: true,
    message: '已通过该认证申请',
    type: 'success',
    })
    },
    handleBan(index,row){
      this.tableData.splice(index, 1)
        ElMessage({
    showClose: true,
    message: '已拒绝该认证申请',
  })
    }
  },
  mounted() {

  },
};
</script>

<style lang="scss" scoped>
.ban {
  color: red;
}
</style>