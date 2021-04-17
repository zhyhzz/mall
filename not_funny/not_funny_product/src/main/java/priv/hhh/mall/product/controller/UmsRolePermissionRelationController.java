package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.UmsRolePermissionRelationEntity;
import priv.hhh.mall.product.service.UmsRolePermissionRelationService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 后台用户角色和权限关系表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@RestController
@RequestMapping("product/umsrolepermissionrelation")
public class UmsRolePermissionRelationController {
    @Autowired
    private UmsRolePermissionRelationService umsRolePermissionRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:umsrolepermissionrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsRolePermissionRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:umsrolepermissionrelation:info")
    public R info(@PathVariable("id") Long id){
		UmsRolePermissionRelationEntity umsRolePermissionRelation = umsRolePermissionRelationService.getById(id);

        return R.ok().put("umsRolePermissionRelation", umsRolePermissionRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:umsrolepermissionrelation:save")
    public R save(@RequestBody UmsRolePermissionRelationEntity umsRolePermissionRelation){
		umsRolePermissionRelationService.save(umsRolePermissionRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:umsrolepermissionrelation:update")
    public R update(@RequestBody UmsRolePermissionRelationEntity umsRolePermissionRelation){
		umsRolePermissionRelationService.updateById(umsRolePermissionRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:umsrolepermissionrelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsRolePermissionRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
