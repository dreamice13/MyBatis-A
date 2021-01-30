package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest {
	
	public void testSelectById() {
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById((long) 1);
			Assert.assertNotNull("用户查询结果为空", user);
			Assert.assertEquals("admin", user.getUserName());
		} finally {
			sqlSession.close();
		}
	}

	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAll();
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size() > 0 );
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectRolesByUserId() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRolesByUserId((long) 1);
			Assert.assertNotNull(roleList);
			Assert.assertTrue(roleList.size() > 0 );
		}finally {
			sqlSession.close();
		}
	}
	
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test1");
			sysUser.setUserPassword("123456");
			sysUser.setUserInfo("测试用户1");
			sysUser.setUserEmail("test@mybatis");
			sysUser.setHeadImg(new byte[] {1,2,3});
			sysUser.setCreateTime(new Date());
			int count = userMapper.insert(sysUser);
			Assert.assertEquals(1, count);
			Assert.assertNull(sysUser.getId());
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test1");
			sysUser.setUserPassword("123456");
			sysUser.setUserInfo("测试用户2");
			sysUser.setUserEmail("test@mybatis");
			sysUser.setHeadImg(new byte[] {1,2,3});
			sysUser.setCreateTime(new Date());
			int count = userMapper.insert2(sysUser);
			Assert.assertEquals(1, count);
			Assert.assertNotNull(sysUser.getId());
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test1");
			sysUser.setUserPassword("123456");
			sysUser.setUserInfo("测试用户3");
			sysUser.setUserEmail("test@mybatis");
			sysUser.setHeadImg(new byte[] {1,2,3});
			sysUser.setCreateTime(new Date());
			int count = userMapper.insert3(sysUser);
			Assert.assertEquals(1, count);
			Assert.assertNotNull(sysUser.getId());
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public void testUpdateById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setId(1005L);
			sysUser.setUserName("test1-update");
			sysUser.setUserPassword("12345678");
			sysUser.setUserInfo("测试用户1-update");
			sysUser.setUserEmail("test-update@mybatis");
			sysUser.setHeadImg(new byte[] {1,2,3});
			sysUser.setCreateTime(new Date());
			int count = userMapper.updateById(sysUser);
			Assert.assertEquals(1, count);
			Assert.assertEquals("test1-update", sysUser.getUserName());
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			int count = userMapper.deleteById(1012L);
			Assert.assertEquals(1, count);
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public void testSelectRolesByUserIdAndRoleEnabled() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 两个参数报错
//			List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled((long) 1, 1);
			// 使用map方式
			HashMap<Object, Object> map = new HashMap<>();
			map.put("userId", "1");
			map.put("enabled", "1");
//			List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(map);
			
			// 使用JavaBean方式
			SysUser user = new SysUser();
			user.setId(1L);
			SysRole role = new SysRole();
			role.setEnabled(1);
			List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(user, role);
			Assert.assertNotNull(roleList);
			Assert.assertTrue(roleList.size() > 0 );
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectByUser() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 只查询用户名
			SysUser query = new SysUser();
			query.setUserName("ad");
			List<SysUser> userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() > 0 );
			// 只通过邮箱查询
			query = new SysUser();
			query.setUserEmail("test@mybatis");
			userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() > 0 );
			// 用户名邮箱同时查询
			query = new SysUser();
			query.setUserName("ad");
			query.setUserEmail("test@mybatis");
			userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() == 0 );
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByIdSelective() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 只查询用户名
			SysUser user = new SysUser();
			user.setId(1L);
			user.setUserEmail("test@mybatis.tk");
			int result = userMapper.updateByIdSelective(user);
			Assert.assertEquals(1, result);
			user = userMapper.selectById(1L);
			Assert.assertEquals("admin", user.getUserName());
			Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
}
