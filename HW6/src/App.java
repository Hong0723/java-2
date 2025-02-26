/* HW6
자바프로그래밍2_1분반
2024/11/13
32211792
박재홍 */

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {   // Swing 애플리케이션의 UI를 이벤트 디스패치 스레드에서 실행
        SwingUtilities.invokeLater(() -> {
            ProgramLauncherCommandApp app = new ProgramLauncherCommandApp();
            app.setVisible(true); // 애플리케이션 창을 화면에 표시
        });
    }}