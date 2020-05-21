import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HelloWorldMainComponent } from './hello-world-main/hello-world-main.component';
import { TestComponent } from './test/test.component';
import { StarWarsCharactersComponent } from './star-wars-characters/star-wars-characters.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldMainComponent,
    TestComponent,
    StarWarsCharactersComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
