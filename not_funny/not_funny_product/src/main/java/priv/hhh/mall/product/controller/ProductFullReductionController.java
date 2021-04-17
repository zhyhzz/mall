package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.ProductFullReductionEntity;
import priv.hhh.mall.product.service.ProductFullReductionService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 产品满减表(只针对同商品)
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:50
 */
@RestController
@RequestMapping("product/productfullreduction")
public class ProductFullReductionController {
    @Autowired
    private ProductFullReductionService productFullReductionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productfullreduction:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productFullReductionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productfullreduction:info")
    public R info(@PathVariable("id") Long id){
		ProductFullReductionEntity productFullReduction = productFullReductionService.getById(id);

        return R.ok().put("productFullReduction", productFullReduction);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productfullreduction:save")
    public R save(@RequestBody ProductFullReductionEntity productFullReduction){
		productFullReductionService.save(productFullReduction);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productfullreduction:update")
    public R update(@RequestBody ProductFullReductionEntity productFullReduction){
		productFullReductionService.updateById(productFullReduction);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productfullreduction:delete")
    public R delete(@RequestBody Long[] ids){
		productFullReductionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
