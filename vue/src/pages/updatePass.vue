<template>
  <v-sheet
  max-width="100%"
  min-height="100%"
  rounded
  class="elevation-1">
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field type="password"
      v-model="pass1"
      :rules="passRule1"
      label="  输入新密码"
      rounded
      shaped
      required
    ></v-text-field>
    <v-text-field type="password"
      v-model="pass2"
      :rules="passRule2"
      label="  确认新密码"
                  rounded
                  shaped
      required
    ></v-text-field>

    <v-text-field
      v-model="email"
      :rules="emailRule"
      label="  邮箱"
      rounded
      shaped
      required
    ></v-text-field>

    <v-text-field
      v-model="tel"
      :rules="telRule"
      label="  电话"
      rounded
      shaped
      required
    ></v-text-field>

    <v-btn
      :disabled="!valid"
      color="success"
      class="mr-4"
      @click="validate"
    >
      提交
    </v-btn>

    <v-btn
      color="error"
      class="mr-4"
      @click="reset"
    >
      重置
    </v-btn>

  </v-form>
  </v-sheet>
</template>

<script>
export default {
  data: () => ({
    valid: true,
    pass1: '',
    pass2: '',
    email: '',
    tel:'',
    passRule1: [
      v => !!v || 'required',
      v => /^[a-zA-Z]\w{5,17}$/.test(v) || '以字母开头，长度在6~18之间，只能包含字母、数字和下划线',
    ],
    emailRule: [
      v => !!v || 'required',
      v => /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(v) || '请输入有效的邮箱地址',
    ],
    telRule: [
      v => !!v || 'required',
      v => /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/.test(v) || '请输入有效的手机号码',
    ],
    passRule2: [
      v => !!v || 'required',
    ]
  }),
  methods: {
    validate () {
      this.$refs.form.validate()
      var obj = {'email': this.email, 'password': this.pass1}
      console.log(this.pass1);
      this.$axios.post('/do/admin/updatePass',obj).then(res => {
        console.log(res.data)
        console.log('111')
        window.alert('修改成功，请重新登录');
        window.location.href = '/'
      }).catch(function (error) {
        console.log(error)
      })

    },
    reset () {
      this.$refs.form.reset()
    },
    resetValidation () {
      this.$refs.form.resetValidation()
    },
  },
}
</script>
