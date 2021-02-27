package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.provider.PrivilegeProvider;


public interface PrivilegeMapper {
	@SelectProvider(method = "selectById", type = PrivilegeProvider.class)
    SysPrivilege selectById(Long id);
	
	/**
	 * 根据角色ID查询角色权限	
	 * @param roleId
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月27日上午10:11:14
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月27日上午10:11:14
	 * 修改备注: 
	 */
	List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}
