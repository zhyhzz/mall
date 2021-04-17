package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.ProductLadderEntity;
import priv.hhh.mall.product.service.ProductLadderService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 产品阶梯价格表(只针对同商品)
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:50
 */
@RestController
@RequestMapping("product/productladder")
public class ProductLadderController {
    @Autowired
    private ProductLadderService productLadderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productladder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productLadderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productladder:info")
    public R info(@PathVariable("id") Long id){
		ProductLadderEntity productLadder = productLadderService.getById(id);

        return R.ok().put("productLadder", productLadder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productladder:save")
    public R save(@RequestBody ProductLadderEntity productLadder){
		productLadderService.save(productLadder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productladder:update")
    public R update(@RequestBody ProductLadderEntity productLadder){
		productLadderService.updateById(productLadder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productladder:delete")
    public R delete(@RequestBody Long[] ids){
		productLadderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
