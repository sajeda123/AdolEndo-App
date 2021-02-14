package com.example.adolendo;

public class Student {
    private String Name;
    private String InstitutionName;
    private String ClassName;
    private String Section;
    private String Roll;
    private String Email;
    private String MobileNumber;
    private String ClassTeacherName;
    private String ClassTeacherMobile;
    private String ClassTeacherEmail;
    private String GurdianName;
    private String GurdianRelation;
    private String GurdianEmail;
    private String DateOfBirth;

    public Student(){

    }

    public Student(String name, String institutionName, String className, String section, String roll, String email, String mobileNumber, String classTeacherName, String classTeacherMobile, String classTeacherEmail, String gurdianName, String gurdianRelation, String gurdianEmail, String dateOfBirth) {
        Name = name;
        InstitutionName = institutionName;
        ClassName = className;
        Section = section;
        Roll = roll;
        Email = email;
        MobileNumber = mobileNumber;
        ClassTeacherName = classTeacherName;
        ClassTeacherMobile = classTeacherMobile;
        ClassTeacherEmail = classTeacherEmail;
        GurdianName = gurdianName;
        GurdianRelation = gurdianRelation;
        GurdianEmail = gurdianEmail;
        DateOfBirth = dateOfBirth;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionName(String institutionName) {
        InstitutionName = institutionName;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getClassTeacherName() {
        return ClassTeacherName;
    }

    public void setClassTeacherName(String classTeacherName) {
        ClassTeacherName = classTeacherName;
    }

    public String getClassTeacherMobile() {
        return ClassTeacherMobile;
    }

    public void setClassTeacherMobile(String classTeacherMobile) {
        ClassTeacherMobile = classTeacherMobile;
    }

    public String getClassTeacherEmail() {
        return ClassTeacherEmail;
    }

    public void setClassTeacherEmail(String classTeacherEmail) {
        ClassTeacherEmail = classTeacherEmail;
    }

    public String getGurdianName() {
        return GurdianName;
    }

    public void setGurdianName(String gurdianName) {
        GurdianName = gurdianName;
    }

    public String getGurdianRelation() {
        return GurdianRelation;
    }

    public void setGurdianRelation(String gurdianRelation) {
        GurdianRelation = gurdianRelation;
    }

    public String getGurdianEmail() {
        return GurdianEmail;
    }

    public void setGurdianEmail(String gurdianEmail) {
        GurdianEmail = gurdianEmail;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
}
