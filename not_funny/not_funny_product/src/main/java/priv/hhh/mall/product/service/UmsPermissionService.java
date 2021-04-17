package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsPermissionEntity;

import java.util.Map;

/**
 * 后台用户权限表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsPermissionService extends IService<UmsPermissionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

