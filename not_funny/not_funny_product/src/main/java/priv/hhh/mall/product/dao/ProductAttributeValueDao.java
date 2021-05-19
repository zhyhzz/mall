package priv.hhh.mall.product.dao;

import priv.hhh.mall.product.entity.ProductAttributeValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储产品参数信息的表
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@Mapper
public interface ProductAttributeValueDao extends BaseMapper<ProductAttributeValueEntity> {
	
}
