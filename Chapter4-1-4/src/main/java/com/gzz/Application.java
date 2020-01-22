package com.gzz;

import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.gzz.async.Task;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAsync
@Slf4j
@Configuration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
		executor.setPoolSize(20);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setAwaitTerminationSeconds(60);
		return executor;

	}

	@Autowired
	private Task task;

	@PostConstruct
	@SneakyThrows
	public void test() {

		for (int i = 0; i < 500; i++) {
			task.doTaskOne(i);
			task.doTaskTwo(i);
			task.doTaskThree(i);
 			//log.info(i + "");
			if (i == 499) {
// 				System.exit(0);
			}
			log.info(taskExecutor().toString());
		}
	}
}

/**
 * 说明： setWaitForTasksToCompleteOnShutdown（true）该方法就是这里的关键，
 * 用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean， 这样这些异步任务的销毁就会先于Redis线程池的销毁。
 * 同时，这里还设置了setAwaitTerminationSeconds(60)， 该方法用来设置线程池中任务的等待时间，
 * 如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
 */