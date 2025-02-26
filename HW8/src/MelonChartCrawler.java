import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

// MelonChartCrawler 클래스는 멜론 차트 데이터를 크롤링하여 출력하는 기능을 제공
public class MelonChartCrawler {

    // 크롤링 대상 URL을 저장하는 필드
    private String url;

    // 생성자: 크롤링 대상 URL을 초기화.
    public MelonChartCrawler(String url) {
        this.url = url;
    }

    // 멜론 차트 데이터를 가져오는 메서드
    public void fetchMelonChart() {
        try {
            // Jsoup 라이브러리를 사용하여 URL에 연결하고 HTML 문서를 가져옴.
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                    .get();

            System.out.println("Parsing Melon Chart Website...");

            // .lst50 클래스를 가진 요소들을 선택하여 상위 50곡 데이터를 가져옴
            Elements songs = document.select(".lst50"); 

            // 각 곡의 정보를 추출
            for (Element song : songs) {
                // 노래 제목을 .rank01 클래스 내부의 <a> 태그에서 추출
                String title = song.select(".rank01 a").text();

                // 가수 이름을 .rank02 클래스 내부의 첫 번째 <a> 태그에서 추출
                String artist = song.select(".rank02 a").first().text();

                // 앨범 이름을 .rank03 클래스 내부의 <a> 태그에서 추출
                String album = song.select(".rank03 a").text();

                // 노래 순위를 .rank 클래스에서 추출
                String rank = song.select(".rank").text();

                // 추출한 데이터를 콘솔에 출력합니다.
                System.out.println("Rank: " + rank);    
                System.out.println("Title: " + title );
                System.out.println("Artist: " + artist );
                System.out.println("Album: " + album);
                System.out.println("------------------------");
            }

        } catch (IOException e) {
            // 연결 실패 또는 데이터 로드 중 예외가 발생했을 때 에러 메시지를 출력
            System.out.println("Error: Unable to connect to Melon.");
            e.printStackTrace();
        }
    }
}
