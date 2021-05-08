package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.OmsOrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-19 15:51:04
 */
public interface OmsOrderSettingService extends IService<OmsOrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

