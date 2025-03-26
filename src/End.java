public class End implements Command{
    private Console console;

    public End(Console console) {
        this.console = console;
    }

    @Override
    public String execute() {
        return "Konec hry";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
