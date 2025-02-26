import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Recipe10000Crawler extends AbstractWebCrawler { 
// Recipe10000Crawler 클래스는 AbstractWebCrawler를 상속받아 '10000 Recipe' 웹사이트에서 레시피 데이터를 크롤링
    public Recipe10000Crawler(String url){  // 생성자: 부모 클래스의 생성자를 호출하여 크롤링 대상 URL을 설정
        super(url);
    }

    @Override
    protected void connectToWebsite() { // '10000 Recipe' 웹사이트에 연결하는 메서드: 연결 시 메시지를 출력
        System.out.println("Connecting to Recipe10000 website: " + getUrl());
    }

    @Override
    protected Document fetchPage(){ // 웹 페이지를 가져오는 메서드: Jsoup 라이브러리를 사용하여 HTML 데이터를 가져옴
        try{
            System.out.println("Fetching page from Recipe10000 website...");
            return Jsoup.connect(getUrl()).get(); // Jsoup 라이브러리를 사용하여 URL에서 HTML 문서를 가져옴
        } catch (IOException e) {
            System.out.println("Error fetching page: "+ e.getMessage()); // 예외 발생 시 에러 메시지를 출력하고 null을 반환
            return null;
        }
    }

    @Override
    protected void parsePage(Document document){ // 웹 페이지를 파싱하는 메서드: HTML 문서에서 레시피 데이터를 추출
        System.out.println("Parsing Recipe10000 website...");
        Elements recipes = document.select(".common_sp_list_ul li"); // 레시피 목록 요소를 CSS 선택자로 선택함

        for (var recipe : recipes) {
            String recipeTitle = recipe.select(".common_sp_caption_tit").text(); // 레시피 제목 추출
            String recipeImage = recipe.select("img").attr("src"); // 레시피 이미지 URL 추출
            String recipeLink = recipe.select("a").attr("href"); // 레시피 상세 이미지 링크 추출
            
            // 추출된 데이터 출력
            System.out.println("Recipe Title: " + recipeTitle);
            System.out.println("Image URL: " + recipeImage);
            System.out.println("Link: " + recipeLink);

            try{
                Document recipePage = Jsoup.connect("https://www.10000recipe.com" + recipeLink).get(); // 상세 페이지를 가져옴
                String recipeDescription = recipePage.select(".view2_summary_in").text(); // 레시피 설명 추출
                Elements ingredients = recipePage.select(".ready_ingre3 ul li"); // 재료 목록 추출
                System.out.println("Description: " + recipeDescription);
                System.out.println("Ingredients: ");
                for (var ingredient : ingredients){
                    System.out.println("- "+ ingredient.text());
                }

            Elements cookingSteps = recipePage.select(".view_step_cont"); // 조리 단계 추출
            System.out.println("Cooking steps: ");    
            for(var step : cookingSteps){
                System.out.println("- "+ step.text());
            }
            } catch (IOException e){
                System.out.println("Error fetching recipe details: "+ e.getMessage());
            }
            System.out.println("-----------------");
        }
    }

        @Override
        protected void process(){ // 파싱한 데이터를 추가적으로 처리하는 메서드
            System.out.println("Processing parsed Recipe10000 data...");
        }

    

}
