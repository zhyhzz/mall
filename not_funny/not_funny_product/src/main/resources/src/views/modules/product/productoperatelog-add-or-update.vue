<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="productId">
      <el-input v-model="dataForm.productId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="priceOld">
      <el-input v-model="dataForm.priceOld" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="priceNew">
      <el-input v-model="dataForm.priceNew" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="salePriceOld">
      <el-input v-model="dataForm.salePriceOld" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="salePriceNew">
      <el-input v-model="dataForm.salePriceNew" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="赠送的积分" prop="giftPointOld">
      <el-input v-model="dataForm.giftPointOld" placeholder="赠送的积分"></el-input>
    </el-form-item>
    <el-form-item label="" prop="giftPointNew">
      <el-input v-model="dataForm.giftPointNew" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="usePointLimitOld">
      <el-input v-model="dataForm.usePointLimitOld" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="usePointLimitNew">
      <el-input v-model="dataForm.usePointLimitNew" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="操作人" prop="operateMan">
      <el-input v-model="dataForm.operateMan" placeholder="操作人"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
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
          productId: '',
          priceOld: '',
          priceNew: '',
          salePriceOld: '',
          salePriceNew: '',
          giftPointOld: '',
          giftPointNew: '',
          usePointLimitOld: '',
          usePointLimitNew: '',
          operateMan: '',
          createTime: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          priceOld: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          priceNew: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          salePriceOld: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          salePriceNew: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          giftPointOld: [
            { required: true, message: '赠送的积分不能为空', trigger: 'blur' }
          ],
          giftPointNew: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          usePointLimitOld: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          usePointLimitNew: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          operateMan: [
            { required: true, message: '操作人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/productoperatelog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.productOperateLog.productId
                this.dataForm.priceOld = data.productOperateLog.priceOld
                this.dataForm.priceNew = data.productOperateLog.priceNew
                this.dataForm.salePriceOld = data.productOperateLog.salePriceOld
                this.dataForm.salePriceNew = data.productOperateLog.salePriceNew
                this.dataForm.giftPointOld = data.productOperateLog.giftPointOld
                this.dataForm.giftPointNew = data.productOperateLog.giftPointNew
                this.dataForm.usePointLimitOld = data.productOperateLog.usePointLimitOld
                this.dataForm.usePointLimitNew = data.productOperateLog.usePointLimitNew
                this.dataForm.operateMan = data.productOperateLog.operateMan
                this.dataForm.createTime = data.productOperateLog.createTime
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
              url: this.$http.adornUrl(`/product/productoperatelog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'priceOld': this.dataForm.priceOld,
                'priceNew': this.dataForm.priceNew,
                'salePriceOld': this.dataForm.salePriceOld,
                'salePriceNew': this.dataForm.salePriceNew,
                'giftPointOld': this.dataForm.giftPointOld,
                'giftPointNew': this.dataForm.giftPointNew,
                'usePointLimitOld': this.dataForm.usePointLimitOld,
                'usePointLimitNew': this.dataForm.usePointLimitNew,
                'operateMan': this.dataForm.operateMan,
                'createTime': this.dataForm.createTime
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
