package com.gzz.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.annotation.DateTime;

/**
 * 参数校验
 */
@Validated
@RestController
public class ValidateController {

	@GetMapping("/test")
	public String test(@DateTime(message = "您输入的格式错误，正确的格式为：{format}", format = "yyyy-MM-dd HH:mm") String date) {
		return "success";
	}

}
