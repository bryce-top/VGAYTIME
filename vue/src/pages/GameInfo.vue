<template>
	<div style="background-color: #011627;margin-top: -0.7rem;">
		<GuideLine></GuideLine>
		<el-row :gutter="10" >
		  <el-col :xs="0" :sm="1" :md="2" :lg="3" :xl="2"><div class="grid-content "></div></el-col>	  
		  <el-col :xs="14" :sm="13" :md="12" :lg="11" :xl="12">
			<div class="grid-content ">
				<br /><br />
				<div class="ContentTitle">
					<p><a href="#">所有游戏</a>><a href="#">冒险游戏</a>><a href="#">Tomb Raider系列</a>><a href="#">Shadow of the Tomb Raider: Definitive Edition</a></p>
						<span>Shadow of the Tomb Raider: Definitive Edition</span>
				</div><br />
				<el-carousel height="10rem">
				      <el-carousel-item>
				        <!-- <h3 class="small">{{ item }}</h3> -->
						<video id="bgvid" src="../../assets/image/Tomb.mp4" autoplay="autoplay" 
							loop="loop" muted="muted"><source src="image/star.mp4" type="video/mp4"></video>
				      </el-carousel-item>
				</el-carousel>
<!-- 				<el-carousel height="6rem">
				      <el-carousel-item v-for="(item,index) in List" :key="index" :style="item.style">
				        {{item.html}}
				      </el-carousel-item>
				</el-carousel> -->
				<slider ref="slider" :options="options" @slide='slide' @tap='onTap'>
				       <!-- slideritem wrapped package with the components you need -->
				       <slideritem v-for="(item,index) in List" :key="index" :style="item.style"></slideritem>
				       <!-- Customizable loading -->
				       <div slot="loading"></div>
				 </slider>
				 
				 <el-col :span="24">
				   <el-card shadow="hover" style="width: 100%;height: 1.5rem;font-size: 0.5rem;text-align: left;
				 background-image: url(../../../static/image/tomb2.jpg);">
				 	在 Steam 上查看 “Tomb Raider” 全系列作品
				   </el-card><br /><br /><br />
				   <el-card shadow="hover" style="width: 100%;height: 1.5rem;font-size: 0.5rem;background: #67C23A;
				 text-align: left;">
				   	下载 Shadow of the Tomb Raider Demo
				     </el-card><br /><br /><br />
					 <el-card shadow="hover" style="width: 100%;height: 3rem;font-size: 0.5rem;text-align: left;
				 background-image: url(../../../static/image/tomb8.jpg);">
					   	购买 Tomb Raider Collection 捆绑包
					   	<p style="font-size: 0.3rem;">购买此捆绑包，所有 4 个项目立省 46%！</p>
					 </el-card><br /><br /><br />
				 </el-col>  
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
				 background-image: url(../../../static/image/tomb5.jpg);"></div>
					 <p>在《Shadow of the Tomb Raider：最终版》中，探索劳拉最初为何会注定成为古墓侠盗的最终章。《Shadow of the Tomb Raider：最终版》包括主游戏、全7个DLC古墓挑战，以及所有可下载武器、装束、技能，是跟随劳拉探索命运的最终完整体验。</p>
					 <br />
					 <p>在世界上最致命的地点生存下来：征服残酷无情的丛林，并活着走出来。探索充满裂隙和幽深隧道的水下环境。</p><br />
					 <p>与丛林合而为一：火力不足、以寡敌众的劳拉，必须充分利用丛林中的环境，像美洲豹一样迅猛出击、悄然而退，使用泥浆作为伪装手段，在敌人队伍中制造恐惧，播撒混乱。</p><br />
					 <p>探索黑暗残忍的古墓：古墓变得比以往更加恐怖，需要细致谨慎的探索技术才能到达，还要以智慧破解杀机重重的谜题。</p><br /><br />
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
					<!-- <el-tabs type="border-card">
					    <el-tab-pane label="Windows" name="first">
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
					    <el-tab-pane label="Mac OS X" name="second">
							<div class="SysNeed">
								<font color="#FFFFFF">最低配置</font></span><br />
								操作系统:<p>macOS 10.15</p>
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
					    <el-tab-pane label="Steams OS+Linux" name="third">
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
					  </el-tabs> -->
					  <div style="height: 3rem;"></div>
				</div>
			</div>
		  </el-col>
		  <el-col :xs="10" :sm="9" :md="8" :lg="7" :xl="8"><div class="grid-content ">
		  <div align="center" style="margin-top: 1.2rem;">
			  <el-button type="primary" plain style="width: 3rem;height: 0.8rem;font-size: 0.3rem;background: #434953;color: #67c1f5;">社区中心</el-button><br /><br />
			  <div style="width: 80%;background: url(../../../static/image/tombHeader.jpg)no-repeat; background-size: 100% auto;height: 3rem" align="center" >
			  </div>
			  <div class="GameText">
			  	<p>劳拉·克劳馥一路狂奔，拯救世界免遭玛雅预言中的天灾摧毁，她终将迎接命运，成长为命中注定的古墓侠盗。</p>
				<div class="GameInfo">
					<a>最近评测：&nbsp;&nbsp;&nbsp;&nbsp;<font color="#54a5d4">特别好评</font> </a>
				</div><br />
				<div class="GameInfo">
					<a>全部评测：&nbsp;&nbsp;&nbsp;&nbsp;<font color="#54a5d4">特别好评</font> </a>
				</div><br />
				<div class="GameInfo">
					<a>发行日期：&nbsp;&nbsp;&nbsp;&nbsp;<font color="">2018年9月15日</font> </a>
				</div><br />
				<div class="GameInfo">
					<a>开发商：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#54a5d4">Eidos-Montréal, Crystal Dynamics</font> </a>
				</div><br />
				<div class="GameInfo">
					<a>发行商：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#54a5d4">Square Enix, Feral Interactive (Mac)</font> </a>
				</div><br />
				<div class="GameInfo">
					<a>该产品的热门用户自定义标签：</a><br /><br />
					<el-row type="flex" class="row-bg">
					  <el-col :span="4"><div class="grid-content"><el-button type="primary">冒险</el-button></div></el-col>
					  <el-col :span="4"><div class="grid-content"><el-button type="primary">动作</el-button></div></el-col>
					  <el-col :span="6"><div class="grid-content"><el-button type="primary">女性主角</el-button></div></el-col>
					  <el-col :span="4"><div class="grid-content"><el-button type="primary">单人</el-button></div></el-col>
					  <el-col :span="6"><div class="grid-content"><el-button type="primary">开放世界</el-button></div></el-col>
					</el-row>				
				</div>
				<el-col :span="24">
				  <el-card shadow="hover" style="background: #000000;margin-top: 1.2rem;border: 0rem; ">
				  	<h2>您对这款游戏感兴趣吗？</h2>
				  </el-card>
				  <el-card shadow="hover" style="background: #14131a;border: 0rem;">
					<div class="AskInfo">
						<p>基于您的游戏、好友以及您关注的鉴赏家，登录以查看您是否有可能喜欢这个内容的原因。</p>
						<el-row type="flex" class="row-bg" style="font-size: 0.3rem;">
						  <el-col :span="24"><div class="grid-content"><el-button type="primary" plain style="font-size: 0.3rem;background: #434953;color: #67c1f5;">登陆</el-button>
						  或者<el-button type="primary" plain style="font-size: 0.3rem;background: #434953;color: #67c1f5;">在STEAM打开</el-button></div></el-col>
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
// import slider components
import { slider, slideritem } from 'vue-concise-slider'
export default {
el: '#app',
methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    },
data () {
   return {
	 List : [
	        {
	          html: 'slider1',
	          style: {
	            background: "url(../../../static/image/tomb1.jpg)no-repeat",
	            'background-size': '100% auto',
				'width': '33% ',
				 height: '3rem'
	          }
	        },
	        {
	          html: 'slider2',
	          style: {
	            background: "url(../../../static/image/tomb2.jpg)no-repeat",
	            'background-size': '100% auto',
	            'width': '33% ',
	             height: '3rem'
	          }
	        },
	        {
	          html: 'slider3',
	          style: {
	            background: "url(../../../static/image/tomb3.jpg)no-repeat",
	            'background-size': '100% auto',
	            'width': '33% ',
	             height: '3rem'
	          }
	        },
	        {
	          html: 'slider4',
	          style: {
	            background: "url(../../../static/image/tomb4.jpg)no-repeat",
	            'background-size': '100% auto',
	            'width': '33% ',
	             height: '3rem'
	          }
	        },
	        {
	          html: 'slider5',
	          style: {
	            background: "url(../../../static/image/tomb5.jpg)no-repeat",
	            'background-size': '100% auto',
	            'width': '33% ',
	             height: '3rem'
	          }
	        },
	        {
	          html: 'slider6',
	          style: {
	            background: "url(../../../static/image/tomb6.jpg)no-repeat",
	            'background-size': '100% auto',
	            'width': '33% ',
	             height: '3rem'
	          }
	        },
	        {
	          html: 'slider7',
	          style: {
	            background: "url(../../../static/image/tomb7.jpg)no-repeat",
	            'background-size': '100% auto',
	            'width': '33% ',
	             height: '3rem'
	          }
	        },
	        {
	          html: 'slider8',
	          style: {
	            background: "url(../../../static/image/tomb8.jpg)no-repeat",
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
   slider,
   slideritem
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
</style>
