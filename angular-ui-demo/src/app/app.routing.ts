import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from "./login/login.component";
import { AddPersonComponent } from "./person/add-person/add-person.component";
import { ListPersonComponent } from "./person/list-person/list-person.component";
import { EditPersonComponent } from "./person/edit-person/edit-person.component";
import { AuthGuard } from './core/auth.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'add-person', component: AddPersonComponent, canActivate: [AuthGuard] },
  { path: 'list-person', component: ListPersonComponent, canActivate: [AuthGuard] },
  { path: 'edit-person', component: EditPersonComponent, canActivate: [AuthGuard] },
  { path: '', component: LoginComponent }
];

export const routing = RouterModule.forRoot(routes);
