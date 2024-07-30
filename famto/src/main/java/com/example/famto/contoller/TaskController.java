package com.example.famto.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.famto.entity.Order;
import com.example.famto.entity.TaskModel;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.TaskRepo;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskRepo taskRepository;
	
	// create order
	@PostMapping
	public TaskModel createTask(@RequestBody TaskModel task) {
		return this.taskRepository.save(task);
	}
	
	// get all orders
	@GetMapping
	public List<TaskModel> getAllOrders() {
		return this.taskRepository.findAll();
	}

	// get order by id
	@GetMapping("/{newId}")
	public TaskModel getOrderById(@PathVariable (value = "newId") Integer newId) {
		return this.taskRepository.findById(newId).orElseThrow(() -> new ResourceNotFoundException("Order not found with newId :" + newId));
	}
	

}
