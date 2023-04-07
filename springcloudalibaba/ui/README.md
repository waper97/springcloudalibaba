# ui

This template should help get you started developing with Vue 3 in Vite.

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur) + [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin).

## Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).

## Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Compile and Minify for Production

```sh
npm run build
```
解决跨域问题

在`vite.config.js`文件中
```js
export default defineConfig({
  plugins: [vue()],
  server: {
    port: 3000,
    open: true, //自动打开
    base: "./ ", //生产环境路径
    proxy: { // 本地开发环境通过代理实现跨域，生产环境使用 nginx 转发
      // 正则表达式写法
      '/api': {
        target: 'http://localhost:5067/api', // 后端服务实际地址
        changeOrigin: true, //是否允许跨域
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  }
})
```