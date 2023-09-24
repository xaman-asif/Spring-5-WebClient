import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './components/customer.component';
import { DetailsComponent } from './details/details.component';
import { FormsComponent } from './forms/forms.component';

const customerRoutes: Routes = [
  {
    path: '',
    component: CustomerComponent,
  },
  {
    path: 'add',
    component: FormsComponent,
  },
  {
    path: ':id',
    component: DetailsComponent,
  },
];

@NgModule({
  declarations: [DetailsComponent, FormsComponent],
  imports: [
    RouterModule.forChild(customerRoutes),
    CommonModule,
    ReactiveFormsModule,
  ],
  exports: [RouterModule],
})
export class CustomerModule {}
