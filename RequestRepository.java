package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Request;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

	//List<Request> findByTime(long time);

	//@Query("FROM request WHERE time+3600000 > :time")
    //List<Request> findRequest(@Param("time")long time);
	
	@Query(value = "SELECT count(distinct user) FROM request  WHERE time >= ?1 or time-3600000 <= ?1", nativeQuery = true)
	int findUserByTime(long time);
	
	@Query(value = "SELECT count(*) FROM request  WHERE (time >= ?1 or time-3600000 > ?1) and event =?2", nativeQuery = true)
	int findClickByTime(long time, String event);
	
	@Query(value = "SELECT count(*) FROM request  WHERE (time >= ?1 or time-3600000 > ?1) and event=?2", nativeQuery = true)
	int findImpressionsByTime(long time, String event);
	
	
}
