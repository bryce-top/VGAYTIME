<template>
  <div id="app">
    <div class="line">
      <el-menu
        style="border: none"
        :default-active="this.$route.path"
        class="el-menu-demo"
        router mode="horizontal"
        @select="handleSelect"
        background-color="#303133"
        text-color="#C0C4CC"
        active-text-color="#D351E1"
      >
        <router-link to="/">
          <img
            src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/LOGO.png"
            style="
            width: 3%;
            height: auto;
            margin-top: 1%;
            margin: 1% 2% 0 1%;
            float: left;
          "
            alt=""
          /></router-link>
        <el-menu-item index="/">首页</el-menu-item>
        <el-menu-item index="/allGame" >所有游戏</el-menu-item>

        <el-menu-item index="3">虚幻引擎</el-menu-item>
        <el-submenu index="2">
          <template #title>关于 SANE GAME</template>
          <el-menu-item index="2-1">关于公司</el-menu-item>
          <el-menu-item index="2-2">SANE GAME</el-menu-item>
          <el-menu-item index="2-3">招纳贤士</el-menu-item>
        </el-submenu>
        <div class="right">
          <div class="login" v-show="noLogin">
            <el-submenu index="5">
              <template #title>
                <img
                  src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/n7efKzPzaW.png"
                  style="width: 15%; margin-right: 10%"
                  alt=""
                />登录</template
              >
              <router-link to="/register"
              ><el-menu-item index="5-1">账号注册</el-menu-item></router-link
              >
              <router-link to="/login">
                <el-menu-item index="5-2">立即登录</el-menu-item></router-link
              >
            </el-submenu>
          </div>
          <div class="login" v-show="!noLogin">
            <el-submenu index="6">
              <template #title
              ><img
                src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/%E6%88%91%E7%9A%84.png"
                style="width: 15%; margin-right: 10%"
                alt=""
              />{{ user.name }}</template
              >

              <!-- <img src="https://sanegame.oss-cn-hangzhou.aliyuncs.com/%E6%88%91%E7%9A%84.png" style="width:15%;margin-right:10%" alt=""> -->


              <el-menu-item index="6-1" @click="gotoprofile">我的账号</el-menu-item>
              <el-menu-item @click="tologout" index="6-2">退出登录</el-menu-item>
            </el-submenu>
          </div>
          <el-button style="
            float: right;
            height: 60px;
            border-radius: 0%;
            background: #721e78;
            color: #fff;
            border: none;
          ">获取客户端</el-button>
          <el-select style="float:right;top:10px;"
            v-model="value"
            multiple
            filterable
            remote
            reserve-keyword
            placeholder="请输入关键词"
            :remote-method="remoteMethod"
            :loading="loading">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
      </el-menu>
    </div>
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',

  data() {
    return {
      options: [],
      value: [],
      list: [],
      loading: false,
      states: ["Alabama", "Alaska", "Arizona",
        "Arkansas", "California", "Colorado",
        "Connecticut", "Delaware", "Florida",
        "Georgia", "Hawaii", "Idaho", "Illinois",
        "Indiana", "Iowa", "Kansas", "Kentucky",
        "Louisiana", "Maine", "Maryland",
        "Massachusetts", "Michigan", "Minnesota",
        "Mississippi", "Missouri", "Montana",
        "Nebraska", "Nevada", "New Hampshire",
        "New Jersey", "New Mexico", "New York",
        "North Carolina", "North Dakota", "Ohio",
        "Oklahoma", "Oregon", "Pennsylvania",
        "Rhode Island", "South Carolina",
        "South Dakota", "Tennessee", "Texas",
        "Utah", "Vermont", "Virginia",
        "Washington", "West Virginia", "Wisconsin",
        "Wyoming"]
    }
  },
  mounted() {
    this.list = this.states.map(item => {
      return { value: `value:${item}`, label: `label:${item}` };
    });
  },
  methods: {
    remoteMethod(query) {
      if (query !== '') {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.options = this.list.filter(item => {
            return item.label.toLowerCase()
              .indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.options = [];
      }
    }
  }
}
</script>

<style>
#app {
  min-height: 100%;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>

