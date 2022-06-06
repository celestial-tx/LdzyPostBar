<template>
  <div>
      <!-- 帖子展示 -->
    <div class="box" v-infinite-scroll="load" infinite-scroll-disabled="disabled" >
        <div v-for="(i,index) in topicTypes" :key="index" class="box-item" >
             <div class="box-item-name">{{ i.fromName }}</div><br/><br/>
             <div v-if="i.content.length > 50"> 
               {{ i.content.slice(0,50) }}
               <div v-if="i.tid > 0">...</div>
               <div v-if="i.tid < 0">{{i.content.slice(50,i.content.length)}}</div>

                 <el-button v-if="i.tid > 0" @click="TF(index)" type="text">展开全部</el-button>
                 <el-button v-if="i.tid < 0" @click="TF(index)" type="text">收起</el-button>
               
             </div>
             <div v-if="i.content.length < 50" > {{ i.content }} </div>
          <router-link :to="{name:'Topic', params:{id: i.tid}}">
             <el-button type="text">查看详情</el-button>
          </router-link>
        </div>
        <p v-if="loading" style="margin-top:10px;" class="loading">
          <span></span>
        </p>
        <p v-if="noMore" style="margin-top:10px;font-size:13px;color:#ccc">没有更多了</p>
    </div>
  </div>
</template>

<script>
export default {
  name:'TopicList',
  data() {
    return {
      topicTypes:[],
      count: 0,//起始页数值为0
      loading: false,
      totalPages: "",//取后端返回内容的总页数
    };
  },
  watch:{
    $route(){
      this.getTopic();
    }
  },
  computed: {
    noMore() {
      //当起始页数大于总页数时停止加载
      return this.count >= this.totalPages - 1;
    },
     disabled() {
      return this.loading || this.noMore;
    }
  },

  methods:{

    TF(index){
      this.topicTypes[index].tid = this.topicTypes[index].tid * -1
    },
    
    getTopic(){
      let params = {
        pageNumber: this.count,
        pageSize: 10 //每页查询条数
      };
      this.$axios
      .get("/hou/topic/type?topic_type="+ this.$route.params.type+ 
           "&pageNumber="+params.pageNumber+"&pageSize="+params.pageSize)
           .then(res => {
              console.log(res);
          this.topicTypes = this.topicTypes.concat(res.data.data); //因为每次后端返回的都是数组，所以这边把数组拼接到一起
          this.totalPages = res.data.body.totalPages;
          this.loading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
     load() {
      //滑到底部时进行加载
      this.loading = true;
      setTimeout(() => {
        this.count += 1; //页数+1
        this.getTopic(); //调用接口，此时页数+1，查询下一页数据
      }, 2000);
    },
  },
  mounted() {
   this.getTopic();
    },

}
</script>

<style scoped>
.box-item-name{
   float: left;
   font-size: 24px;
}

#box{
  width: 100%;
  height: 100%;
  position: absolute;
  overflow-y: auto;
}
.box {
  width: 100%;
   margin:  0 auto;
}
.box-item{
  padding: 0;
  font-size: 14px;
  width: 80%;
  margin-left: 15%;
  /* height: 170px; */
  /* line-height: 70px; */
  border-bottom: 1px solid #e7e7e7;
  align-items: center;
  padding: 0 1rem;
}
.loading span {
  display: inline-block;
  width: 20px;
  height: 20px;
  border: 2px solid #409eff;
  border-left: transparent;
  animation: zhuan 0.5s linear infinite;
  border-radius: 50%;
}
</style>