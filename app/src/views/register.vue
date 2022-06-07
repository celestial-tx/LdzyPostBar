<template>
  <div>
    <div class="background">
      <img :src="imgSrc"
           width="100%"
           height="100%"
           alt="" />
    </div>
    <div class="login_container">
      <!-- 登录块 -->
      <div class="login_box">
        <!-- 表单区域 -->
        <h2>注册</h2>
        <el-form ref="loginFormRef"
                 :model="loginForm"
                 :rules="loginRules"
                 :v-model="login"
                 class="login_form"
                 label-width="0">
          <!-- 用户名 -->
          <el-form-item prop="uname"
                        class="from_item">
            用户名：<el-input v-model="loginForm.uname"
                      prefix-icon="iconfont icon-yonghu"
                      class="in">
            </el-input>
          </el-form-item>
          <!-- 用户账号 -->
          <el-form-item prop="account"
                        class="from_item">
            账&nbsp;&nbsp;号： <el-input v-model="loginForm.account"
                      prefix-icon="iconfont icon-yonghu"
                      class="in"></el-input>
          </el-form-item>
          <!-- 密码 -->
          <el-form-item prop="passwd"
                        class="from_item">
            密&nbsp;&nbsp;码： <el-input v-model="loginForm.passwd"
                      prefix-icon="iconfont icon-mima"
                      show-password
                      class="in"></el-input>
          </el-form-item>
          <!-- 按钮 -->
          <el-form-item class="btns">
            <el-button type="primary"
                       @click="login">提交</el-button>
            <el-button type="info"
                       @click="resetLoginForm()">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>
 
<script>
export default {
  data() {
    return {
      imgSrc: require('../assets/login3.png'),
      //表单数据
      loginForm: {
        uname: '',
        account: '',
        passwd: '',
      },
      //验证对象
      loginRules: {
        uname: [
          { required: true, message: '用户名为必填项', trigger: 'blur' },
          {
            min: 0,
            max: 10,
            message: '长度在 0 到 10 个字符',
            trigger: 'blur',
          },
        ],
        //校验账号
        account: [
          { required: true, message: '用户账号为必填项', trigger: 'blur' },
          {
            min: 0,
            max: 10,
            message: '长度在 0 到 10 个字符',
            trigger: 'blur',
          },
        ],
        //校验密码
        passwd: [
          { required: true, message: '用户密码为必填项', trigger: 'blur' },
          {
            min: 6,
            max: 10,
            message: '长度在 6 到 10 个字符',
            trigger: 'blur',
          },
        ],
      },
    }
  },
  methods: {
    resetLoginForm() {
      //重置用户名和密码方法
      this.$refs.loginFormRef.resetFields()
    },
    login() {
      const user= new URLSearchParams()
      user.append('uname', this.loginForm.uname)
      user.append('account', this.loginForm.account)
      user.append('passwd', this.loginForm.passwd)
      this.$axios.post("/hou/user/register",user)
      .then(res => {
        if(res.data.code == 20001){
          this.$router.replace({ path: '/' })
        }
      })
    },
  },
}
</script>
 
<style  scoped>
.login_container {
  background-color: palegreen;
}
.login_box {
  width: 550px;
  height: 350px;
  /* background-color: #ffffff; */
  background: rgba(255, 255, 255, 0.3);
  border: 1px solid black;
  opacity: 0.85;
  filter: alpha(opacity=90);
  border-radius: 20px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.avatar_box {
  width: 130px;
  height: 130px;
  border: -30px solid #eee;
  border-radius: 50%;
  padding: 0px;
  box-shadow: 0 0 2px #ddd;
  left: 50%;
}
.from_item {
  margin-left: 5%;
}
.btns {
  display: flex;
  justify-content: space-around;
}
.login_form {
  position: absolute;
  bottom: 0%;
  width: 100%;
  border: 30px;
}
.background {
  width: 100%;
  height: 100%; /**宽高100%是为了图片铺满屏幕 */
  z-index: -1;
  position: absolute;
}
.in {
  margin-left: 5%;
  margin-right: 10%;
  width: 350px;
}
h1,
h2,
h3 {
  font-size: xxpx;

  color: rgb(7, 7, 7);

  text-align: center;
}
</style>