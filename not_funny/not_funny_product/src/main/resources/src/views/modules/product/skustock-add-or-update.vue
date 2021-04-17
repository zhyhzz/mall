<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="productId">
      <el-input v-model="dataForm.productId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="sku编码" prop="skuCode">
      <el-input v-model="dataForm.skuCode" placeholder="sku编码"></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="库存" prop="stock">
      <el-input v-model="dataForm.stock" placeholder="库存"></el-input>
    </el-form-item>
    <el-form-item label="预警库存" prop="lowStock">
      <el-input v-model="dataForm.lowStock" placeholder="预警库存"></el-input>
    </el-form-item>
    <el-form-item label="展示图片" prop="pic">
      <el-input v-model="dataForm.pic" placeholder="展示图片"></el-input>
    </el-form-item>
    <el-form-item label="销量" prop="sale">
      <el-input v-model="dataForm.sale" placeholder="销量"></el-input>
    </el-form-item>
    <el-form-item label="单品促销价格" prop="promotionPrice">
      <el-input v-model="dataForm.promotionPrice" placeholder="单品促销价格"></el-input>
    </el-form-item>
    <el-form-item label="锁定库存" prop="lockStock">
      <el-input v-model="dataForm.lockStock" placeholder="锁定库存"></el-input>
    </el-form-item>
    <el-form-item label="商品销售属性，json格式" prop="spData">
      <el-input v-model="dataForm.spData" placeholder="商品销售属性，json格式"></el-input>
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
          skuCode: '',
          price: '',
          stock: '',
          lowStock: '',
          pic: '',
          sale: '',
          promotionPrice: '',
          lockStock: '',
          spData: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuCode: [
            { required: true, message: 'sku编码不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          stock: [
            { required: true, message: '库存不能为空', trigger: 'blur' }
          ],
          lowStock: [
            { required: true, message: '预警库存不能为空', trigger: 'blur' }
          ],
          pic: [
            { required: true, message: '展示图片不能为空', trigger: 'blur' }
          ],
          sale: [
            { required: true, message: '销量不能为空', trigger: 'blur' }
          ],
          promotionPrice: [
            { required: true, message: '单品促销价格不能为空', trigger: 'blur' }
          ],
          lockStock: [
            { required: true, message: '锁定库存不能为空', trigger: 'blur' }
          ],
          spData: [
            { required: true, message: '商品销售属性，json格式不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/skustock/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.skuStock.productId
                this.dataForm.skuCode = data.skuStock.skuCode
                this.dataForm.price = data.skuStock.price
                this.dataForm.stock = data.skuStock.stock
                this.dataForm.lowStock = data.skuStock.lowStock
                this.dataForm.pic = data.skuStock.pic
                this.dataForm.sale = data.skuStock.sale
                this.dataForm.promotionPrice = data.skuStock.promotionPrice
                this.dataForm.lockStock = data.skuStock.lockStock
                this.dataForm.spData = data.skuStock.spData
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
              url: this.$http.adornUrl(`/product/skustock/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'skuCode': this.dataForm.skuCode,
                'price': this.dataForm.price,
                'stock': this.dataForm.stock,
                'lowStock': this.dataForm.lowStock,
                'pic': this.dataForm.pic,
                'sale': this.dataForm.sale,
                'promotionPrice': this.dataForm.promotionPrice,
                'lockStock': this.dataForm.lockStock,
                'spData': this.dataForm.spData
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
