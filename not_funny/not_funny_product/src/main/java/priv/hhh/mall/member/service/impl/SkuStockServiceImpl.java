package priv.hhh.mall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.member.dao.SkuStockDao;
import priv.hhh.mall.member.entity.SkuStockEntity;
import priv.hhh.mall.member.service.SkuStockService;


@Service("skuStockService")
public class SkuStockServiceImpl extends ServiceImpl<SkuStockDao, SkuStockEntity> implements SkuStockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuStockEntity> page = this.page(
                new Query<SkuStockEntity>().getPage(params),
                new QueryWrapper<SkuStockEntity>()
        );

        return new PageUtils(page);
    }

}