package priv.hhh.mall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 画册图片表
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@Data
@TableName("pms_album_pic")
public class AlbumPicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long albumId;
	/**
	 * 
	 */
	private String pic;

}
