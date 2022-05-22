<template>
  <div id="menu-wrapper" v-if="ifMenu">
    <el-menu
      :default-active="activeIndex"
      :collapse="asideIsCollapse"
      @select="handleSelect"
      :mode="menuMode"
      id="menu"
    >
      <el-menu-item index="1">
        <template #title>首页</template>
      </el-menu-item>
      <el-menu-item index="2">
        <template #title>教育用书</template>
      </el-menu-item>
      <el-menu-item index="3">
        <template #title>学术著作</template>
      </el-menu-item>
      <el-menu-item index="4">
        <template #title>社会读物</template>
      </el-menu-item>
      <el-menu-item index="5">
        <template #title>期刊</template>
      </el-menu-item>
      <el-menu-item index="6">
        <template #title>个人中心</template>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import store from "../../store";
export default {
  name: "LayOutMenu",
  data() {
    return {
      ifMenu: true,
      activeIndex: "1",
      menuMode: "horizontal",
      asideIsCollapse: false,
      isAdmin: true,
      isHR: true,
      isFinance: true,
      isStaff: true,

      mapper: {
        1: "/presentation",
        2: "/edumall",
        3: "/academicmall",
        4: "/socialmall",
        5: "/journalmall",
        6: "/user",
      },
    };
  },
  components: {},

  methods: {
    handleSelect(key) {
      if (this.mapper[key] !== undefined) {
        this.$router.push(this.mapper[key]);
        if (window.innerWidth < 1080) {
          store.commit("setAsideIsCollapse", true);
        }
      }
    },
    setMode(width) {
      if (width < 1080) {
        this.menuMode = "vertical";
      } else {
        this.menuMode = "horizontal";
      }
    },
    setIndexActive() {
      if (this.$route.path.indexOf("edumall") !== -1) {
        this.ifMenu = false;
        this.$nextTick(() => {
          this.ifMenu = true;
          this.activeIndex = "2";
        });
      } else if (this.$route.path.indexOf("academicmall") !== -1) {
        this.ifMenu = false;
        this.$nextTick(() => {
          this.ifMenu = true;
          this.activeIndex = "3";
        });
      }else if (this.$route.path.indexOf("socialmall") !== -1) {
        this.ifMenu = false;
        this.$nextTick(() => {
          this.ifMenu = true;
          this.activeIndex = "4";
        });
      } else if (this.$route.path.indexOf("journalmall") !== -1) {
        this.ifMenu = false;
        this.$nextTick(() => {
          this.ifMenu = true;
          this.activeIndex = "5";
        });
      }
      else if (this.$route.path.indexOf("user") !== -1) {
        this.ifMenu = false;
        this.$nextTick(() => {
          this.ifMenu = true;
          this.activeIndex = "6";
        });
      }
    },
  },
  mounted() {
    this.setMode(window.innerWidth);
    this.setIndexActive();
  },
  computed: {
    getAsideIsCollapse() {
      return store.state.asideIsCollapse;
    },
    getWidth() {
      return store.state.width;
    },
  },
  watch: {
    getAsideIsCollapse(newEvent) {
      this.asideIsCollapse = newEvent;
    },
    getWidth(width) {
      this.setMode(width);
    },
    $route() {
      this.setIndexActive();
    },
  },
};
</script>

<style  lang="scss" scoped>
#menu-wrapper {
  height: 100%;

  #menu {
    border: 0;
    height: 100%;
  }
}
</style>