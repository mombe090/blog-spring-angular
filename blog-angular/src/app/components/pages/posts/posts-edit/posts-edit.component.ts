import {AfterViewInit, Component, OnInit} from '@angular/core';
import {PostService} from '../../../../services/post.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PostModel} from '../../../../models/post.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-posts-edit',
  templateUrl: './posts-edit.component.html',
  styleUrls: ['./posts-edit.component.css']
})
export class PostsEditComponent implements OnInit, AfterViewInit {
  post: PostModel = new PostModel(0, '', '');
  EditForm: FormGroup;
  constructor(
    private postService: PostService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder
    ) { }

  ngOnInit() {

    const id = this.activatedRoute.snapshot.params.id;
    this.postService.getPost(id).subscribe(
      (post: PostModel) => {
        this.post = post;
        this.loadForm();
      }, (error) => {
        console.log(error);
      }
    );
    this.loadForm();
  }

  ngAfterViewInit(): void {

  }

  loadForm() {
    this.EditForm = this.fb.group({
      'title': [this.post.title, Validators.required],
      'content': [this.post.content, Validators.required]
    });
  }

  onFormSubmit() {
    const title = this.EditForm.get('title').value;
    const content = this.EditForm.get('content').value;

    this.post.title = title;
    this.post.content = content;

    this.postService.updatePost(this.post).subscribe(
      (post: PostModel) => {
        this.router.navigate(['/posts/' + post.id]);
      }, (error) => {
        console.log(error);
      }
    );
  }


}
