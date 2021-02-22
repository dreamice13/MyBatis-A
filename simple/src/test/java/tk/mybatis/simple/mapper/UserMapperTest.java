package tk.mybatis.simple.mapper;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public void testSelectByIdOrUserName() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setId(1L);
			user.setUserName("admin");
			SysUser queryUser = userMapper.selectByIdOrUserName(user);
			Assert.assertNotNull(queryUser);
			user.setId(null);
			queryUser = userMapper.selectByIdOrUserName(user);
			Assert.assertNotNull(queryUser);
			user.setUserName(null);
			queryUser = userMapper.selectByIdOrUserName(user);
			Assert.assertNull(queryUser);
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectByUserTrim() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 只查询用户名
			SysUser query = new SysUser();
			query.setUserName("ad");
			List<SysUser> userList = userMapper.selectByUserTrim(query);
			Assert.assertTrue(userList.size() > 0 );
			// 只通过邮箱查询
			query = new SysUser();
			query.setUserEmail("test@mybatis");
			userList = userMapper.selectByUserTrim(query);
			Assert.assertTrue(userList.size() > 0 );
			// 用户名邮箱同时查询
			query = new SysUser();
			query.setUserName("ad");
			query.setUserEmail("test@mybatis");
			userList = userMapper.selectByUserTrim(query);
			Assert.assertTrue(userList.size() == 0 );
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectByUserWhere() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 只查询用户名
			SysUser query = new SysUser();
			query.setUserName("ad");
			List<SysUser> userList = userMapper.selectByUserWhere(query);
			Assert.assertTrue(userList.size() > 0 );
			// 只通过邮箱查询
			query = new SysUser();
			query.setUserEmail("test@mybatis");
			userList = userMapper.selectByUserWhere(query);
			Assert.assertTrue(userList.size() > 0 );
			// 用户名邮箱同时查询
			query = new SysUser();
			query.setUserName("ad");
			query.setUserEmail("test@mybatis");
			userList = userMapper.selectByUserWhere(query);
			Assert.assertTrue(userList.size() == 0 );
		}finally {
			sqlSession.close();
		}
	}
	
	
	public void testUpdateByIdSelectiveSet() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 只查询用户名
			SysUser user = new SysUser();
			user.setId(1L);
			user.setUserEmail("test@mybatis.tk");
			int result = userMapper.updateByIdSelectiveSet(user);
			Assert.assertEquals(1, result);
			user = userMapper.selectById(1L);
			Assert.assertEquals("admin", user.getUserName());
			Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	public void testselectByIdList() {
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// list
			List<Long> idList = new ArrayList<>();
			idList.add(1L);
			idList.add(1001L);
			List<SysUser> userList = userMapper.selectByIdList(idList);
			Assert.assertEquals(2, userList.size());
			// array
			Long[] arr = {1L, 1001L};
			List<SysUser> userList1 = userMapper.selectByIdListArray(arr);
			Assert.assertEquals(2, userList1.size());
			// map、多参数
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ids", arr);
			List<SysUser> userList2 = userMapper.selectByIdListMap(map);
			Assert.assertEquals(2, userList2.size());
			
			List<SysUser> userList3 = userMapper.selectByIdListParam(idList);
			Assert.assertEquals(2, userList3.size());
			
		} finally {
			sqlSession.close();
		}
	}
	
	public void testSelectUserByBind() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("tes");
			List<SysUser> list = userMapper.selectUserByBind(sysUser);
			Assert.assertTrue(list.size() > 0);
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectTime() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			String time = userMapper.SelectTime();
			Assert.assertNotNull(time);
			System.out.println(time);
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectUserAndRolesById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser user = userMapper.selectUserAndRolesById(1001L);
//			SysUser user = userMapper.selectUserAndRolesById2(1001L);
//			SysUser user = userMapper.selectUserAndRolesById3(1001L);
			SysUser user = userMapper.selectUserAndRolesByIdSelect(1001L);
			Assert.assertNotNull(user);
			System.out.println("调用user.getRole()");
			Assert.assertNotNull(user.getRole());
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAllUserAndRoles() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAllUserAndRoles();
			System.out.println("用户数" + userList.size());
			for(SysUser user : userList) {
				System.out.println("用户名" + user.getUserName());
				for(SysRole role : user.getRoleList()) {
					System.out.println("角色名" + role.getRoleName());
				}
			}
		}finally {
			sqlSession.close();
		}
	}
}
