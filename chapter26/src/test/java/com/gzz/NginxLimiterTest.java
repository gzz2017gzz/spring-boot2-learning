package com.gzz;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NginxLimiterTest {
	ExecutorService service = Executors.newFixedThreadPool(5);

	@Test
	public void main() throws ExecutionException, InterruptedException {
		for (int i = 0; i < 6; i++) {
			CompletableFuture.supplyAsync(() -> {
				final ResponseEntity<String> entity = new RestTemplate().getForEntity("http://192.168.0.133:70/index", String.class);
				return entity.getBody();
			}, service).thenAccept(System.out::println);
		}
		service.shutdown();
	}
}
