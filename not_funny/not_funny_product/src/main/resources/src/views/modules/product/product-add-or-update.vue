<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="brandId">
      <el-input v-model="dataForm.brandId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="productCategoryId">
      <el-input v-model="dataForm.productCategoryId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="feightTemplateId">
      <el-input v-model="dataForm.feightTemplateId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="productAttributeCategoryId">
      <el-input v-model="dataForm.productAttributeCategoryId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pic">
      <el-input v-model="dataForm.pic" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="货号" prop="productSn">
      <el-input v-model="dataForm.productSn" placeholder="货号"></el-input>
    </el-form-item>
    <el-form-item label="删除状态：0->未删除；1->已删除" prop="deleteStatus">
      <el-input v-model="dataForm.deleteStatus" placeholder="删除状态：0->未删除；1->已删除"></el-input>
    </el-form-item>
    <el-form-item label="上架状态：0->下架；1->上架" prop="publishStatus">
      <el-input v-model="dataForm.publishStatus" placeholder="上架状态：0->下架；1->上架"></el-input>
    </el-form-item>
    <el-form-item label="新品状态:0->不是新品；1->新品" prop="newStatus">
      <el-input v-model="dataForm.newStatus" placeholder="新品状态:0->不是新品；1->新品"></el-input>
    </el-form-item>
    <el-form-item label="推荐状态；0->不推荐；1->推荐" prop="recommandStatus">
      <el-input v-model="dataForm.recommandStatus" placeholder="推荐状态；0->不推荐；1->推荐"></el-input>
    </el-form-item>
    <el-form-item label="审核状态：0->未审核；1->审核通过" prop="verifyStatus">
      <el-input v-model="dataForm.verifyStatus" placeholder="审核状态：0->未审核；1->审核通过"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="销量" prop="sale">
      <el-input v-model="dataForm.sale" placeholder="销量"></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="促销价格" prop="promotionPrice">
      <el-input v-model="dataForm.promotionPrice" placeholder="促销价格"></el-input>
    </el-form-item>
    <el-form-item label="赠送的成长值" prop="giftGrowth">
      <el-input v-model="dataForm.giftGrowth" placeholder="赠送的成长值"></el-input>
    </el-form-item>
    <el-form-item label="赠送的积分" prop="giftPoint">
      <el-input v-model="dataForm.giftPoint" placeholder="赠送的积分"></el-input>
    </el-form-item>
    <el-form-item label="限制使用的积分数" prop="usePointLimit">
      <el-input v-model="dataForm.usePointLimit" placeholder="限制使用的积分数"></el-input>
    </el-form-item>
    <el-form-item label="副标题" prop="subTitle">
      <el-input v-model="dataForm.subTitle" placeholder="副标题"></el-input>
    </el-form-item>
    <el-form-item label="商品描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="商品描述"></el-input>
    </el-form-item>
    <el-form-item label="市场价" prop="originalPrice">
      <el-input v-model="dataForm.originalPrice" placeholder="市场价"></el-input>
    </el-form-item>
    <el-form-item label="库存" prop="stock">
      <el-input v-model="dataForm.stock" placeholder="库存"></el-input>
    </el-form-item>
    <el-form-item label="库存预警值" prop="lowStock">
      <el-input v-model="dataForm.lowStock" placeholder="库存预警值"></el-input>
    </el-form-item>
    <el-form-item label="单位" prop="unit">
      <el-input v-model="dataForm.unit" placeholder="单位"></el-input>
    </el-form-item>
    <el-form-item label="商品重量，默认为克" prop="weight">
      <el-input v-model="dataForm.weight" placeholder="商品重量，默认为克"></el-input>
    </el-form-item>
    <el-form-item label="是否为预告商品：0->不是；1->是" prop="previewStatus">
      <el-input v-model="dataForm.previewStatus" placeholder="是否为预告商品：0->不是；1->是"></el-input>
    </el-form-item>
    <el-form-item label="以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮" prop="serviceIds">
      <el-input v-model="dataForm.serviceIds" placeholder="以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮"></el-input>
    </el-form-item>
    <el-form-item label="" prop="keywords">
      <el-input v-model="dataForm.keywords" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="note">
      <el-input v-model="dataForm.note" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="画册图片，连产品图片限制为5张，以逗号分割" prop="albumPics">
      <el-input v-model="dataForm.albumPics" placeholder="画册图片，连产品图片限制为5张，以逗号分割"></el-input>
    </el-form-item>
    <el-form-item label="" prop="detailTitle">
      <el-input v-model="dataForm.detailTitle" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="detailDesc">
      <el-input v-model="dataForm.detailDesc" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="产品详情网页内容" prop="detailHtml">
      <el-input v-model="dataForm.detailHtml" placeholder="产品详情网页内容"></el-input>
    </el-form-item>
    <el-form-item label="移动端网页详情" prop="detailMobileHtml">
      <el-input v-model="dataForm.detailMobileHtml" placeholder="移动端网页详情"></el-input>
    </el-form-item>
    <el-form-item label="促销开始时间" prop="promotionStartTime">
      <el-input v-model="dataForm.promotionStartTime" placeholder="促销开始时间"></el-input>
    </el-form-item>
    <el-form-item label="促销结束时间" prop="promotionEndTime">
      <el-input v-model="dataForm.promotionEndTime" placeholder="促销结束时间"></el-input>
    </el-form-item>
    <el-form-item label="活动限购数量" prop="promotionPerLimit">
      <el-input v-model="dataForm.promotionPerLimit" placeholder="活动限购数量"></el-input>
    </el-form-item>
    <el-form-item label="促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购" prop="promotionType">
      <el-input v-model="dataForm.promotionType" placeholder="促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购"></el-input>
    </el-form-item>
    <el-form-item label="品牌名称" prop="brandName">
      <el-input v-model="dataForm.brandName" placeholder="品牌名称"></el-input>
    </el-form-item>
    <el-form-item label="商品分类名称" prop="productCategoryName">
      <el-input v-model="dataForm.productCategoryName" placeholder="商品分类名称"></el-input>
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
          brandId: '',
          productCategoryId: '',
          feightTemplateId: '',
          productAttributeCategoryId: '',
          name: '',
          pic: '',
          productSn: '',
          deleteStatus: '',
          publishStatus: '',
          newStatus: '',
          recommandStatus: '',
          verifyStatus: '',
          sort: '',
          sale: '',
          price: '',
          promotionPrice: '',
          giftGrowth: '',
          giftPoint: '',
          usePointLimit: '',
          subTitle: '',
          description: '',
          originalPrice: '',
          stock: '',
          lowStock: '',
          unit: '',
          weight: '',
          previewStatus: '',
          serviceIds: '',
          keywords: '',
          note: '',
          albumPics: '',
          detailTitle: '',
          detailDesc: '',
          detailHtml: '',
          detailMobileHtml: '',
          promotionStartTime: '',
          promotionEndTime: '',
          promotionPerLimit: '',
          promotionType: '',
          brandName: '',
          productCategoryName: ''
        },
        dataRule: {
          brandId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productCategoryId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          feightTemplateId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productAttributeCategoryId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pic: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productSn: [
            { required: true, message: '货号不能为空', trigger: 'blur' }
          ],
          deleteStatus: [
            { required: true, message: '删除状态：0->未删除；1->已删除不能为空', trigger: 'blur' }
          ],
          publishStatus: [
            { required: true, message: '上架状态：0->下架；1->上架不能为空', trigger: 'blur' }
          ],
          newStatus: [
            { required: true, message: '新品状态:0->不是新品；1->新品不能为空', trigger: 'blur' }
          ],
          recommandStatus: [
            { required: true, message: '推荐状态；0->不推荐；1->推荐不能为空', trigger: 'blur' }
          ],
          verifyStatus: [
            { required: true, message: '审核状态：0->未审核；1->审核通过不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          sale: [
            { required: true, message: '销量不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          promotionPrice: [
            { required: true, message: '促销价格不能为空', trigger: 'blur' }
          ],
          giftGrowth: [
            { required: true, message: '赠送的成长值不能为空', trigger: 'blur' }
          ],
          giftPoint: [
            { required: true, message: '赠送的积分不能为空', trigger: 'blur' }
          ],
          usePointLimit: [
            { required: true, message: '限制使用的积分数不能为空', trigger: 'blur' }
          ],
          subTitle: [
            { required: true, message: '副标题不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '商品描述不能为空', trigger: 'blur' }
          ],
          originalPrice: [
            { required: true, message: '市场价不能为空', trigger: 'blur' }
          ],
          stock: [
            { required: true, message: '库存不能为空', trigger: 'blur' }
          ],
          lowStock: [
            { required: true, message: '库存预警值不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '单位不能为空', trigger: 'blur' }
          ],
          weight: [
            { required: true, message: '商品重量，默认为克不能为空', trigger: 'blur' }
          ],
          previewStatus: [
            { required: true, message: '是否为预告商品：0->不是；1->是不能为空', trigger: 'blur' }
          ],
          serviceIds: [
            { required: true, message: '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮不能为空', trigger: 'blur' }
          ],
          keywords: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          albumPics: [
            { required: true, message: '画册图片，连产品图片限制为5张，以逗号分割不能为空', trigger: 'blur' }
          ],
          detailTitle: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          detailDesc: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          detailHtml: [
            { required: true, message: '产品详情网页内容不能为空', trigger: 'blur' }
          ],
          detailMobileHtml: [
            { required: true, message: '移动端网页详情不能为空', trigger: 'blur' }
          ],
          promotionStartTime: [
            { required: true, message: '促销开始时间不能为空', trigger: 'blur' }
          ],
          promotionEndTime: [
            { required: true, message: '促销结束时间不能为空', trigger: 'blur' }
          ],
          promotionPerLimit: [
            { required: true, message: '活动限购数量不能为空', trigger: 'blur' }
          ],
          promotionType: [
            { required: true, message: '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购不能为空', trigger: 'blur' }
          ],
          brandName: [
            { required: true, message: '品牌名称不能为空', trigger: 'blur' }
          ],
          productCategoryName: [
            { required: true, message: '商品分类名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/product/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.brandId = data.product.brandId
                this.dataForm.productCategoryId = data.product.productCategoryId
                this.dataForm.feightTemplateId = data.product.feightTemplateId
                this.dataForm.productAttributeCategoryId = data.product.productAttributeCategoryId
                this.dataForm.name = data.product.name
                this.dataForm.pic = data.product.pic
                this.dataForm.productSn = data.product.productSn
                this.dataForm.deleteStatus = data.product.deleteStatus
                this.dataForm.publishStatus = data.product.publishStatus
                this.dataForm.newStatus = data.product.newStatus
                this.dataForm.recommandStatus = data.product.recommandStatus
                this.dataForm.verifyStatus = data.product.verifyStatus
                this.dataForm.sort = data.product.sort
                this.dataForm.sale = data.product.sale
                this.dataForm.price = data.product.price
                this.dataForm.promotionPrice = data.product.promotionPrice
                this.dataForm.giftGrowth = data.product.giftGrowth
                this.dataForm.giftPoint = data.product.giftPoint
                this.dataForm.usePointLimit = data.product.usePointLimit
                this.dataForm.subTitle = data.product.subTitle
                this.dataForm.description = data.product.description
                this.dataForm.originalPrice = data.product.originalPrice
                this.dataForm.stock = data.product.stock
                this.dataForm.lowStock = data.product.lowStock
                this.dataForm.unit = data.product.unit
                this.dataForm.weight = data.product.weight
                this.dataForm.previewStatus = data.product.previewStatus
                this.dataForm.serviceIds = data.product.serviceIds
                this.dataForm.keywords = data.product.keywords
                this.dataForm.note = data.product.note
                this.dataForm.albumPics = data.product.albumPics
                this.dataForm.detailTitle = data.product.detailTitle
                this.dataForm.detailDesc = data.product.detailDesc
                this.dataForm.detailHtml = data.product.detailHtml
                this.dataForm.detailMobileHtml = data.product.detailMobileHtml
                this.dataForm.promotionStartTime = data.product.promotionStartTime
                this.dataForm.promotionEndTime = data.product.promotionEndTime
                this.dataForm.promotionPerLimit = data.product.promotionPerLimit
                this.dataForm.promotionType = data.product.promotionType
                this.dataForm.brandName = data.product.brandName
                this.dataForm.productCategoryName = data.product.productCategoryName
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
              url: this.$http.adornUrl(`/product/product/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'brandId': this.dataForm.brandId,
                'productCategoryId': this.dataForm.productCategoryId,
                'feightTemplateId': this.dataForm.feightTemplateId,
                'productAttributeCategoryId': this.dataForm.productAttributeCategoryId,
                'name': this.dataForm.name,
                'pic': this.dataForm.pic,
                'productSn': this.dataForm.productSn,
                'deleteStatus': this.dataForm.deleteStatus,
                'publishStatus': this.dataForm.publishStatus,
                'newStatus': this.dataForm.newStatus,
                'recommandStatus': this.dataForm.recommandStatus,
                'verifyStatus': this.dataForm.verifyStatus,
                'sort': this.dataForm.sort,
                'sale': this.dataForm.sale,
                'price': this.dataForm.price,
                'promotionPrice': this.dataForm.promotionPrice,
                'giftGrowth': this.dataForm.giftGrowth,
                'giftPoint': this.dataForm.giftPoint,
                'usePointLimit': this.dataForm.usePointLimit,
                'subTitle': this.dataForm.subTitle,
                'description': this.dataForm.description,
                'originalPrice': this.dataForm.originalPrice,
                'stock': this.dataForm.stock,
                'lowStock': this.dataForm.lowStock,
                'unit': this.dataForm.unit,
                'weight': this.dataForm.weight,
                'previewStatus': this.dataForm.previewStatus,
                'serviceIds': this.dataForm.serviceIds,
                'keywords': this.dataForm.keywords,
                'note': this.dataForm.note,
                'albumPics': this.dataForm.albumPics,
                'detailTitle': this.dataForm.detailTitle,
                'detailDesc': this.dataForm.detailDesc,
                'detailHtml': this.dataForm.detailHtml,
                'detailMobileHtml': this.dataForm.detailMobileHtml,
                'promotionStartTime': this.dataForm.promotionStartTime,
                'promotionEndTime': this.dataForm.promotionEndTime,
                'promotionPerLimit': this.dataForm.promotionPerLimit,
                'promotionType': this.dataForm.promotionType,
                'brandName': this.dataForm.brandName,
                'productCategoryName': this.dataForm.productCategoryName
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
