import {Route} from '@angular/router';
import {HomeComponent} from './components/pages/home/home.component';
import {PostsComponent} from './components/pages/posts/posts.component';
import {PostsShowComponent} from './components/pages/posts/posts-show/posts-show.component';

export const routes: Route[] = [
  {path: 'home', component: HomeComponent},
  {path: 'todos', component: PostsComponent},
  {path: 'posts/:id', component: PostsShowComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];
