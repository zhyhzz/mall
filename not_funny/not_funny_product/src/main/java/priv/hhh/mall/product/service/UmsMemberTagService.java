package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.UmsMemberTagEntity;

import java.util.Map;

/**
 * 用户标签表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
public interface UmsMemberTagService extends IService<UmsMemberTagEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

