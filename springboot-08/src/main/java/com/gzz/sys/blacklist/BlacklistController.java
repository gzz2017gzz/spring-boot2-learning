package com.gzz.sys.blacklist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.base.Page;

/**
 * @类说明 [blacklist]控制器
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@RestController
@RequestMapping("blacklist")
public class BlacklistController {

	@Autowired
	private BlacklistService service; // 注入blacklist数据逻辑层

	/**
	 * @方法说明 新增[blacklist]记录
	 */
	@PostMapping("save")
	public int save(@RequestBody Blacklist blacklist) {
		return service.save(blacklist);
	}

	/**
	 * @方法说明 删除blacklist记录(多条)
	 */
	@DeleteMapping("delete")
	public int delete(Integer ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明 修改blacklist记录
	 */
	@PostMapping("update")
	public int update(@RequestBody Blacklist blacklist) {
		return service.update(blacklist);
	}

	/**
	 * @方法说明 按条件查询分页blacklist列表
	 */
	@PostMapping("queryPage")
	public Page<Blacklist> queryPage(@RequestBody BlacklistCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页blacklist列表
	 */
	@PostMapping("queryList")
	public List<Blacklist> queryList(@RequestBody BlacklistCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明 按主键查单个blacklist记录
	 */
	@PostMapping("findById")
	public Blacklist findById(@RequestParam("id") Integer id) {
		return service.findById(id);
	}

	/**
	 * @方法说明 按条件查询blacklist记录个数
	 */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody BlacklistCond cond) {
		return service.queryCount(cond);
	}
}