package template;
// 데이터를 파싱하는 인터페이스. 제네릭 타입T를 사용하여 다양한 데이터 사용 가능
public interface ParserStrategy<T> {
    T parse(String line);
}
