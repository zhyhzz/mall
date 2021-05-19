package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.AlbumPicDao;
import priv.hhh.mall.product.entity.AlbumPicEntity;
import priv.hhh.mall.product.service.AlbumPicService;


@Service("albumPicService")
public class AlbumPicServiceImpl extends ServiceImpl<AlbumPicDao, AlbumPicEntity> implements AlbumPicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AlbumPicEntity> page = this.page(
                new Query<AlbumPicEntity>().getPage(params),
                new QueryWrapper<AlbumPicEntity>()
        );

        return new PageUtils(page);
    }

}