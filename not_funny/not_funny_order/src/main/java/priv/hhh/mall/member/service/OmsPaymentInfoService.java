package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.OmsPaymentInfoEntity;

import java.util.Map;

/**
 * 支付信息表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-19 15:51:04
 */
public interface OmsPaymentInfoService extends IService<OmsPaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

