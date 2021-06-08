package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserMapper userMapper;

	// 查看所有用户
	@Test
	void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

	// 添加
	@Test
	public void testAdd() {
		User user = new User();
		user.setName("王六");
		user.setAge(20);
		user.setEmail("1243@qq.com");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}

	// 修改
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(1395299376172863490L);
		user.setName("lucymary2");
		int count = userMapper.updateById(user);
		System.out.println(count);
	}

	// 测试乐观锁
	@Test
	public void testOptimisicInsert() {
		// 先根据id查询
		User user = userMapper.selectById(1401731426140463106L);
		// 再修改
		user.setName("新张三");
		// 此时mp会自动将version+1
		userMapper.updateById(user);
	}

	// 多个id批量查询
	@Test
	public void testSelect1() {
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
		System.out.println(users);
	}

	// 简单条件查询
	@Test
	public void testSelect2() {
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("name","Jack");
		columnMap.put("age",20);
		List<User> users = userMapper.selectByMap(columnMap);
		System.out.println(users);
	}

	// 分页查询：selectPage
	@Test
	public void testSelectPage() {
		Page<User> page = new Page(1,3);
		Page<User> userPage = userMapper.selectPage(page, null);
		// 返回对象得到分页所有数据
		long pages = userPage.getPages(); // 总页数
		long current = userPage.getCurrent(); // 当前页
		List<User> records = userPage.getRecords(); // 查询数据集合
		long total = userPage.getTotal(); // 总记录数
		boolean hasNext = userPage.hasNext();  // 下一页
		boolean hasPrevious = userPage.hasPrevious(); // 上一页

		System.out.println(pages);
		System.out.println(current);
		System.out.println(records);
		System.out.println(total);
		System.out.println(hasNext);
		System.out.println(hasPrevious);
	}

	// 分页查询：selectMapsPage
	@Test
	public void testSelectMapsPage() {
		//Page不需要泛型
		Page<Map<String, Object>> page = new Page<>(1, 5);
		Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, null);
		List<Map<String, Object>> records = pageParam.getRecords();
		records.forEach(System.out::println);
		System.out.println(pageParam.getCurrent());
		System.out.println(pageParam.getPages());
		System.out.println(pageParam.getSize());
		System.out.println(pageParam.getTotal());
		System.out.println(pageParam.hasNext());
		System.out.println(pageParam.hasPrevious());
	}

	// 测试删除：id
	@Test
	public void testDeleteById(){
		int result = userMapper.deleteById(5L);
		System.out.println(result);
	}

	// 测试删除：批量deleteBatchIds
	@Test
	public void testDeleteBatchIds() {
		int result = userMapper.deleteBatchIds(Arrays.asList(8, 9, 10));
		System.out.println(result);
	}

	// 测试删除：条件deleteByMap
	@Test
	public void testDeleteByMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Helen");
		map.put("age", 18);
		int result = userMapper.deleteByMap(map);
		System.out.println(result);
	}

	// 测试删除：逻辑删除
	@Test
	public void testDelete2() {
		int result = userMapper.deleteById(1402187049806303233L);
		System.out.println(result);
	}

	// 复杂查询
	@Test
	public void testQuery() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		// 1. ge大于等于、gt大于、le小于等于、lt小于
		queryWrapper.ge("age", 12); // age >= 12

		// 2. isNull、isNotNull
		queryWrapper.isNull("name");

		// 3. eq等于、ne不等于
		queryWrapper.eq("name", "Tom");

		// 4. between字段在范围中
		queryWrapper.between("age", 12, 18);

		// 5. like模糊查询（包含）、notLike不包含、likeLeft、likeRight
		queryWrapper.like("name", "e"); // 等价于select * where name like "%e%"

		// 6. orderByDesc降序排列
		queryWrapper.orderByDesc("id");

		List<User> users = userMapper.selectList(queryWrapper);
		System.out.println("users = " + users);
	}











}
