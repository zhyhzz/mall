package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-18 20:53:02
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

