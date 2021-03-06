package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.ProductAttributeDao;
import priv.hhh.mall.product.entity.ProductAttributeEntity;
import priv.hhh.mall.product.service.ProductAttributeService;


@Service("productAttributeService")
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeDao, ProductAttributeEntity> implements ProductAttributeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductAttributeEntity> page = this.page(
                new Query<ProductAttributeEntity>().getPage(params),
                new QueryWrapper<ProductAttributeEntity>()
        );

        return new PageUtils(page);
    }

}