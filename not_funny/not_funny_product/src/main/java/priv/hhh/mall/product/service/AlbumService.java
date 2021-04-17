package priv.hhh.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.mall.product.entity.AlbumEntity;

import java.util.Map;

/**
 * 相册表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
public interface AlbumService extends IService<AlbumEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

