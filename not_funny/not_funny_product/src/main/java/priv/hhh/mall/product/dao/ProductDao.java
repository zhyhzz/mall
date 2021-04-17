package priv.hhh.mall.product.dao;

import priv.hhh.mall.product.entity.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品信息
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
	
}
