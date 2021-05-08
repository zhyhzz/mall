package priv.hhh.mall.member.dao;

import priv.hhh.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-18 20:53:02
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
