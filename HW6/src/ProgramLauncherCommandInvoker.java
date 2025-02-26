import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ProgramLauncherCommandInvoker {
    private IProgramLauncherCommand command; // 현재 실행할 명령어를 나타내는 필드
    private Stack<IProgramLauncherCommand> commandStack = new Stack<>(); // 실행한 명령어들을 저장하는 스택

    // 새로운 명령어를 설정하는 메소드
    public void setCommand(IProgramLauncherCommand c){
        this.command = c;   
    }
    
    // 설정된 명령어를 실행하고, 스택에 저장하는 메소드
    public void executeCommand(){
        if(command != null){ // 명령어가 설정되어 있는지 확인
            command.execute(); // 명령어 실행
            commandStack.push(command); // 실행한 명령어를 스택에 저장
        }   
    }

    // 마지막으로 실행한 명령어를 되돌리는 메소드
    public void undoLastCommand() {
        if (!commandStack.isEmpty()){ // 스택이 비어있지 않은지 확인
            IProgramLauncherCommand lastCommand = commandStack.pop(); // 스택에서 마지막 명령어를 가져옴
            lastCommand.undo(); // 마지막 명령어의 undo 메소드 실행
        }
    }

    // 최근에 실행된 명령어의 이름 목록을 반환하는 메소드
    public List<String> getRecentlyExecutedCommands() {
        return commandStack.stream() // 스택의 명령어들을 스트림으로 변환
                           .map(IProgramLauncherCommand::getName) // 각 명령어의 이름을 가져옴
                           .collect(Collectors.toList()); // 이름 목록을 리스트로 수집
    }
}
