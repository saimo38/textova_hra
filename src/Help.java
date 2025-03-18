public class Help implements Command{
    private Console console;

    @Override
    public String execute() {
        return "Seznam prikazu:\n" +
                "bribe\n" + "end\n" + "explore\n" + "goto\n" + "help\n" + "hint\n" + "inventory\n" + "pickup\n" +
                "putdown\n" + "talk";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
