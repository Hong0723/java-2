package template;
public class DailyHealthData {
    private String date; //날짜
    private double bloodSugarLevel; //혈당 수치
    private double insulinDose;  // 인슐린 용량
    private double carbsIntake;  //탄수화물 섭취량
    private double Protein;  //단백질 섭취량

    //생성자 생성
    public DailyHealthData(String date, double bloodSugarLevel, double insulinDose, double carbsIntake, double Protein) {
        this.date = date;
        this.bloodSugarLevel = bloodSugarLevel;
        this.insulinDose = insulinDose;
        this.carbsIntake = carbsIntake;
        this.Protein = Protein;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBloodSugarLevel() {
        return this.bloodSugarLevel;
    }

    public void setBloodSugarLevel(double bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }

    public double getInsulinDose() {
        return this.insulinDose;
    }

    public void setInsulinDose(double insulinDose) {
        this.insulinDose = insulinDose;
    }

    public double getCarbsIntake() {
        return this.carbsIntake;
    }

    public void setCarbsIntake(double carbsIntake) {
        this.carbsIntake = carbsIntake;
    }

    public double getProtein() {
        return this.Protein;
    }
    public void setProtein(double Protein) {
        this.Protein = Protein;
    }

    @Override
    public String toString() {
        return "{" +
                " date='" + date + "'" +
                ", bloodSugarLevel='" + bloodSugarLevel + "'" +
                ", insulinDose='" + insulinDose + "'" +
                ", carbsIntake='" + carbsIntake + "'" +
                ", Protein='" + Protein + "'" +
                "}";
    }
}
