package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSeriesRepository extends JpaRepository<WebSeries, Integer> {
	WebSeries findByName(String name);
}
