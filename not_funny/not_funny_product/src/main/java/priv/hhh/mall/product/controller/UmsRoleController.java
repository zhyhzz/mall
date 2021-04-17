package priv.hhh.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.product.entity.UmsRoleEntity;
import priv.hhh.mall.product.service.UmsRoleService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 后台用户角色表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@RestController
@RequestMapping("product/umsrole")
public class UmsRoleController {
    @Autowired
    private UmsRoleService umsRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:umsrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:umsrole:info")
    public R info(@PathVariable("id") Long id){
		UmsRoleEntity umsRole = umsRoleService.getById(id);

        return R.ok().put("umsRole", umsRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:umsrole:save")
    public R save(@RequestBody UmsRoleEntity umsRole){
		umsRoleService.save(umsRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:umsrole:update")
    public R update(@RequestBody UmsRoleEntity umsRole){
		umsRoleService.updateById(umsRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:umsrole:delete")
    public R delete(@RequestBody Long[] ids){
		umsRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
