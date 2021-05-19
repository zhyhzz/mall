package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.ProductCategoryAttributeRelationEntity;

import java.util.Map;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface ProductCategoryAttributeRelationService extends IService<ProductCategoryAttributeRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

