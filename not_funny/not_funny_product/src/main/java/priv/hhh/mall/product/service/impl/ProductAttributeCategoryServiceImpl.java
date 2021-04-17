package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.ProductAttributeCategoryDao;
import priv.hhh.mall.product.entity.ProductAttributeCategoryEntity;
import priv.hhh.mall.product.service.ProductAttributeCategoryService;


@Service("productAttributeCategoryService")
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryDao, ProductAttributeCategoryEntity> implements ProductAttributeCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductAttributeCategoryEntity> page = this.page(
                new Query<ProductAttributeCategoryEntity>().getPage(params),
                new QueryWrapper<ProductAttributeCategoryEntity>()
        );

        return new PageUtils(page);
    }

}