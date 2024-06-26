import { Component, OnInit, ViewChild } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Employee } from '../employee';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent implements OnInit{

  EmployeeId:any;
  emp!:any;

  constructor(private service:EmployeeService,private router:Router, private route: ActivatedRoute){  }
  
  @ViewChild('myform') myform!:NgForm ;

  ngOnInit(): void {
    this.EmployeeId=this.route.snapshot.paramMap.get('id');
    this.emp=this.service.getEmployeeById(this.EmployeeId).subscribe(e=>this.emp=e);
  }

  updateEmployeeById(id: number, emp: Employee){
    if (this.myform.invalid) {
      alert('Please fill out all required fields.');
    }
    else{
      this.service.updateById(id,emp).subscribe(()=>this.router.navigate(['']));
      alert("Employee Updated Successfully!");
    }
  }

  goBack(){
    this.router.navigate([""]);
  }
}

