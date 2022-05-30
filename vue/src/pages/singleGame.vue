<template>
  <div id="building" style="margin-top: 0px;">
    <headbar />
    <el-button round @click="back" style="background: rgba(255,255,255,0.3);position: absolute;top:15%;left:8%;z-index:999">返回</el-button>
    <el-row :gutter="10" >
      <el-col :xs="0" :sm="1" :md="2" :lg="3" :xl="2"><div class="grid-content "></div></el-col>
      <el-col :xs="14" :sm="13" :md="12" :lg="11" :xl="12">
        <div class="grid-content ">
          <br /><br />
          <div id="gameinfo">
            <h1 style="font-size: 500%;color: whitesmoke">{{ gamename }}</h1>
          </div>
          <br />
          <el-carousel indicator-position="outside" height="500px" interval="5000">
            <el-carousel-item v-for="item in imgArray" :key="item">
              <img :src="item" class="rightImg">
            </el-carousel-item>
          </el-carousel>

          <!-- <el-button type="info" plain style="width: 100%;height: 1.5rem;font-size: 0.5rem;text-align: left;
          background-image: url(../../../static/image/tomb2.jpg);">在 Steam 上查看 “Tomb Raider” 全系列作品</el-button>
          <br /><br /><br /> -->
          <!-- 				 <el-button type="success" style="width: 100%;height: 1.5rem;font-size: 0.5rem;
                   text-align: left;">下载 Shadow of the Tomb Raider Demo</el-button><br /><br /><br />
                   <el-button type="info" style="width: 100%;height: 3rem;font-size: 0.5rem;text-align: left;
                   background-image: url(../../../static/image/tomb8.jpg);">购买 Tomb Raider Collection 捆绑包
                   <p style="font-size: 0.3rem;">购买此捆绑包，所有 4 个项目立省 46%！</p>
                   </el-button> -->
          <div class="SysInfo"><br /><br />
            <font color="#FFFFFF">评测</font></span><br />
            <el-divider></el-divider>
            <span>“The most ambitious in the modern trilogy”</span><br />
            <span>9/10 – IGN</span><br /><br />
            <span>“A must-play”</span><br />
            <span>4.5/5 – Hardcore Gamer</span><br /><br />
            <span>“One of Lara Croft’s best modern adventures”</span><br />
            <span>84/100 – PC Gamer</span><br /><br />
          </div>
          <div class="SysInfo"><br /><br />
            <font color="#FFFFFF">关于这款游戏</font></span><br />
            <el-divider></el-divider>
            <div style="width: 100%;height: 6rem;font-size: 0.5rem;text-align: left;
				 background-image: url(../img/game1.jpg);"></div>
            <p>
              {{ gameinfo }}
            </p>
          </div>	<br /><br />

          <div class="SysInfo">

            <font color="#FFFFFF">系统需求</font></span><br />
            <el-tabs type="card">
              <el-tab-pane label="Windows">
                <div class="SysNeed">
                  <font color="#FFFFFF">最低配置</font></span><br />
                  操作系统:<p>Windows 7 64 bit</p>
                  处理器:<p>i3-3220 INTEL or AMD Equivalent</p>
                  内存:<p>8 GB RAM</p>
                  显卡:<p>Nvidia GTX 660/GTX 1050 or AMD Radeon HD 7770</p>
                  DirectX 版本:<p>11</p>
                  存储空间:<p>需要 40 GB 可用空间</p>
                </div>
                <div class="SysNeed">
                  <font color="#FFFFFF">推荐配置</font></span><br />
                  操作系统:<p>Windows 7 64 bit</p>
                  处理器:<p>i3-3220 INTEL or AMD Equivalent</p>
                  内存:<p>16 GB RAM</p>
                  显卡:<p>Nvidia GTX 660/GTX 1050 or AMD Radeon HD 7770</p>
                  DirectX 版本:<p>11</p>
                  存储空间:<p>需要 40 GB 可用空间</p>
                </div>
              </el-tab-pane>
              <el-tab-pane label="Mac OS X">
                <div class="SysNeed">
                  <font color="#FFFFFF">最低配置</font></span><br />
                  操作系统:<p>macOS 10.15</p>
                  处理器:<p>2GHz Intel Core i5</p>
                  内存:<p>8 GB RAM</p>
                  显卡:<p>2GB AMD Radeon R9 M290 or better, 1.5GB Intel Iris 540 or better</p>
                  存储空间:<p>需要 40 GB 可用空间</p>
                  附注事项:<p>The game is supported on the following Macs. To check your Mac model and when it was released, select About This Mac from the Apple menu on your menu bar.</p>
                </div>
                <div class="SysNeed">
                  <font color="#FFFFFF">推荐配置</font></span><br />
                  操作系统:<p>macOS 10.15</p>
                  处理器:<p>2GHz Intel Core i5</p>
                  内存:<p>8 GB RAM</p>
                  显卡:<p>2GB AMD Radeon R9 M290 or better, 1.5GB Intel Iris 540 or better</p>
                  存储空间:<p>需要 40 GB 可用空间</p>
                </div>
              </el-tab-pane>
              <el-tab-pane label="Steams OS+Linux">
                <div class="SysNeed">
                  <font color="#FFFFFF">最低配置</font></span><br />
                  操作系统:<p> Ubuntu 18.04 64-bit</p>
                  处理器:<p> 3.4GHz Intel Core i3-4130</p>
                  内存:<p>8 GB RAM</p>
                  显卡:<p>2GB AMD R9 285 (GCN 3rd Generation), 2GB Nvidia GTX 680</p>
                  附注事项:<p>* Requires Vulkan.</p>
                  <p>* Nvidia requires 418.56 or newer drivers.</p>
                </div>
                <div class="SysNeed">
                  <font color="#FFFFFF">推荐配置</font></span><br />
                  操作系统:<p> Ubuntu 18.04 64-bit</p>
                  处理器:<p> 3.4GHz Intel Core i7-4770</p>
                  内存:<p>16 GB RAM</p>
                  显卡:<p>8GB AMD Radeon RX 480, 8GB Nvidia GTX 1080</p>
                  附注事项:<p>* Requires Vulkan.</p>
                  <p>* Nvidia requires 418.56 or newer drivers.</p>
                </div>
              </el-tab-pane>
            </el-tabs>
            <div style="height: 3rem;"></div>
          </div>
          <div id="comment">
            <h1 style="color: white">评论</h1>
            <b-input-group prepend="评论" class="mt-3">
              <b-form-input v-model="newcomment"></b-form-input>
              <b-input-group-append>
                <b-button variant="info" @click="insertComment()">发表</b-button>
              </b-input-group-append>
            </b-input-group>
            <hr class="my-4">
            <div id="singlecomment" v-for="item in comment" >
              <b-list-group  >
                <b-list-group-item style="background:rgba(138,43,226,0.2);color:whitesmoke;border-bottom-color: whitesmoke"><p style="font-size: small"> {{ item.username }}</p><p style="color: white">{{item.content}}</p><v-icon>
                  {{ icon }}</v-icon> </b-list-group-item>

              </b-list-group>
            </div>
          </div>
        </div>
      </el-col>
      <el-col :xs="10" :sm="9" :md="8" :lg="7" :xl="8"><div class="grid-content ">
        <div align="center" style="margin-top: 1.2rem;">
          <div style="width: 80%;background: url(../img/game1.jpg)no-repeat; background-size: 100% auto;height: 3rem" align="center" >
          </div>
          <div class="GameText">
            <p>{{gameinfo}}</p>
            <div class="GameInfo">
              <a>最近评测：&nbsp;&nbsp;&nbsp;&nbsp;<font color="#54a5d4">特别好评</font> </a>
            </div><br />
            <div class="GameInfo">
              <a>全部评测：&nbsp;&nbsp;&nbsp;&nbsp;<font color="#54a5d4">特别好评</font> </a>
            </div><br />
            <div class="GameInfo">
              <a>开发商：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#54a5d4">{{company}}</font> </a>
            </div><br />
            <div class="GameInfo">
              <a>该产品的热门用户自定义标签：</a><br /><br />
              <el-row type="flex" class="row-bg">
                <el-col :span="9"><div class="grid-content"><el-button type="primary">{{type}}</el-button></div></el-col>
                <el-col :span="5"><div class="grid-content"><el-button type="primary">{{dimension}}</el-button></div></el-col>
                <el-col :span="4"><div class="grid-content"><el-button type="primary">单人</el-button></div></el-col>
                <el-col :span="6"><div class="grid-content"><el-button type="primary">摄影游戏</el-button></div></el-col>
              </el-row>
            </div>
            <el-col :span="24">
              <el-card shadow="hover" style="background: #000000;margin-top: 1.2rem;border: 0rem; ">
                <h2>您对这款游戏感兴趣吗？</h2>
              </el-card>
              <el-card shadow="hover" style="background: #14131a;border: 0rem;">
                <div class="AskInfo">
                  <p>为这款游戏点个赞。</p>
                  <el-row type="flex" class="row-bg" style="font-size: 0.3rem;">
                    <el-col :span="24"><div class="grid-content"><el-button type="primary" plain style="font-size: 0.3rem;background: #434953;color: #67c1f5;">点赞</el-button>
                    </div></el-col>
                  </el-row>
                </div>
              </el-card><br /><br /><br />
              <el-card shadow="hover" style="background: #14131a;border: 0rem;" body-style="padding:0rem;border:0rem;">
                <el-table
                  :data="tableData"
                  stripe
                  style="width: 100%;" cell-style="background: #14131a;color: #acb2b8;" header-cell-style="background: #14131a;color: #acb2b8;">
                  <el-table-column
                    prop="language"
                    label="语言"
                    width="80%">
                  </el-table-column>
                  <el-table-column
                    prop="ui"
                    label="界面"
                    width="100%">
                  </el-table-column>
                  <el-table-column
                    prop="radio"
                    label="完全音频"
                    width="100%">
                  </el-table-column>
                  <el-table-column
                    prop="word"
                    label="字幕">
                  </el-table-column>
                </el-table>
              </el-card>
            </el-col>
            <div style="margin-top: 3rem;">

            </div>
          </div>
        </div>
      </div></el-col>
      <el-col :xs="0" :sm="1" :md="2" :lg="3" :xl="2"><div class="grid-content "></div></el-col>
    </el-row>
    <!-- <img src="../../../static/image/tomb1.jpg" /> -->
  </div>
