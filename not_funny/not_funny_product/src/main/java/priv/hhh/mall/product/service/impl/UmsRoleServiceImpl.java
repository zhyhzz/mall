package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsRoleDao;
import priv.hhh.mall.product.entity.UmsRoleEntity;
import priv.hhh.mall.product.service.UmsRoleService;


@Service("umsRoleService")
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleDao, UmsRoleEntity> implements UmsRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRoleEntity> page = this.page(
                new Query<UmsRoleEntity>().getPage(params),
                new QueryWrapper<UmsRoleEntity>()
        );

        return new PageUtils(page);
    }

}