package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Request;
import com.example.demo.repository.RequestRepository;

@RestController
public class RequestController {

	@Autowired RequestRepository requestRepository; 
	
	@GetMapping("/analytics")
    public Map<String, Integer> getRequest(@RequestParam(value="timestamp", required=true) long time) {
        //List<Request>  list = requestRepository.findRequest(time);
        
        /*List<Request>  list = requestRepository.findByTime(time);
        
        for(Request r : list) {
        	System.out.println(r.getUser_id() + ":" + r.getTime());
        }
        */
		int distinctuser = requestRepository.findUserByTime(time);
        System.out.println(distinctuser);
        
        int numClick = requestRepository.findClickByTime(time, "click");
        System.out.println(numClick);
        
        int numImpressions = requestRepository.findImpressionsByTime(time, "impressions");
        System.out.println(numImpressions);
        
        Map<String, Integer> map = new HashMap<>();
        
        map.put("user", distinctuser);
        map.put("numClick", numClick);
        map.put("numImpressions", numImpressions);
        
		return map;
    }
	
	@PostMapping("/analytics")
    public void createRequest(@RequestParam(value="timestamp", required=true) long time,
    		@RequestParam(value="user", required=true) int user,
    				@RequestParam(value="event", required=true) String event) {
		System.out.println(time + ":" + user + ":" + event);
		requestRepository.save(new Request(time, user, event));
		System.out.println("saved");
        //return employeeRepository.save(employee);
    }
}
