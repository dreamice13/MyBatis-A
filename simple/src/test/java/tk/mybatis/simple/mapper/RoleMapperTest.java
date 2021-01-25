package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;

public class RoleMapperTest extends BaseMapperTest{
	
	@Test
	public void testSelectById() {
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role = roleMapper.selectById((long) 1);
//			SysRole role = roleMapper.selectById2((long) 1);
			Assert.assertNotNull(role);
			Assert.assertEquals("管理员", role.getRoleName());
			
//			List<SysRole> roles = roleMapper.selectAll();
//			Assert.assertNotNull("角色名称为空", roles.get(0).getRoleName());
//			Assert.assertTrue("查询数量为0", roles.size() > 0);
		} finally {
			sqlSession.close();
		}
	}
	
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role =  new SysRole();
			role.setEnabled(1);
			role.setRoleName("新增3");
			role.setCreateBy(1L);
			role.setCreateTime(new Date());
			int count = roleMapper.insert3(role);
			Assert.assertNotNull("count为null", count);
			Assert.assertNotNull(role.getId());
			Assert.assertEquals(1, count);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public void testUpdate() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role =  new SysRole();
			role.setId(6L);
			role.setEnabled(1);
			role.setRoleName("更新1");
			role.setCreateBy(1L);
			role.setCreateTime(new Date());
			int count = roleMapper.update(role);
			Assert.assertNotNull("count为null", count);
			Assert.assertNotNull(role.getId());
			Assert.assertEquals("更新1", role.getRoleName());
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public void testDelete() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			int count = roleMapper.delete(8L);
			Assert.assertNotNull("count为null", count);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
}
