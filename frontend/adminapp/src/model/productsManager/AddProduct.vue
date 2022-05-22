<template>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
    :size="formSize"
    style="width:85%;margin-left:5%"
  >
    <el-form-item label="书名" prop="title">
      <el-input v-model="ruleForm.title" />
    </el-form-item>
    <el-form-item label="作者/核心" prop="author">
      <el-input v-model="ruleForm.author" />
    </el-form-item>
    <el-form-item label="一级分类" prop="type">
      <el-radio-group v-model="ruleForm.type">
        <el-radio label="教育用书" />
        <el-radio label="学术著作" />
        <el-radio label="社会读物" />
        <el-radio label="期刊" />
      </el-radio-group>
    </el-form-item>
    <el-form-item label="二级分类" prop="grade1">
      <el-input v-model="ruleForm.grade1" />
    </el-form-item>
    <el-form-item label="三级分类" prop="grade2">
      <el-input v-model="ruleForm.grade2" />
    </el-form-item>
    <el-form-item label="四级分类" prop="grade3">
      <el-input v-model="ruleForm.grade3" />
    </el-form-item>
    <el-form-item label="出版时间" required>
      <el-col :span="11">
        <el-form-item prop="date">
          <el-date-picker
            v-model="ruleForm.date"
            type="date"
            placeholder="选择一个日期"
            style="width: 100%"
          />
        </el-form-item>
      </el-col>
    </el-form-item>
    <el-form-item label="版面字数" prop="wordCount">
      <el-input v-model="ruleForm.wordCount" />
    </el-form-item>
    <el-form-item label="开本" prop="format">
      <el-input v-model="ruleForm.format" />
    </el-form-item>
    <el-form-item label="页数" prop="pageCount">
      <el-input v-model="ruleForm.pageCount" />
    </el-form-item>
    <el-form-item label="装帧形式" prop="bookbinding">
      <el-input v-model="ruleForm.bookbinding" />
    </el-form-item>
    <el-form-item label="语言" prop="language">
      <el-input v-model="ruleForm.language" />
    </el-form-item>
    <el-form-item label="申请所需积分（分/本）" prop="points">
      <el-input v-model="ruleForm.points" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm(ruleFormRef)"
        >添加产品</el-button
      >
      <el-button @click="resetForm(ruleFormRef)">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import type { FormInstance } from "element-plus";
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter();
const formSize = ref("default");
const ruleFormRef = ref<FormInstance>();
const ruleForm = reactive({
  title: "",
  author: "",
  type: "",
  grade1: "",
  grade2: "",
  grade3: "",
  date: "",
  wordCount:"",
  format:"",
  pageCount:"",
  bookbinding:"",
  language:"",
  points:1,
});

const rules = reactive({
  title: [
    { required: true, message: "请输入书名", trigger: "blur" },
    // { min: 1, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
  ],
  author: [{ required: true, message: "请输入作者/核心", trigger: "blur" }],
  date: [
    {
      type: "date",
      required: true,
      message: "请选择一个日期",
      trigger: "change",
    },
  ],
  type: [
    {
      // type: "array",
      required: true,
      message: "请选择一个一级分类",
      trigger: "blur",
    },
  ],
  grade1: [{ required: true, message: "请输入二级分类", trigger: "blur" }],
  points: [{ required: true, message: "请输入申请每本所需积分", trigger: "blur" }]
});

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid, fields) => {
    if (valid) {
    ElMessage({
    showClose: true,
    message: '添加成功',
    type: 'success',
    })
    router.go(0);
    } else {
      console.log("error submit!", fields);
    }
  });
};

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.resetFields();
};
</script>