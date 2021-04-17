package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.ProductFullReductionEntity;

import java.util.Map;

/**
 * 产品满减表(只针对同商品)
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:50
 */
public interface ProductFullReductionService extends IService<ProductFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

