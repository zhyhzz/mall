package priv.hhh.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 后台资源表
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@Data
@TableName("ums_resource")
public class UmsResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 资源名称
	 */
	private String name;
	/**
	 * 资源URL
	 */
	private String url;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 资源分类ID
	 */
	private Long categoryId;

}
