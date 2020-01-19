package com.gzz.sys.users;
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
 * @类说明 [users]控制器
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@RestController
@RequestMapping("users")
public class UsersController {
 
	@Autowired
	private UsersService service; //注入users数据逻辑层

    /**
     * @方法说明  新增[users]记录
     */
	@PostMapping("save")
	public int save(@RequestBody Users users) {
		return service.save(users);
	}

    /**
     * @方法说明 删除users记录(多条)
     */
	@DeleteMapping("delete")
	public int delete( Long ids[]) {
		return service.delete(ids);
	}

    /**
     * @方法说明 修改users记录
     */
	@PostMapping("update")
	public int update(@RequestBody Users users) {
		return service.update(users);
	}

    /**
     * @方法说明 按条件查询分页users列表
     */
	@PostMapping("queryPage")
	public Page<Users> queryPage(@RequestBody UsersCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页users列表
     */
	@PostMapping("queryList")
	public List<Users> queryList(@RequestBody UsersCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个users记录
     */
	@PostMapping("findById")
	public Users findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询users记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody UsersCond cond ){
		return service.queryCount(cond);
	}
}