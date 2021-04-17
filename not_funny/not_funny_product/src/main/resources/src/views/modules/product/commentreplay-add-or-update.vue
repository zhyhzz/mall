<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="commentId">
      <el-input v-model="dataForm.commentId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberNickName">
      <el-input v-model="dataForm.memberNickName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberIcon">
      <el-input v-model="dataForm.memberIcon" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="content">
      <el-input v-model="dataForm.content" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="评论人员类型；0->会员；1->管理员" prop="type">
      <el-input v-model="dataForm.type" placeholder="评论人员类型；0->会员；1->管理员"></el-input>
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
          commentId: '',
          memberNickName: '',
          memberIcon: '',
          content: '',
          createTime: '',
          type: ''
        },
        dataRule: {
          commentId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberNickName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberIcon: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '评论人员类型；0->会员；1->管理员不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/commentreplay/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.commentId = data.commentReplay.commentId
                this.dataForm.memberNickName = data.commentReplay.memberNickName
                this.dataForm.memberIcon = data.commentReplay.memberIcon
                this.dataForm.content = data.commentReplay.content
                this.dataForm.createTime = data.commentReplay.createTime
                this.dataForm.type = data.commentReplay.type
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
              url: this.$http.adornUrl(`/product/commentreplay/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'commentId': this.dataForm.commentId,
                'memberNickName': this.dataForm.memberNickName,
                'memberIcon': this.dataForm.memberIcon,
                'content': this.dataForm.content,
                'createTime': this.dataForm.createTime,
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
