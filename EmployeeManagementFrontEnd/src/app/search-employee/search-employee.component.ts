import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrl: './search-employee.component.css'
})
export class SearchEmployeeComponent implements OnInit{

  EmployeeId!:any;
  emp:any;
  constructor(private service:EmployeeService,private router:Router,private route:ActivatedRoute){ }
  ngOnInit(): void {
    this.EmployeeId=this.route.snapshot.paramMap.get('id');
    this.service.getEmployeeById(this.EmployeeId).subscribe(e=>this.emp=e);
  }

  searchEmployee(id: number) {
    this.service.checkEmployee(id).subscribe(
      (result) => {
        if (result) {
          this.service.getEmployeeById(id).subscribe(e=>this.emp=e);
        } else {
          alert("Employee not found!");
        }
      }
    );
  }

  deleteEmployee(id:number){
    this.service.deleteById(id).subscribe(()=>this.router.navigate(['']));
  }
  
  updateEmployee(id:number){
    this.router.navigate(['/update',id]).then(()=>window.location.reload())
  }

}
