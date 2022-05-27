<template>
  <div class="line">
    <el-menu
      style="border: none"
      :default-active="this.$route.path"
      class="el-menu-demo"
      router mode="horizontal"
      @select="handleSelect"
      background-color="#303133"
      text-color="#C0C4CC"
      active-text-color="#D351E1"
    >
      <router-link to="/">
        <img
          src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/LOGO.png"
          style="
            width: 3%;
            height: auto;
            margin: 1% 2% 0 1%;
            float: left;
          "
          alt=""
        /></router-link>
      <el-menu-item index="/">首页</el-menu-item>
      <el-menu-item index="/allGame" >所有游戏</el-menu-item>
      <el-submenu index="2">
        <template #title>游戏分类</template>
        <el-menu-item index="/showGame?type=竞技">竞技</el-menu-item>
        <el-menu-item index="/showGame?type=射击">射击</el-menu-item>
        <el-menu-item index="/showGame?type=角色扮演">角色扮演</el-menu-item>
      </el-submenu>
      <el-menu-item index="" @click="changeUser">{{ sta }}</el-menu-item>
      <el-menu-item index="" @click="userHome">{{ userhome }}</el-menu-item>
      <div class="right">
        <div class="login" v-show="noLogin">
          <el-submenu index="5">
            <template #title>
              <img
                src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/n7efKzPzaW.png"
                style="width: 15%; margin-right: 10%"
                alt=""
              />登录</template
            >
            <router-link to="/register"
            ><el-menu-item index="5-1">账号注册</el-menu-item></router-link
            >
            <router-link to="/login">
              <el-menu-item index="5-2">立即登录</el-menu-item></router-link
            >
          </el-submenu>
        </div>
        <el-col id="search" :span="6" style="float:right;margin-right: 5%;width: 270px; margin-top: 10px; margin-bottom: 5px" >
          <el-input
            type="text"
            prefix-icon="el-icon-search"
            v-model="kb_content"
            placeholder="请输入"
            style="width: 270px; cursor: pointer"
            @keyup.enter.native="getGame"
          ></el-input>
        </el-col>
      </div>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'header',
  data() {
    return {
      options: [],
      value: [],
      list: [],
      loading: false,
      kb_content:'',
      user:'登录',
      userhome:''
    }
  },
  mounted() {
    this.list = this.states.map(item => {
      return { value: `value:${item}`, label: `label:${item}` };
    });
    this.changeUser();
  },


  created() {
    if(!this.$cookies.isKey('account')){
      this.sta='登录'
      this.$router.push('/login');
    }else {this.sta='退出登录',this.userhome='个人信息'}
  },

  methods:{
    getGame(){
      // window.location.href="http://localhost:8080/#/singleGame"
      this.$router.push({path: "/singleGame",query: {name:this.kb_content}});
      if(this.kb_content){
        this.$store.dispatch('setSearchKey',this.kb_content)  //当输入词条时，将词条更新到数据仓库
      }
    },
    changeUser(){
      this.$cookies.remove('account')
      this.sta='登录';
      this.userhome='';
      this.$router.push('/login');
    },
    userHome(){
      if (!this.$cookies.isKey('account')){
      }else {
        this.$router.push('/userHome');
      }
    }


  }
}
</script>

<style scoped>
#search{

}
.line {
  min-height: 100%;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
  width: auto;
}
</style>
