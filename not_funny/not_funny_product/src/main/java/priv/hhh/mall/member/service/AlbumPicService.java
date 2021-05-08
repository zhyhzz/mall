package priv.hhh.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.member.entity.AlbumPicEntity;

import java.util.Map;

/**
 * 画册图片表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface AlbumPicService extends IService<AlbumPicEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

