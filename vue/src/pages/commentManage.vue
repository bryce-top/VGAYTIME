<template>
  <v-row justify="center">
    <v-expansion-panels
      inset
      accordion
    >
      <v-expansion-panel
        v-for="(game,index1) in games"
        v-bind:key="index1"
      >
        <v-expansion-panel-header @click="getComment(index1)" >{{game.name}}</v-expansion-panel-header>

        <v-expansion-panel-content
          v-for="(comment,index2) in comments"
          v-bind:key="index2"
        >
          <v-icon
            x-large
            class="mr-2"
            @click="deleteComment(index2,comment)"
          >
            mdi-delete-outline
          </v-icon>
          <v-snackbar
            v-model="snackbar"
          >
            {{ text }}

            <template v-slot:action="{ attrs }">
              <v-btn
                color="pink"
                text
                v-bind="attrs"
                @click="snackbar = false"
              >
                关闭
              </v-btn>
            </template>
          </v-snackbar>
          {{comment.content}}
        </v-expansion-panel-content>

      </v-expansion-panel>
    </v-expansion-panels>
  </v-row>
</template>

<script>
export default {
  name: "commentManage",
  data() {
    return {
      number:'',
      games:[],
      comments: [],
      snackbar: false,
      text: `已成功删除`,
    }
  },
  created() {
    this.$axios.get('/do/game/AllGame')
      .then(res=> {
        console.log(res.data);
        this.games = res.data;
      });
  },
  methods:{
    getComment (index) {
      console.log(this.games[index].id);
      this.$axios.get('/do/comment/getGameComment',{
        params: {
          page: 0,
          page_size: 100000,
          game_id:this.games[index].id
        }
      })
        .then(res=> {
          console.log("success");
          this.comments = res.data;
          // console.log(this.comments);
        });
      this.comments = [];
    },
    deleteComment(index,comment){
      this.snackbar = true;
      this.comments.splice(index, 1);
      console.log(comment);
      this.$axios.post('/do/comment/deleteComment', comment)
        .then(res=> {
          console.log(res);
          console.log('delete success');
        })
    }
  }
}
</script>

<style scoped>

</style>
