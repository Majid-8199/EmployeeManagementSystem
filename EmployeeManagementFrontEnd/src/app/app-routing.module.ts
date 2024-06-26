import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { SearchEmployeeComponent } from './search-employee/search-employee.component';

const routes: Routes = [
  {path:'',component:EmployeeListComponent},
  {path:'add',component:AddEmployeeComponent},
  {path:'update/:id',component:UpdateEmployeeComponent},
  {path:'search/:id',component:SearchEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
