package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.UmsMemberRuleSettingEntity;
import priv.hhh.mall.product.service.UmsMemberRuleSettingService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 会员积分成长规则表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@RestController
@RequestMapping("product/umsmemberrulesetting")
public class UmsMemberRuleSettingController {
    @Autowired
    private UmsMemberRuleSettingService umsMemberRuleSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:umsmemberrulesetting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberRuleSettingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:umsmemberrulesetting:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberRuleSettingEntity umsMemberRuleSetting = umsMemberRuleSettingService.getById(id);

        return R.ok().put("umsMemberRuleSetting", umsMemberRuleSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:umsmemberrulesetting:save")
    public R save(@RequestBody UmsMemberRuleSettingEntity umsMemberRuleSetting){
		umsMemberRuleSettingService.save(umsMemberRuleSetting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:umsmemberrulesetting:update")
    public R update(@RequestBody UmsMemberRuleSettingEntity umsMemberRuleSetting){
		umsMemberRuleSettingService.updateById(umsMemberRuleSetting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:umsmemberrulesetting:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberRuleSettingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
