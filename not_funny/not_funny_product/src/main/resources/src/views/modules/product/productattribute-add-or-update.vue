<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="productAttributeCategoryId">
      <el-input v-model="dataForm.productAttributeCategoryId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="属性选择类型：0->唯一；1->单选；2->多选" prop="selectType">
      <el-input v-model="dataForm.selectType" placeholder="属性选择类型：0->唯一；1->单选；2->多选"></el-input>
    </el-form-item>
    <el-form-item label="属性录入方式：0->手工录入；1->从列表中选取" prop="inputType">
      <el-input v-model="dataForm.inputType" placeholder="属性录入方式：0->手工录入；1->从列表中选取"></el-input>
    </el-form-item>
    <el-form-item label="可选值列表，以逗号隔开" prop="inputList">
      <el-input v-model="dataForm.inputList" placeholder="可选值列表，以逗号隔开"></el-input>
    </el-form-item>
    <el-form-item label="排序字段：最高的可以单独上传图片" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序字段：最高的可以单独上传图片"></el-input>
    </el-form-item>
    <el-form-item label="分类筛选样式：1->普通；1->颜色" prop="filterType">
      <el-input v-model="dataForm.filterType" placeholder="分类筛选样式：1->普通；1->颜色"></el-input>
    </el-form-item>
    <el-form-item label="检索类型；0->不需要进行检索；1->关键字检索；2->范围检索" prop="searchType">
      <el-input v-model="dataForm.searchType" placeholder="检索类型；0->不需要进行检索；1->关键字检索；2->范围检索"></el-input>
    </el-form-item>
    <el-form-item label="相同属性产品是否关联；0->不关联；1->关联" prop="relatedStatus">
      <el-input v-model="dataForm.relatedStatus" placeholder="相同属性产品是否关联；0->不关联；1->关联"></el-input>
    </el-form-item>
    <el-form-item label="是否支持手动新增；0->不支持；1->支持" prop="handAddStatus">
      <el-input v-model="dataForm.handAddStatus" placeholder="是否支持手动新增；0->不支持；1->支持"></el-input>
    </el-form-item>
    <el-form-item label="属性的类型；0->规格；1->参数" prop="type">
      <el-input v-model="dataForm.type" placeholder="属性的类型；0->规格；1->参数"></el-input>
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
          productAttributeCategoryId: '',
          name: '',
          selectType: '',
          inputType: '',
          inputList: '',
          sort: '',
          filterType: '',
          searchType: '',
          relatedStatus: '',
          handAddStatus: '',
          type: ''
        },
        dataRule: {
          productAttributeCategoryId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          selectType: [
            { required: true, message: '属性选择类型：0->唯一；1->单选；2->多选不能为空', trigger: 'blur' }
          ],
          inputType: [
            { required: true, message: '属性录入方式：0->手工录入；1->从列表中选取不能为空', trigger: 'blur' }
          ],
          inputList: [
            { required: true, message: '可选值列表，以逗号隔开不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序字段：最高的可以单独上传图片不能为空', trigger: 'blur' }
          ],
          filterType: [
            { required: true, message: '分类筛选样式：1->普通；1->颜色不能为空', trigger: 'blur' }
          ],
          searchType: [
            { required: true, message: '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索不能为空', trigger: 'blur' }
          ],
          relatedStatus: [
            { required: true, message: '相同属性产品是否关联；0->不关联；1->关联不能为空', trigger: 'blur' }
          ],
          handAddStatus: [
            { required: true, message: '是否支持手动新增；0->不支持；1->支持不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '属性的类型；0->规格；1->参数不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/productattribute/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productAttributeCategoryId = data.productAttribute.productAttributeCategoryId
                this.dataForm.name = data.productAttribute.name
                this.dataForm.selectType = data.productAttribute.selectType
                this.dataForm.inputType = data.productAttribute.inputType
                this.dataForm.inputList = data.productAttribute.inputList
                this.dataForm.sort = data.productAttribute.sort
                this.dataForm.filterType = data.productAttribute.filterType
                this.dataForm.searchType = data.productAttribute.searchType
                this.dataForm.relatedStatus = data.productAttribute.relatedStatus
                this.dataForm.handAddStatus = data.productAttribute.handAddStatus
                this.dataForm.type = data.productAttribute.type
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
              url: this.$http.adornUrl(`/product/productattribute/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productAttributeCategoryId': this.dataForm.productAttributeCategoryId,
                'name': this.dataForm.name,
                'selectType': this.dataForm.selectType,
                'inputType': this.dataForm.inputType,
                'inputList': this.dataForm.inputList,
                'sort': this.dataForm.sort,
                'filterType': this.dataForm.filterType,
                'searchType': this.dataForm.searchType,
                'relatedStatus': this.dataForm.relatedStatus,
                'handAddStatus': this.dataForm.handAddStatus,
                'type': this.dataForm.type
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
