<template>
  <div>
    <el-result
        icon="warning"
        title="404提示"
        sub-title="你找的页面走丢了~"
    >
      <template #extra>
        <el-button type="primary" @click="$router.push('/login')">返回首页</el-button>
      </template>
    </el-result>

  </div>

</template>

<script>
export default {
  name: "error"
}
</script>

<style scoped>

</style>