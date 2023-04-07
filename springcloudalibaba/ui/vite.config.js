import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
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
  }
})
