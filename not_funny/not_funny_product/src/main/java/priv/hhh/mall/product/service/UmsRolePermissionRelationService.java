package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsRolePermissionRelationEntity;

import java.util.Map;

/**
 * 后台用户角色和权限关系表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsRolePermissionRelationService extends IService<UmsRolePermissionRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

