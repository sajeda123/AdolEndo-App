package com.example.adolendo;
public class Participant {
    private String Participant_Id,Question_1,Question_2,Question_3,Question_4,Question_5,Question_6,Question_7,Question_8,Question_9,Result;

    public Participant(String Question_1, String Question_2,String Question_3,String Question_4,String Question_5,String Question_6,String Question_7,String Question_8,String Question_9,String Result) {
        //this.Participant_Id=User_id;
        this.Question_1 = Question_1;
        this.Question_2 = Question_2;
        this.Question_3 = Question_3;
        this.Question_4 = Question_4;
        this.Question_5 = Question_5;
        this.Question_6 = Question_6;
        this.Question_7 = Question_7;
        this.Question_8 = Question_8;
        this.Question_9 = Question_9;
        this.Result=Result;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    /* public String getParticipant_Id() {
         return Participant_Id;
     }

     public void setParticipant_Id(String participant_id) {
         Participant_Id = participant_id;
     }

     */
    public String getQuestion_1() {
        return Question_1;
    }

    public void setQuestion_1(String question_1) {
        Question_1 = question_1;
    }

    public String getQuestion_2() {
        return Question_2;
    }

    public void setQuestion_2(String question_2) {
        Question_2 = question_2;
    }

    public String getQuestion_3() {
        return Question_3;
    }

    public void setQuestion_3(String question_3) {
        Question_3 = question_3;
    }

    public String getQuestion_4() {
        return Question_4;
    }

    public void setQuestion_4(String question_4) {
        Question_4 = question_4;
    }

    public String getQuestion_5() {
        return Question_5;
    }

    public void setQuestion_5(String question_5) {
        Question_5 = question_5;
    }

    public String getQuestion_6() {
        return Question_6;
    }

    public void setQuestion_6(String question_6) {
        Question_6 = question_6;
    }

    public String getQuestion_7() {
        return Question_7;
    }

    public void setQuestion_7(String question_7) {
        Question_7 = question_7;
    }

    public String getQuestion_8() {
        return Question_8;
    }

    public void setQuestion_8(String question_8) {
        Question_8 = question_8;
    }

    public String getQuestion_9() {
        return Question_9;
    }

    public void setQuestion_9(String question_9) {
        Question_9 = question_9;
    }

}

