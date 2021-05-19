package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.ProductVertifyRecordDao;
import priv.hhh.mall.product.entity.ProductVertifyRecordEntity;
import priv.hhh.mall.product.service.ProductVertifyRecordService;


@Service("productVertifyRecordService")
public class ProductVertifyRecordServiceImpl extends ServiceImpl<ProductVertifyRecordDao, ProductVertifyRecordEntity> implements ProductVertifyRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductVertifyRecordEntity> page = this.page(
                new Query<ProductVertifyRecordEntity>().getPage(params),
                new QueryWrapper<ProductVertifyRecordEntity>()
        );

        return new PageUtils(page);
    }

}