import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  public getAll(){
    return this.http.get("http://localhost:8080/employee/viewall");
  }

  public getEmployeeById(id:number){
    return this.http.get('http://localhost:8080/employee/view/'+id);
  }

  public addEmployee(emp:Employee){
    return this.http.post('http://localhost:8080/employee/add',emp);
  }

  public deleteAllEmployees(){
    return this.http.delete('http://localhost:8080/employee/deleteall');
  }

  public deleteById(id:number){
    return this.http.delete('http://localhost:8080/employee/delete/'+id);
  }

  public updateById(id:number, emp:Employee){
    return this.http.put('http://localhost:8080/employee/update/'+id,emp);
  }

  public downloadEmployee(){
    return this.http.get('http://localhost:8080/employee/download',{ responseType: 'blob'});
  }

  public checkEmployee(id:number){
    return this.http.get('http://localhost:8080/employee/check/'+id);
  }
}

