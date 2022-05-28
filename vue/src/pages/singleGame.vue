<template>
  <div>
    <headbar />

  <div class="singleGame">

    <ul v-for="item in game">
      <li>{{item.name}}</li>
      <li>{{item.company}}</li>
    </ul>

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
      game:''
    }
  },
  methods:{
    search(){

      if(this.$route.query.id){
        var id=this.$route.query.id
        this.axios.get("/do/game/findGamebyid?id="+id,).then(res=>{
          var jsonObj =JSON.parse(JSON.stringify(res.data));
          if (res.data){

            this.game=res.data;

          }
        });}else if(this.$route.query.name){

        var name=this.$route.query.name
        this.axios.get("/do/game/findGamebyname?name="+name,).then(res=>{
          var jsonObj =JSON.parse(JSON.stringify(res.data));

          if (res.data!=''){
            this.game=res.data;
            this.reload()
          }else{
            alert("无数据！");
            this.$router.push("/");
          }
        });
      }
    }
  }
}


</script>

<style scoped>
.singleGame{
  background-image: url("../img/bak.png");
  height: 1080px;
  width: 1920px;
}

</style>
