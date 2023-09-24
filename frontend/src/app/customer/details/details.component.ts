import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../models/customer.interface';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  customerId: number | null = null;
  customer: Customer | null = null;

  constructor(
    private route: ActivatedRoute,
    private customerService: CustomerService
  ) {}
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.customerId = Number(params.get('id'));

      this.customerService.getCustomerById(this.customerId).subscribe((res) => {
        this.customer = <Customer>res;
      });
    });
  }
}
