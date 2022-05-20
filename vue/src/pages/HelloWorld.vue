<template>
  <div class="hello">

    <el-menu :default-active="this.$route.path" class="el-menu-demo" router mode="horizontal" @select="handleSelect">
      <el-menu-item index="/" >首页</el-menu-item>
      <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-menu-item index="2-1" >选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="/AllGame">游戏展示</el-menu-item>
      <el-menu-item index="/login">登录</el-menu-item>
      <b-form-input v-model="id" size="sm" class="mr-sm-2" placeholder="SearchGamebyid"></b-form-input>
      <b-button size="sm" class="my-2 my-sm-0" type="submit" @click="searchid">Search</b-button>
      <b-form-input v-model="name" size="sm" class="mr-sm-2" placeholder="SearchGamebyname"></b-form-input>
      <b-button size="sm" class="my-2 my-sm-0" type="submit" @click="searchname">Search</b-button>
    </el-menu>
    <div class="line"></div>
    <div id="typebutton">
      <b-button-group vertical>
        <b-button variant="danger" @click="searchAction('动作')" >动作</b-button>
        <b-button variant="info" @click="searchAction('动作')" >竞速</b-button>
        <b-button variant="danger" @click="searchAction('射击')">射击</b-button>
        <b-button variant="info" @click="searchAction('角色扮演')">角色扮演</b-button>
      </b-button-group>
    </div>
    <h1>{{ msg }}</h1>
    <h2>玩游戏多是件美事啊</h2>
    <h3>{{user}}</h3>
    <router-link :to="{path:'/singleGame',query:{id:1,}}" id="link">单个游戏展示</router-link>


  </div>
</template>

<script>
export default {
  name: 'HelloWorld',

  data () {
    return {
      msg: 'Welcome to VGAYTIME',
      user:this.$cookies.get('account'),
      id:''
    }
  },
  created(){
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
  },
  methods:{
    searchid(){
      this.$router.push({path:'/singleGame',query:{id:this.id}});
    },
    searchname(){
      this.$router.push({path:'/singleGame',query:{name:this.name}});
    },
    searchAction(value){
      this.$router.push({path:'/showGame',query:{type:value}});
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.mr-sm-2{

  width: 10%;
  display: inline;
}
h1, h2, h3 {
  font-weight: normal;
  color: aqua;
}
.hello{
  height: 100%;
  width: 100%;
  top: 0px;
  left: 0px;
  position: absolute;
  background-image: url("../img/2.png");
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}
#typebutton{
  position: absolute;
  left: 0px;
  top: 10%;
}
</style>
