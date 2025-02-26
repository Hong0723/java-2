import java.util.Map;

public class FileLoaderImporterAdapter<T> implements FileImporter<T> { // 임포터 객체를 로더 객체로 변환하는 어댑터 클래스이며 FileLoader 인터페이스 상속
    private FileLoader<T> adaptee;
    
    public FileLoaderImporterAdapter(FileLoader<T> adaptee) {
        this.adaptee = adaptee;
    }

   
    @Override
    public Map<String, T> importFile(String filepath) {  // 임포터 객체를 로더 클래스의 파싱 메소드로 파싱
        return adaptee.load(filepath);
    }
 
    @Override
    public void exportFile(String filepath, Map<String, T> map) {    // 로더 객체의 파일 생성
        adaptee.save(filepath, map);
    }
}
