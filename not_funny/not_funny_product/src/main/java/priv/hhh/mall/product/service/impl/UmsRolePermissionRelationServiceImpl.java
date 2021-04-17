package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsRolePermissionRelationDao;
import priv.hhh.mall.product.entity.UmsRolePermissionRelationEntity;
import priv.hhh.mall.product.service.UmsRolePermissionRelationService;


@Service("umsRolePermissionRelationService")
public class UmsRolePermissionRelationServiceImpl extends ServiceImpl<UmsRolePermissionRelationDao, UmsRolePermissionRelationEntity> implements UmsRolePermissionRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRolePermissionRelationEntity> page = this.page(
                new Query<UmsRolePermissionRelationEntity>().getPage(params),
                new QueryWrapper<UmsRolePermissionRelationEntity>()
        );

        return new PageUtils(page);
    }

}