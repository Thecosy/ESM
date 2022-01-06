<template>
<div>
  <div style="margin-top: 20px">
    <el-button @click="goToAdd()">增加</el-button>

  </div>

  <el-table
      :data="tableData"
      border
      style="width: 550px">
    <el-table-column
        fixed
        prop="bookid"
        label="id"
        width="150">
    </el-table-column>
    <el-table-column
        prop="name"
        label="书名"
        width="120">
    </el-table-column>
    <el-table-column
        prop="price"
        label="价格"
        width="120">
    </el-table-column>

    <el-table-column
        fixed="right"
        label="操作"
        width="150">
      <template slot-scope="scope">
        <el-button
            size="mini"
            @click="handleEdit( scope.row)">编辑</el-button>
        <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</div>
</template>

<script>
console.log(123123)
export default {
  name: "Index",
  methods:{
    goToAdd() {
      this.$router.push('/add')
    },
    handleEdit(rows) {
      this.$router.push('/update?id='+rows.bookid)
    },
    handleDelete(row){
      let that = this
      this.$confirm('是否确定删除'+row.name+'?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete('http://localhost:8181/book1/delete/'+row.bookid).then(
            function (resp){
              if(resp.data){
                that.$alert(row.name+'已删除成功', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    location.reload()
                  }
                });
              }
            }
        )
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }
  },
  created() {

    let that = this;

    axios.get('http://localhost:8181/book1/list').then(function (resp){
      console.log(resp.data)
      that.tableData = resp.data;
    })
  },
  data() {
    return {
      tableData: []
    }
  }
}
</script>

<style scoped>

</style>