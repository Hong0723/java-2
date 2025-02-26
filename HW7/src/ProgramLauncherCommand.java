public class ProgramLauncherCommand {
    private String name;
    private String executable;
    private String icon;

    public ProgramLauncherCommand(String name, String executable, String icon) {
        this.name = name;
        this.executable = executable;
        this.icon = icon;
    }

    public String getName(){
        return this.name; 
        }
    public void setName(String name) {
        this.name = name;
        }

    public String getExecutable() {
        return this.executable; 
        }
    public void setExecutable(String executable) {
        this.executable = executable;
        }

    public String getIcon() {
        return this.icon; 
        }
    public void setIcon(String icon) {
        this.icon = icon;
        }
}