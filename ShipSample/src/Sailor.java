public class Sailor {

    private String name;
    private int grade;

    public Sailor(String sailorName, int sailorGrade) {
        name = sailorName;
        if (sailorGrade > 100) this.grade = 100;
        else if (sailorGrade < 0) this.grade = 0;
        else grade = sailorGrade;
    }

    public String getSailorName() {
        return name;
    }

    public int getSailorGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Sailor:" + name + ":" + grade;
    }
}
