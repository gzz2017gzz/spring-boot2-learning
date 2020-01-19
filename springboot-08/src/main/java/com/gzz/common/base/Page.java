package com.gzz.common.base;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @功能描述:分页工具
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2018-07-13
 */
@Setter
@Getter
@AllArgsConstructor
public class Page<T> {
	private List<T> dataList = new ArrayList<>();// 数据列表
	private int pageSize = 10;// 页大小
	private long rowCount;// 记录数
	private int curpage = 0;// 当前页
	private int pageCount;// 总页数
}
