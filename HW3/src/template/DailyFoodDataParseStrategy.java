package template;
import java.util.*;


public class DailyFoodDataParseStrategy implements ParserStrategy<DailyFoodData> { // csv파일 데이터를 파싱하여 객체로 변환 시켜주는 클래스
    private List<FoodData> foodDataList;

    public DailyFoodDataParseStrategy(List<FoodData> foodDataList) {
        this.foodDataList = foodDataList;
    }

    @Override
    
    public DailyFoodData parse(String line) { // token을 콤마로 나눈다
        String[] tokens = line.split(",");
        if (tokens.length < 2) { // 만약 토근의 길이가 2보다 작다면 유효하지 않은 csv테이터 형식을 출력해줌
            throw new IllegalArgumentException("유효하지 않은 CSV 데이터 형식: " + line);
        }
        
        String date = tokens[0].trim();  // 첫 번째 값은 날짜
        // 음식이름을 list에 추가, 음식 비교를 위해서 쌍따옴표를 제거
        List<String> foodNames = new ArrayList<>();
        for(int i=1; i<tokens.length;i++) {
            foodNames.add(tokens[i].replace("\"",""));
        }

        List<FoodData> foods = new ArrayList<>();
        //음식 이름에 해당하는 foodName을 찾음
        for (String foodName : foodNames) {
            foodName = foodName.trim(); // 음식 이름의 공백을 제거 
            // 음식 이름의 공백을 제거
            FoodData matchingFood = null;
            // 음식 이름과 비교를 하여 똑같으면 break
            for (FoodData food : foodDataList) {
                if(food.getName().equals(foodName)) {
                    matchingFood = food;
                    break;
                }
            }
            if(matchingFood != null) {
                foods.add(matchingFood);
            }
        }         
        // 알맞은 날짜와 이름을 return
        return new DailyFoodData(date, foods);
    }
}
