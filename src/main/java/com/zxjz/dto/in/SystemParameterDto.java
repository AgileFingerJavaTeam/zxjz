package com.zxjz.dto.in;

public class SystemParameterDto {
    private String parameter_name;
    private String ios_version ;
    private int user_id;
    private int job_id;
    private int merchant_id;
    private String words_evaluate;
    private double descriptive_corre;
    private double punctuality_idea;
    private double conscientiousness;
    private double working_ability;
    private double compre_evaluation;
    private int recruiting_id;
    private int parameter_id;
    private String serial_number;
    private String parameter_description;
    private String parameter;
    private int id;
    private int parameterId;

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getParameter_description() {
        return parameter_description;
    }

    public void setParameter_description(String parameter_description) {
        this.parameter_description = parameter_description;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getIos_version() {
        return ios_version;
    }

    public void setIos_version(String ios_version) {
        this.ios_version = ios_version;
    }

    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(int merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getWords_evaluate() {
        return words_evaluate;
    }

    public void setWords_evaluate(String words_evaluate) {
        this.words_evaluate = words_evaluate;
    }

    public double getDescriptive_corre() {
        return descriptive_corre;
    }

    public void setDescriptive_corre(double descriptive_corre) {
        this.descriptive_corre = descriptive_corre;
    }

    public double getPunctuality_idea() {
        return punctuality_idea;
    }

    public void setPunctuality_idea(double punctuality_idea) {
        this.punctuality_idea = punctuality_idea;
    }

    public double getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(double conscientiousness) {
        this.conscientiousness = conscientiousness;
    }

    public double getWorking_ability() {
        return working_ability;
    }

    public void setWorking_ability(double working_ability) {
        this.working_ability = working_ability;
    }

    public double getCompre_evaluation() {
        return compre_evaluation;
    }

    public void setCompre_evaluation(double compre_evaluation) {
        this.compre_evaluation = compre_evaluation;
    }

    public int getRecruiting_id() {
        return recruiting_id;
    }

    public void setRecruiting_id(int recruiting_id) {
        this.recruiting_id = recruiting_id;
    }

    @Override
    public String toString() {
        return "SystemParameterDto{" +
                "parameter_name='" + parameter_name + '\'' +
                ", ios_version='" + ios_version + '\'' +
                ", user_id=" + user_id +
                ", job_id=" + job_id +
                ", merchant_id=" + merchant_id +
                ", words_evaluate='" + words_evaluate + '\'' +
                ", descriptive_corre=" + descriptive_corre +
                ", punctuality_idea=" + punctuality_idea +
                ", conscientiousness=" + conscientiousness +
                ", working_ability=" + working_ability +
                ", compre_evaluation=" + compre_evaluation +
                ", recruiting_id=" + recruiting_id +
                ", parameter_id=" + parameter_id +
                ", serial_number='" + serial_number + '\'' +
                ", parameter_description='" + parameter_description + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }
}
