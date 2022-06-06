module.exports = {
  devServer:{
    port:8081,
    proxy:{
      "/hou":{
        target: "http://127.0.0.1:8080",
        ws:true,
        changeOrigin: true,
        pathRewrite:{
          "^/hou":"/"
        }
      }
    }
  }
};