import {Route} from '@angular/router';
import {HomeComponent} from './components/pages/home/home.component';
import {PostsComponent} from './components/pages/posts/posts.component';
import {PostsShowComponent} from './components/pages/posts/posts-show/posts-show.component';
import {PostsEditComponent} from './components/pages/posts/posts-edit/posts-edit.component';
import {PostsCreateComponent} from './components/pages/posts/posts-create/posts-create.component';

export const routes: Route[] = [
  {path: 'home', component: HomeComponent},
  {path: 'posts', component: PostsComponent},
  {path: 'posts/create', component: PostsCreateComponent},
  {path: 'posts/:id', component: PostsShowComponent},
  {path: 'posts/edit/:id', component: PostsEditComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];
