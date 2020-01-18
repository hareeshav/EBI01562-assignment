import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Person } from "../model/person.model";
import { Observable } from "rxjs/index";
import { ApiResponse } from "../model/api.response";

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://hareesh-rest-api.us-east-1.elasticbeanstalk.com/hareesh-demo/persons/';

  login(loginPayload): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://hareesh-rest-api.us-east-1.elasticbeanstalk.com/hareesh-demo/' + 'token/generate-token', loginPayload);
  }

  getPersons(): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl);
  }

  getPersonById(id: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl + id);
  }

  createPerson(person: Person): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, person);
  }

  updatePerson(person: Person): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + person.id, person);
  }

  deletePerson(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
}
