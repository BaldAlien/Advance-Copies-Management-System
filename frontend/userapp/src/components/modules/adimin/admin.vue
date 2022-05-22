<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="${comment}" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="author">
        <el-input
          v-model="queryParams.author"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="grade1">
        <el-input
          v-model="queryParams.grade1"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="grade2">
        <el-input
          v-model="queryParams.grade2"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="grade3">
        <el-input
          v-model="queryParams.grade3"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="imgsrc">
        <el-input
          v-model="queryParams.imgsrc"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="isbn">
        <el-input
          v-model="queryParams.isbn"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="issn">
        <el-input
          v-model="queryParams.issn"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="publicationTime">
        <el-date-picker clearable
          v-model="queryParams.publicationTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择${comment}">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="${comment}" prop="wordCount">
        <el-input
          v-model="queryParams.wordCount"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="format">
        <el-input
          v-model="queryParams.format"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="pageCount">
        <el-input
          v-model="queryParams.pageCount"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="bookbinding">
        <el-input
          v-model="queryParams.bookbinding"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="language">
        <el-input
          v-model="queryParams.language"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="points">
        <el-input
          v-model="queryParams.points"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
            type="primary"
            plain
            icon="Plus"
            @click="handleAdd"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="Delete"
            @click="handleDeleteBatch"
        >批量删除
        </el-button>
      </el-col>
      <RightToolbar v-model:showSearch="showSearch" @queryTable="getList" :columns="columns" />
    </el-row>

    <el-table border :data="productsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="title" v-if="columns[0].visible"/>
      <el-table-column label="${comment}" align="center" prop="author" v-if="columns[1].visible"/>
      <el-table-column label="${comment}" align="center" prop="grade1" v-if="columns[2].visible"/>
      <el-table-column label="${comment}" align="center" prop="grade2" v-if="columns[3].visible"/>
      <el-table-column label="${comment}" align="center" prop="grade3" v-if="columns[4].visible"/>
      <el-table-column label="${comment}" align="center" prop="type" v-if="columns[5].visible"/>
      <el-table-column label="${comment}" align="center" prop="imgsrc" v-if="columns[6].visible"/>
      <el-table-column label="${comment}" align="center" prop="isbn" v-if="columns[7].visible"/>
      <el-table-column label="${comment}" align="center" prop="issn" v-if="columns[8].visible"/>
      <el-table-column label="${comment}" align="center" prop="publicationTime" width="180" v-if="columns[9].visible"/>
      <el-table-column label="${comment}" align="center" prop="wordCount" v-if="columns[10].visible"/>
      <el-table-column label="${comment}" align="center" prop="format" v-if="columns[11].visible"/>
      <el-table-column label="${comment}" align="center" prop="pageCount" v-if="columns[12].visible"/>
      <el-table-column label="${comment}" align="center" prop="bookbinding" v-if="columns[13].visible"/>
      <el-table-column label="${comment}" align="center" prop="language" v-if="columns[14].visible"/>
      <el-table-column label="${comment}" align="center" prop="points" v-if="columns[15].visible"/>
      <el-table-column label="操作" width="200" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
              type="text"
              size="small"
              icon="Edit"
              @click="handleUpdate(scope.row)"
          >编辑
          </el-button>
          <el-button
              type="text"
              size="small"
              icon="Delete"
              @click="handleDelete(scope.row)"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <Pagination
        v-show="total > 0"
        v-model:page="queryParams.pageNumber"
        v-model:pageSize="queryParams.pageSize"
        :total="total"
        @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" v-model="open" width="60%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="${comment}" prop="title">
          <el-input v-model="form.title" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="author">
          <el-input v-model="form.author" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="grade1">
          <el-input v-model="form.grade1" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="grade2">
          <el-input v-model="form.grade2" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="grade3">
          <el-input v-model="form.grade3" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="imgsrc">
          <el-input v-model="form.imgsrc" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="isbn">
          <el-input v-model="form.isbn" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="issn">
          <el-input v-model="form.issn" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="publicationTime">
          <el-date-picker clearable size="small"
            v-model="form.publicationTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="wordCount">
          <el-input v-model="form.wordCount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="format">
          <el-input v-model="form.format" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="pageCount">
          <el-input v-model="form.pageCount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="bookbinding">
          <el-input v-model="form.bookbinding" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="language">
          <el-input v-model="form.language" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="points">
          <el-input v-model="form.points" placeholder="请输入${comment}" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm" >提 交</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Products",
    data() {
      return {
        // 导出遮罩层
        exportLoading: false,
        // 选中数组
        ids: [],
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 表格数据
        productsList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNumber: 1,
          pageSize: 10,
          title: null,
          author: null,
          grade1: null,
          grade2: null,
          grade3: null,
          type: null,
          imgsrc: null,
          isbn: null,
          issn: null,
          publicationTime: null,
          wordCount: null,
          format: null,
          pageCount: null,
          bookbinding: null,
          language: null,
          points: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
        },
        // 列显隐信息
        columns: [
          {key: 0, label: "$column.columnComment", visible: true},
          {key: 1, label: "$column.columnComment", visible: true},
          {key: 2, label: "$column.columnComment", visible: true},
          {key: 3, label: "$column.columnComment", visible: true},
          {key: 4, label: "$column.columnComment", visible: true},
          {key: 5, label: "$column.columnComment", visible: true},
          {key: 6, label: "$column.columnComment", visible: true},
          {key: 7, label: "$column.columnComment", visible: true},
          {key: 8, label: "$column.columnComment", visible: true},
          {key: 9, label: "$column.columnComment", visible: true},
          {key: 10, label: "$column.columnComment", visible: true},
          {key: 11, label: "$column.columnComment", visible: true},
          {key: 12, label: "$column.columnComment", visible: true},
          {key: 13, label: "$column.columnComment", visible: true},
          {key: 14, label: "$column.columnComment", visible: true},
          {key: 15, label: "$column.columnComment", visible: true},
        ],
        // 数据字典选项
        dict: {
        },
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询部门列表 */
      getList() {
        this.$get('/products/list', this.queryParams).then((res) => {
          this.productsList = res.data
          this.total = Number.parseInt(res.count)
        })
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNumber = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加【请填写功能名称】";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        this.$get('/products/' + row.id).then((res) => {
          this.form = res.data
          this.open = true;
          this.title = "修改【请填写功能名称】";
        })
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            this.$post('/products/save', this.form).then((res) => {
              if (this.form.id !== undefined && this.form.id !== null) {
                this.$modal.msgSuccess("修改成功");
              } else {
                this.$modal.msgSuccess("新增成功");
              }
              this.getList();
              this.open = false;
              this.reset();
            });
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        this.$modal.confirm('是否确认删除此数据项?').then(() => {
          return this.$post('/products/delete?id=' + row.id)
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {
        });
      },
      /** 批量删除按钮操作 */
      handleDeleteBatch() {
        this.$modal.confirm('是否确认批量删除选定的数据项?').then(() => {
          return this.$post('/products/delete/batch', this.ids)
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {
        });
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.id)
      },
    }
  };
</script>
