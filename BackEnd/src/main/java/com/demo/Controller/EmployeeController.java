package com.demo.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.EmployeeEntity;
import com.demo.Exception.IdNotFoundException;
import com.demo.Service.EmployeeService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/viewall")
	public List<EmployeeEntity> getAllEmployees(){
		return service.ViewAll();
	}
	
	@PostMapping("/add")
	public void addEmployees(@RequestBody EmployeeEntity entity){
		service.addEmployee(entity);
	}
	
	@GetMapping("/view/{id}")
	public EmployeeEntity viewById(@PathVariable long id) throws IdNotFoundException {
		return service.viewById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) throws IdNotFoundException {
		service.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateEmploeeById(@PathVariable long id,@RequestBody EmployeeEntity employeeEntity) throws IdNotFoundException {
		service.updateEmploeeById(id, employeeEntity);
	}
	
	@DeleteMapping("/deleteall")
	public void deleteAllEmployee() {
		service.deleteAllEmployee();
	}
	
	@GetMapping("/download")
	public byte[] downloadEmployeesData() throws FileNotFoundException, JRException {
		return service.downloadEmployeesData();
	}
	
	@GetMapping("/check/{id}")
	public Boolean checkEmployee(@PathVariable long id) {
		return service.checkEmployee(id);
	}

}
