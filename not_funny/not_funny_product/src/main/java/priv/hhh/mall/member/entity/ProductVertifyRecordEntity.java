package priv.hhh.mall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品审核记录
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:37:51
 */
@Data
@TableName("pms_product_vertify_record")
public class ProductVertifyRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long productId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 审核人
	 */
	private String vertifyMan;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 反馈详情
	 */
	private String detail;

}
