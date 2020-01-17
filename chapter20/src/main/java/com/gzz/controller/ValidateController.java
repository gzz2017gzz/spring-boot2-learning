package com.gzz.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.groups.Groups;
import com.gzz.pojo.Book;

/**
 * 参数校验
 */

@RestController
public class ValidateController {

	@GetMapping("/insert")
	public String insert(@Validated(value = Groups.Default.class) Book book) {
		return "insert";
	}

	@GetMapping("/update")
	public String update(@Validated(value = { Groups.Default.class, Groups.Update.class }) Book book) {
		return "update";
	}
}
