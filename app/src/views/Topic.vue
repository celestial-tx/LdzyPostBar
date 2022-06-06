<template>
  <div class="body">
    <div class="card">
    <el-card class="box-card">
      <div slot="header"
           class="clearfix">
        <span class="titel-name">{{ this.topics.fromName }}</span>
      </div>
      <div class="box-content">
        {{ topics.content }}
      </div>
    </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Topic',

  data() {
    return {
      topics: [],
      
    };
  },

  watch:{
    $route(){
      this.getTopic();
    }
  },

  mounted() {
  this.getTopic()
    

    },

  methods:{
    getTopic(){
      this.$axios
      .get("/hou/topic/byId/"+ this.$route.params.id)
           .then(res => {
              this.topics = res.data.data
           })
    }
  }

}
</script>

<style>

.title-name{
    font-size: 28px;
    font-weight:bold;
}

.box-content{
    font-size: 16px;
}

.card{
  width: 880px;
  padding-top: 5%;
  margin: auto;
}

.body{
  width: 100%;
  height: 100vh;
  background-size:100% 100%;
  background: url("../assets/TB2.jpg") no-repeat;
  background-position: center;
}

  .item {
    margin-bottom: 18px;
  }

  .clearfix {
    display: table;
    content: "";
  }

  .box-card {
    height: 500px;
    width: 880px;
    margin: auto;
  }
</style>