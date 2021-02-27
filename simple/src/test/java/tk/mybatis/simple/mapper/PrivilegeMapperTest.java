package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest{
	public void testSelectById() {
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			SysPrivilege pri = privilegeMapper.selectById((long) 1);
			Assert.assertNotNull(pri.getPrivilegeName());
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectPrivilegeByRoleId() {
		SqlSession sqlSession = getSqlSession();
		try {
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			List<SysPrivilege> priList = privilegeMapper.selectPrivilegeByRoleId((long) 1);
			Assert.assertTrue(priList.size() > 0);
		} finally {
			sqlSession.close();
		}
	}
}
