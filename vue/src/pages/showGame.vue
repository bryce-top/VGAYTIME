<template>
  <div>
    <headbar />

<div class="showGame">
  <div v-for="item in game" id="list" @click="showGame(item.id)">
    <h1 id="gamename">{{item.name}}</h1>
    <p id="company">{{item.company}}</p>
  </div>
</div>
  </div>
</template>

<script>
import headbar from '@/pages/header';
export default {
  name: "showGame",
  components:{
    headbar
  },
  created(){
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
  },
  mounted() {
    this.searchGame()
    window.addEventListener('scroll', this.lazyLoading);
  },
  watch: {
    '$route' (to, from) {
      // 在mounted函数执行的方法，放到该处
      this.searchGame();
    }},
  data(){
    return{
      game:[],
      page: 0,
      page_size: 5,
      page_count: 10,
    }
  },
  methods:{
    searchGame(){
    if (this.$route.query.type){
      var type=this.$route.query.type

      this.axios.get("/do/game/findGamebytype?type="+type,).then(res=>{
        var jsonObj =JSON.parse(JSON.stringify(res.data));
        if (res.data){
          this.game=res.data;
        }
      });
    }else if (this.$route.query.name){
      this.$cookies.remove("game")
      this.$cookies.remove("game_id")
      var name=this.$route.query.name
      this.axios.get("/do/game/findTotal?name="+name).then(res=>{
        this.page_count=res.data
        if (res.data!=''){
              this.page=0
              this.$cookies.set("game",name,"1h")
              this.$cookies.set("game_id",this.$route.query.id,"1h")
              this.game=[]
              this.getData()
              this.reload()
            }else if (res.data==''){
              alert("无数据！");
              // this.$router.push("/");
            }
      })
      this.getData()
    }
    },
    showGame(id){
      this.$router.push({path: "/singleGame",query: {id:id}});
    },
    lazyLoading () {
      const scrollTop = document.documentElement.scrollTop
      const clientHeight = document.documentElement.clientHeight
      const scrollHeight = document.documentElement.scrollHeight

      if (scrollTop + clientHeight >= scrollHeight) {

        this.page++
        if (this.page * this.page_size > this.page_count) return
        this.getData()
      }
    },
    getData(){
      let _this = this;
      _this.$http.get('do/game/findGamebyname',{
        params: {
          page:_this.page,
          page_size:_this.page_size,
          name:this.$cookies.get("game")
        }
      }).then((res)=>{

        _this.game =_this.game.concat(res.data);
      },(err)=>{
        console.log(err);
      })
    },
  },


}
</script>

<style scoped>
.showGame{
  background-image: url("../img/bak.png");
  background-repeat: repeat-y;
  min-height: 94%;
  min-width: 100%;
  position: absolute;
}
#list{

  opacity: 0.9;
  width: 80%;
  height: 200px;
  left: 20%;
  margin: 5px;
  background-color: #204d74;
}
#list:hover{
  background-color: #2c3e50;
}
#gamename{

  position: relative;
  top: 10px;
  left: 2%;
  color: red;
}
#company{
  position: relative;
  top: 20%;
  left: 6%;
}
</style>
