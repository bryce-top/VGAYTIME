<template>
  <div>
    <headbar />

<div class="showGame">
  <div v-for="item in game">
    <h1>{{item.name}}</h1>
    <h2>{{item.company}}</h2>
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
  created() {
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
  },
  mounted() {
    this.searchGamebyType()
  },
  watch: {
    '$route' (to, from) {
      // 在mounted函数执行的方法，放到该处
      this.searchGamebyType();
    }},
  data(){
    return{
      game:''
    }
  },
  methods:{
    searchGamebyType(){

      var type=this.$route.query.type

      this.axios.get("/do/game/findGamebytype?type="+type,).then(res=>{
        var jsonObj =JSON.parse(JSON.stringify(res.data));
        if (res.data){

          this.game=res.data;
        }
      });
    }
  }

}
</script>

<style scoped>

</style>
