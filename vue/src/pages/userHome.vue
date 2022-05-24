<template>
  <div>
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
            <b-form-input id="nested-street" v-model="username"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="账号:"
            label-align-sm="right"
            label-for="nested-city"
          >
            <b-form-input id="nested-city" v-model="account"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="邮箱:"
            label-align-sm="right"
            label-for="nested-state"
          >
            <b-form-input id="nested-state" v-model="email"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="密码:"
            label-align-sm="right"
            label-for="nested-country"
          >
            <b-form-input id="nested-country"></b-form-input>
          </b-form-group>

          <b-form-group
            label-cols-sm="3"
            label="Ship via:"
            label-align-sm="right" class="mb-0"
          >
            <b-form-radio-group
              class="pt-2"
              :options="['Air', 'Courier', 'Mail']"
            ></b-form-radio-group>
          </b-form-group>
        </b-form-group>
      </b-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "userHome",
  data(){
    return{
      username:'',
      account:'',
      email:''
    }
  },
  created() {
    if (!this.$cookies.isKey('account')){
      this.$router.push("/login")
    }
    this.axios.post('/do/user/getUserinfo', "account="+this.$cookies.get('account')).then(res=>{
      if(res.data){
        this.username=res.data.username;
        this.account=res.data.account;
        this.email=res.data.email;
      }
    })
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
