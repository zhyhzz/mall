package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsRoleEntity;

import java.util.Map;

/**
 * 后台用户角色表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsRoleService extends IService<UmsRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

