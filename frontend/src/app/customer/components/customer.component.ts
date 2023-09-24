import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
})
export class CustomerComponent implements OnInit {
  customerList: any;

  constructor(
    private customerService: CustomerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.customerService
      .getCustomerList()
      .subscribe((data) => (this.customerList = data));
  }

  deleteCustomer(customerId: number) {
    this.customerService.deleteCustomerById(customerId).subscribe(
      (res) => {
        console.log(res);

        console.log(this.customerList);

        console.log(this.customerList);
      },
      (err) => {
        console.log('I am here');
        console.log(this.customerList);
        const index = this.customerList.findIndex((customer: any) => {
          customer.id === customerId;
        });

        this.customerList.splice(index, 1);

        console.error(err);
        console.log('I am end');
        console.log(this.customerList);
      }
    );
  }
}
