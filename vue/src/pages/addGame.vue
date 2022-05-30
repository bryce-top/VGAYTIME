<template>
  <div>
    <headbar />
  <v-card>
    <v-card-title>
      <span class="text-h5">新增游戏</span>
    </v-card-title>

    <v-card-text>
      <v-container>
        <v-row>
          <v-col
            cols="12"
            sm="6"
            md="6"
          >
            <v-text-field
              label="游戏名称"
              v-model="game.name"
            ></v-text-field>
          </v-col>
          <v-col
            cols="12"
            sm="6"
            md="6"
          >
            <v-text-field
              label="类型"
              v-model="game.type"
            ></v-text-field>
          </v-col>
          <v-col
            cols="12"
            sm="6"
            md="6"
          >
            <v-text-field
              label="公司"
              v-model="game.company"
            ></v-text-field>
          </v-col>
          <v-col
            cols="12"
            sm="6"
            md="6"
          >
            <v-text-field
              label="区域"
              v-model="game.region"
            ></v-text-field>
          </v-col>
          <v-col
            cols="12"
            sm="6"
            md="6"
          >
            <v-text-field
              label="画面"
              v-model="game.dimension"
            ></v-text-field>
          </v-col>
          <v-col
            cols="12"
            sm="6"
            md="12"
          >
            <v-text-field
              label="简介"
              v-model="game.content"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-card-text>

    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn
        color="blue darken-1"
        text
        @click="close"
      >
        退出
      </v-btn>
      <v-btn
        color="blue darken-1"
        text
        @click="save"
      >
        保存
      </v-btn>
    </v-card-actions>
  </v-card>
  </div>
</template>

<script>
import headbar from '@/pages/header';
export default {
  name: "addGame",
  data(){
    return{
      game:{
      name:'',
      company:'',
      region:'',
      type:'',
      content:'',
      dimension:''
      }
    }
  },
  created() {
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
  },
  methods:{
    save(){
      this.axios.post('/do/game/insertGame', this.game)
        .then(res=> {
          alert("添加成功，等待管理员审核")
          console.log(res);
          window.location.href='/'
        })
    },
    close(){
      window.location.href='/'
    }

    }
  }


</script>

<style scoped>

</style>
