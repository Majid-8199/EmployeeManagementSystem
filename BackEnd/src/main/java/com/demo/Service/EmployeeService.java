package com.demo.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.demo.Entity.EmployeeEntity;
import com.demo.Exception.IdNotFoundException;
import com.demo.Repo.EmployeeRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
 	public List<EmployeeEntity> ViewAll(){
		return repo.findAll();
	}
 	
 	public EmployeeEntity viewById(long id) throws IdNotFoundException {
 		Optional<EmployeeEntity> employee=repo.findById(id);
 		if(employee.isPresent()) {
 			return employee.get();
 		}
 		else {
 			throw new IdNotFoundException("Id: "+id+" not found");
 		}
 	}
 	
 	public void addEmployee(EmployeeEntity employeeEntity) {
 		repo.save(employeeEntity);
 	}
 	
 	public void deleteAllEmployee() {
 		repo.deleteAll();
 	}
 	
 	public void deleteById(long id) throws IdNotFoundException {
 		Optional<EmployeeEntity> employee=repo.findById(id);
 		if(employee.isPresent()) {
 			repo.deleteById(id);
 		}
 		else {
 			throw new IdNotFoundException("Id: "+id+" not found");
 		}
 	}
 	
 	public void updateEmploeeById(long Id, EmployeeEntity employeeEntity) throws IdNotFoundException {
 		Optional<EmployeeEntity> employee=repo.findById(Id);
 		if(employee.isPresent()) {
 			EmployeeEntity e=employee.get();
 			e.setFirstname(employeeEntity.getFirstname());
 			e.setLastname(employeeEntity.getLastname());
 			e.setEmail(employeeEntity.getEmail());
 			e.setPh(employeeEntity.getPh());
 			e.setJobrole(employeeEntity.getJobrole());
 			e.setSalary(employeeEntity.getSalary());
 			repo.save(e);
 		}
 		else {
 			throw new IdNotFoundException("Id:"+Id+" not found!");
 		}
 	}
 	
 	public byte[] downloadEmployeesData() throws FileNotFoundException, JRException {
 		List<EmployeeEntity> employee=repo.findAll();
 		File file=ResourceUtils.getFile("classpath:employee.jrxml");
 		JasperReport js=JasperCompileManager.compileReport(file.getAbsolutePath());
 		JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(employee);
 		JasperPrint jp=JasperFillManager.fillReport(js, null, datasource);
 		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
 		JasperExportManager.exportReportToPdfStream(jp, outputStream);
 		return outputStream.toByteArray();
 	}
 	
 	public Boolean checkEmployee(long id) {
 		Optional<EmployeeEntity> employee=repo.findById(id);
 		if(employee.isPresent()) {
 			return true;
 		}
 		else {
 			return false;
 		}
 	}
}
