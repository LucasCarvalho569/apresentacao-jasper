import { ClienteService } from './service/Cliente.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgModel, FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule
  ],
  providers: [
    ClienteService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
