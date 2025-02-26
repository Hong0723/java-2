import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.List;

public class ProgramLauncherCommandApp extends JFrame {

    private ProgramLauncherCommandInvoker launcher = new ProgramLauncherCommandInvoker(); // 명령어 실행 및 되돌리기를 담당하는 invoker 객체
    private Map<String, ProgramLauncherCommand> commandsMap; // 명령어 이름과 ProgramLauncherCommand 객체를 매핑한 맵

    public ProgramLauncherCommandApp() {
        setTitle("Program Launcher with Icons"); // 프로그램 타이틀 설정
        setSize(600, 600); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 시 프로그램 종료
        setLayout(new GridLayout(0, 1)); // 레이아웃을 한 열로 설정 (버튼이 세로로 추가됨)

        // 최근 실행 명령어 조회 버튼 추가 (Your Code)
        JButton recentCommandsButton = new JButton("최근 실행 명령어 조회");
        recentCommandsButton.addActionListener(e -> showRecentCommands());
        add(recentCommandsButton);
        
        // JSON 파일에서 명령어를 로드하고 commandsMap에 저장
        commandsMap = ProgramLauncherCommandImporter.loadCommandsFromJson("commands.json");

        // 각 명령어에 대해 버튼을 생성하고 GUI에 추가
        for (Map.Entry<String, ProgramLauncherCommand> entry : commandsMap.entrySet()) {
            JButton button = createButtonWithIcon(entry.getKey(), entry.getValue()); // 명령어 버튼 생성
            add(button); // 버튼을 GUI에 추가
        }

        // Undo 버튼 추가 (마지막 명령어를 되돌리기)
        JButton undoButton = new JButton("Undo Last Command");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launcher.undoLastCommand(); // 마지막 명령어 되돌리기
            }
        });
        add(undoButton);

        setVisible(true); // 창을 화면에 보이게 설정
    }

    // 최근에 실행된 명령어 목록을 가져와서 JOptionPane으로 출력 (Your Code)
    private void showRecentCommands() {
        List<String> recentCommands = launcher.getRecentlyExecutedCommands(); // 최근 명령어 목록 가져오기
        String message = recentCommands.isEmpty()
                ? "최근 실행된 명령어가 없습니다."
                : String.join("\n", recentCommands);
        JOptionPane.showMessageDialog(this, message, "최근 실행 명령어", JOptionPane.INFORMATION_MESSAGE); // 메시지 박스로 출력
    }

    // 명령어 이름과 아이콘을 사용해 버튼을 생성
    private JButton createButtonWithIcon(String name, ProgramLauncherCommand command) {
        JButton button = new JButton(name); // 명령어 이름으로 버튼 생성
        button.setIcon(new ImageIcon(command.getIcon())); // 아이콘 설정
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launcher.setCommand(command); // invoker에 명령어 설정
                launcher.executeCommand(); // 명령어 실행
            }
        });
        return button; // 생성된 버튼 반환
    }
}
