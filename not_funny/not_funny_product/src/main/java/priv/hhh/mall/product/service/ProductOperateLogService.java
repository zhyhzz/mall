package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.ProductOperateLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface ProductOperateLogService extends IService<ProductOperateLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

