<template>
  <div style="width: 300px">
  <el-form ref="form" :model="form" :rules="rules"  label-width="80px">
      <el-form-item label="编号" prop="bookid" >
          <el-input v-model.number="form.bookid" readonly></el-input>
      </el-form-item>
    <el-form-item label="书名" prop="name">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price" >
      <el-input v-model.number="form.price"></el-input>
    </el-form-item>
      <el-form-item>
          <el-button type="primary" @click="submitForm('form')">立即修改</el-button>
          <el-button>取消</el-button>
      </el-form-item>
  </el-form>
  </div>
</template>

<script>
export default {
  name: "Update",
  created() {
    let that = this
    axios.get('http://localhost:8181/book1/findById/'+this.$route.query.id).then(
        function (resp){
          console.log(resp.data)
          that.form = resp.data;
        }
    )
  },
  data(){
        return{
          form: {
            bookid: '',
            name: '',
            price: ''
          },
          rules: {
            bookid: [
              { required: true, message: '请输入编号', trigger: 'blur' }

            ],
            name: [
              { required: true, message: '请输入图书', trigger: 'blur' },
              { min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' }
            ],
            price: [
              { required: true, message: '请输入价格', trigger: 'blur' },
              {type:'number' , message: ' 价格必须为数字'},
            ],
          }
        }
  },
  methods:{
    submitForm(formName) {
      let that = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.form)
          axios.put('http://localhost:8181/book1/update',this.form).then(
            function(resp) {
              if(resp.data){
                  that.$alert(that.form.name+'修改成功', '', {
                    confirmButtonText:'确定',
                    callback: action => {
                      that.$router.push('/index')
                    }
                  });
              }
            }
          )
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>

</style>