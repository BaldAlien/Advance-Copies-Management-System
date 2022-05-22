<template>
  <div class="auth">
    <div class="auth-card">
      <login-form
        class="login-form"
        v-if="currentState === 'login'"
      ></login-form>
      <regist-form
        class="regist-form"
        v-else-if="currentState === 'regist'"
      ></regist-form>
      <alter-form
        class="alter-form"
        v-else-if="currentState === 'alter'"
      ></alter-form>
    </div>
  </div>
</template>

<script lang="ts">
import LoginForm from "../components/auth/LoginForm.vue";
import RegistForm from "../components/auth/RegistForm.vue";
import AlterForm from "../components/auth/AlterForm.vue";
import store from "../store";

export default {
  components: { LoginForm, RegistForm, AlterForm },
  setup() {},
  data() {
    return {
      currentState: "login",
    };
  },
  computed: {
    getEvent() {
      return store.state.event;
    },
  },
  watch: {
    getEvent(newEvent: string) {
      this.currentState = newEvent;
    },
  },
};
</script>

<style lang="scss">
.auth {
  // position: absolute;
  background: #f7f8fa;
  width: 100%;
  height: 100%;
  .auth-card {
    width: 450px;
    top: calc(50% - 250px);
    padding-top: 95px;
    margin: 0 auto;
    box-sizing: border-box;
    @media screen and(max-width:1080px) {
      right: calc(50% - 275px);
    }
    @media screen and(max-width:720px ) {
      width: 100%;
      height: 100%;
      max-width: 100%;
      top: 0;
      right: 0;
    }
    @media screen and(max-height:720px ) {
      width: 100%;
      height: 100%;
      max-width: 100%;
      top: 0;
      right: 0;
    }
    .login-form {
      width: 100%;
      background-color: #fff;
      padding: 60px;
      box-sizing: border-box;
      box-shadow: 0px 0px 10px 10px rgba(0, 0, 0, 0.05);
      border-radius: 5px;
      overflow: auto;
      @media screen and(max-width:720px) {
        padding-top: 80px;
      }
    }
    .regist-form {
      @extend .login-form;
      @media screen and(min-width:720px) {
        position: relative;
        top: -50px;
      }
    }
  }
}
</style>