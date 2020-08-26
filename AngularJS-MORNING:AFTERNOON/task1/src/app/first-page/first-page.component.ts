import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent implements OnInit {

  constructor(private _router: Router) { }

  get empName() {
    return this.empFormGroup.get('empName');
  }

  get empId() {
    return this.empFormGroup.get('empId');
  }

  get empGender(){
    return this.empFormGroup.get('empGender');
  }

  get empDesignation(){
    return this.empFormGroup.get('empDesignation');
  }

  get empPhone(){
    return this.empFormGroup.get('empPhone');
  }

  empFormGroup = new FormGroup({
    empName: new FormControl("",[Validators.required,Validators.minLength(3)]),
    empId: new FormControl("",[Validators.required,Validators.pattern("^[0-9]*$")]),
    empGender: new FormControl("",[Validators.required,Validators.pattern("^[f|F|m|M]?e?[m|M]ale$")]),
    empDesignation: new FormControl("",[Validators.required,Validators.minLength(2)]),
    empPhone: new FormControl("",[Validators.required,Validators.minLength(10),Validators.maxLength(10),Validators.pattern("^[0-9]*$")])
  });

  submitData() {
    if(this.empFormGroup.valid){
      this._router.navigateByUrl('/secondPageComponent', { state: { data: this.empFormGroup.value } });
    }
    else{
      alert("Some input fields still have errors. Please clear them and re-submit.")
    }
  }

  ngOnInit(): void {
  }

}
