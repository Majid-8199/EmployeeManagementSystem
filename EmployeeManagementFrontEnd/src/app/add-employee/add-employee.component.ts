import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrl: './add-employee.component.css'
})
export class AddEmployeeComponent implements OnInit{
 

    @ViewChild('myform') myform!:NgForm ;
  
    constructor(private service:EmployeeService,private router:Router){
    }
  
    ngOnInit(): void {
    }
  
    addEmployee(emp:Employee){
      if (this.myform.invalid) {
        alert('Please fill out all required fields.');
      }
      else{
        this.service.addEmployee(emp).subscribe();
        this.router.navigate(['']);
        alert("Employee Added Successfully!");
      }
    }
  } 
   