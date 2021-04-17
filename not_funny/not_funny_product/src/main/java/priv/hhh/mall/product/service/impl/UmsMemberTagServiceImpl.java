package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsMemberTagDao;
import priv.hhh.mall.product.entity.UmsMemberTagEntity;
import priv.hhh.mall.product.service.UmsMemberTagService;


@Service("umsMemberTagService")
public class UmsMemberTagServiceImpl extends ServiceImpl<UmsMemberTagDao, UmsMemberTagEntity> implements UmsMemberTagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberTagEntity> page = this.page(
                new Query<UmsMemberTagEntity>().getPage(params),
                new QueryWrapper<UmsMemberTagEntity>()
        );

        return new PageUtils(page);
    }

}