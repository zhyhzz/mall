package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsResourceCategoryEntity;

import java.util.Map;

/**
 * 资源分类表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsResourceCategoryService extends IService<UmsResourceCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

