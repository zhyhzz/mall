package priv.hhh.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 后台用户角色和权限关系表
 * 
 * @author electreep
 * @email ${email}
 * @date 2021-04-17 23:09:29
 */
@Data
@TableName("ums_role_permission_relation")
public class UmsRolePermissionRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long roleId;
	/**
	 * 
	 */
	private Long permissionId;

}
