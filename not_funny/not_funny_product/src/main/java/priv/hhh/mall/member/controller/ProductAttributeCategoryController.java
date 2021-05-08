package priv.hhh.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.member.entity.ProductAttributeCategoryEntity;
import priv.hhh.mall.member.service.ProductAttributeCategoryService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 产品属性分类表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/productattributecategory")
public class ProductAttributeCategoryController {
    @Autowired
    private ProductAttributeCategoryService productAttributeCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productattributecategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productAttributeCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productattributecategory:info")
    public R info(@PathVariable("id") Long id){
		ProductAttributeCategoryEntity productAttributeCategory = productAttributeCategoryService.getById(id);

        return R.ok().put("productAttributeCategory", productAttributeCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productattributecategory:save")
    public R save(@RequestBody ProductAttributeCategoryEntity productAttributeCategory){
		productAttributeCategoryService.save(productAttributeCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productattributecategory:update")
    public R update(@RequestBody ProductAttributeCategoryEntity productAttributeCategory){
		productAttributeCategoryService.updateById(productAttributeCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productattributecategory:delete")
    public R delete(@RequestBody Long[] ids){
		productAttributeCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
