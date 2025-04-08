import { Component, OnInit } from '@angular/core';
import {ModalController} from "@ionic/angular";
import {Reward} from "../../../Model";

@Component({
  selector: 'app-reward-modal',
  templateUrl: './reward-modal.component.html',
  styleUrls: ['./reward-modal.component.scss'],
  standalone: false
})
export class RewardModalComponent  implements OnInit {
  availableRewards = [
    { name: 'Free Coffee', tokens: 10 },
    { name: 'Extra Recess', tokens: 20 },
    { name: 'Gift Card', tokens: 50 },
  ];
  transactionHistory:any = [];

  constructor(private modalController: ModalController) { }

  ngOnInit() {}
  dismiss() {
    this.modalController.dismiss();
  }

  // Methode, die aufgerufen wird, wenn eine Belohnung ausgewählt wird
  closeModal() {
    this.modalController.dismiss();
  }
  redeemReward(reward:Reward) {
    const transaction = {
      type: 'redeem',
      rewardName: reward.name,
      price: reward.tokens,
      date: new Date().toLocaleString(),
    };
    this.modalController.dismiss(transaction);
  }
}
