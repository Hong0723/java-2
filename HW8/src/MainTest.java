/* HW8
자바프로그래밍2_1분반
2024/11/27
32211792
박재홍 */


public class MainTest {
    public static void main(String[] args) {
        AbstractWebCrawler crawler = new Recipe10000Crawler("https://www.10000recipe.com/recipe/list.html");
        crawler.crawlWebsite();

        System.out.println("\nSwitching to CGV Crawler...\n");
        
        crawler = new CGVCrawler("http://www.cgv.co.kr/movies/?lt=1&ft=0");
        crawler.crawlWebsite();

        System.out.println("\n Switching to MelonChartCrawler (Your Code)");

        // (Your Code)
        String url = "https://www.melon.com/chart/index.htm"; // 멜론 차트 URL    
        MelonChartCrawler crawler1 = new MelonChartCrawler(url);
        crawler1.fetchMelonChart();
    }

}