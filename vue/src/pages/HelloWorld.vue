
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
      <div id="title3">
        <h1>新闻资讯</h1>
      </div>
      <el-card class="box-card">
        <div slot="header" class="clearfix" >
          <span style="color:whitesmoke">来自VGTIME</span>
          <el-button style="float: right; padding: 3px 0" type="text">转到</el-button>
        </div>

        <el-card shadow="hover" class="news" >
          <img src="https://img01.vgtime.com/game/cover/2022/05/27/220527220827554_u8855.jpg" style="text-align: center;width:96%;height: 54%">
          <br><br>
          <a class="newsContent" href="https://www.vgtime.com/topic/1169948.jhtml" target="_blank">新一期索尼State of Play将于6月3日播出</a>
        </el-card>

        <el-card shadow="hover" class="news" style="left:39%">
          <img src="https://img01.vgtime.com/game/cover/2022/05/28/220528101124624_u524.jpg" style="margin: auto;width:96%;height: 54%">
          <br><br>
          <a class="newsContent" href="https://www.vgtime.com/topic/1169983.jhtml" target="_blank">《星球大战 绝地：幸存者》公开 2023年发售</a>
        </el-card>

        <el-card shadow="hover" class="news" style="left:75%">
          <img src="https://img01.vgtime.com/game/cover/2022/05/27/220527092005666_u202875.jpg" style="margin: auto;width:96%;height: 54%">
          <br><br>
          <a class="newsContent" href="https://www.vgtime.com/topic/1169873.jhtml" target="_blank">CDPR最新动向：《巫师》新作已开启前期制作</a>
        </el-card>

        <el-card shadow="hover" class="news" style="top:57%">
          <img src="https://img01.vgtime.com/game/cover/2022/05/27/220527000628797_u524.jpg" style="margin: auto;width:96%;height: 54%">
          <br><br>
          <a class="newsContent" href="https://www.vgtime.com/topic/1169867.jhtml" target="_blank">Epic喜加三：限时一周送《生化奇兵 合集》</a>
        </el-card>

        <el-card shadow="hover" class="news" style="top:57%;left:39%">
          <img src="https://img01.vgtime.com/game/cover/2021/03/19/210319102724478_u77470.jpg" style="margin: auto;width:96%;height: 54%">
          <br><br>
          <a class="newsContent" href="https://www.vgtime.com/topic/1169763.jhtml" target="_blank">夜光组新作《Forspoken》已在欧洲通过分级</a>
        </el-card>

        <el-card shadow="hover" class="news" style="top:57%;left:75%">
          <img src="https://img01.vgtime.com/game/cover/2022/05/24/220524222720513_u8855.jpg" style="margin: auto;width:96%;height: 54%">
          <br><br>
          <a class="newsContent" href="https://www.vgtime.com/topic/1169659.jhtml" target="_blank">《霍格沃茨之遗》PS5特性宣传片公布 身临其境的魔法世界</a>
        </el-card>

      </el-card>
      </div>

    <div id="building4">

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
.newsContent{
  color:whitesmoke;
  text-align: center;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
.news{
  width:300px;
  height:270px;
  position:absolute;
  background: rgba(0,0,0,0.7);
  border: #989595;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  border: #3d1963;
  position:absolute;
  top:12%;
  left:15%;
  margin: auto;
  width:1280px;
  height:720px;
  background: rgba(138,43,226,0.2);
}
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
#title3{
  position:absolute;
  top:2%;
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
#building4{
  top: 300%;
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
