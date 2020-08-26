import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-second-page',
  templateUrl: './second-page.component.html',
  styleUrls: ['./second-page.component.css']
})
export class SecondPageComponent implements OnInit {

  empName = "";
  empGender = "";
  empDesignation = "";
  empPhone = "";
  empId = "";

  constructor(public _router: Router) { 
    console.log(this._router.getCurrentNavigation().extras.state.data);
    this.empName =  this._router.getCurrentNavigation().extras.state.data.empName
    this.empId = this._router.getCurrentNavigation().extras.state.data.empId
    this.empGender = this._router.getCurrentNavigation().extras.state.data.empGender
    this.empDesignation = this._router.getCurrentNavigation().extras.state.data.empDesignation
    this.empPhone = this._router.getCurrentNavigation().extras.state.data.empPhone
  }

  ngOnInit(): void {
  }

}
