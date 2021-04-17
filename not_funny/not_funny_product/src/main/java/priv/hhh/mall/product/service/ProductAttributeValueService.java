package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.ProductAttributeValueEntity;

import java.util.Map;

/**
 * 存储产品参数信息的表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface ProductAttributeValueService extends IService<ProductAttributeValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

