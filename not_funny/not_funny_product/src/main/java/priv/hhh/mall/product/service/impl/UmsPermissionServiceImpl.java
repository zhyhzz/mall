package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsPermissionDao;
import priv.hhh.mall.product.entity.UmsPermissionEntity;
import priv.hhh.mall.product.service.UmsPermissionService;


@Service("umsPermissionService")
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionDao, UmsPermissionEntity> implements UmsPermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsPermissionEntity> page = this.page(
                new Query<UmsPermissionEntity>().getPage(params),
                new QueryWrapper<UmsPermissionEntity>()
        );

        return new PageUtils(page);
    }

}