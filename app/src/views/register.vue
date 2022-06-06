<template>
  <div id="background">
    <el-form ref="user" id="contain">
      <h1>Register</h1>

      <el-form-item class="form">
        <label>用户名：</label><input type="text" v-model="user.uname" /><br />
      </el-form-item>
      <el-form-item class="form">
        <label>账号：</label><input type="Id" v-model="user.userAccount" /><br />
      </el-form-item>
      <el-form-item class="form">
        <label>密码：</label
        ><input type="password" v-model="user.userPassword" /><br />
      </el-form-item>
      <el-form-item>
       <button @click="toLogin()">登录</button>
       <button @click="save()">注册</button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  name: "register",
  props: {
    msg: String,
  },
  data() {
    return {
      user:{
        uname: "",
        userAccount:"",
        userPassword: "",
      }
    };
  },
  methods: {
    //点击完成按钮触发注册
    save(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios
            .post("/hou/user/register", { user: this.user })
            .then((res) => {
              if (res.data.code == 15) {
                this.$cookies.set('status','logined')
                this.$router.replace({ path: '/' })
                this.$message.info(res.data.msg)
              } else {
                this.$message.error(res.data.msg)
              }
            })
            .catch((res) => {
              this.$message.error('登录失败')
            })
        } else {
          return false
        }
      })
    },
    // save(){
    //   this.$axios.post(
    //     "/hou/user/register",this.user
    //   )
    //   .then((res) => {
    //           if (res.data.code == 20001) {
    //             this.$message.info(res.data.message)
    //           } else {
    //             this.$message.error(res.data.message)
    //           }
    //         })
    //         .catch((res) => {
    //           this.$message.error('登录失败')
    //         })

    // },
    
    toLogin(){
      this.$router.replace("/login");
    }
  },
};
</script>


<style scoped>
#background {
  width: 100%;
  height: 100%;
  background: url("../assets/login2.jpg");
  background-size: 100% 100%;
  position: fixed;
  top: 0;
  left: 0;
}
#contain {
  width: 580px;
  height: 560px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: #00000090;
  text-align: center;
  border-radius: 20px;
}
#contain h1 {
  color: white;
}
.form {
  color: white;
  margin-left: 20%;
  margin-top: 60px;
  font-size: 20px;
  text-align: left;
}
label {
  float: left;
  width: 5em;
  margin-right: 1em;
  text-align: right;
}
input,
textarea {
  margin-left: 10px;
  padding: 4px;
  border: solid 1px #4e5ef3;
  outline: 0;
  font: normal 13px/100% Verdana, Tahoma, sans-serif;
  width: 200px;
  height: 20px;
  background: #f1f1f190;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
}
input:hover,
textarea:hover,
input:focus,
textarea:focus {
  border-color: #0d0aa1;
}
button {
  position: relative;
  height: 33px;
  width: 150px;
  background: rgba(35, 19, 252, 0.425);
  border-radius: 10px;
  margin-top: 38px;
  box-shadow: none;
  color: white;
  margin-left: 40px;
}
</style>
