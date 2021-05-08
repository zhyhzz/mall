package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-18 20:53:02
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

