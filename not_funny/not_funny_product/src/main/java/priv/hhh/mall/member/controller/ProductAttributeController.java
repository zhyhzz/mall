package priv.hhh.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.member.entity.ProductAttributeEntity;
import priv.hhh.mall.member.service.ProductAttributeService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 商品属性参数表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/productattribute")
public class ProductAttributeController {
    @Autowired
    private ProductAttributeService productAttributeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productattribute:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productAttributeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productattribute:info")
    public R info(@PathVariable("id") Long id){
		ProductAttributeEntity productAttribute = productAttributeService.getById(id);

        return R.ok().put("productAttribute", productAttribute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productattribute:save")
    public R save(@RequestBody ProductAttributeEntity productAttribute){
		productAttributeService.save(productAttribute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productattribute:update")
    public R update(@RequestBody ProductAttributeEntity productAttribute){
		productAttributeService.updateById(productAttribute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productattribute:delete")
    public R delete(@RequestBody Long[] ids){
		productAttributeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
