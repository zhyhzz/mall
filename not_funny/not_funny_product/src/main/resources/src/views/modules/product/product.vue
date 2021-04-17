<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('product:product:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('product:product:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="brandId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="productCategoryId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="feightTemplateId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="productAttributeCategoryId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="name"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pic"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="productSn"
        header-align="center"
        align="center"
        label="货号">
      </el-table-column>
      <el-table-column
        prop="deleteStatus"
        header-align="center"
        align="center"
        label="删除状态：0->未删除；1->已删除">
      </el-table-column>
      <el-table-column
        prop="publishStatus"
        header-align="center"
        align="center"
        label="上架状态：0->下架；1->上架">
      </el-table-column>
      <el-table-column
        prop="newStatus"
        header-align="center"
        align="center"
        label="新品状态:0->不是新品；1->新品">
      </el-table-column>
      <el-table-column
        prop="recommandStatus"
        header-align="center"
        align="center"
        label="推荐状态；0->不推荐；1->推荐">
      </el-table-column>
      <el-table-column
        prop="verifyStatus"
        header-align="center"
        align="center"
        label="审核状态：0->未审核；1->审核通过">
      </el-table-column>
      <el-table-column
        prop="sort"
        header-align="center"
        align="center"
        label="排序">
      </el-table-column>
      <el-table-column
        prop="sale"
        header-align="center"
        align="center"
        label="销量">
      </el-table-column>
      <el-table-column
        prop="price"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="promotionPrice"
        header-align="center"
        align="center"
        label="促销价格">
      </el-table-column>
      <el-table-column
        prop="giftGrowth"
        header-align="center"
        align="center"
        label="赠送的成长值">
      </el-table-column>
      <el-table-column
        prop="giftPoint"
        header-align="center"
        align="center"
        label="赠送的积分">
      </el-table-column>
      <el-table-column
        prop="usePointLimit"
        header-align="center"
        align="center"
        label="限制使用的积分数">
      </el-table-column>
      <el-table-column
        prop="subTitle"
        header-align="center"
        align="center"
        label="副标题">
      </el-table-column>
      <el-table-column
        prop="description"
        header-align="center"
        align="center"
        label="商品描述">
      </el-table-column>
      <el-table-column
        prop="originalPrice"
        header-align="center"
        align="center"
        label="市场价">
      </el-table-column>
      <el-table-column
        prop="stock"
        header-align="center"
        align="center"
        label="库存">
      </el-table-column>
      <el-table-column
        prop="lowStock"
        header-align="center"
        align="center"
        label="库存预警值">
      </el-table-column>
      <el-table-column
        prop="unit"
        header-align="center"
        align="center"
        label="单位">
      </el-table-column>
      <el-table-column
        prop="weight"
        header-align="center"
        align="center"
        label="商品重量，默认为克">
      </el-table-column>
      <el-table-column
        prop="previewStatus"
        header-align="center"
        align="center"
        label="是否为预告商品：0->不是；1->是">
      </el-table-column>
      <el-table-column
        prop="serviceIds"
        header-align="center"
        align="center"
        label="以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮">
      </el-table-column>
      <el-table-column
        prop="keywords"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="note"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="albumPics"
        header-align="center"
        align="center"
        label="画册图片，连产品图片限制为5张，以逗号分割">
      </el-table-column>
      <el-table-column
        prop="detailTitle"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="detailDesc"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="detailHtml"
        header-align="center"
        align="center"
        label="产品详情网页内容">
      </el-table-column>
      <el-table-column
        prop="detailMobileHtml"
        header-align="center"
        align="center"
        label="移动端网页详情">
      </el-table-column>
      <el-table-column
        prop="promotionStartTime"
        header-align="center"
        align="center"
        label="促销开始时间">
      </el-table-column>
      <el-table-column
        prop="promotionEndTime"
        header-align="center"
        align="center"
        label="促销结束时间">
      </el-table-column>
      <el-table-column
        prop="promotionPerLimit"
        header-align="center"
        align="center"
        label="活动限购数量">
      </el-table-column>
      <el-table-column
        prop="promotionType"
        header-align="center"
        align="center"
        label="促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购">
      </el-table-column>
      <el-table-column
        prop="brandName"
        header-align="center"
        align="center"
        label="品牌名称">
      </el-table-column>
      <el-table-column
        prop="productCategoryName"
        header-align="center"
        align="center"
        label="商品分类名称">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './product-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/product/product/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/product/product/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
