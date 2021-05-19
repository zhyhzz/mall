package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.ProductAttributeValueDao;
import priv.hhh.mall.product.entity.ProductAttributeValueEntity;
import priv.hhh.mall.product.service.ProductAttributeValueService;


@Service("productAttributeValueService")
public class ProductAttributeValueServiceImpl extends ServiceImpl<ProductAttributeValueDao, ProductAttributeValueEntity> implements ProductAttributeValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductAttributeValueEntity> page = this.page(
                new Query<ProductAttributeValueEntity>().getPage(params),
                new QueryWrapper<ProductAttributeValueEntity>()
        );

        return new PageUtils(page);
    }

}