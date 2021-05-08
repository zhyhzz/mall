package priv.hhh.mall.member.dao;

import priv.hhh.mall.member.entity.ProductCategoryAttributeRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@Mapper
public interface ProductCategoryAttributeRelationDao extends BaseMapper<ProductCategoryAttributeRelationEntity> {
	
}
