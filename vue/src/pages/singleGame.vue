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
      <b-input-group prepend="评论" class="mt-3">
        <b-form-input v-model="newcomment"></b-form-input>
        <b-input-group-append>
          <b-button variant="info" @click="insertComment()">发表</b-button>
        </b-input-group-append>
      </b-input-group>
      <hr class="my-4">
    <div id="singlecomment" v-for="item in comment" >
      <b-list-group  >
        <b-list-group-item style="background-color: #2c3e50;color: white">{{ item.content }}</b-list-group-item>
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
    window.addEventListener('scroll', this.lazyLoading);
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
      page_size: 15,
      page_count: 10,
      comment:[],
      newcomment:''
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
            this.axios.get("/do/comment/getTotal?game_id="+this.$cookies.get("game_id")).then(res=>{
              if(res.data)
               this.page_count=res.data
            });
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
      _this.$http.get('/do/comment/getGameComment',{
        params: {
          page:_this.page,
          page_size:_this.page_size,
          game_id:this.$cookies.get("game_id")
        }
      }).then((res)=>{

        _this.comment =_this.comment.concat(res.data);
      },(err)=>{
        console.log(err);
      })
    },
    insertComment(){
      var obj={'user_id':this.$cookies.get("user_id"),'game_id':this.$cookies.get("game_id"),'content':this.newcomment}
      this.axios.post("/do/comment/insertGameComment",obj).then(res=>{
        if (res.data){
          this.$router.go(0)
        }
      })
    },
  }
}


</script>

<style scoped>
.singleGame{
  background-image: url("../img/bak.png");
  background-repeat: repeat-y;
  min-height: 94%;
  min-width: 100%;
  position: absolute;

}
#gameinfo{
  /*position: absolute;*/
  position: relative;
  top: 10%;
  width: 70%;
  left: 15%;
}
#comment{
  background-color: #2c3e50;
 /*position: absolute;*/
  position: relative;
  top: 32%;
  left: 15%;
  width: 70%;
}
</style>
