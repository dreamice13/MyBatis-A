package tk.mybatis.simple.mapper;

import java.util.Date;
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
	
	@Test
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
}
