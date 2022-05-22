<template>
<div style="top:0; position: absolute; width: 100%">
<el-menu
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#545c64"
  text-color="#fff"

  active-text-color="#ffd04b">
<el-menu-item index="1" >用户管理</el-menu-item>
<el-submenu index="2">
  <template slot="title" >游戏管理</template>
  <el-menu-item index="2-1">所有游戏</el-menu-item>
  <el-menu-item index="2-2">已审核</el-menu-item>
  <el-menu-item index="2-3">待审核</el-menu-item>
</el-submenu>
<el-menu-item index="3" >评论管理</el-menu-item>
<el-menu-item index="4" ><router-link :to="{path:'/'}"><b-button>游戏主页</b-button></router-link></el-menu-item>
</el-menu>
</div>
</template>
<script>
export default {
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
