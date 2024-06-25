package com.alfaris.redis.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alfaris.redis.entity.PshSchedulerTest;
import com.alfaris.redis.repository.PshSchedulerTestRepository;

@Component
public class RedisSchedulerJob {

	@Autowired
	private RedissonClient redissonClient;

	private static Logger logger = LogManager.getLogger(RedisSchedulerJob.class);

	@Autowired
	private PshSchedulerTestRepository repository;

	@Scheduled(fixedDelay = 3000)
	public void processJob() {
		String lockKey = "jobLock";

		// Acquire the lock
		RLock lock = redissonClient.getLock(lockKey);
		try {
			if (lock.tryLock()) {
				try {
					PshSchedulerTest recordToProcess = repository.findByStatus("reload");
					if (recordToProcess != null) {
						logger.info("Found record to process: " + recordToProcess);
						recordToProcess.setStatus("processed");
						repository.save(recordToProcess);
						logger.info("Job executed successfully.......");
					} else {
						System.out.println("No record found");
					}
				} finally {
					lock.unlock();
				}
			} else {
				// Lock acquisition failed, another instance is already processing
				logger.info(
						"##################Failed to acquire lock, another instance is already processing##################");
			}
		} catch (Exception e) {
			logger.info("Exception occurred: " + e.getMessage());
		}
	}
}
