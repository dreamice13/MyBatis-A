package tk.mybatis.simple.provider;

import org.apache.ibatis.jdbc.SQL;

public class PrivilegeProvider {
	public String selectById(final Long id) {
		/*return new SQL() {
			{
				SELECT ("id, privilege_name privilegeName, privilege_url privilegeUrl");
				FROM("sys_privilege");
				WHERE("id = #{id}");
			}
		}.toString();*/
		return "select id, privilege_name privilegeName, privilege_url privilegeUrl from sys_privilege where id = #{id}";
	} 
}
