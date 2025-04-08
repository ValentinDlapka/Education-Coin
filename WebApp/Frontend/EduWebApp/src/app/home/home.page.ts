import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: false,
})
export class HomePage {
  username: string = '';
  constructor(private router : Router ) {}

   redirect() {
    if(this.username == "Oppitz") {
      this.router.navigate(['/teacher-dashboard']);
    } else {
      this.router.navigate(['/student-dashboard']);
    }
  }
}
