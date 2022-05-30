<template>
<div>
  <template>
    <v-data-table
      :headers="headers"
      :items="games"
      :search="search"
      sort-by="name"
      class="elevation-1"
    >
      <template v-slot:top>
        <v-toolbar
          flat
        >
          <v-toolbar-title>游戏管理</v-toolbar-title>
          <v-divider
            class="mx-4"
            inset
            vertical
          ></v-divider>
          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
          ></v-text-field>
          <v-spacer></v-spacer>
          <v-dialog
            v-model="dialog"
            max-width="500px"
          >
            <template v-slot:activator="{ on, attrs }">
            </template>
            <v-card>
              <v-card-title>
                <span class="text-h5">{{ formTitle }}</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        v-model="editedItem.name"
                        label="游戏名称"
                        disabled
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        v-model="editedItem.type"
                        label="类型"
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        v-model="editedItem.company"
                        label="公司"
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        v-model="editedItem.region"
                        label="区域"
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        v-model="editedItem.dimension"
                        label="画面"
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        v-model="editedItem.content"
                        label="简介"
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
          </v-dialog>
          <v-dialog v-model="dialogDelete" max-width="500px">
            <v-card>
              <v-card-title class="text-h5">确定删除此游戏？</v-card-title>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="closeDelete">取消</v-btn>
                <v-btn color="blue darken-1" text @click="deleteItemConfirm">确认</v-btn>
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </template>
      <template v-slot:item.actions="{ item }">
        <v-icon
          small
          class="mr-2"
          @click="editItem(item)"
        >
          mdi-pencil
        </v-icon>
        <v-icon
          small
          @click="deleteItem(item)"
        >
          mdi-delete
        </v-icon>
      </template>
      <template v-slot:no-data>
        <v-btn
          color="primary"
          @click="initialize"
        >
          刷新
        </v-btn>
      </template>
    </v-data-table>
  </template>
</div>
</template>

<script>
export default {
  data: () => ({
    dialog: false,
    dialogDelete: false,
    search: '',
    headers: [
      {
        text: '游戏名称',
        align: 'start',
        sortable: false,
        value: 'name',
      },
      { text: '类型', value: 'type'},
      { text: '公司', value: 'company' },
      { text: '地区', value: 'region' },
      { text: '画面', value: 'dimension' },
      { text: '简介', value: 'content' },
      { text: 'Actions', value: 'actions', sortable: false },
    ],
    games: [],
    editedIndex: -1,
    editedItem: {
      name: this.name,
      type: this.type,
      company: this.company,
      region: this.region,
      dimension: this.dimension,
      content: this.content
    },
    defaultItem: {

    },
  }),
  computed: {
    formTitle () {
      return this.editedIndex === -1 ? '新增' : '修改'
    },
  },
  watch: {
    dialog (val) {
      val || this.close()
    },
    dialogDelete (val) {
      val || this.closeDelete()
    },
  },
  created () {
    this.initialize()
  },
  methods: {
    initialize () {
      this.$axios.get('/do/game/AllGame').then(res => {
        this.games = res.data
        console.log(res.data)
        console.log('111')
      }).catch(function (error) {
        console.log(error)
      })
    },
    editItem (item) {
      this.editedIndex = this.games.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },
    deleteItem (item) {
      this.editedIndex = this.games.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
    },
    deleteItemConfirm () {
      this.games.splice(this.editedIndex, 1)
      this.closeDelete()
      // var obj = {'email': this.editedItem.email, 'password': this.editedItem.password, 'sex':this.editedItem.sex, 'briefInfo': this.editedItem.briefInfo, 'account': this.editedItem.account, 'username':this.editedItem.username}
      this.$axios.post('/do/game/deleteGame', this.editedItem)
        .then(res=> {
          console.log(res);
          console.log('333')
        })
    },
    close () {
      this.dialog = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },
    closeDelete () {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },
    save () {
      if (this.editedIndex > -1) {
        Object.assign(this.games[this.editedIndex], this.editedItem)
      } else {
        this.games.push(this.editedItem)
      }
      // var obj = {'email': this.editedItem.email, 'password': this.editedItem.password, 'sex':this.editedItem.sex, 'briefInfo': this.editedItem.briefInfo, 'account': this.editedItem.account, 'username':this.editedItem.username}
      this.$axios.post('/do/game/updateGame', this.editedItem)
        .then(res=> {
          console.log(res);
          console.log('333')
        })
      this.close()
    },
  },
}
</script>

<style scoped>

</style>
