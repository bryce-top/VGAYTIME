<template>
<div id="register">
  <div id="reg">
    <p style="text-align: center">注册</p><br><br>
    用户名<el-input v-model="username" placeholder="请输入用户名"></el-input><br><br>
     邮箱<el-input v-model="email" placeholder="请输入邮箱"></el-input><br><br>
     账号<el-input v-model="account" placeholder="请输入内容"></el-input><br><br>
     密码<el-input v-model="password" placeholder="请输入密码"></el-input><br><br>
    <router-link :to="{path:'/login'}"><b-button id="loginbutton">去登录</b-button></router-link>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <b-button id="registerbutton" type="submit" @click="register">注册</b-button>
  </div>
</div>
</template>

<script>
export default {
  name: "register",
  data(){
    return{
      username:'',
      email:'',
      account:'',
      password:''
    }

  },
  methods:{
    register(){
      this.axios.post('/do/user/register', "account="+this.account+"&password="+this.password+"&username="+this.username+"&email="+this.email)
        .then(res=> {
          console.log(res);

          window.location.href='/'
        })
        .catch(function (error) {
          console.log(error);
        });
    }

  }

}
</script>

<style scoped>
.el-input {
  width: 200px;
}
#register{
  background-image:url("../img/3.png");
  background-repeat: no-repeat;
  background-position: center;
  background-color: pink;
  height: 100%;
  width: 100%;
  top: 0px;
  position: absolute;
  left: 0px;

}
#reg{
  position: absolute;

  height: 45%;
  width: 30%;
  top: 35%;
  left: 35%;
  background-color: white;
  opacity: 0.9;
  border-radius: 15px;
}
</style>
