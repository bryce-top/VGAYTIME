
<template>
  <div>
    <headbar />
  <div id="building">
    <div>

      <div id="title">
        <h1>精选游戏</h1>
      </div>
  <el-carousel :interval="4000"  indicator-position="outside" height="720px"  style="margin: auto;top:200px;">
    <el-carousel-item v-for="item in imgArray" :key="item">
      <img :src="item" class="rightImg">
    </el-carousel-item>
  </el-carousel>
  </div>
  </div>

    <div id="building2">
      <div>
      <div id="title2">
        <h1>精选游戏</h1>
      </div>
      <el-carousel :interval="4000"  indicator-position="outside" height="720px"  style="margin: auto;top:200px;">
        <el-carousel-item v-for="item in imgArray" :key="item">
          <img :src="item" class="rightImg">
        </el-carousel-item>
      </el-carousel>
      </div>
    </div>

  </div>
</template>


<script>
import headbar from '@/pages/header';
export default {
  components:{ headbar
  },
  name: 'HelloWorld',
  data () {
    return {
      imgArray: [
        require('../img/game1.jpg'),
        require('../img/game2.jpg'),
        require('../img/game3.jpg'),
        require('../img/game4.jpg'),
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
#title{
position:absolute;
  top:10%;
  left:10%;
  color: purple;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
#title2{
  position:absolute;
  top:10%;
  left:10%;
  color: purple;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
#building{
  background:url("../img/bak.png");
  width:100%;
  height:100%;
  position:absolute;
  background-size:100% 100%;
}
#building2{
  top: 100%;
  background:url("../img/bak.png");
  width:100%;
  height:100%;
  position:absolute;
  background-size:100% 100%;

}
.rightImg {
  width: 1280px;
  height: 720px;
}

.el-carousel__item h3 {

  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  margin: 0;
}

.el-carousel__item {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;

}

.carousel-image {
  max-width: 100%;
  max-height: 100%;
}

</style>
