<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="首字母" prop="firstLetter">
      <el-input v-model="dataForm.firstLetter" placeholder="首字母"></el-input>
    </el-form-item>
    <el-form-item label="" prop="sort">
      <el-input v-model="dataForm.sort" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="是否为品牌制造商：0->不是；1->是" prop="factoryStatus">
      <el-input v-model="dataForm.factoryStatus" placeholder="是否为品牌制造商：0->不是；1->是"></el-input>
    </el-form-item>
    <el-form-item label="" prop="showStatus">
      <el-input v-model="dataForm.showStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="产品数量" prop="productCount">
      <el-input v-model="dataForm.productCount" placeholder="产品数量"></el-input>
    </el-form-item>
    <el-form-item label="产品评论数量" prop="productCommentCount">
      <el-input v-model="dataForm.productCommentCount" placeholder="产品评论数量"></el-input>
    </el-form-item>
    <el-form-item label="品牌logo" prop="logo">
      <el-input v-model="dataForm.logo" placeholder="品牌logo"></el-input>
    </el-form-item>
    <el-form-item label="专区大图" prop="bigPic">
      <el-input v-model="dataForm.bigPic" placeholder="专区大图"></el-input>
    </el-form-item>
    <el-form-item label="品牌故事" prop="brandStory">
      <el-input v-model="dataForm.brandStory" placeholder="品牌故事"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          firstLetter: '',
          sort: '',
          factoryStatus: '',
          showStatus: '',
          productCount: '',
          productCommentCount: '',
          logo: '',
          bigPic: '',
          brandStory: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          firstLetter: [
            { required: true, message: '首字母不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          factoryStatus: [
            { required: true, message: '是否为品牌制造商：0->不是；1->是不能为空', trigger: 'blur' }
          ],
          showStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productCount: [
            { required: true, message: '产品数量不能为空', trigger: 'blur' }
          ],
          productCommentCount: [
            { required: true, message: '产品评论数量不能为空', trigger: 'blur' }
          ],
          logo: [
            { required: true, message: '品牌logo不能为空', trigger: 'blur' }
          ],
          bigPic: [
            { required: true, message: '专区大图不能为空', trigger: 'blur' }
          ],
          brandStory: [
            { required: true, message: '品牌故事不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/product/brand/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.brand.name
                this.dataForm.firstLetter = data.brand.firstLetter
                this.dataForm.sort = data.brand.sort
                this.dataForm.factoryStatus = data.brand.factoryStatus
                this.dataForm.showStatus = data.brand.showStatus
                this.dataForm.productCount = data.brand.productCount
                this.dataForm.productCommentCount = data.brand.productCommentCount
                this.dataForm.logo = data.brand.logo
                this.dataForm.bigPic = data.brand.bigPic
                this.dataForm.brandStory = data.brand.brandStory
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/brand/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'firstLetter': this.dataForm.firstLetter,
                'sort': this.dataForm.sort,
                'factoryStatus': this.dataForm.factoryStatus,
                'showStatus': this.dataForm.showStatus,
                'productCount': this.dataForm.productCount,
                'productCommentCount': this.dataForm.productCommentCount,
                'logo': this.dataForm.logo,
                'bigPic': this.dataForm.bigPic,
                'brandStory': this.dataForm.brandStory
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
