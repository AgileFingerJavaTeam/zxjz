package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public class SettlementAddFunctionDto {

     private int user_id;
     private int withdrawal_serial_number;
     private int classification_of_settlement_expenses;
     private double settlement_amount;
     private String settlement_time;
     private String instructions ;
     private int employees_id;

    public String getSettlement_time() {
        return settlement_time;
    }

    public void setSettlement_time(String settlement_time) {
        this.settlement_time = settlement_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getWithdrawal_serial_number() {
        return withdrawal_serial_number;
    }

    public void setWithdrawal_serial_number(int withdrawal_serial_number) {
        this.withdrawal_serial_number = withdrawal_serial_number;
    }

    public int getClassification_of_settlement_expenses() {
        return classification_of_settlement_expenses;
    }

    public void setClassification_of_settlement_expenses(int classification_of_settlement_expenses) {
        this.classification_of_settlement_expenses = classification_of_settlement_expenses;
    }

    public double getSettlement_amount() {
        return settlement_amount;
    }

    public void setSettlement_amount(double settlement_amount) {
        this.settlement_amount = settlement_amount;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    @Override
    public String toString() {
        return "SettlementAddFunctionDto{" +
                "user_id=" + user_id +
                ", withdrawal_serial_number=" + withdrawal_serial_number +
                ", classification_of_settlement_expenses=" + classification_of_settlement_expenses +
                ", settlement_amount=" + settlement_amount +
                ", settlement_time='" + settlement_time + '\'' +
                ", instructions='" + instructions + '\'' +
                ", employees_id=" + employees_id +
                '}';
    }
}
