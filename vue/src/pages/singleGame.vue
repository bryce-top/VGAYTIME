<template>
  <div>
    <headbar />

  <div class="singleGame">

    <div id="gameinfo">
      <b-jumbotron bg-variant="dark" text-variant="white" border-variant="secondary">
        <template v-slot:header>{{ gamename }}</template>
        <template v-slot:lead>
          {{ company}}
        </template>
        <hr class="my-4">
        <p>
          {{ gameinfo }}
        </p>
      </b-jumbotron>
    </div>
    <div id="comment">
     <h1 style="color: white">评论</h1>
      <hr class="my-4">
    <div id="singlecomment" v-for="item in comment">
    <b-list-group >
      <b-list-group-item >{{  }}</b-list-group-item>
      <b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
      <b-list-group-item>Morbi leo risus</b-list-group-item>
    </b-list-group>
  </div>
  </div>
  </div>
  </div>
</template>

<script>
import headbar from '@/pages/header';
export default {
  name: "singleGame",
  components:{
    headbar
  },
  created() {
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
  },
  mounted() {
    this.search();
  },
  watch: {
    '$route' (to, from) {
      // 在mounted函数执行的方法，放到该处
      this.search();
    }},

  // },
  data(){
    return{
      gamename:'',
      company:'',
      gameinfo:'',
      page: 0,
      page_size: 5,
      page_count: 10,
      comment:[]
    }
  },
  methods:{
    search(){
      if(this.$route.query.id){
        var id=this.$route.query.id
        this.axios.get("/do/game/findGamebyid?id="+id,).then(res=>{
          var jsonObj =JSON.parse(JSON.stringify(res.data));
          if (res.data){
            this.gamename=jsonObj[0].name
            this.gameinfo=jsonObj[0].content
            this.company=jsonObj[0].company
            this.getData()
          }
        });}
      // else if(this.$route.query.name){
      //   var name=this.$route.query.name
      //   this.axios.get("/do/comment/getGameComment?game_id="+this.$cookies.get("game_id"),).then(res=>{
      //     var jsonObj =JSON.parse(JSON.stringify(res.data));
      //     if (res.data!=''){
      //       this.game=res.data;
      //       this.reload()
      //     }else{
      //       alert("无数据！");
      //       this.$router.push("/");
      //     }
      //   });
      // }
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
      _this.$http.get('do/comment/getGameComment',{
        params: {
          page:_this.page,
          page_size:_this.page_size,
          game_id:this.$cookies.get("game_id")
        }
      }).then((res)=>{

        _this.comment =_this.game.comment(res.data);
      },(err)=>{
        console.log(err);
      })
    },


  }
}


</script>

<style scoped>
.singleGame{
  background-image: url("../img/bak.png");
  height: 1080px;
  width: 1920px;
}
#gameinfo{
  position: absolute;
  top: 10%;
  width: 70%;
  left: 15%;
}
#comment{
  background-color: #2c3e50;
 position: absolute;
  top: 32%;
  left: 15%;
  width: 70%;
}
</style>
