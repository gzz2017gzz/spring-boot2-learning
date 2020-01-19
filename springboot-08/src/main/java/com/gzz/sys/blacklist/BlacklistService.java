package com.gzz.sys.blacklist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 [blacklist]业务逻辑层
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Service
 
public class BlacklistService {

	@Autowired
	private BlacklistDao dao; // 注入blacklist数据访问层

	/**
	 * @方法说明 新增[blacklist]记录
	 */
	// @Transactional
	public int save(Blacklist blacklist) {
		return dao.save(blacklist);
	}

	/**
	 * @方法说明 删除blacklist记录(多条)
	 */
	public int delete(Integer ids[]) {
		// return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);// 物理删除
	}

	/**
	 * @方法说明 更新blacklist记录
	 */
	// @Transactional
	public int update(Blacklist blacklist) {
		return dao.update(blacklist);
	}

	/**
	 * @方法说明 按条件查询分页blacklist列表
	 */
	public Page<Blacklist> queryPage(BlacklistCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页blacklist列表
	 */
	public List<Blacklist> queryList(BlacklistCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个blacklist记录
	 */
	public Blacklist findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询blacklist记录个数
	 */
	public long queryCount(BlacklistCond cond) {
		return dao.queryCount(cond);
	}
}