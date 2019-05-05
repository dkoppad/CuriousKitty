package edu.pdx.www.curiouskitty;

public class Question {

    private String question;
    private String manswer;
    private String[] moption1;

    public Question(String question, String manswer, String[] moption1) {
        this.question = question;
        this.moption1 = moption1;

        this.manswer = manswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getMoption1() {
        return String.valueOf(moption1);
    }

    public String getManswer() {
        return manswer;
    }

}
