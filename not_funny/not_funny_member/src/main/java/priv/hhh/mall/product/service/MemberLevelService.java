package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-18 20:53:01
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

