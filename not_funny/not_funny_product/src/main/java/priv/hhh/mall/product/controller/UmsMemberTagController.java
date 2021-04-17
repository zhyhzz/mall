package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.UmsMemberTagEntity;
import priv.hhh.mall.product.service.UmsMemberTagService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 用户标签表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@RestController
@RequestMapping("product/umsmembertag")
public class UmsMemberTagController {
    @Autowired
    private UmsMemberTagService umsMemberTagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:umsmembertag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberTagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:umsmembertag:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberTagEntity umsMemberTag = umsMemberTagService.getById(id);

        return R.ok().put("umsMemberTag", umsMemberTag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:umsmembertag:save")
    public R save(@RequestBody UmsMemberTagEntity umsMemberTag){
		umsMemberTagService.save(umsMemberTag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:umsmembertag:update")
    public R update(@RequestBody UmsMemberTagEntity umsMemberTag){
		umsMemberTagService.updateById(umsMemberTag);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:umsmembertag:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberTagService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
