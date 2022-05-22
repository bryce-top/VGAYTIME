<template>
  <div id="app">
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
          <el-menu-item index="2-1">竞技</el-menu-item>
          <el-menu-item index="2-2">射击</el-menu-item>
          <el-menu-item index="2-3">角色扮演</el-menu-item>
        </el-submenu>
        <el-menu-item index="3">关于我们</el-menu-item>
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
<!--          <div class="login" v-show="!noLogin">-->
<!--            <el-submenu index="6">-->
<!--              <template #title-->
<!--              ><img-->
<!--                src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/%E6%88%91%E7%9A%84.png"-->
<!--                style="width: 15%; margin-right: 10%"-->
<!--                alt=""-->
<!--              />{{ user.name }}</template-->
<!--              >-->
<!--              &lt;!&ndash; <img src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/%E6%88%91%E7%9A%84.png" style="width:15%;margin-right:10%" alt=""> &ndash;&gt;-->
<!--              <el-menu-item index="6-1" @click="gotoprofile">我的账号</el-menu-item>-->
<!--              <el-menu-item @click="tologout" index="6-2">退出登录</el-menu-item>-->
<!--            </el-submenu>-->
<!--          </div>-->

<!--                 搜索框-->

          <el-col id="search" :span="6" style="float:left; margin-left: 45vw;width: 270px; margin-top: 10px; margin-bottom: 5px" >
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
    <router-view/>
  </div>
</template>

<script>


export default {
  name: 'App',
  data() {
    return {
      options: [],
      value: [],
      list: [],
      loading: false,
      kb_content:''
    }
  },
  mounted() {
    this.list = this.states.map(item => {
      return { value: `value:${item}`, label: `label:${item}` };
    });
  },
  methods:{
    getGame(){
      // window.location.href="http://localhost:8080/#/singleGame"

      this.$router.push({path: "/singleGame",query: {name:this.kb_content}});
      if(this.kb_content){
        this.$store.dispatch('setSearchKey',this.kb_content)  //当输入词条时，将词条更新到数据仓库
      }
    }
  }
 }
</script>

<style>
#search{

}
#app {
  min-height: 100%;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>

