package com.gzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gzz.async.Task;

import lombok.SneakyThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private Task task;

	@Test
	@SneakyThrows
	public void test() {

		for (int i = 0; i < 100; i++) {
			task.doTaskOne(i);
			task.doTaskTwo(i);
			task.doTaskThree(i);
//
//			if (i == 499) {
//				System.exit(0);
//			}
		}
	}

}
