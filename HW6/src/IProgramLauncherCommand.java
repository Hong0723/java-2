public interface IProgramLauncherCommand {
    void execute(); // 명령어 실행 메소드
    void undo(); // 명령어 실행 취소 메소드 
    String getName(); // (Your Code)
}
