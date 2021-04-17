package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.ProductAttributeValueEntity;
import priv.hhh.mall.product.service.ProductAttributeValueService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 存储产品参数信息的表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/productattributevalue")
public class ProductAttributeValueController {
    @Autowired
    private ProductAttributeValueService productAttributeValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productattributevalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productAttributeValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productattributevalue:info")
    public R info(@PathVariable("id") Long id){
		ProductAttributeValueEntity productAttributeValue = productAttributeValueService.getById(id);

        return R.ok().put("productAttributeValue", productAttributeValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productattributevalue:save")
    public R save(@RequestBody ProductAttributeValueEntity productAttributeValue){
		productAttributeValueService.save(productAttributeValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productattributevalue:update")
    public R update(@RequestBody ProductAttributeValueEntity productAttributeValue){
		productAttributeValueService.updateById(productAttributeValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productattributevalue:delete")
    public R delete(@RequestBody Long[] ids){
		productAttributeValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
