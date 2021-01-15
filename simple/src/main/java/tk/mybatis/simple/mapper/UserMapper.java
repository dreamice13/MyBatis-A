package tk.mybatis.simple.mapper;

import java.util.List;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	
	/**
	 * 通过ID查询用户	
	 * @param id
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月9日下午2:34:58
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月9日下午2:34:58
	 * 修改备注: 
	 */
	SysUser selectById(Long id);
	
	/**
	 * 查询全部用户	
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月9日下午2:36:04
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月9日下午2:36:04
	 * 修改备注: 
	 */
	List<SysUser> selectAll();
	
	/**
	 * 根据用户id获取角色信息	
	 * @param id
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月14日上午10:02:15
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月14日上午10:02:15
	 * 修改备注: 
	 */
	List<SysRole> selectRolesByUserId(Long userId);
}
