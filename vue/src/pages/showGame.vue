<template>
<div class="showGame">
  <div v-for="item in game">
    <h1>{{item.name}}</h1>
    <h2>{{item.company}}</h2>
  </div>
</div>
</template>

<script>
export default {
  name: "showGame",
  created() {
    var type=this.$route.query.type
    this.axios.get("/do/game/findGamebytype?type="+type,).then(res=>{
      var jsonObj =JSON.parse(JSON.stringify(res.data));
      if (res.data){

        this.game=res.data;
      }
    });
  },
  data(){
    return{
      game:''
    }
  }
}
</script>

<style scoped>

</style>
