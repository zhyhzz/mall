package priv.hhh.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 相册表
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@Data
@TableName("pms_album")
public class AlbumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String coverPic;
	/**
	 * 
	 */
	private Integer picCount;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private String description;

}
