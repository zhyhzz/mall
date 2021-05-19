package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.ProductLadderEntity;

import java.util.Map;

/**
 * 产品阶梯价格表(只针对同商品)
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:50
 */
public interface ProductLadderService extends IService<ProductLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

