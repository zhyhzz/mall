package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.SkuStockEntity;

import java.util.Map;

/**
 * sku的库存
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface SkuStockService extends IService<SkuStockEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

