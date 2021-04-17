<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="计费类型:0->按重量；1->按件数" prop="chargeType">
      <el-input v-model="dataForm.chargeType" placeholder="计费类型:0->按重量；1->按件数"></el-input>
    </el-form-item>
    <el-form-item label="首重kg" prop="firstWeight">
      <el-input v-model="dataForm.firstWeight" placeholder="首重kg"></el-input>
    </el-form-item>
    <el-form-item label="首费（元）" prop="firstFee">
      <el-input v-model="dataForm.firstFee" placeholder="首费（元）"></el-input>
    </el-form-item>
    <el-form-item label="" prop="continueWeight">
      <el-input v-model="dataForm.continueWeight" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="continmeFee">
      <el-input v-model="dataForm.continmeFee" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="目的地（省、市）" prop="dest">
      <el-input v-model="dataForm.dest" placeholder="目的地（省、市）"></el-input>
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
          chargeType: '',
          firstWeight: '',
          firstFee: '',
          continueWeight: '',
          continmeFee: '',
          dest: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          chargeType: [
            { required: true, message: '计费类型:0->按重量；1->按件数不能为空', trigger: 'blur' }
          ],
          firstWeight: [
            { required: true, message: '首重kg不能为空', trigger: 'blur' }
          ],
          firstFee: [
            { required: true, message: '首费（元）不能为空', trigger: 'blur' }
          ],
          continueWeight: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          continmeFee: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          dest: [
            { required: true, message: '目的地（省、市）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/feighttemplate/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.feightTemplate.name
                this.dataForm.chargeType = data.feightTemplate.chargeType
                this.dataForm.firstWeight = data.feightTemplate.firstWeight
                this.dataForm.firstFee = data.feightTemplate.firstFee
                this.dataForm.continueWeight = data.feightTemplate.continueWeight
                this.dataForm.continmeFee = data.feightTemplate.continmeFee
                this.dataForm.dest = data.feightTemplate.dest
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
              url: this.$http.adornUrl(`/product/feighttemplate/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'chargeType': this.dataForm.chargeType,
                'firstWeight': this.dataForm.firstWeight,
                'firstFee': this.dataForm.firstFee,
                'continueWeight': this.dataForm.continueWeight,
                'continmeFee': this.dataForm.continmeFee,
                'dest': this.dataForm.dest
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
