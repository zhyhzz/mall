package priv.hhh.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.member.entity.AlbumEntity;
import priv.hhh.mall.member.service.AlbumService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 相册表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:album:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = albumService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:album:info")
    public R info(@PathVariable("id") Long id){
		AlbumEntity album = albumService.getById(id);

        return R.ok().put("album", album);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:album:save")
    public R save(@RequestBody AlbumEntity album){
		albumService.save(album);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:album:update")
    public R update(@RequestBody AlbumEntity album){
		albumService.updateById(album);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:album:delete")
    public R delete(@RequestBody Long[] ids){
		albumService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
