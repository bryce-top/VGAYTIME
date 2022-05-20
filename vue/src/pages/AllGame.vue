<template style="height:100%">
<div class="AllGame">
  <el-row :gutter="20">
    <el-col :span="6"><div class="grid-content bg-purple">动作</div></el-col>
    <el-col :span="6"><div class="grid-content bg-purple">竞速</div></el-col>
    <el-col :span="6"><div class="grid-content bg-purple">射击</div></el-col>
    <el-col :span="6"><div class="grid-content bg-purple">休闲</div></el-col>
  </el-row>
<!--<div id="r1">-->
<!--  <div class="r1" v-for="item in game"><h1> {{item.name}}</h1>,<h2>{{item.company}}</h2></div>-->
<!--</div>-->
  <div class="r1" v-for="item in game"><h1> {{item.name}}</h1>,<h2>{{item.company}}</h2></div>
  <router-link :to="{path:'/'}" id="link">返回首页</router-link>
</div>
</template>

<script>

export default {
  name: "AllGame",
  data(){
    return{
      game:''
    }
  },

  created() {
    this.axios.get('/do/game/AllGame').then(res=>{
      var jsonObj =JSON.parse(JSON.stringify(res.data));
      this.game=res.data;
    })
  },

}
</script>

<style scoped>
h1,h2{
  color: red;
}
.AllGame{
  min-height: 100%;
  width: 100%;
  top: 0px;
  left: 0px;
  position: absolute;
  background-image: url("../img/4.png");
  background-attachment: scroll;
  background-repeat: repeat-y;

  background-position: center;
  /*background-size: cover;*/

}
/*.el-row {*/
/*   margin-bottom: 20px;*/
/*&:last-child {*/
/*   margin-bottom: 0;*/
/* }*/
/*}*/
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
#r1{
  position: absolute;
  left: 1%;
  height: 80%;
  background: #99a9bf;
  opacity: 0.7;
  top: 10%;
  width: 22%;
}
.r1{
  float: left;
  min-height: 30%;
  width: 25%;
  background: #2c3e50;
  border: 6px solid#e3e3e3;
  opacity: 0.8;
}
#link{
  top: 90%;
  left: 5%;
  position: absolute;
  color: red;
}
</style>
