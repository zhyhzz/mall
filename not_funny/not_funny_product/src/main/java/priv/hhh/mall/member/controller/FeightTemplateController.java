package priv.hhh.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.member.entity.FeightTemplateEntity;
import priv.hhh.mall.member.service.FeightTemplateService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 运费模版
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/feighttemplate")
public class FeightTemplateController {
    @Autowired
    private FeightTemplateService feightTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:feighttemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feightTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:feighttemplate:info")
    public R info(@PathVariable("id") Long id){
		FeightTemplateEntity feightTemplate = feightTemplateService.getById(id);

        return R.ok().put("feightTemplate", feightTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:feighttemplate:save")
    public R save(@RequestBody FeightTemplateEntity feightTemplate){
		feightTemplateService.save(feightTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:feighttemplate:update")
    public R update(@RequestBody FeightTemplateEntity feightTemplate){
		feightTemplateService.updateById(feightTemplate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:feighttemplate:delete")
    public R delete(@RequestBody Long[] ids){
		feightTemplateService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
