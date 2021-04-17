package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsResourceEntity;

import java.util.Map;

/**
 * 后台资源表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsResourceService extends IService<UmsResourceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

