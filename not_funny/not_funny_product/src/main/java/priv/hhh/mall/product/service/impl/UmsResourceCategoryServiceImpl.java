package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsResourceCategoryDao;
import priv.hhh.mall.product.entity.UmsResourceCategoryEntity;
import priv.hhh.mall.product.service.UmsResourceCategoryService;


@Service("umsResourceCategoryService")
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryDao, UmsResourceCategoryEntity> implements UmsResourceCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsResourceCategoryEntity> page = this.page(
                new Query<UmsResourceCategoryEntity>().getPage(params),
                new QueryWrapper<UmsResourceCategoryEntity>()
        );

        return new PageUtils(page);
    }

}