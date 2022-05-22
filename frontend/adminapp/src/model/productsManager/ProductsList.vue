<template>
  <el-table :data="filterTableData" stripe style="width: 100%" height="100%">
    <el-table-column type="expand">
      <template #default="props">
        <p class="detail">作者: {{ props.row.author }}</p>
        <p class="detail">二级分类: {{ props.row.grade1 }}</p>
        <p class="detail">三级级分类: {{ props.row.grade2 }}</p>
        <p class="detail">四级分类: {{ props.row.grade3 }}</p>
        <p class="detail">ISBN: {{ props.row.isbn }}</p>
        <p class="detail">ISSN: {{ props.row.issn }}</p>
        <p class="detail">出版时间: {{ props.row.publicationTime }}</p>
        <p class="detail">版面字数: {{ props.row.wordCount }}</p>
        <p class="detail">全书页数: {{ props.row.pageCount }}</p>
        <p class="detail">开本: {{ props.row.format }}</p>
        <p class="detail">装帧形式: {{ props.row.bookbinding }}</p>
        <p class="detail">语言: {{ props.row.language }}</p>
        <p class="detail">申请所需积分: {{ props.row.points }}</p>
        <p class="detail">图片地址: {{ props.row.imgsrc }}</p>
      </template>
    </el-table-column>
    <el-table-column label="一级分类" prop="type" sortable/>
    <el-table-column label="书名" prop="title" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="Type to search" />
      </template>
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >编辑</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>


  <el-dialog v-model="dialogFormVisible" title="编辑样书产品信息">
    <el-form :model="form">
      <el-form-item label="书名" :label-width="formLabelWidth">
        <el-input v-model="form.title" autocomplete="off" />
      </el-form-item>
      <el-form-item label="作者/核心" :label-width="formLabelWidth">
        <el-input v-model="form.author" autocomplete="off" />
      </el-form-item>
      <el-form-item label="一级分类" :label-width="formLabelWidth">
        <el-select v-model="form.type" placeholder="Please select a zone">
          <el-option label="教育用书" value="教育用书" />
          <el-option label="学术著作" value="学术著作" />
          <el-option label="社会读物" value="社会读物" />
          <el-option label="期刊" value="期刊" />
        </el-select>
      </el-form-item>
      <el-form-item label="二级分类" :label-width="formLabelWidth">
        <el-input v-model="form.grade1" autocomplete="off" />
      </el-form-item>
      <el-form-item label="三级分类" :label-width="formLabelWidth">
        <el-input v-model="form.grade2" autocomplete="off" />
      </el-form-item>
      <el-form-item label="四级分类" :label-width="formLabelWidth">
        <el-input v-model="form.grade3" autocomplete="off" />
      </el-form-item>
      <el-form-item label="图片路径" :label-width="formLabelWidth">
        <el-input v-model="form.imgsrc" autocomplete="off" />
      </el-form-item>
      <el-form-item label="ISBN" :label-width="formLabelWidth">
        <el-input v-model="form.isbn" autocomplete="off" />
      </el-form-item>
      <el-form-item label="ISSN" :label-width="formLabelWidth">
        <el-input v-model="form.issn" autocomplete="off" />
      </el-form-item>
      <el-form-item label="出版时间" :label-width="formLabelWidth">
        <el-input v-model="form.publicationTime" autocomplete="off" />
      </el-form-item>
      <el-form-item label="版面字数" :label-width="formLabelWidth">
        <el-input v-model="form.wordCount" autocomplete="off" />
      </el-form-item>
      <el-form-item label="开本" :label-width="formLabelWidth">
        <el-input v-model="form.format" autocomplete="off" />
      </el-form-item>
      <el-form-item label="页数" :label-width="formLabelWidth">
        <el-input v-model="form.pageCount" autocomplete="off" />
      </el-form-item>
      <el-form-item label="装帧形式" :label-width="formLabelWidth">
        <el-input v-model="form.bookbinding" autocomplete="off" />
      </el-form-item>
      <el-form-item label="语言" :label-width="formLabelWidth">
        <el-input v-model="form.language" autocomplete="off" />
      </el-form-item>
      <el-form-item label="所需积分" :label-width="formLabelWidth">
        <el-input v-model="form.points" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="Confirm()"
          >Confirm</el-button
        >
      </span>
    </template>
  </el-dialog>
</template>


<script lang="ts">
import { ElMessage } from 'element-plus'
import { _getProducts , _editProducts, _deleteProducts} from '../../api/productsList/productsList';
import {computed,  reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter();
export default {
    data(){
        return{
            tableData:[],
            infoBackup: {},
            infoEdit: false,
            dialogFormVisible : ref(false),
            search : "",
        }
    },
    computed:{
        filterTableData : function () {
            return this.tableData.filter(
                (data) =>
                !this.search ||
                data.title.toLowerCase().includes(this.search.toLowerCase()) ||
                data.type.toLowerCase().includes(this.search.toLowerCase())
            )
        }
    },
    methods:{
        getProductsList(){
            const params={pageNumber:1,pageSize:5000};
            _getProducts(params)
                .then((res) => {
                this.tableData=res.data.records;
                })
                .catch((err) => {
                    console.log("err!");
                });
        },
        handleEdit(index,row){
            console.log(row);
            // this.infoEdit = true;
            this.dialogFormVisible = true;
            this.form = row;

            // this.infoBackup = JSON.parse(JSON.stringify(this.info));
        },
        handleDelete(index,row){
          console.log(row.bookId);
          const id={
            id:row.bookId
          }
          _deleteProducts(id)
            .then((res) => {
              console.log(res);
            })
            .catch((err) => {
                console.log("err!");
            });
            ElMessage({
    showClose: true,
    message: '删除成功',
    type: 'success',
    })
    router.go(0);
        },
        Confirm(){
            this.dialogFormVisible = false;
            _editProducts(this.form)
            .then((res) => {
                console.log(res);
                })
            .catch((err) => {
                console.log("err!");
            });
        }
    },
    mounted(){
        this.getProductsList();
    },
}
</script>

<style lang="scss" scoped>
.detail{
    margin-left: 30px;
}
</style>