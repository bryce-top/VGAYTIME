<template>
  <div id="login">
    <div id="poem">
    <h1 >夕阳红</h1><br><br>
      <p>去吧，&nbsp&nbsp&nbsp去做不一样的自己</p><br>
    <p>去做不被定义的狂兵</p><br>
      <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp------致亲爱的尼少</p>
    </div>
    <div id="log">
      <p style="text-align: center">登录</p><br><br><br>
      账号<el-input v-model="account" placeholder="请输入内容"></el-input><br><br><br>
      密码<el-input v-model="password" placeholder="请输入密码" type="password"></el-input><br><br>
      <p id="loginfo">{{loginfo}}</p>
      <b-button id="loginbutton" type="submit" @click="login">登录</b-button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<router-link :to="{path:'/register'}"><b-button>去注册</b-button></router-link>
    </div>
  </div>


</template>

<script>

import {h} from "vue";

export default {
    name:"Login.vue",
    data(){
      return {
          account:'',
          password:'',
          loginfo:''
      }
    },
  methods: {
    login(){

      this.axios.post('/do/user/login', "account="+this.account+"&password="+this.password+"")
        .then(res=> {
          console.log(res);
          if (res.data){

            this.loginfo="登录成功";

            this.$cookies.set('account',this.account,'1h');

          window.location.href='/'
          }else {
            this.loginfo="账号或密码错误！"
          }
        })
        .catch(function (error) {
          console.log(error);
        });

  }

}
}
</script>
<style  scoped>
.el-input {
  width: 200px;
}
#poem{
  text-align: left;
  left: 5%;
  position: absolute;
}
#login{
  background-image:url("../img/1.png");
  background-repeat: no-repeat;
  background-position: center;
  background-color: pink;
  height: 100%;
  width: 100%;
  top: 0px;
  position: absolute;
  left: 0px;

}
#log{
  position: absolute;

  height: 35%;
  width: 30%;
  top: 35%;
  left: 35%;
  background-color: white;
  opacity: 0.9;
  border-radius: 15px;
}
#loginfo{
  color: red;
  font-size: small;
  position: absolute;
  left: 45%;
  top: 20%;
}
</style>