</template>

<script>
import headbar from '@/pages/header';

export default {
  name: "singleGame",

  created() {
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
    this.imgArray=[
      require('../img/gameImg/'+''+this.$cookies.get('game_id')+''+'/1.jpg'),
      require('../img/gameImg/'+''+this.$cookies.get('game_id')+''+'/2.jpg'),
      require('../img/gameImg/'+''+this.$cookies.get('game_id')+''+'/3.jpg'),
      require('../img/gameImg/'+''+this.$cookies.get('game_id')+''+'/4.jpg'),]
  },
  mounted() {
    this.search();
    window.addEventListener('scroll', this.lazyLoading);
  },
  watch: {
    '$route' (to, from) {
      // 在mounted函数执行的方法，放到该处
      this.search();
    }},
  methods:{
    back(){
      this.$router.replace('/allGame')
    },

    search(){

      if(this.$route.query.id){
        var id=this.$route.query.id
        this.axios.get("/do/game/findGamebyid?id="+id,).then(res=>{
          var jsonObj =JSON.parse(JSON.stringify(res.data));
          if (res.data){
            this.gamename=jsonObj[0].name
            this.gameinfo=jsonObj[0].content
            this.company=jsonObj[0].company
            this.type=jsonObj[0].type
            this.dimension=jsonObj[0].dimension
            this.axios.get("/do/comment/getTotal?game_id="+this.$cookies.get("game_id")).then(res=>{
              if(res.data)
                this.page_count=res.data
            });
            this.getData()
          }
        });}

    },
    lazyLoading () {
      const scrollTop = document.documentElement.scrollTop
      const clientHeight = document.documentElement.clientHeight
      const scrollHeight = document.documentElement.scrollHeight

      if (scrollTop + clientHeight >= scrollHeight) {

        this.page++
        if (this.page * this.page_size > this.page_count) return
        this.getData()
      }
    },
    getData(){
      let _this = this;
      _this.$http.get('/do/comment/getGameComment',{
        params: {
          page:_this.page,
          page_size:_this.page_size,
          game_id:this.$cookies.get("game_id")

        }
      }).then((res)=>{

        _this.comment =_this.comment.concat(res.data);
      },(err)=>{
        console.log(err);
      })
    },
    insertComment(){
      var obj={'user_id':this.$cookies.get("user_id"),'game_id':this.$cookies.get("game_id"),'content':this.newcomment}
      // var obj={'user_id':this.$cookies.get("user_id"),'game_id':1,'content':this.newcomment}
      this.axios.post("/do/comment/insertGameComment",obj).then(res=>{
        if (res.data){
          this.$router.go(0)
        }
      })
    },
  },
  data () {
    return {
      gamename:'',
      company:'',
      gameinfo:'',
      type:'',
      dimension:'',
      page: 0,
      page_size: 15,
      page_count: 10,
      comment:[],
      newcomment:'',
      imgArray: [],
      List : [
        {
          html: 'slider1',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        },
        {
          html: 'slider2',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        },
        {
          html: 'slider3',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        },
        {
          html: 'slider4',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        },
        {
          html: 'slider5',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        },
        {
          html: 'slider6',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        },
        {
          html: 'slider7',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        },
        {
          html: 'slider8',
          style: {
            background: "url(../img/game1.jpg)no-repeat",
            'background-size': '100% auto',
            'width': '33% ',
            height: '3rem'
          }
        }
      ],
      tableData: [{
        language: '简体中文',
        ui: '✔',
        radio: '✔',
        word: '✔'
      }, {
        language: '英语',
        ui: '✔',
        radio: '✔',
        word: '✔'
      }, {
        language: '法语',
        ui: '✔',
        radio: '✔',
        word: '✔'
      }, {
        language: '意大利语',
        ui: '✔',
        radio: '✔',
        word: '✔'
      }, {
        language: '德语',
        ui: '✔',
        radio: '✔',
        word: '✔'
      },{
        language: '西班牙语',
        ui: '✔',
        radio: '✔',
        word: '✔'
      }, {
        language: '韩语',
        ui: '✔',
        radio: '✔',
        word: '✔'
      },{
        language: '繁体中文',
        ui: '✔',
        radio: '✔',
        word: '✔'
      },{
        language: '波兰语',
        ui: '✔',
        radio: '✔',
        word: '✔'
      }],
      //Slider configuration [obj]
      options: {
        currentPage: 0,
        tracking: false,
        thresholdDistance: 100,
        thresholdTime: 300,
        infinite: 4,
        slidesToScroll: 4,
        loop: true
      }
    }
  },
  components: {

    headbar
  }
}
</script>


