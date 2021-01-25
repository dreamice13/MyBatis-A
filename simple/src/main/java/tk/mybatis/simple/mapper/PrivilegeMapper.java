package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.provider.PrivilegeProvider;


public interface PrivilegeMapper {
	@SelectProvider(method = "selectById", type = PrivilegeProvider.class)
    SysPrivilege selectById(Long id);
}
