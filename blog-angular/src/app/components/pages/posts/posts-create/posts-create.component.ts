import { Component, OnInit } from '@angular/core';
import {PostModel} from '../../../../models/post.model';
import {PostService} from '../../../../services/post.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../../../services/user.service';
import {UserModel} from '../../../../models/user.model';

@Component({
  selector: 'app-posts-create',
  templateUrl: './posts-create.component.html',
  styleUrls: ['./posts-create.component.css']
})
export class PostsCreateComponent implements OnInit {
  post: PostModel;
  CreatForm: FormGroup;
  constructor(
    private postService: PostService,
    private router: Router,
    private fb: FormBuilder,
    private userService: UserService
    ) { }

  ngOnInit() {
    this.loadForm();
  }

  loadForm() {
    this.CreatForm = this.fb.group({
      'title': ['', Validators.required],
      'content': ['', Validators.required],
    });
  }

  onFormSubmit() {
    const title = this.CreatForm.get('title').value;
    const content = this.CreatForm.get('content').value;
    this.userService.getUser(2).subscribe(
      (user: UserModel) => {
        this.post = new PostModel(null, title, content, null, user);
        this.postService.savePost(this.post).subscribe(
          (post: PostModel) => {
            console.log(post);
            this.router.navigate(['/posts/' + post.id]);
          },
          (error) => {
            console.log(error);
          }
        );
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
