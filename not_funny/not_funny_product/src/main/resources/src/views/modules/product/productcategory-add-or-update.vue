<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="上机分类的编号：0表示一级分类" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder="上机分类的编号：0表示一级分类"></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="分类级别：0->1级；1->2级" prop="level">
      <el-input v-model="dataForm.level" placeholder="分类级别：0->1级；1->2级"></el-input>
    </el-form-item>
    <el-form-item label="" prop="productCount">
      <el-input v-model="dataForm.productCount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="productUnit">
      <el-input v-model="dataForm.productUnit" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="是否显示在导航栏：0->不显示；1->显示" prop="navStatus">
      <el-input v-model="dataForm.navStatus" placeholder="是否显示在导航栏：0->不显示；1->显示"></el-input>
    </el-form-item>
    <el-form-item label="显示状态：0->不显示；1->显示" prop="showStatus">
      <el-input v-model="dataForm.showStatus" placeholder="显示状态：0->不显示；1->显示"></el-input>
    </el-form-item>
    <el-form-item label="" prop="sort">
      <el-input v-model="dataForm.sort" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="图标" prop="icon">
      <el-input v-model="dataForm.icon" placeholder="图标"></el-input>
    </el-form-item>
    <el-form-item label="" prop="keywords">
      <el-input v-model="dataForm.keywords" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="描述"></el-input>
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
          parentId: '',
          name: '',
          level: '',
          productCount: '',
          productUnit: '',
          navStatus: '',
          showStatus: '',
          sort: '',
          icon: '',
          keywords: '',
          description: ''
        },
        dataRule: {
          parentId: [
            { required: true, message: '上机分类的编号：0表示一级分类不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          level: [
            { required: true, message: '分类级别：0->1级；1->2级不能为空', trigger: 'blur' }
          ],
          productCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productUnit: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          navStatus: [
            { required: true, message: '是否显示在导航栏：0->不显示；1->显示不能为空', trigger: 'blur' }
          ],
          showStatus: [
            { required: true, message: '显示状态：0->不显示；1->显示不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          icon: [
            { required: true, message: '图标不能为空', trigger: 'blur' }
          ],
          keywords: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/productcategory/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.parentId = data.productCategory.parentId
                this.dataForm.name = data.productCategory.name
                this.dataForm.level = data.productCategory.level
                this.dataForm.productCount = data.productCategory.productCount
                this.dataForm.productUnit = data.productCategory.productUnit
                this.dataForm.navStatus = data.productCategory.navStatus
                this.dataForm.showStatus = data.productCategory.showStatus
                this.dataForm.sort = data.productCategory.sort
                this.dataForm.icon = data.productCategory.icon
                this.dataForm.keywords = data.productCategory.keywords
                this.dataForm.description = data.productCategory.description
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
              url: this.$http.adornUrl(`/product/productcategory/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'parentId': this.dataForm.parentId,
                'name': this.dataForm.name,
                'level': this.dataForm.level,
                'productCount': this.dataForm.productCount,
                'productUnit': this.dataForm.productUnit,
                'navStatus': this.dataForm.navStatus,
                'showStatus': this.dataForm.showStatus,
                'sort': this.dataForm.sort,
                'icon': this.dataForm.icon,
                'keywords': this.dataForm.keywords,
                'description': this.dataForm.description
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
