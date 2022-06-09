<template>
  
</template>

<script>
export default {
  data(){
    return{
      userAccount:"",
    }
  },
  methods:{
    getUser(){
      this.userID = this.$store.state.loginID
      this.$axios.get("/hou/user/"+this.userID )
    }
  }
}
</script>

<style>

</style>