module.exports = {
  devServer: {
    port: 3000,
    proxy: {
      '/api/*': {
        target: 'http://loalhost:8080'
      }
    }
  }
}
s
