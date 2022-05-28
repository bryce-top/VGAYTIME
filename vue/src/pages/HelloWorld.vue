
<template>
  <div>
    <headbar />
  <div id="building">
    <div>

      <div id="title">
        <h1>精选游戏</h1>
      </div>
  <el-carousel :interval="4000"  indicator-position="outside" height="720px"  style="margin: auto;top:100px;">
    <el-carousel-item v-for="item in imgArray" :key="item">
      <img :src="item" class="rightImg">
    </el-carousel-item>
  </el-carousel>
  </div>
  </div>

    <div id="building2">
      <div>
      <div id="title2">
        <h1>玩家之声</h1>
      </div>
        <el-carousel indicator-position="outside" height="630px" interval="1500" style="margin:auto;top:200px">
          <el-carousel-item v-for="(item,index) in ListCommunity" :key="index" style="background: #2c2748">
            <el-row :gutter="0">
              <el-col :span="15">
                <img :src="item.src" class="rightImg1">
              </el-col>
              <el-col :span="2"><br />
              </el-col>
              <el-col :span="5">
                <el-card shadow="hover" style="background: #2c2748;color: #fff;border: 0rem;font-size: 1.7rem; padding: 15px;">
                  <p>{{item.html}}</p>
                </el-card>
              </el-col>
              <el-col :span="2"><br />
              </el-col>
            </el-row>
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>

    <div id="building3">
      <h1>玩家之声</h1>
      </div>

  </div>
</template>


<script>
import { slider, slideritem } from 'vue-concise-slider';
import headbar from '@/pages/header';
export default {
  components:{ headbar,
    slider,
    slideritem
  },
  name: 'HelloWorld',
  data () {
    return {
      imgArray: [
        require('../img/game1.jpg'),
        require('../img/game2.jpg'),
        require('../img/game3.jpg'),
        require('../img/game4.jpg'),
      ],
      ListCommunity: [
        {
          html: '"在打折快结束前真诚安利一下，35块钱，买不了吃亏买不了上当！！ 理由：1.除女主以外全语音，配角路人都有配音。 2.就我个人来说，我很喜欢这种家国情怀的故事，女主对于自己背负的使命有过无力，害怕的情感，但是她都将这些情绪克服了。"',
          src:require('../img/game1.jpg')
        }, {
          html: '"游戏是好游戏，但可能并不都会喜欢。以及现阶段糟心的优化问题，入手前需三思 R星出品，游戏质量还是那么出色，只是这次体验下来，个人评价与一部分玩家一样，可以说是哪都好，就感觉不是那么好玩。"',
          src: require('../img/game2.jpg')
        }, {
          html: '"这是我2020年玩过最好的游戏了！值得推荐！不对，是强烈推荐！。希望各位主播多玩玩这个游戏，推荐一下，让厂商多赚钱！ 而且这翻译质量贼高。"',
          src: require('../img/game2.jpg')
        }
      ],
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
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 100rem;
  margin: 0;
}
#title{
position:absolute;
  top:3%;
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
#building3{
  top: 200%;
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
.rightImg1 {
  width: 1120px;
  height: 630px;
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
