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
  methods:{
    computed: {                     //监听词条
      getSearchKey(){
        return this.$store.state.searchKey
      }
    },
    watch: {
      getSearchKey: {
        handler(){  //当词条改变时执行事件
          // this.recordis(newValue)
          // console.log('new',newValue)
          // console.log('old',oldValue)
          alert(1123)
          this.axios.get("/do/game/findGamebyname?name="+newValue,).then(res=>{
            var jsonObj =JSON.parse(JSON.stringify(res.data));
            if (res.data){
              location.reload()
              this.game=res.data;
            }
          });
        }
      }

    },
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
