import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../models/customer.interface';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  _url = 'http://localhost:8081/api/provider/customers';

  constructor(private _http: HttpClient) {}

  getCustomerList() {
    return this._http.get<any>(this._url);
  }

  getCustomerById(customerId: number) {
    return this._http.get<any>(this._url + '/' + customerId);
  }

  createCustomer(customer: Customer) {
    return this._http.post<any>(this._url, customer);
  }

  deleteCustomerById(customerId: number) {
    console.log(this._url + '/' + customerId);
    return this._http.delete<any>(this._url + '/' + customerId);
  }
}
