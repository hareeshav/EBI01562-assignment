import { Component, OnInit, Inject } from '@angular/core';
import { Router } from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { first } from "rxjs/operators";
import { User } from "../../model/user.model";
import { ApiService } from "../../service/api.service";

@Component({
  selector: 'app-edit-person',
  templateUrl: './edit-person.component.html',
  styleUrls: ['./edit-person.component.css']
})
export class EditPersonComponent implements OnInit {

  user: User;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    let userId = window.localStorage.getItem("editPersonId");
    if (!userId) {
      alert("Invalid action.")
      this.router.navigate(['list-person']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      favColour: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      age: ['', Validators.required],
      hobbies: ['', Validators.required]
    });
    this.apiService.getPersonById(+userId)
      .subscribe(data => {
        this.editForm.setValue(data.result);
      });
  }

  onSubmit() {
    this.apiService.updatePerson(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          if (data.status === 200) {
            alert('User updated successfully.');
            this.router.navigate(['list-person']);
          } else {
            alert(data.message);
          }
        },
        error => {
          alert(error);
        });
  }

}
