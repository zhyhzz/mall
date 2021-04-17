package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsRoleMenuRelationDao;
import priv.hhh.mall.product.entity.UmsRoleMenuRelationEntity;
import priv.hhh.mall.product.service.UmsRoleMenuRelationService;


@Service("umsRoleMenuRelationService")
public class UmsRoleMenuRelationServiceImpl extends ServiceImpl<UmsRoleMenuRelationDao, UmsRoleMenuRelationEntity> implements UmsRoleMenuRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRoleMenuRelationEntity> page = this.page(
                new Query<UmsRoleMenuRelationEntity>().getPage(params),
                new QueryWrapper<UmsRoleMenuRelationEntity>()
        );

        return new PageUtils(page);
    }

}