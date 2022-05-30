<template>
  <v-container fluid>
    <v-data-iterator
      :items="games"
      item-key="name"
      :page.sync="page"
      :search="search"
      disable-pagination
      hide-default-footer
    >
      <template v-slot:default="{ items, isExpanded, expand }">
        <v-row>
          <v-col
            v-for="item in items"
            :key="item.name"
            cols="12"
            sm="6"
            md="4"
            lg="3"
          >
            <v-card>
              <v-card-title>
                <h4>{{ item.name }}</h4>
              </v-card-title>
              <v-btn
                :disabled="!valid"
                color="success"
                class="mr-4"
                @click="check(item)"
              >
                通过
              </v-btn>
              <v-switch
                :input-value="isExpanded(item)"
                :label="isExpanded(item) ? '关闭' : '查看详情'"
                class="pl-4 mt-0"
                @change="(v) => expand(item, v)"
              ></v-switch>
              <v-divider></v-divider>
              <v-list
                v-if="isExpanded(item)"
                dense
              >
                <v-list-item>
                  <v-list-item-content>名称：</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.name }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>类型：</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.type }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>公司：</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.company }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>区域：</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.region }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>画面：</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.dimension }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>介绍：</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.content }}
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-card>
          </v-col>
        </v-row>
      </template>
    </v-data-iterator>
  </v-container>
</template>

<script>
export default {
  name: "gameCheck",
  data: () => ({
    singleExpand: false,
    games: [
    ],
    itemsPerPageArray: [4, 8, 12],
    search: '',
    filter: {},
    itemsPerPage: 3,
    valid:true
  }),
  created() {
    this.$axios.get('/do/game/uncheckGame').then(res => {
      this.games = res.data
      console.log(res.data)
      console.log('111')
    }).catch(function (error) {
      console.log(error)
    })
  },
  methods:{
    check(item){
      this.games.splice(this.games.indexOf(item), 1);
      var obj = { 'id' : item.id};
      this.$axios.post('/do/admin/gameCheck', obj)
        .then(res=> {
          console.log(res);
        })
    }
  }
}
</script>

<style scoped>

</style>
