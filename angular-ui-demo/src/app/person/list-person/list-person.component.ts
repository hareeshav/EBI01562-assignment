import { Component, OnInit, Inject } from '@angular/core';
import { Router } from "@angular/router";
import { Person } from "../../model/person.model";
import { ApiService } from "../../service/api.service";

@Component({
  selector: 'app-list-person',
  templateUrl: './list-person.component.html',
  styleUrls: ['./list-person.component.css']
})
export class ListPersonComponent implements OnInit {

  persons: Person[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    if (!window.localStorage.getItem('token')) {
      this.router.navigate(['login']);
      return;
    }
    this.apiService.getPersons()
      .subscribe(data => {
        this.persons = data.result;
      });
  }

  deletePerson(person: Person): void {
    this.apiService.deletePerson(person.id)
      .subscribe(data => {
        this.persons = this.persons.filter(u => u !== person);
      })
  };

  editPerson(person: Person): void {
    window.localStorage.removeItem("editPersonId");
    window.localStorage.setItem("editPersonId", person.id.toString());
    this.router.navigate(['edit-person']);
  };

  addPerson(): void {
    this.router.navigate(['add-person']);
  };
}
