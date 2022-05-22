<template>
  <div>
{{username}}
  </div>
</template>

<script>
export default {
  name: "userHome",
  data(){
    return{
      username:''
    }
  },
  created() {
    this.username=this.$cookies.get('account');
  }
}
</script>

<style scoped>

</style>
