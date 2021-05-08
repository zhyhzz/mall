package priv.hhh.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.member.entity.SkuStockEntity;
import priv.hhh.mall.member.service.SkuStockService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * sku的库存
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/skustock")
public class SkuStockController {
    @Autowired
    private SkuStockService skuStockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skustock:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuStockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skustock:info")
    public R info(@PathVariable("id") Long id){
		SkuStockEntity skuStock = skuStockService.getById(id);

        return R.ok().put("skuStock", skuStock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skustock:save")
    public R save(@RequestBody SkuStockEntity skuStock){
		skuStockService.save(skuStock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:skustock:update")
    public R update(@RequestBody SkuStockEntity skuStock){
		skuStockService.updateById(skuStock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skustock:delete")
    public R delete(@RequestBody Long[] ids){
		skuStockService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
