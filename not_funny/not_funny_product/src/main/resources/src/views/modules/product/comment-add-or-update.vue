<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="productId">
      <el-input v-model="dataForm.productId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberNickName">
      <el-input v-model="dataForm.memberNickName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="productName">
      <el-input v-model="dataForm.productName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="评价星数：0->5" prop="star">
      <el-input v-model="dataForm.star" placeholder="评价星数：0->5"></el-input>
    </el-form-item>
    <el-form-item label="评价的ip" prop="memberIp">
      <el-input v-model="dataForm.memberIp" placeholder="评价的ip"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="showStatus">
      <el-input v-model="dataForm.showStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="购买时的商品属性" prop="productAttribute">
      <el-input v-model="dataForm.productAttribute" placeholder="购买时的商品属性"></el-input>
    </el-form-item>
    <el-form-item label="" prop="collectCouont">
      <el-input v-model="dataForm.collectCouont" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="readCount">
      <el-input v-model="dataForm.readCount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="content">
      <el-input v-model="dataForm.content" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="上传图片地址，以逗号隔开" prop="pics">
      <el-input v-model="dataForm.pics" placeholder="上传图片地址，以逗号隔开"></el-input>
    </el-form-item>
    <el-form-item label="评论用户头像" prop="memberIcon">
      <el-input v-model="dataForm.memberIcon" placeholder="评论用户头像"></el-input>
    </el-form-item>
    <el-form-item label="" prop="replayCount">
      <el-input v-model="dataForm.replayCount" placeholder=""></el-input>
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
          memberNickName: '',
          productName: '',
          star: '',
          memberIp: '',
          createTime: '',
          showStatus: '',
          productAttribute: '',
          collectCouont: '',
          readCount: '',
          content: '',
          pics: '',
          memberIcon: '',
          replayCount: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberNickName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          star: [
            { required: true, message: '评价星数：0->5不能为空', trigger: 'blur' }
          ],
          memberIp: [
            { required: true, message: '评价的ip不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          showStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productAttribute: [
            { required: true, message: '购买时的商品属性不能为空', trigger: 'blur' }
          ],
          collectCouont: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          readCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pics: [
            { required: true, message: '上传图片地址，以逗号隔开不能为空', trigger: 'blur' }
          ],
          memberIcon: [
            { required: true, message: '评论用户头像不能为空', trigger: 'blur' }
          ],
          replayCount: [
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
              url: this.$http.adornUrl(`/product/comment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.comment.productId
                this.dataForm.memberNickName = data.comment.memberNickName
                this.dataForm.productName = data.comment.productName
                this.dataForm.star = data.comment.star
                this.dataForm.memberIp = data.comment.memberIp
                this.dataForm.createTime = data.comment.createTime
                this.dataForm.showStatus = data.comment.showStatus
                this.dataForm.productAttribute = data.comment.productAttribute
                this.dataForm.collectCouont = data.comment.collectCouont
                this.dataForm.readCount = data.comment.readCount
                this.dataForm.content = data.comment.content
                this.dataForm.pics = data.comment.pics
                this.dataForm.memberIcon = data.comment.memberIcon
                this.dataForm.replayCount = data.comment.replayCount
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
              url: this.$http.adornUrl(`/product/comment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'memberNickName': this.dataForm.memberNickName,
                'productName': this.dataForm.productName,
                'star': this.dataForm.star,
                'memberIp': this.dataForm.memberIp,
                'createTime': this.dataForm.createTime,
                'showStatus': this.dataForm.showStatus,
                'productAttribute': this.dataForm.productAttribute,
                'collectCouont': this.dataForm.collectCouont,
                'readCount': this.dataForm.readCount,
                'content': this.dataForm.content,
                'pics': this.dataForm.pics,
                'memberIcon': this.dataForm.memberIcon,
                'replayCount': this.dataForm.replayCount
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
