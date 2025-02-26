package template;
// 이름, 탄수화물, 칼로리, 단백질 등의 정보를 포함
public class FoodData {
    private String name;
    private double carbs;
    private double calories;
    private double Protein;
    
    public FoodData(String name, double carbs, double calories,double Protein) {
        this.name = name;
        this.carbs = carbs;
        this.calories = calories;
        this.Protein = Protein;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarbs() {
        return this.carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getCalories() {
        return this.calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
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
            " name='" + name + "'" +
            ", carbs='" + carbs + "'" +
            ", calories='" + calories + "'" +
            ", Protein='" + Protein + "'" +
            "}";
    }
}
