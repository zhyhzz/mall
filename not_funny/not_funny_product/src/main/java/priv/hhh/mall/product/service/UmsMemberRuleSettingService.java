package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsMemberRuleSettingEntity;

import java.util.Map;

/**
 * 会员积分成长规则表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsMemberRuleSettingService extends IService<UmsMemberRuleSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

