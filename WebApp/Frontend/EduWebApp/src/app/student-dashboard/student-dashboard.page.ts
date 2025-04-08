import { Component, OnInit } from '@angular/core';
import {ModalController} from "@ionic/angular";
import {RewardModalComponent} from "../reward-modal/reward-modal.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.page.html',
  styleUrls: ['./student-dashboard.page.scss'],
  standalone: false
})
export class StudentDashboardPage implements OnInit {
  redeemRewardList = false;
  selectedReward: string | null = null;
  userTokens = 200;
  transactionHistory: any[] = [
    {
      type: 'earn',
      rewardName: 'Testnote 1.0 – Mathe',
      price: 200,
      date: new Date().toLocaleString()
    },
    {
      type: 'redeem',
      rewardName: 'Free Coffee',
      price: 10,
      date: '08.04.2025, 09:15:06'
    },
    {
      type: 'redeem',
      rewardName: 'Gift Card',
      price: 50,
      date: '05.04.2025, 11:30:42'
    }
  ];


  constructor(private modalController: ModalController, private router: Router) { }

  ngOnInit() {
  }


  // Toggle method to show/hide the reward list
  toggleRewardList() {
    this.redeemRewardList = !this.redeemRewardList;
  }

  selectReward(reward: string) {
    this.selectedReward = reward;
    console.log(`Selected Reward: ${reward}`);
    this.toggleRewardList(); // Close modal after selection
  }

  async openRewardModal() {
    const modal = await this.modalController.create({
      component: RewardModalComponent,
    });

    await modal.present();

    const { data } = await modal.onDidDismiss();

    if (data) {
      // Tokens abziehen
      this.userTokens -= data.price;

      // Transaktion speichern
      this.transactionHistory.unshift(data);
    }
  }

  logout() {
    this.router.navigate(['home']);
  }
}
