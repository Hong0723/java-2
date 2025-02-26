package template;
// ParserStrategy인터페이스를 구현
public class FoodDataParseStrategy implements ParserStrategy<FoodData> {
    // csv파일을 파싱, FoodData 객체로 변환시킴
    public FoodData parse(String line) {
        String[] tokens = line.split(",");
        String name = tokens[0];
        double carbs = Double.parseDouble(tokens[1]);
        double calories = Double.parseDouble(tokens[2]);
        double Protein = Double.parseDouble(tokens[3]);

        return new FoodData(name, carbs, calories,Protein);
    }
}
