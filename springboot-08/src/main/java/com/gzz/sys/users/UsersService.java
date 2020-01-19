package com.gzz.sys.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 [users]业务逻辑层
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Service
public class UsersService {

	@Autowired
	private UsersDao dao; // 注入users数据访问层

	/**
	 * @方法说明 新增[users]记录
	 */
	// @Transactional
	public int save(Users users) {
		return dao.save(users);
	}

	/**
	 * @方法说明 删除users记录(多条)
	 */
	public int delete(Long ids[]) {
		// return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);// 物理删除
	}

	/**
	 * @方法说明 更新users记录
	 */
	// @Transactional
	public int update(Users users) {
		return dao.update(users);
	}

	/**
	 * @方法说明 按条件查询分页users列表
	 */
	public Page<Users> queryPage(UsersCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页users列表
	 */
	public List<Users> queryList(UsersCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个users记录
	 */
	public Users findById(Long id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询users记录个数
	 */
	public long queryCount(UsersCond cond) {
		return dao.queryCount(cond);
	}
}