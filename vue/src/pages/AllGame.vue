<template style="height:100%">
  <div id="building">
  <div>
  <headbar />
    <el-card shadow="hover" class="news" >
      <img src="https://img01.vgtime.com/game/cover/2022/05/27/220527220827554_u8855.jpg" style="text-align: center;width:96%;height: 54%">
      <br><br>
      <a class="newsContent" href="https://www.vgtime.com/topic/1169948.jhtml" target="_blank">新一期索尼State of Play将于6月3日播出</a>
    </el-card>
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
  background:url("../img/bak.png");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}
.news{
  width:300px;
  height:270px;
  position:absolute;
  background: rgba(255,255,255,0.7);
  border: #989595;
}
</style>
