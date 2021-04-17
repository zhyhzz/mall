package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.UmsResourceCategoryEntity;
import priv.hhh.mall.product.service.UmsResourceCategoryService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 资源分类表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@RestController
@RequestMapping("product/umsresourcecategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService umsResourceCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:umsresourcecategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsResourceCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:umsresourcecategory:info")
    public R info(@PathVariable("id") Long id){
		UmsResourceCategoryEntity umsResourceCategory = umsResourceCategoryService.getById(id);

        return R.ok().put("umsResourceCategory", umsResourceCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:umsresourcecategory:save")
    public R save(@RequestBody UmsResourceCategoryEntity umsResourceCategory){
		umsResourceCategoryService.save(umsResourceCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:umsresourcecategory:update")
    public R update(@RequestBody UmsResourceCategoryEntity umsResourceCategory){
		umsResourceCategoryService.updateById(umsResourceCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:umsresourcecategory:delete")
    public R delete(@RequestBody Long[] ids){
		umsResourceCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
