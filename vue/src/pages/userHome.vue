<template>
  <div>
    <headbar />
    <div id="form">
      <b-card bg-variant="light">
        <b-form-group
          label-cols-lg="3"
          label="个人信息"
          label-size="lg"
          label-class="font-weight-bold pt-0"
          class="mb-0"
        >
          <b-form-group
            label-cols-sm="3"
            label="用户名:"
            label-align-sm="right"
            label-for="nested-street"
          >
            <b-form-input id="nested-street" v-model="user.username"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="账号:"
            label-align-sm="right"
            label-for="nested-city"
          >
            <b-form-input id="nested-city" v-model="user.account"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="邮箱:"
            label-align-sm="right"
            label-for="nested-state"
          >
            <b-form-input id="nested-state" v-model="user.email"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="密码:"
            label-align-sm="right"
            label-for="nested-country"
          >
            <b-form-input id="nested-country" v-model="user.password" type="password"></b-form-input>
          </b-form-group>

          <b-button @click="changeInfo">提交</b-button>
        </b-form-group>
      </b-card>
    </div>
  </div>
</template>

<script>
import headbar from '@/pages/header';
export default {
  name: "userHome",

  components:{
    headbar
  },
  data(){
    return{
      user:{
        username:'',
        account:'',
        email:'',
        password:''
      },
    }
  },

  created() {
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
    this.axios.post('/do/user/getUserinfo', "account="+this.$cookies.get('account')).then(res=>{
      if(res.data){
        this.user.username=res.data.username;
        this.user.account=res.data.account;
        this.user.email=res.data.email;
        this.user.password=res.data.password;
        // this.user=res.data;
      }
    })

  },

  methods:{

    changeInfo(){

      alert(this.user.account)
      this.axios.post('/do/user/updateUser', this.user)
        .then(res=> {
          console.log(res);


        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}
</script>

<style scoped>
#form{
  width: 60%;
  height: 100%;
  float: top;
}

</style>
