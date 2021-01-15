package tk.mybatis.simple.model;

public class SysRolePrivilege {
    private Long RoleId;
    private Long PrivilegeId;
	public Long getRoleId() {
		return RoleId;
	}
	public void setRoleId(Long roleId) {
		RoleId = roleId;
	}
	public Long getPrivilegeId() {
		return PrivilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		PrivilegeId = privilegeId;
	}
}
