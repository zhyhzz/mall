package priv.hhh.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.member.entity.ProductCategoryEntity;
import priv.hhh.mall.member.service.ProductCategoryService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 产品分类
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/productcategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productcategory:info")
    public R info(@PathVariable("id") Long id){
		ProductCategoryEntity productCategory = productCategoryService.getById(id);

        return R.ok().put("productCategory", productCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productcategory:save")
    public R save(@RequestBody ProductCategoryEntity productCategory){
		productCategoryService.save(productCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productcategory:update")
    public R update(@RequestBody ProductCategoryEntity productCategory){
		productCategoryService.updateById(productCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productcategory:delete")
    public R delete(@RequestBody Long[] ids){
		productCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
