import java.util.Map;



public class FileImporterLoaderAdapter<T> implements FileLoader<T> { // 로더 객체를 임포터 객체로 변환하는 어댑터 클래스이며 FileLoader 인터페이스 상속
    private FileImporter<T> adaptee;
    
    public FileImporterLoaderAdapter(FileImporter<T> adaptee) {
        this.adaptee = adaptee;
    }

   
    @Override
    public Map<String, T> load(String filepath) {  // 임포터 객체의 파싱메소드 호출
        return adaptee.importFile(filepath);
    }
    
    @Override
    public void save(String filepath, Map<String, T> map) { // 임포터 객체의 파일 생성
        adaptee.exportFile(filepath, map);
    }
}
