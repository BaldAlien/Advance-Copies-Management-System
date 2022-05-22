<template>
  <el-container id="container">
    <el-header id="header"> header </el-header>
    <el-container>
      <el-aside
        id="sider"
        :width="asideWidth"
        :class="{ asideFloat: isAsideFloatActive }"
      >sider
      </el-aside>
      <el-main id="main"> main</el-main>
    </el-container>
  </el-container>
</template>

<style  lang="scss" scoped>
#container {
  width: 100%;
  height: 100%;

  #header {
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);

    z-index: 999;
  }
  #sider {
    height: 100%;
    @media screen and (min-width: 1080px) {
      display: none;

      overflow-x: hidden;
      overflow-y: auto;
      height: calc(100vh - 60px);
      transition-duration: 0.25s;
      transition-timing-function: linear;
    }

    z-index: 998;
  }
  #mask {
    z-index: 997;
    background-color: rgba(192, 192, 192, 0.5);
    width: 100%;
    height: 100%;
    position: absolute;
  }
  #main {
    padding: 0;
    height: calc(100vh - 60px);
    overflow: auto;
  }
  .asideFloat {
    position: absolute;
  }
  #main {
    background-color: rgb(250, 250, 250);
  }
}
</style>