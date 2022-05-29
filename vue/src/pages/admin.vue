<template>
  <v-app id="inspire">
    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <template>
            <v-card
              class="mx-auto"
              width="256"
              tile
              dark
            >
              <v-navigation-drawer permanent>

                <v-list>
                  <v-list-item>
                    <v-list-item-avatar>
                      <v-avatar
                        color="teal"
                        size="56"
                      >X</v-avatar>
                    </v-list-item-avatar>
                  </v-list-item>

                  <v-list-item link>
                    <v-list-item-content>
                      <v-list-item-title class="text-h6">
                        你好
                      </v-list-item-title>
                      <v-list-item-subtitle>{{email}}</v-list-item-subtitle>
                    </v-list-item-content>

                    <v-list-item-action>
                      <v-icon>mdi-menu-down</v-icon>
                    </v-list-item-action>
                  </v-list-item>
                </v-list>
                <v-divider></v-divider>
                <v-list
                  nav
                  dense
                >
                  <v-list-item-group
                    color="primary"
                  >
                    <v-list-item @click="userManage">
                      <v-list-item-icon></v-list-item-icon>
                      <v-list-item-content>
                        <v-list-item-title >用户管理</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="gameManage">
                      <v-list-item-icon></v-list-item-icon>
                      <v-list-item-content>
                        <v-list-item-title >游戏管理</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="gameCheck">
                      <v-list-item-icon></v-list-item-icon>
                      <v-list-item-content>
                        <v-list-item-title >游戏审核</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="forgetPass">
                      <v-list-item-icon></v-list-item-icon>
                      <v-list-item-content>
                        <v-list-item-title >修改密码</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                    <v-list-item to="/">
                      <v-list-item-icon></v-list-item-icon>
                      <v-list-item-content>
                        <v-list-item-title >返回主页</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>
                        <v-list-item-title >&nbsp;</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>
                        <v-list-item-title >&nbsp;</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>
                        <v-list-item-title >&nbsp;</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                  </v-list-item-group>
                </v-list>
              </v-navigation-drawer>
            </v-card>
          </template>

          <v-col>
            <v-sheet
              rounded="lg"
              min-width="100%"
            >
              <v-alert
                prominent
                type="success"
                v-if="isWelcome"
              >
                <v-row align="center">
                  <v-col class="grow">
                    开始工作吧，今天有5条未审批的游戏
                  </v-col>
                  <v-col class="shrink">
                    <v-btn @click="gameCheck">审批</v-btn>
                  </v-col>
                </v-row>
              </v-alert>
              <div v-if="isUserManage">
                <userTable/>
              </div>
              <div v-if="isMyInfo">
                <updatePass />
              </div>
              <div v-if="isGameCheck">
                <gameCheck />
              </div>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import userTable from '@/pages/userTable';
import updatePass from "./updatePass";
import gameCheck from "./gameCheck";
export default {
  name:'admin',
  methods: {
    userManage() {
      this.isUserManage = true;
      this.isGameManage = false;
      this.isGameCheck = false;
      this.isMyInfo = false;
      this.isWelcome = false;
    },
    gameManage() {
      this.isUserManage = false;
      this.isGameManage = true;
      this.isGameCheck = false;
      this.isMyInfo = false;
      this.isWelcome = false;
    },
    gameCheck() {
      this.isUserManage = false;
      this.isGameManage = false;
      this.isGameCheck = true;
      this.isMyInfo = false;
      this.isWelcome = false;
    },
    forgetPass() {
      this.isUserManage = false;
      this.isGameManage = false;
      this.isGameCheck = false;
      this.isMyInfo = true;
      this.isWelcome = false;
    }
  },
  data() {
      return {
        isUserManage: false,
        isGameManage: false,
        isGameCheck: false,
        isMyInfo: false,
        isWelcome: true,
        email:this.$cookies.get('adminaccount'),
        users: [],
      }
    },

}
</script>
