package com.gzz.sys.blacklist;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
/**
 * @类说明 [blacklist]实体类
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class Blacklist {
    // 以下为数据库中 字段
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
    // 以下为查询显示辅助属性
}