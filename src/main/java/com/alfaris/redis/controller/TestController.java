package com.alfaris.redis.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alfaris.redis.entity.PshSchedulerTest;
import com.alfaris.redis.repository.PshSchedulerTestRepository;

@RestController
@RequestMapping("/api/test")
public class TestController {
	private static Logger logger = LogManager.getLogger(TestController.class);

	@Autowired
	private PshSchedulerTestRepository repository;

	@PostMapping
	public String saveData(@RequestBody PshSchedulerTest entity) {
		try {
			repository.save(entity);
			logger.info("Details Saved....");
			return "success";
		} catch (Exception e) {
			return "failed";
		}

	}

}
