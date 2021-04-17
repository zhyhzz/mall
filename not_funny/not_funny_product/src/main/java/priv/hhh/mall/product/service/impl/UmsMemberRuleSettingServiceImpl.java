package priv.hhh.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.product.dao.UmsMemberRuleSettingDao;
import priv.hhh.mall.product.entity.UmsMemberRuleSettingEntity;
import priv.hhh.mall.product.service.UmsMemberRuleSettingService;


@Service("umsMemberRuleSettingService")
public class UmsMemberRuleSettingServiceImpl extends ServiceImpl<UmsMemberRuleSettingDao, UmsMemberRuleSettingEntity> implements UmsMemberRuleSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberRuleSettingEntity> page = this.page(
                new Query<UmsMemberRuleSettingEntity>().getPage(params),
                new QueryWrapper<UmsMemberRuleSettingEntity>()
        );

        return new PageUtils(page);
    }

}