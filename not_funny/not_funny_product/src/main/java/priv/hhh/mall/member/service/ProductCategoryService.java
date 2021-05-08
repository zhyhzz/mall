package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.ProductCategoryEntity;

import java.util.Map;

/**
 * 产品分类
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface ProductCategoryService extends IService<ProductCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

