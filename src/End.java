public class End implements Command{
    private Console console;

    public End(Console console) {
        this.console = console;
    }

    /**
     * Příkaz end ukončuje hru.
     * @return vrátí oznámení o konci hry
     */
    @Override
    public String execute() {
        return "Konec hry";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
