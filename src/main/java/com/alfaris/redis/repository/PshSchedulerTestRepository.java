package com.alfaris.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfaris.redis.entity.PshSchedulerTest;

public interface PshSchedulerTestRepository extends JpaRepository<PshSchedulerTest, String> {

	PshSchedulerTest findByStatus(String string);
}