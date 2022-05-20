<template>
  <div class="singleGame">
    <ul>
      <li>{{gamename}}</li>
      <li>{{company}}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "singleGame",
  created() {
    var id=this.$route.query.id
    this.axios.get("/do/game/findGamebyid?id="+id,).then(res=>{
      var jsonObj =JSON.parse(JSON.stringify(res.data));
      if (res.data){

        this.gamename=jsonObj.name;
        this.company=jsonObj.company;

      }
    });
  },
  data(){
    return{
      gamename:'',
      company:''
    }
  }

}
</script>

<style scoped>

</style>
