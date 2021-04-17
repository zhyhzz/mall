package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.UmsRoleMenuRelationEntity;
import priv.hhh.mall.product.service.UmsRoleMenuRelationService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 后台角色菜单关系表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@RestController
@RequestMapping("product/umsrolemenurelation")
public class UmsRoleMenuRelationController {
    @Autowired
    private UmsRoleMenuRelationService umsRoleMenuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:umsrolemenurelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsRoleMenuRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:umsrolemenurelation:info")
    public R info(@PathVariable("id") Long id){
		UmsRoleMenuRelationEntity umsRoleMenuRelation = umsRoleMenuRelationService.getById(id);

        return R.ok().put("umsRoleMenuRelation", umsRoleMenuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:umsrolemenurelation:save")
    public R save(@RequestBody UmsRoleMenuRelationEntity umsRoleMenuRelation){
		umsRoleMenuRelationService.save(umsRoleMenuRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:umsrolemenurelation:update")
    public R update(@RequestBody UmsRoleMenuRelationEntity umsRoleMenuRelation){
		umsRoleMenuRelationService.updateById(umsRoleMenuRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:umsrolemenurelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsRoleMenuRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
