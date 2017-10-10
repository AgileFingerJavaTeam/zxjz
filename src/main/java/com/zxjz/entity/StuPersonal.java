package com.zxjz.entity;

public class StuPersonal {
    private int userId;//学生用户ID
    private String name;//学生姓名
    private String phone;//学生手机号
    private String password;//密码
    private String regDatetime;
    private String headPic;//头像
    private String sex;//性别
    private String nation;//民族
    private String birthday;//生日
    private String school;//学校
    private String enrollmentYear;//入学年份
    private String college;//学院
    private String system;//系
    private String major;//专业
    private String schClass;//班级
    private String schAddress;//校内住址
    private String stuNumber;//学号
    private String contact;//联系电话
    private String email;//邮箱
    private String job;//
    private String numberJob;//历史兼职次数
    private String missNumber;//爽约次数
    private float generalEvaluation;//总评价星级
    private float descriptiveCorre;//描述相符
    private float punctualityIdea;//守时观念
    private float conscientiousness;//责任心
    private float workingAbility;//工作能力
    private float compreEvaluation;//综合评价

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(String regDatetime) {
        this.regDatetime = regDatetime;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchClass() {
        return schClass;
    }

    public void setSchClass(String schClass) {
        this.schClass = schClass;
    }

    public String getSchAddress() {
        return schAddress;
    }

    public void setSchAddress(String schAddress) {
        this.schAddress = schAddress;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNumberJob() {
        return numberJob;
    }

    public void setNumberJob(String numberJob) {
        this.numberJob = numberJob;
    }

    public String getMissNumber() {
        return missNumber;
    }

    public void setMissNumber(String missNumber) {
        this.missNumber = missNumber;
    }

    public float getGeneralEvaluation() {
        return generalEvaluation;
    }

    public void setGeneralEvaluation(float generalEvaluation) {
        this.generalEvaluation = generalEvaluation;
    }

    public float getDescriptiveCorre() {
        return descriptiveCorre;
    }

    public void setDescriptiveCorre(float descriptiveCorre) {
        this.descriptiveCorre = descriptiveCorre;
    }

    public float getPunctualityIdea() {
        return punctualityIdea;
    }

    public void setPunctualityIdea(float punctualityIdea) {
        this.punctualityIdea = punctualityIdea;
    }

    public float getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(float conscientiousness) {
        this.conscientiousness = conscientiousness;
    }

    public float getWorkingAbility() {
        return workingAbility;
    }

    public void setWorkingAbility(float workingAbility) {
        this.workingAbility = workingAbility;
    }

    public float getCompreEvaluation() {
        return compreEvaluation;
    }

    public void setCompreEvaluation(float compreEvaluation) {
        this.compreEvaluation = compreEvaluation;
    }

    @Override
    public String toString() {
        return "StuPersonal{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", regDatetime='" + regDatetime + '\'' +
                ", headPic='" + headPic + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday='" + birthday + '\'' +
                ", school='" + school + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", college='" + college + '\'' +
                ", system='" + system + '\'' +
                ", major='" + major + '\'' +
                ", schClass='" + schClass + '\'' +
                ", schAddress='" + schAddress + '\'' +
                ", stuNumber='" + stuNumber + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", numberJob='" + numberJob + '\'' +
                ", missNumber='" + missNumber + '\'' +
                ", generalEvaluation=" + generalEvaluation +
                ", descriptiveCorre=" + descriptiveCorre +
                ", punctualityIdea=" + punctualityIdea +
                ", conscientiousness=" + conscientiousness +
                ", workingAbility=" + workingAbility +
                ", compreEvaluation=" + compreEvaluation +
                '}';
    }
}
