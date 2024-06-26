import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent implements OnInit{

  check!:boolean;
  EmployeeId!:number;
  employees:any;

  constructor(private service:EmployeeService, private router:Router){}

  ngOnInit(): void {
    this.service.getAll().subscribe(data=>this.employees=data)
  }

  deleteEmployeeById(id:number){
    this.service.deleteById(id).subscribe();
    window.location.reload();
  }

  deleteAllEmployees(){
    this.service.deleteAllEmployees().subscribe();
    window.location.reload();
  }

  downloadReport() {
    this.service.downloadEmployee().subscribe({
      next: (blob) => {
        const a = document.createElement('a');
        const objectUrl = URL.createObjectURL(blob);
        a.href = objectUrl;
        a.download = 'employee_report.pdf';
        a.click();
        URL.revokeObjectURL(objectUrl);
        alert('Download successfull!');
      },
      error: (err) => {
        console.error('Error downloading report:', err);
        alert('Download failed!');
      }
    });
  }

  updateEmployeeById(id: number) {
    this.router.navigate(['/update', id]);
  }

  searchEmployee(EmployeeId: number) {
    this.service.checkEmployee(EmployeeId).subscribe(
      (result) => {
        if (result) {
          this.router.navigate(['/search', EmployeeId]);
        } else {
          alert("Employee not found!");
        }
      }
    );
  }

  
}
