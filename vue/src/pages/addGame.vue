<template>
  <div>
    <div>
      <h1> 添加游戏 </h1>
      <b-card bg-variant="light">
        <b-form-group
          label-cols-lg="3"
          label="游戏信息"
          label-size="lg"
          label-class="font-weight-bold pt-0"
          class="mb-0"
        >
          <b-form-group
            label-cols-sm="3"
            label="游戏名:"
            label-align-sm="right"
            label-for="nested-street"
          >
            <b-form-input id="nested-street" v-model="game.gamename"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="公司:"
            label-align-sm="right"
            label-for="nested-city"
          >
            <b-form-input id="nested-city" v-model="game.company" ></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="类型:"
            label-align-sm="right"
            label-for="nested-state"
          >
            <b-form-input id="nested-state" v-model="game.type"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="内容:"
            label-align-sm="right"
            label-for="nested-country"
          >
            <b-form-input id="nested-country" v-model="game.content" ></b-form-input>
          </b-form-group>
          <b-form-group
            label-cols-sm="3"
            label="地区:"
            label-align-sm="right"
            label-for="nested-country"
          >
            <b-form-input id="nested-country" v-model="game.region" ></b-form-input>
          </b-form-group>


          <b-button @click="addGame">提交</b-button>
        </b-form-group>
      </b-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "addGame",
  data(){
    return{
      game:{
      gamename:'',
      company:'',
      region:'',
      type:'',
      content:''}
    }
  },
  created() {
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
  },
  methods:{
    addGame(){
      this.axios.post('/do/game/insertGame', this.game)
        .then(res=> {
          alert("添加成功，等待管理员审核")
          this.reload();
          console.log(res);
        })
        .catch(function (error) {
          console.log(error);
          alert("失败")
          this.reload();
        });
    }

    }
  }


</script>

<style scoped>

</style>
