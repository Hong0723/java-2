import org.jsoup.nodes.Document;

public abstract class AbstractWebCrawler { // AbstractWebCrawler 클래스는 웹 크롤링 작업을 수행하기 위한 템플릿을 제공하는 추상 클래스

    private final String url; // 크롤링 대상 웹사이트의 URL을 저장하는 필드

    public AbstractWebCrawler(String url){  // 생성자: 웹 크롤러를 초기화할 때 크롤링 대상 URL을 받아 초기화
        this.url = url;
    }

    public final void crawlWebsite(){ // 템플릿 메서드: 웹 크롤링 작업의 전체 흐름을 정의
        connectToWebsite();     // 웹사이트 연결
        Document document = fetchPage();    // 웹 페이지를 가져옴
        if(document != null){       // 페이지가 정상적으로 가져와졌다면 
            parsePage(document);    // 페이지를 파싱
            process();      // 파싱된 데이터 처리
        }
        disconnectFromWebsite();    // 웹사이트 연결 해제
    };
    
    protected abstract void connectToWebsite(); // 웹사이트에 연결하는 메소드 
    protected abstract Document fetchPage(); // 웹 페이지를 가져오는 메소드
    protected abstract void parsePage(Document document); // 웹 페이지를 파싱하는 메소드
    protected abstract void process(); // 파싱된 데이터를 처리하는 메소드

    protected void disconnectFromWebsite(){ // 웹사이트 연결을 해제하는 메소드
        System.out.println("Disconnected from website.");
    };

    public String getUrl() {
        return url;
    }
}
