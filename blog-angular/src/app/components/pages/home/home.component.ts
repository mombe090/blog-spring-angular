import {AfterViewInit, Component, OnInit} from '@angular/core';
import {PostService} from '../../../services/post.service';
import {PostModel} from '../../../models/post.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, AfterViewInit {
  posts: PostModel[] = [];
  constructor(private postService: PostService) { }

  ngOnInit() {
    this.postService.getPosts();
  }

  ngAfterViewInit(): void {
    this.postService.posts_$.subscribe(
      (posts: PostModel[]) => {
        this.posts = posts;
      }
    );
  }

  onShowComments() {

  }
}
