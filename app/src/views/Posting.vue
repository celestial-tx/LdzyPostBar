<template>
<div>
    <div id="editor">
 
    </div>
    <button @click="add()">提交</button>
</div>
</template>
<script>
import E from "wangeditor"
export default {
    data() {
        return {
            editor:''
        }
    },
    mounted(){
        this.editor = new E('#editor')
        this.editor.create()
    },
    methods: {
        add(){
           
        }   
    },
}
</script>
<style scoped>
  #editor{
    padding-top:20px ;
  }
</style>