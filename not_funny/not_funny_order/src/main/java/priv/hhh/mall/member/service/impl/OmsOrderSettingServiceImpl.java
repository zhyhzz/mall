package priv.hhh.mall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.Query;

import priv.hhh.mall.member.dao.OmsOrderSettingDao;
import priv.hhh.mall.member.entity.OmsOrderSettingEntity;
import priv.hhh.mall.member.service.OmsOrderSettingService;


@Service("omsOrderSettingService")
public class OmsOrderSettingServiceImpl extends ServiceImpl<OmsOrderSettingDao, OmsOrderSettingEntity> implements OmsOrderSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderSettingEntity> page = this.page(
                new Query<OmsOrderSettingEntity>().getPage(params),
                new QueryWrapper<OmsOrderSettingEntity>()
        );

        return new PageUtils(page);
    }

}