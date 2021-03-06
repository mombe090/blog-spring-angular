import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {UserModel} from '../models/user.model';
import {HttpClient} from '@angular/common/http';
import {StaticService} from './static.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users = new BehaviorSubject<UserModel[]>(null);
  users$ = this.users.asObservable();

  constructor(
    private http: HttpClient,
    private staticValue: StaticService
  ) { }

  getUsers() {
    this.http.get(this.staticValue.baseUrl + 'users', this.staticValue.httpOptions).subscribe(
      (users: UserModel[]) => {
        this.users.next(users);
      },
      (error) => {
        console.log(error);
      }
    );
    return this.users$;
  }

  getUser(user_id: number) {
   return this.http.get(this.staticValue.baseUrl + 'users/' + user_id, this.staticValue.httpOptions);
  }

  saveUser(user: UserModel) {
    return this.http.post(this.staticValue.baseUrl + 'users',  user, this.staticValue.httpOptions);
  }

  updateUser(user: UserModel) {
    return this.http.put(this.staticValue.baseUrl + 'users/' + user.id,  user, this.staticValue.httpOptions);
  }

  deletUser(user_id: number) {
    return this.http.delete(this.staticValue.baseUrl + 'users/' + user_id,  this.staticValue.httpOptions);
  }
}
