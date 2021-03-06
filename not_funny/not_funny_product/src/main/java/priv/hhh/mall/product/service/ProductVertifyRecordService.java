package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.ProductVertifyRecordEntity;

import java.util.Map;

/**
 * 商品审核记录
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface ProductVertifyRecordService extends IService<ProductVertifyRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

