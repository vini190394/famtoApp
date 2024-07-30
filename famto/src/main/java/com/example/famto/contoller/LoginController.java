package com.example.famto.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.famto.entity.Login;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.LoginRepository;

@RestController
@RequestMapping("/api/logins")

public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;

	// get all logins
	@GetMapping
	public List<Login> getAllLogins() {
		return this.loginRepository.findAll();
		
	}

	// get login by id
	@GetMapping("/{loginId}")
	public Login getLoginById(@PathVariable (value = "loginId") long loginId) {
		return this.loginRepository.findById(loginId).orElseThrow(() -> new ResourceNotFoundException("User not found with loginId :" + loginId));
	}

	// create login
	@PostMapping
	
	public Login createLogin(@RequestBody Login login) {	
		
		return this.loginRepository.save(login);
	
	}
	
	// update login
	@PutMapping("/{loginId}")
	public Login updateLogin(@RequestBody Login login, @PathVariable ("loginId") long loginId) {
		 Login existingLogin = this.loginRepository.findById(loginId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with loginId :" + loginId));
		 if (login.getPhoneNumber() != null) {existingLogin.setPhoneNumber(login.getPhoneNumber());}
		 if (login.getName() != null) {existingLogin.setName(login.getName());}
		 if (login.getAddress() != null) {existingLogin.setAddress(login.getAddress());}
		 return this.loginRepository.save(existingLogin);
	}
	
	// delete login by id
	@DeleteMapping("/{loginId}")
	public ResponseEntity<Login> deleteLogin(@PathVariable ("loginId") long loginId){
		 Login existingLogin = this.loginRepository.findById(loginId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with loginId :" + loginId));
		 this.loginRepository.delete(existingLogin);
		 return ResponseEntity.ok().build();
	}

}
