<template>
  <div id="building">
  <div id="login">
    <headbar />
    <div id="poem" >
    <h1 >夕阳红</h1><br><br>
      <p>去吧，&nbsp&nbsp&nbsp去做不一样的自己</p><br>
    <p>去做不被定义的狂兵</p><br>
      <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp------致亲爱的尼少</p>
    </div>
    <div class="box">
      <p style="text-align: center; position: relative; top: 45px;left:-8px;">
        <img
          src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/LOGO.png"
          style="position:absolute;width: 67px; height: 33px;top:-160px;left:100px;"
        />
      </p>
      <div class="reg" style="color:white;">
        <h1 style="text-align: center;">登录</h1><br><br>
              账号<el-input v-model="account" placeholder="请输入邮箱"></el-input><br><br><br>
              密码<el-input v-model="password" placeholder="请输入密码" type="password"></el-input><br><br>
              <p id="loginfo">{{loginfo}}</p>
              <b-button id="loginbutton" type="submit" @click="login">登录</b-button>&nbsp&nbsp&nbsp&nbsp
        <router-link :to="{path:'/register'}">
          <b-button id="registerbutton" class="pagebutton">去注册</b-button>
        </router-link>
        &nbsp&nbsp&nbsp&nbsp

          <b-button id="adminlogin" type="submit" class="pagebutton" @click="adminlogin">管理员</b-button>

      </div>
    </div>
  </div>
  </div>


</template>

<script>

import headbar from '@/pages/header';
export default {
    name:"Login.vue",
    components:{
      headbar
    },
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
      },
      adminlogin(){
        var obj = {'email': this.account, 'password': this.password}
        this.axios.post('/do/admin/adminLogin', obj)
        .then(res => {
          console.log(res)
          if (res.data){

            this.loginfo="登录成功";

            this.$cookies.set('account',this.account,'1h');

            window.location.href='/admin'
          }else {
            this.loginfo="账号或密码错误！"
          }
        })
      }
    }
}
</script>


<style type="text/css">
#building{
  background:url("../img/bak.png");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}

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

.pagebutton{
  color: white;
}
</style>
