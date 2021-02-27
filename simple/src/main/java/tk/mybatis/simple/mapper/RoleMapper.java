package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import tk.mybatis.simple.model.SysRole;

public interface RoleMapper {
	
	/**
	 * 通过ID查询角色	
	 * @param id
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月21日下午6:29:33
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月21日下午6:29:33
	 * 修改备注: 
	 */
//	@Select(value = { "select id, role_name roleName, enabled, create_by createBy, create_time createTime from sys_role where id = #{id}" })
//	@Select({ "select id, role_name roleName, enabled, create_by createBy, create_time createTime from sys_role where id = #{id}" })
//	@Select("select id, role_name roleName, enabled, create_by createBy, create_time createTime from sys_role where id = #{id}")
	@Select({"select id, role_name roleName, enabled, create_by createBy, create_time createTime", " from sys_role ", "where id = #{id}"})
//	@Select("select * from sys_role where id = #{id}")
	SysRole selectById(Long id);
	
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "roleName", column = "role_name"),
		@Result(property = "enabled", column = "enabled"),
		@Result(property = "createBy", column = "create_by"),
		@Result(property = "createTime", column = "create_time"),
	})
	@Select({"select id, role_name, enabled, create_by, create_time", " from sys_role ", "where id = #{id}"})
	SysRole selectById2(Long id);
	
	@Select("select * from sys_role")
	List<SysRole> selectAll();
	
	/**
	 * 插入角色	
	 * @param sysRole
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年1月23日上午11:19:33
	 * 修改人: Dreamice
	 * 修改时间: 2021年1月23日上午11:19:33
	 * 修改备注: 
	 */
	@Insert({"insert into sys_role(id, role_name, enabled, create_by, create_time) values (#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime})"})
	int insert(SysRole sysRole);
	
	@Insert({"insert into sys_role(role_name, enabled, create_by, create_time) values (#{roleName}, #{enabled}, #{createBy}, #{createTime})"})
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert2(SysRole sysRole);
	
	@Insert({"insert into sys_role(role_name, enabled, create_by, create_time) values (#{roleName}, #{enabled}, #{createBy}, #{createTime})"})
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", before = false, keyProperty = "id", resultType = Long.class)
	int insert3(SysRole sysRole);
	
	@Update({"update sys_role set role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy}, create_time = #{createTime} where id = #{id}"})
	int update(SysRole sysRole);
	
	@Delete("delete from sys_role where id = #{id}")
	int delete(Long id);
	
	/**
	 * 根据用户ID查询用户角色和权限-嵌套查询	
	 * @param user_id
	 * @return
	 * 创建人: Dreamice
	 * 创建时间: 2021年2月27日上午10:34:15
	 * 修改人: Dreamice
	 * 修改时间: 2021年2月27日上午10:34:15
	 * 修改备注: 
	 */
	List<SysRole> selectRoleByUserId(Long user_id);
}
