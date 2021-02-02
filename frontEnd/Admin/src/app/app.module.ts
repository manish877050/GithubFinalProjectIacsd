import { CategoryService } from './category.service';
import { BrandService } from './brand.service';
import { ProductService } from './product.service';
import { OrdersService } from './orders.service';
import { UserServiceService } from './user-service.service';
import { AdminService } from './admin.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserListComponent } from './user-list/user-list.component';
import { ProductListComponent } from './product-list/product-list.component';
import { OrdersListComponent } from './orders-list/orders-list.component';

import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule } from '@angular/common/http';
import { AddProductComponent } from './add-product/add-product.component';
import { BrandComponent } from './brand/brand.component';
import { UploadImageComponent } from './upload-image/upload-image.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DashboardComponent,
    UserListComponent,
    ProductListComponent,
    OrdersListComponent,
    LoginComponent,
    SignupComponent,
    AddProductComponent,
    BrandComponent,
    UploadImageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AdminService,
   UserServiceService,
   ProductService,
   OrdersService ,
   BrandService,
   CategoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
