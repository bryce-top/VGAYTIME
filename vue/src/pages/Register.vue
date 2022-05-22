<template>
  <div class="container">
    <div id="poem" >
      <h1 >夕阳红</h1><br><br>
      <p>去吧，&nbsp&nbsp&nbsp去做不一样的自己</p><br>
      <p>去做不被定义的狂兵</p><br>
      <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp------致亲爱的尼少</p>
    </div>
    <div class="box">
        <p style="text-align: center; position: relative; top: -20px">
          <img
            src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/LOGO.png"
            style="position:absolute;width: 67px; height: 33px;top:-160px;left:90px;"
          />
        </p>
        <div class="reg" style="color:white;">
          <h1 style="text-align: center;">注册</h1><br><br>
          用户名<el-input v-model="username" placeholder="请输入用户名"></el-input><br><br>
           邮箱<el-input v-model="email" placeholder="请输入邮箱"></el-input><br><br>
           账号<el-input v-model="account" placeholder="请输入邮箱"></el-input><br><br>
           密码<el-input v-model="password" placeholder="请输入密码"></el-input><br><br>
          <router-link :to="{path:'/login'}"><b-button id="loginbutton">去登录</b-button></router-link>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
          <b-button id="registerbutton" type="submit" @click="register">注册</b-button>
        </div>
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

<!--<style scoped>-->
<!--.el-input {-->
<!--  width: 200px;-->
<!--}-->
<!--#register{-->
<!--  background-image:url("../img/3.png");-->
<!--  background-repeat: no-repeat;-->
<!--  background-position: center;-->
<!--  background-color: pink;-->
<!--  height: 100%;-->
<!--  width: 100%;-->
<!--  position: absolute;-->
<!--  left: 0px;-->
<!--}-->
<!--#reg{-->
<!--  position: absolute;-->

<!--  height: 45%;-->
<!--  width: 30%;-->
<!--  top: 35%;-->
<!--  left: 35%;-->
<!--  background-color: white;-->
<!--  opacity: 0.9;-->
<!--  border-radius: 15px;-->
<!--}-->
<!--</style>-->
<style type="text/css">
#poem{
  text-align: left;
  left: 5%;
  position: absolute;
}
.input{
  position: relative;
  /* background: red; */
  left: -13%;
  width: 100%;
}
.container {
  height: 100%;
}

.box {
  position: relative;
  width: 430px;
  height: 660px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
  margin-top: 8%;
  margin-bottom: 6.45%;
  background: rgb(18, 18, 18);
}

.box::before {
  content: "";
  position: absolute;
  top: -2px;
  left: -2px;
  right: -2px;
  bottom: -2px;
  background: #fff;
  z-index: -1;
}

.box::after {
  content: "";
  position: absolute;
  top: -2px;
  left: -2px;
  right: -2px;
  bottom: -2px;
  background: #fff;
  z-index: -2;
  filter: blur(40px);
}

.box:before,
.box:after {
  background: linear-gradient(235deg, #d351e1, #060c21, #3d1963);
}

.content {
  padding: 20px;
  box-sizing: border-box;
  color: #fff;
}

.content p {
  font-size: 10px;
  margin-bottom: 20px;
}

.logo {
  position: relative;
  width: 85px;
  height: 50px;
}
</style>
