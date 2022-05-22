<template>
    <div>{{ FormatTime(nowTime) }}</div>
</template>


<script lang="ts">
import { _getUser } from "../../api/userList/userList";
import { computed, reactive, ref } from "vue";
import { ElMessage } from 'element-plus'
export default {
data() {
  return {
    timer: undefined,
    nowTime: new Date(),
  };
},
created() {
  // 显示时间
  this.timer = setInterval(() => {
    this.nowTime= new Date().toLocaleString();
  });
},
// 销毁定时器
beforeDestroy() {
  if (this.timer) {
    clearInterval(this.timer);
  }
},
methods: {
    FormatTime() {
      //返回显示的日期时间格式
      var date = new Date();
      var year = this.formatTime(date.getFullYear());
      var month = this.formatTime(date.getMonth() + 1);
      var day = this.formatTime(date.getDate());
      var hour = this.formatTime(date.getHours());
      var minute = this.formatTime(date.getMinutes());
      var second = this.formatTime(date.getSeconds());
      var weekday = date.getDay();
      var weeks = new Array(
        "星期日",
        "星期一",
        "星期二",
        "星期三",
        "星期四",
        "星期五",
        "星期六"
      );
      var week = weeks[weekday];
      return `${year}-${month}-${day} ${hour}:${minute}:${second} ${week}`;
    },
    formatTime(n) {
      //判断是否需要加0
      if (n < 10) {
        return "0" + n;
      } else {
        return n;
      }
    },
}
 
};
</script>