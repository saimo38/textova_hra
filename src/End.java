public class End implements Command{
    @Override
    public String execute() {
        return "Konec hry";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
