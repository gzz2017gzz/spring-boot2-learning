package com.gzz.sys.users;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
/**
 * @类说明 [users]实体类
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    // 以下为数据库中 字段
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
    // 以下为查询显示辅助属性
}