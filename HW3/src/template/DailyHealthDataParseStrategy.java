package template;

public class DailyHealthDataParseStrategy implements ParserStrategy<DailyHealthData> {

    @Override
    public DailyHealthData parse(String line) {

    // parse메소드, tokens[0]부터 [4]까지 날짜, 혈당 수치, 인슐린 용량, 탄수화물, 단백질(your code) 순으로 정의
    String[] tokens = line.split(",");
    String date = tokens[0];
    double bloodSugarLevel = Double.parseDouble(tokens[1]);
    double insulinDose = Double.parseDouble(tokens[2]);
    double carbsIntake = Double.parseDouble(tokens[3]); 
    double Protein = Double.parseDouble(tokens[4]);

    return new DailyHealthData(date, bloodSugarLevel, insulinDose, carbsIntake, Protein);
    }
}