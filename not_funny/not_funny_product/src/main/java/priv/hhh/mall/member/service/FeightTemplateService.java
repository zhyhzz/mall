package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.FeightTemplateEntity;

import java.util.Map;

/**
 * 运费模版
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface FeightTemplateService extends IService<FeightTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

