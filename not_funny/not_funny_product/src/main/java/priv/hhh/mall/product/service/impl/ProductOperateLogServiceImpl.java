package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.ProductOperateLogDao;
import priv.hhh.mall.product.entity.ProductOperateLogEntity;
import priv.hhh.mall.product.service.ProductOperateLogService;


@Service("productOperateLogService")
public class ProductOperateLogServiceImpl extends ServiceImpl<ProductOperateLogDao, ProductOperateLogEntity> implements ProductOperateLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductOperateLogEntity> page = this.page(
                new Query<ProductOperateLogEntity>().getPage(params),
                new QueryWrapper<ProductOperateLogEntity>()
        );

        return new PageUtils(page);
    }

}