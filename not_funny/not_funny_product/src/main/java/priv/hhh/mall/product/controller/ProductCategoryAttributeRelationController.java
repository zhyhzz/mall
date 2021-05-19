package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.ProductCategoryAttributeRelationEntity;
import priv.hhh.mall.product.service.ProductCategoryAttributeRelationService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/productcategoryattributerelation")
public class ProductCategoryAttributeRelationController {
    @Autowired
    private ProductCategoryAttributeRelationService productCategoryAttributeRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productcategoryattributerelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productCategoryAttributeRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productcategoryattributerelation:info")
    public R info(@PathVariable("id") Long id){
		ProductCategoryAttributeRelationEntity productCategoryAttributeRelation = productCategoryAttributeRelationService.getById(id);

        return R.ok().put("productCategoryAttributeRelation", productCategoryAttributeRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productcategoryattributerelation:save")
    public R save(@RequestBody ProductCategoryAttributeRelationEntity productCategoryAttributeRelation){
		productCategoryAttributeRelationService.save(productCategoryAttributeRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productcategoryattributerelation:update")
    public R update(@RequestBody ProductCategoryAttributeRelationEntity productCategoryAttributeRelation){
		productCategoryAttributeRelationService.updateById(productCategoryAttributeRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productcategoryattributerelation:delete")
    public R delete(@RequestBody Long[] ids){
		productCategoryAttributeRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
