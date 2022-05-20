<template>
  <div class="singleGame">
    <ul v-for="item in game">
      <li>{{item.name}}</li>
      <li>{{item.company}}</li>
    </ul>

  </div>
</template>

<script>
export default {
  name: "singleGame",
  created() {
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
        if (res.data){

          this.game=res.data;

        }
      });
    }
  },
  data(){
    return{
      gamename:'',
      company:'',
      game:''
    }
  }

}
</script>

<style scoped>

</style>
