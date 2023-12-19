import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  publicPath:"/",
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },


  },
  server: { //主要是加上这段代码
    open: true,
    proxy: {
      '/api': {
        target: 'http://localhost:7777',	//实际请求地址
        changeOrigin: true,
        // rewrite(path) {
        //   return path.replace(/^\/api/,'')
        // }
        rewrite: (path) => path.replace(/^\/api/, '')
      },
    }
  },
  build:{
    // 解决打包报错问题
    // - Using dynamic import() to code-split the application
    // - Use build.rollupOptions.output.manualChunks to improve chunking: https://rollupjs.org/guide/en/#outputmanualchunks
    // - Adjust chunk size limit for this warning via build.chunkSizeWarningLimit.
    chunkSizeWarningLimit: 1500,
    rollupOptions:{
      output:{
        manualChunks(id) {
          if (id.includes('node_modules')) {
            return 'vendor';
          }
        }
      }
    }
  }
})
