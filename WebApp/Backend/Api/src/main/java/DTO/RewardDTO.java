package DTO;

import java.math.BigInteger;

public class RewardDTO {
    public Long amount;
    public String test;
    public String grade;

    public RewardDTO(Long amount, String test, String grade) {
        this.amount = amount;
        this.test = test;
        this.grade = grade;
    }
    public RewardDTO() {}

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
