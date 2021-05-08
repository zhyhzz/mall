package priv.hhh.mall.member.dao;

import priv.hhh.mall.member.entity.ProductLadderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品阶梯价格表(只针对同商品)
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:50
 */
@Mapper
public interface ProductLadderDao extends BaseMapper<ProductLadderEntity> {
	
}
