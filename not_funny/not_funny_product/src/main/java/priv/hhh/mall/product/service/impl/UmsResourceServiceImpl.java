package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsResourceDao;
import priv.hhh.mall.product.entity.UmsResourceEntity;
import priv.hhh.mall.product.service.UmsResourceService;


@Service("umsResourceService")
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceDao, UmsResourceEntity> implements UmsResourceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsResourceEntity> page = this.page(
                new Query<UmsResourceEntity>().getPage(params),
                new QueryWrapper<UmsResourceEntity>()
        );

        return new PageUtils(page);
    }

}