<template style="height:100%">
  <div id="building">
  <div>
  <headbar />
    <div v-for="item in game" @click="getGame(item.id)">
    <el-card shadow="hover" class="news"  >
      <p>{{item.name}}</p>
      <img src="https://img01.vgtime.com/game/cover/2022/05/27/220527220827554_u8855.jpg" style="text-align: center;width:96%;height: 54%">
      <br><br>
     <p>{{item.company}}</p>
    </el-card>
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
      game:[],
      activeName: 'first',
      tabPosition: 'left',
    }
  },

  created() {
    this.axios.get('/do/game/AllGame').then(res=>{
      var jsonObj =JSON.parse(JSON.stringify(res.data));
      this.game=res.data;
    })
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    getGame(id){
      this.$cookies.set("game_id",id,"1h")
      this.$router.push({path: "/singleGame",query: {id:id}});
    }
  }

}
</script>

<style scoped>
#building{
  background:url("../img/bak.png");
  width:100%;
  min-height:100%;
  position:absolute;
  background-size:100% 100%;
}
.news{
  width:400px;
  height:400px;
  float: left;
  background: rgba(255,255,255,0.7);
  border: #989595;
  margin: 10px;
}
</style>
