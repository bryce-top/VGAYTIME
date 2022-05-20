<template>
<div>
  <h1> Hello, {{user}}</h1>
</div>
</template>

<script>
export default {
  name: "UserInfo.vue",
  data(){
    return{
      user:''
    }
  },
  created() {
    //这里直接在created函数中使用axios的get请求向后台获取用户信息数据
    // 在实际开发中可以卸载apiadress.js中配置具体的method对应的路径和接口，这个
    //后面完善功能的情况下再进行介绍
    //this.$ajax('http://localhost:5050/do/user/showUser').then(res => {

      this.$axios.get('/do/user/showUser').then(res=>{
        var jsonObj =JSON.parse(JSON.stringify(res.data));

        this.user =jsonObj[0].username;

        console.log(res.data);

    }).catch(function (error) {
      console.log(error);
    });
  }
}
</script>

<style scoped>

</style>
