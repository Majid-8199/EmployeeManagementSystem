import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HeaderComponent } from './header/header.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { SearchEmployeeComponent } from './search-employee/search-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    HeaderComponent,
    AddEmployeeComponent,
    UpdateEmployeeComponent,
    SearchEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
