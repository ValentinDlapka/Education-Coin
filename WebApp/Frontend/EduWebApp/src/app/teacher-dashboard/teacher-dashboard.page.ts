import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-teacher-dashboard',
  templateUrl: './teacher-dashboard.page.html',
  styleUrls: ['./teacher-dashboard.page.scss'],
  standalone: false
})
export class TeacherDashboardPage implements OnInit {

  constructor(private router : Router,) { }

  ngOnInit() {
  }
  students = [
    { name: 'Max Mustermann', class: '1BHIF' },
    { name: 'Valentin Dlapka', class: '5BHIF' },
    { name: 'Philipp Kunnert', class: '5BHIF' },
    {name: 'Stefan Peitl', class: '4BHIF' },
    {name: 'Dominik Haider', class: '2CHIF' },
  ];

  selectedStudent: any = null;
  testName: string = '';
  tokenAmount: number = 0;

  selectStudent(student: any) {
    this.selectedStudent = student;
    this.testName = '';
    this.tokenAmount = 0;
  }

  sendTokens() {
    if (!this.testName || !this.tokenAmount || this.tokenAmount <= 0) {
      alert('Bitte gib einen gültigen Testnamen und Token-Wert ein.');
      return;
    }

    // Später hier Backend-Anbindung oder Weiterleitung
    console.log(`Vergeben: ${this.tokenAmount} Tokens an ${this.selectedStudent.name} für ${this.testName}`);

    // Reset
    this.selectedStudent = null;
  }

  logout() {
    this.router.navigate(['home']);
  }
}
