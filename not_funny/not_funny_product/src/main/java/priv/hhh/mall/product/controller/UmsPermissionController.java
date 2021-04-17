package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.UmsPermissionEntity;
import priv.hhh.mall.product.service.UmsPermissionService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 后台用户权限表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@RestController
@RequestMapping("product/umspermission")
public class UmsPermissionController {
    @Autowired
    private UmsPermissionService umsPermissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:umspermission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsPermissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:umspermission:info")
    public R info(@PathVariable("id") Long id){
		UmsPermissionEntity umsPermission = umsPermissionService.getById(id);

        return R.ok().put("umsPermission", umsPermission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:umspermission:save")
    public R save(@RequestBody UmsPermissionEntity umsPermission){
		umsPermissionService.save(umsPermission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:umspermission:update")
    public R update(@RequestBody UmsPermissionEntity umsPermission){
		umsPermissionService.updateById(umsPermission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:umspermission:delete")
    public R delete(@RequestBody Long[] ids){
		umsPermissionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
