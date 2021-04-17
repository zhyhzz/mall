package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsRoleMenuRelationEntity;

import java.util.Map;

/**
 * 后台角色菜单关系表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsRoleMenuRelationService extends IService<UmsRoleMenuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

