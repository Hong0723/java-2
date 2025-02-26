import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class CGVCrawler extends AbstractWebCrawler { // CGVCrawler 클래스는 AbstractWebCrawler를 상속하여 CGV 영화 웹사이트에서 데이터를 크롤링

    public CGVCrawler(String url){ // 생성자: 부모 클래스의 생성자를 호출하여 크롤링 대상 URL을 설정
        super(url);
    }

    @Override
    protected void connectToWebsite() { // CGV 웹사이트에 연결하는 메서드: 연결 시 메시지를 출력    
        System.out.println("Connecting to CGV Website " + getUrl());
    }

    @Override
    protected Document fetchPage(){  // 웹 페이지를 가져오는 메서드: Jsoup 라이브러리를 사용하여 지정된 URL에서 HTML 문서를 가져옴
        try{
            System.out.println("Fetching page from CGV Website..."); 
            return Jsoup.connect(getUrl()).get(); // Jsoup의 connect 메서드를 사용하여 URL에 연결하고, HTML 내용을 가져옴
        } catch (IOException e) {
            System.out.println("Error fetching page: " + e.getMessage()); // 예외가 발생하면 에러 메시지를 출력하고 null을 반환
            return null;
        }
    }

    @Override
    protected void parsePage(Document document){  // 웹 페이지를 파싱하는 메서드: HTML 문서에서 원하는 데이터를 추출
        System.out.println("Parsing CGV Website...");
        Elements movies = document.select(".sect-movie-chart .box-contents, .sect-movie-chart .box-image");
            // 영화 제목, 출시 날짜, 평점, 이미지 URL을 추출하기 위한 선택자를 정의
        int len = movies.size(); // 선택된 영화 목록의 개수를 가져옴
        for(int i = 0; i<len; i+=2) { // 영화 데이터를 2개의 요소로 묶어서 처리
            String movieTitle = movies.get(i+1).select(".title").text(); // 영화 제목 추출
            String releaseDate = movies.get(i+1).select(".txt-info strong").text(); // 출시 날짜 추출
            String rating = movies.get(i+1).select(".percent span").text(); // 평점 추출
            String movieImage = movies.get(i).select(".thumb-image > img").attr("src"); // 영화 이미지 URL 추출
            
            // 추출된 데이터들 출력
            System.out.println("Title: " + movieTitle); 
            System.out.println("Release Date: " + releaseDate);
            System.out.println("Rating: " + rating);
            System.out.println("Image URL: " + movieImage);
            System.out.println("------------------------");
            }
        }

    @Override
    protected void process(){  // 파싱한 데이터를 추가적으로 처리하는 메서드
        System.out.println("Processing parsed CGV data...");
    }
}
