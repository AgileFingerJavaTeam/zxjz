package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class CurrentAccountInfo {
    private int user_id;
    private int current_account_number;
    private String accounting_time;
    private int classification;
    private String  description;
    private Double amount;
    private String reference_bill_classification;
    private int references_the_internal_serial_number1;
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getCurrent_account_number() {
        return current_account_number;
    }
    public void setCurrent_account_number(int current_account_number) {
        this.current_account_number = current_account_number;
    }
    public String getAccounting_time() {
        return accounting_time;
    }
    public void setAccounting_time(String accounting_time) {
        this.accounting_time = accounting_time;
    }
    public int getClassification() {
        return classification;
    }
    public void setClassification(int classification) {
        this.classification = classification;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getReference_bill_classification() {
        return reference_bill_classification;
    }
    public void setReference_bill_classification(String reference_bill_classification) {
        this.reference_bill_classification = reference_bill_classification;
    }
    public int getReferences_the_internal_serial_number1() {
        return references_the_internal_serial_number1;
    }
    public void setReferences_the_internal_serial_number1(int references_the_internal_serial_number1) {
        this.references_the_internal_serial_number1 = references_the_internal_serial_number1;
    }
    @Override
    public String toString() {
        return "CurrentAccountInfo [user_id=" + user_id + ", current_account_number=" + current_account_number
                + ", accounting_time=" + accounting_time + ", classification=" + classification + ", description="
                + description + ", amount=" + amount + ", reference_bill_classification="
                + reference_bill_classification + ", references_the_internal_serial_number1="
                + references_the_internal_serial_number1 + "]";
    }



}
