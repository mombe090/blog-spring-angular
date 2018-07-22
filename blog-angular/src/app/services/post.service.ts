import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Subject} from 'rxjs';
import {PostModel} from '../models/post.model';
import {StaticService} from './static.service';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private posts = new Subject<PostModel[]>();
  public posts_$ = this.posts.asObservable();

  constructor(private http: HttpClient, private staticService: StaticService) {}

  getPosts() {
    this.http.get(this.staticService.baseUrl + 'posts', this.staticService.httpOptions).subscribe(
      (response: PostModel[]) => {
        this.posts.next(response);
      }, (error) => {
        console.log(error);
      }
    );
    return this.posts_$;
  }
}
