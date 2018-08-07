package Generic;

import java.util.Date;

public class Student<T> {
    private T score;


    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    public Student() {
    }
    public void GetT(T t){}
}

class SupStudent extends Student<Date>{
    @Override
    public Date getScore() {
        return super.getScore();
    }

    @Override
    public void setScore(Date score) {
        super.setScore(score);
    }
}