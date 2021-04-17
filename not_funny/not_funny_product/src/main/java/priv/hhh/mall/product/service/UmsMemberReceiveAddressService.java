package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsMemberReceiveAddressEntity;

import java.util.Map;

/**
 * 会员收货地址表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

