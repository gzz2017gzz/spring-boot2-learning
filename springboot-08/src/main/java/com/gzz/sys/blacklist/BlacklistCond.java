package com.gzz.sys.blacklist;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import com.gzz.common.base.BaseCondition;

/**
 * @类说明 [blacklist]查询条件实体
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add(id, "AND t.id = ?");
		add(ip, "AND t.ip LIKE ?", 3);
		add(iptime, "AND t.iptime = ?");
		// add(ids, "AND t.id IN ");
	}

	// 以下为查询条件
	/**
	 * id
	 */
	private Integer id;
	/**
	 * ip
	 */
	private String ip;
	/**
	 * iptime
	 */
	private Date iptime;
	// private List<Long> ids;// 主键列表
	// 以下为自定义查询条件
}