<template style="height:100%">
  <div id="building">
  <div>
  <headbar />
    <div id="tab">
    <el-tabs :tab-position="tabPosition" v-model="activeName" @tab-click="handleClick" >
      <el-tab-pane label="所有游戏" name="first">所有游戏</el-tab-pane>
      <el-tab-pane label="动作游戏" name="second">动作游戏</el-tab-pane>
      <el-tab-pane label="角色扮演游戏" name="third">角色扮演游戏</el-tab-pane>
      <el-tab-pane label="射击游戏" name="fourth">射击游戏</el-tab-pane>
    </el-tabs>
    </div>
  </div>
  </div>
</template>

<script>
import headbar from '@/pages/header';
export default {
  name: "AllGame",
  components:{
    headbar
  },
  data(){
    return{
      activeName: 'first',
      tabPosition: 'left'
    }
  },

  created() {
    this.axios.get('/do/game/AllGame').then(res=>{
      var jsonObj =JSON.parse(JSON.stringify(res.data));
      this.game=res.data;
    })
    // if (!this.$cookies.isKey('account')){
    //   this.$router.push("/login")
    // }
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }

}
</script>

<style scoped>
#tab{
  color: white;
}
#building{
  /*background:url("../img/bak.png");*/
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}
h1,h2{
  color: red;
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