<style scoped>

.ContentTitle{
  text-align: left;
  font-size: 0.5rem;
  color: #FFFFFF;
}
.ContentTitle p{
  text-decoration: none;
  font-size: 0.3rem;
  color: #acb2b8;
}
.ContentTitle a:hover{
  text-decoration: none;
  font-size: 0.3rem;
  color: #fff;
}
.ContentTitle a{
  text-decoration: none;
  font-size: 0.3rem;
  color: #acb2b8;
}
.el-col {
  border-radius: 0.25rem;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.GameText{
  width: 80%;
}
.GameText p{
  color: #fff;
  text-align: left;
  font-size: 0.3rem;
}
.GameInfo{
  text-align: left;
  font-size: 0.25rem;
  color: #556772;
}
.SysInfo{
  text-align: left;
  font-size: 0.3rem;
  color: #acb2b8;
}
.SysNeed{
  width: 49%;
  float: left;
  color: #556772;
}
.SysNeed p{
  text-align: left;
  font-size: 0.25rem;
  color: #acb2b8;
}
.el-card{
  color: #fff;
}
.AskInfo p{
  font-size: 0.3rem;
  color: #acb2b8;
}
.el-table tr th{
  background: #000000!important;
}
.singleGame{
  background-image: url("../img/bak.png");
  background-repeat: repeat-y;
  min-height: 94%;
  min-width: 100%;
  position: absolute;

}
#gameinfo{
  /*position: absolute;*/
  position: relative;
  top: 10%;
  width: 70%;
  left: 15%;
}
#building{
  background:url("../img/bak.png");
  width:100%;
  /*height:100%;*/
  /*position:relative;*/
  background-repeat: repeat-y;
  /*background-size:100% 100%;*/
}
#comment{
  background: rgba(138,43,226,0);
  /*position: absolute;*/
  position: relative;
  top: 32%;
  left: 0%;
  width: 100%;
}
.rightImg {
  width:100%;
  height: 100%;
}
</style>
