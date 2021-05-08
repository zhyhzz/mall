package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.ProductAttributeCategoryEntity;

import java.util.Map;

/**
 * 产品属性分类表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface ProductAttributeCategoryService extends IService<ProductAttributeCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

