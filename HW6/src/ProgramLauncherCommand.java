import java.io.IOException;

public class ProgramLauncherCommand implements IProgramLauncherCommand {
    private String executable; // 실행 파일 경로를 나타내는 필드
    private String icon; // 아이콘 경로를 나타내는 필드
    private Process process; // 실행된 프로세스를 나타내는 필드
    private String name; // 명령어 이름을 나타내는 필드 (Your code)

    // getter 메소드: 실행 파일 경로 반환
    public String getExecutable() {
        return this.executable;
    }

    // setter 메소드: 실행 파일 경로 설정
    public void setExecutable(String executable) {
        this.executable = executable;
    }

    // getter 메소드: 아이콘 경로 반환
    public String getIcon() {
        return this.icon;
    }

    // setter 메소드: 아이콘 경로 설정
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // getter 메소드: 프로세스 반환
    public Process getProcess() {
        return this.process;
    }

    // setter 메소드: 프로세스 설정
    public void setProcess(Process process) {
        this.process = process;
    }

    // 생성자: 실행 파일 경로, 아이콘 경로, 명령어 이름을 초기화
    public ProgramLauncherCommand(String executable, String icon, String name) {
        this.executable = executable;
        this.icon = icon;
        this.name = name; 
    } 

    // 명령어 실행 메소드
    @Override
    public void execute() {
        try {
            ProcessBuilder pb = new ProcessBuilder(executable.split(" ")); // 실행 파일 경로로 프로세스 생성
            process = pb.start(); // 프로세스 시작
        } catch (Exception e) {
            e.printStackTrace(); // 오류 발생 시 스택 트레이스 출력
        }
    }

    // 명령어 실행 취소 (프로세스 종료) 메소드
    @Override
    public void undo() {
        if(getExecutable().equals("cmd /c start msedge")) {
            try {
                String newCommand = "cmd /c taskkill /im msedge.exe /f";
                ProcessBuilder pb = new ProcessBuilder(newCommand.split(" "));
            process = pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (process.isAlive() && process != null) {
            process.destroy();
        }
    }

    // 명령어 이름 반환 메소드 (Your code)
    @Override
    public String getName() {
        return name;
    }
}
