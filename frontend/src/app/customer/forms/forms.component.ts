import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../models/customer.interface';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css'],
})
export class FormsComponent implements OnInit {
  registrationForm: FormGroup = new FormGroup({});

  constructor(
    private formBuilder: FormBuilder,
    private _registrationService: CustomerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      email: [''],
    });
  }

  onSubmit(): void {
    this._registrationService
      .createCustomer(<Customer>this.registrationForm.value)
      .subscribe(
        (res: HttpResponse<any>) => {
          console.log('Response: ', res);
          this.router.navigate(['/customers']);
        },
        (err) => {
          console.error('Error:', err);
        }
      );
  }
}
