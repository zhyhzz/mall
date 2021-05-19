package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.ProductLadderDao;
import priv.hhh.mall.product.entity.ProductLadderEntity;
import priv.hhh.mall.product.service.ProductLadderService;


@Service("productLadderService")
public class ProductLadderServiceImpl extends ServiceImpl<ProductLadderDao, ProductLadderEntity> implements ProductLadderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductLadderEntity> page = this.page(
                new Query<ProductLadderEntity>().getPage(params),
                new QueryWrapper<ProductLadderEntity>()
        );

        return new PageUtils(page);
    }

}