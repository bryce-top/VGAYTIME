
<template>
  <el-carousel :interval="4000" indicator-position="outside"   style="height:900px;margin: auto;top:200px;">
    <el-carousel-item v-for="item in imgArray" :key="item">
      <img :src="item" class="rightImg">
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  components:{
  },
  name: 'HelloWorld',
  data () {
    return {
      imgArray: [
        require('../img/1.png'),
        require('../img/2.png'),
        require('../img/3.png'),
        require('../img/4.png')
      ]
    }
  },
  // created(){
  //   if (!this.$cookies.isKey('account')){
  //     this.$router.push("/login")
  //   }
  // },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2, h3 {
  font-weight: normal;
  color: aqua;
}

.rightImg {
  width: 1440px;
  height: 900px;
}

.el-carousel__item h3 {

  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 600px;
  margin: 0;
}

.el-carousel__item {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
.carousel-image {
  max-width: 100%;
  max-height: 100%;
}
}
</style>
