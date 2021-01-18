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
	
	/**
	 * 添加用户	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月18日下午4:57:31
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月18日下午4:57:31
	 * 修改备注: 
	 */
	int insert(SysUser sysUser);
	
	/**
	 * 添加用户-使用userGenerateKeys的方式	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月19日上午11:11:31
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月19日上午11:11:31
	 * 修改备注: 
	 */
	int insert2(SysUser sysUser);
	
	/**
	 * 添加用户-使用selectKey的方式		
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月19日上午11:42:24
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月19日上午11:42:24
	 * 修改备注: 
	 */
	int insert3(SysUser sysUser);
	
	/**
	 * 根据主键更新用户数据	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月19日下午1:44:21
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月19日下午1:44:21
	 * 修改备注: 
	 */
	int updateById(SysUser sysUser);
	
	/**
	 * 根据主键删除用户数据	
	 * @param id
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月19日下午1:59:31
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月19日下午1:59:31
	 * 修改备注: 
	 */
	int deleteById(Long id);
}