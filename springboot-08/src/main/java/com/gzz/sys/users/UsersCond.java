package com.gzz.sys.users;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import com.gzz.common.base.BaseCondition;
/**
 * @类说明 [users]查询条件实体
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(id, "AND t.id = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(age, "AND t.age = ?");
    	// add(ids, "AND t.id IN ");
    }
    // 以下为查询条件
	/**
	 * id
	 */
	private Long id;
	/**
	 * name
	 */
	private String name;
	/**
	 * age
	 */
	private Integer age;
	// private List<Long> ids;// 主键列表
	// 以下为自定义查询条件
}