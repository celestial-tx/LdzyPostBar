<template>
  <div>
    <!-- 头部导航栏 -->
    <el-header>
      <el-row  class="nav" type="flex" align="middle">
        <el-col :span="5">
            <el-menu><router-link to="/main">主页</router-link></el-menu>
        </el-col>
        <el-col :span="5">
            <el-menu><router-link :to="{name:'TopicList', params:{type: 1}}">
              学习
            </router-link></el-menu>
        </el-col>
          <el-col :span="5">
            <el-menu><router-link :to="{name:'TopicList', params:{type: 2}}">
              闲聊
            </router-link></el-menu>
          </el-col>
        <el-col :span="5">
            <el-menu><router-link to="/posting">我要发帖</router-link></el-menu>
        </el-col>
        <el-col :span="5">
            <el-menu><router-link to="/userCenter">个人中心</router-link></el-menu>
        </el-col>
        <el-col :span="5">
            <el-menu><router-link to="/">登录</router-link></el-menu>
        </el-col>
      </el-row>
    </el-header>

    <el-main class="main">
      <keep-alive>
        <router-view v-if="$route.meta.keepAlive"></router-view>
      </keep-alive>
      <router-view v-if="!$route.meta.keepAlive"></router-view>
    </el-main>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.nav {
  width: 100%;
  height: 50px;
  top: 0;
  left: 0;
  right: 0;
  background-color: #ffffff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  position: fixed;
  z-index: 999;
  text-align: center;
}
.main{
  width: 100%;
  height: 50%;
}
</style>