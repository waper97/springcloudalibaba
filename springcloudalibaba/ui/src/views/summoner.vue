<template>
  <dev>
    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          fixed
          prop="summonerId"
          label="id"
          width="100">
      </el-table-column>
      <el-table-column
          prop="summonerName"
          label="召唤师技能名称"
          width="120">
      </el-table-column>
      <el-table-column
          prop="summonerRank"
          label="等级限制"
          width="120">
      </el-table-column>
      <el-table-column
          prop="summonerDescription"
          label="描述"
          width="180">
      </el-table-column>
      <el-table-column
          prop="pictureUrl"
          label="图片"
          width="120">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </dev>
</template>

<script>
import {listSummoner} from "@/http";

export default {
  data() {
    return {
      tableData: []
    }
  },
  methods: {
    handleClick(row) {
      console.log(row);
    },
    list(){
      listSummoner().then(res => {
        let data =  res.data.data;
        // for (let i in data) {
        //   for (let typeMapKey in typeMap) {
        //     if (typeMapKey ==  data[i].heroType){
        //       data[i].heroType = typeMap[typeMapKey]
        //     }
        //   }
          this.tableData = data
          // this.page.total = this.tableData.length
        // }

      })
    },

  },
  mounted() {
    this.list()
  }
}
</script>

<style scoped>

</style>