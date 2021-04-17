package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.ProductFullReductionDao;
import priv.hhh.mall.product.entity.ProductFullReductionEntity;
import priv.hhh.mall.product.service.ProductFullReductionService;


@Service("productFullReductionService")
public class ProductFullReductionServiceImpl extends ServiceImpl<ProductFullReductionDao, ProductFullReductionEntity> implements ProductFullReductionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductFullReductionEntity> page = this.page(
                new Query<ProductFullReductionEntity>().getPage(params),
                new QueryWrapper<ProductFullReductionEntity>()
        );

        return new PageUtils(page);
    }

}