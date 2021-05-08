package priv.hhh.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import priv.hhh.mall.member.entity.AlbumPicEntity;
import priv.hhh.mall.member.service.AlbumPicService;
import priv.hhh.common.utils.PageUtils;
import priv.hhh.common.utils.R;



/**
 * 画册图片表
 *
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@RestController
@RequestMapping("product/albumpic")
public class AlbumPicController {
    @Autowired
    private AlbumPicService albumPicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:albumpic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = albumPicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:albumpic:info")
    public R info(@PathVariable("id") Long id){
		AlbumPicEntity albumPic = albumPicService.getById(id);

        return R.ok().put("albumPic", albumPic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:albumpic:save")
    public R save(@RequestBody AlbumPicEntity albumPic){
		albumPicService.save(albumPic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:albumpic:update")
    public R update(@RequestBody AlbumPicEntity albumPic){
		albumPicService.updateById(albumPic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:albumpic:delete")
    public R delete(@RequestBody Long[] ids){
		albumPicService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
