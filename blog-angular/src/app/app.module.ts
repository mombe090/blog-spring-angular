import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainHeaderComponent } from './components/squelettes/main-header/main-header.component';
import { FooterComponent } from './components/squelettes/footer/footer.component';
import { SideBarComponent } from './components/squelettes/side-bar/side-bar.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import {routes} from './routes.routes';
import {HttpClientModule} from '@angular/common/http';
import { PostsComponent } from './components/pages/posts/posts.component';
import { PostsShowComponent } from './components/pages/posts/posts-show/posts-show.component';
import { PostsEditComponent } from './components/pages/posts/posts-edit/posts-edit.component';
import { PostsCreateComponent } from './components/pages/posts/posts-create/posts-create.component';

@NgModule({
  declarations: [
    AppComponent,
    MainHeaderComponent,
    FooterComponent,
    SideBarComponent,
    HomeComponent,
    PostsComponent,
    PostsShowComponent,
    PostsEditComponent,
    PostsCreateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
