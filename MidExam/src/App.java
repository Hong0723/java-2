public class App {
    public static void main(String[] args) throws Exception {
        // 데코레이터 패턴 테스트 실행
        System.out.println("-Decorator pattern-"); 
        new decorator.MainTest();
        System.out.println(); 

        // 팩토리 빌더 패턴 테스트 실행
        System.out.println("-factoryBuilder pattern-"); 
        new factoryBuilder.MainTest();
        System.out.println();

        // 옵저버 패턴 테스트 실행
        System.out.println("-observer pattern-");
        new observer.MainTest();
        System.out.println();

        // 전략 패턴 테스트 실행
        System.out.println("-strategy pattern-");
        new strategy.MainTest();
        System.out.println();
    }
}
