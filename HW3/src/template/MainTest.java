package template;
import java.util.List;

public class MainTest {

    public MainTest() {
        
		List<FoodData> foodDataList = new FileImporter<>(new FoodDataParseStrategy()).loadCSV("fooddata.csv");

        // Load dailyfooddata
		List<DailyFoodData> dailyFoodDataList = new FileImporter<>(new DailyFoodDataParseStrategy(foodDataList)).loadCSV("dailyfooddata.csv");

        // Load dailyhealthdata
		List<DailyHealthData> dailyHealthDataList = new FileImporter<>(new DailyHealthDataParseStrategy()).loadCSV("dailyhealthdata.csv");
        // Subject
        DiabetesManager manager = new DiabetesManager();
        // Observer
        BloodSugarObserver bo = new BloodSugarObserver(150);
        CarbsIntakeObserver co = new CarbsIntakeObserver(100);
        InsulinObserver io = new InsulinObserver(10);
        Protein Do = new Protein(3);
        
        manager.addObserver(bo);
        manager.addObserver(co);
        manager.addObserver(io);
        manager.addObserver(Do);
        
        
        
        // Simulate health data updates with food integration
        new Thread(() -> {// Simulate food affecting carbs & insulin
        for (DailyHealthData h : dailyHealthDataList) {
        DailyFoodData f = dailyFoodDataList.stream().filter(e -> 
            e.getDate().equals(h.getDate())).findAny().orElse(null);
                double totalCarbs = f.getFoods().stream().mapToDouble(e -> e.getCarbs()).sum();
                totalCarbs += h.getCarbsIntake();
                h.setCarbsIntake(totalCarbs);
                double insulinDose = (h.getInsulinDose() + totalCarbs) / 10.0;
        
                h.setInsulinDose(insulinDose);
                

                //your code
                double Protein = f.getFoods().stream().mapToDouble(e -> e.getProtein()).sum();
                Protein += h.getProtein();

                h.setProtein(Protein);
                System.out.println(h.getDate());
                manager.addDailyHealthData(h);
        try {
            Thread.sleep(1000); // Wait for 1 second before next update
        } catch (InterruptedException  e) {
            e.printStackTrace();    
        }
        
            System.out.println("\n\n");
        }
        manager.removeObserver(bo);
        manager.removeObserver(io);
        manager.removeObserver(co);
        manager.removeObserver(Do);
        System.out.println("옵저버 삭제");
    }).start();

    
    }
}
