<template style="height:100%">
  <div id="building">
  <div>
  <headbar />
    <el-col :span="1">
      <el-menu
        :mode="horizontal"
        default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#303133"
        text-color="#C0C4CC"
        active-text-color="#D351E1">
        <el-menu-item index="1">所有游戏</el-menu-item>
        <el-menu-item index="2">动作游戏</el-menu-item>
        <el-menu-item index="3">角色扮演</el-menu-item>
        <el-menu-item index="4">射击游戏</el-menu-item>
      </el-menu>
    </el-col>
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
      tabPosition: 'left',
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
#building{
  /*background:url("../img/bak.png");*/
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}
</style>
