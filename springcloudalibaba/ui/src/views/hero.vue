<template>
  <el-container class="layout-container-demo" style="height: 800px ;border: solid #eee" >
    <el-aside width="200px" >
      <el-scrollbar>
        <el-menu :default-openeds="['1', '3']">
          <el-sub-menu index="3">
            <el-menu-item-group>
              <template #title></template>
              <el-menu-item index="3-1">英雄</el-menu-item>
              <el-menu-item index="3-2" @click="handleRouterTureItem">装备</el-menu-item>
              <el-menu-item index="3-2" @click="mhandleRouterTureSummoner">召唤师技能</el-menu-item>
            </el-menu-item-group>

          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 1px"
            ><setting
            /></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
<!--          <span>Tom</span>-->
        </div>
      </el-header>

      <el-main>
        <el-scrollbar>
          <el-table :data="tableData">
            <el-table-column prop="ename" label="id" />
            <el-table-column prop="cname" label="英雄名称"  />
            <el-table-column prop="heroType" label="英雄类型" />
            <el-table-column prop="mossId" label="moss" />
            <el-table-column prop="newType" label="类型" />
            <el-table-column prop="skinName" label="皮肤名称" />
            <el-table-column prop="title" label="标题" />
            <el-table-column prop="pictureUrl" label="图片路径" />


            <el-table-column>
              <template slot-scope="scope">
                  <el-button>编辑</el-button>
                  <el-button>删除</el-button>
              </template>
            </el-table-column>

          </el-table>

        </el-scrollbar>

      </el-main>
    </el-container>

  </el-container>
<!--  :page-sizes="[100, 200, 300, 400]"-->
<!--  :page-size="100"-->
<!--  :current-page="currentPage4"-->
  <el-pagination
      small
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :total="this.page.total">
  </el-pagination>
</template>

<script>
import { ref } from 'vue'
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
const typeMap = {
  3: '坦克',
  1: '战士',
  2: '法师',
  4: '刺客',
  5: '射手',
  6: '辅助',
  10: '限免',
  11: '新手'
}

import {listHero,login} from "@/http";
export default {
  name: "herolist",
  data() {
    return {
      tableData: [],
      page:{
        total:1000
      }
    }
  },


  methods: {
    list(){
      listHero().then(res => {
        let data =  res.data.data;
        for (let i in data) {
          for (let typeMapKey in typeMap) {
            if (typeMapKey ==  data[i].heroType){
              data[i].heroType = typeMap[typeMapKey]
            }
          }
          this.tableData = data
          this.page.total = this.tableData.length
        }

      }),

          login().then(res =>{

          })
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
    handleClick(row) {
      console.log(row);
    },

    handleRouterTureItem(){
      this.$router.push('/item')
    }
    ,mhandleRouterTureSummoner(){
      this.$router.push('/summoner')
    }

  },
  filters:{




  },
  mounted(){
   this.list()
  },
  computed:{
  },
  created() {
    // this.fuck()
  }


}
</script>

<style scoped>
/*.layout-container-demo .el-header {*/
/*  position: relative;*/
/*  background-color: var(--el-color-primary-light-7);*/
/*  color: var(--el-text-color-primary);*/
/*}*/

.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
</style>