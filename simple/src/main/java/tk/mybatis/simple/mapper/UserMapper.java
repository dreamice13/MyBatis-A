package tk.mybatis.simple.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	 * 修改备注: 无
	 */
	int deleteById(Long id);
	
	/**
	 * 根据用户id和角色enabled获取角色	
	 * @param userId
	 * @param enabled
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月19日下午7:11:54
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月19日下午7:11:54
	 * 修改备注: 
	 */
//	List<SysRole> selectRolesByUserIdAndRoleEnabled(Long userId, Integer enabled);
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);
	
	/**
	 * 根据用户id和角色enabled获取角色--通过map传参	
	 * @param map
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月19日下午7:30:35
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月19日下午7:30:35
	 * 修改备注: 
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(HashMap map);
	
	/**
	 * 根据用户id和角色enabled获取角色--多个参数通过JavaBean的方式	
	 * @param user
	 * @param role
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月20日下午7:49:09
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月20日下午7:49:09
	 * 修改备注: 
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("user") SysUser user, @Param("role") SysRole role);
	
	/**
	 * 根据动态条件查询用户信息	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月26日下午7:21:35
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月26日下午7:21:35
	 * 修改备注: 
	 */
	List<SysUser> selectByUser(SysUser sysUser);
	
	/**
	 * 选择性更新-使用if标签	
	 * @param sysUser
	 * @return
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月30日下午9:04:35
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月30日下午9:04:35
	 * 修改备注: 
	 */
	int updateByIdSelective(SysUser sysUser);
	
	/**
	 * 查询-choose	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月31日上午11:21:45
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月31日上午11:21:45
	 * 修改备注: 
	 */
	SysUser selectByIdOrUserName(SysUser sysUser);
	
	/**
	 * 查询用户信息-trim标签的方式	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月7日下午5:56:02
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月7日下午5:56:02
	 * 修改备注: 
	 */
	List<SysUser> selectByUserTrim(SysUser sysUser);
	
	/**
	 * 查询用户信息-where标签的方式	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月7日下午6:16:21
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月7日下午6:16:21
	 * 修改备注: 
	 */
	List<SysUser> selectByUserWhere(SysUser sysUser);
	
	/**
	 * 选择性更新-使用set、if标签	
	 * @param sysUser
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月8日下午3:27:40
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月8日下午3:27:40
	 * 修改备注: 
	 */
	int updateByIdSelectiveSet(SysUser sysUser);
	
	/**
	 * 通过ID查询用户-使用foreach标签	
	 * @param idList
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月8日下午4:45:44
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月8日下午4:45:44
	 * 修改备注: 
	 */
	List<SysUser> selectByIdList(List<Long> idList);
	List<SysUser> selectByIdListArray(Long[] array);
	List<SysUser> selectByIdListMap(HashMap<String, Object> map);
	List<SysUser> selectByIdListParam(@Param("idParam") List<Long> ids);
	
	/**
	 * 通过名称模糊查询用户-bind	
	 * @param uName
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月10日上午10:55:06
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月10日上午10:55:06
	 * 修改备注: 
	 */
	List<SysUser> selectUserByBind(SysUser sysUser);
	
	String SelectTime();
	
	/**
	 * 根据用户id获取用户信息和角色信息	
	 * @param id
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月18日下午3:52:18
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月18日下午3:52:18
	 * 修改备注:
	 *  selectUserAndRolesById：自动映射
	 *  selectUserAndRolesById2：resultMap配置
	 *  selectUserAndRolesById3：association方式
	 */
	SysUser selectUserAndRolesById(Long id);
	SysUser selectUserAndRolesById2(Long id);
	SysUser selectUserAndRolesById3(Long id);
	SysUser selectUserAndRolesByIdSelect(Long id);
	
	/**
	 * 获取所有用户以及对应的角色	
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月22日上午11:32:41
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月22日上午11:32:41
	 * 修改备注: 
	 */
	List<SysUser> selectAllUserAndRoles();
	
	/**
	 * 获取所有用户以及对应的角色、权限	
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月25日下午7:09:01
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月25日下午7:09:01
	 * 修改备注: 
	 */
	List<SysUser> selectAllUserAndRolesAndPrivilege();
	
	/**
	 * 用户查询-collection嵌套查询	
	 * @param id
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月27日上午11:04:46
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月27日上午11:04:46
	 * 修改备注: 
	 */
	SysUser selectAllUserAndRolesSelect(Long id);
}
