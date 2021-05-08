package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.OmsOrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-19 15:51:04
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

