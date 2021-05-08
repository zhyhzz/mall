package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.ProductAttributeEntity;

import java.util.Map;

/**
 * 商品属性参数表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface ProductAttributeService extends IService<ProductAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

