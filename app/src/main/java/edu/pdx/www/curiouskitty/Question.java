package edu.pdx.www.curiouskitty;

public class Question {

    private String question;
    private String manswer;
    private String moption1;
    private String moption2;
    private String moption3;
    private String moption4;

    public Question(String question, String manswer, String moption1,String moption2, String moption3,String moption4) {
        this.question = question;
        this.manswer = manswer;
        this.moption1 = moption1;
        this.moption2 = moption2;
        this.moption3 = moption3;
        this.moption4 = moption4;
    }

    public String getQuestion() {
        return question;
    }

    public String getManswer() {
        return manswer;
    }

    public String getMoption1() {
        return moption1;
    }

    public String getMoption2() {
        return moption2;
    }

    public String getMoption3() {
        return moption3;
    }

    public String getMoption4() {
        return moption4;
    }
}
