public class Help implements Command{
    /**
     * Příkaz help vypíše všechny dostupné příkazy.
     * @return vrátí seznam příkazů
     */
    @Override
    public String execute() {
        return "Seznam prikazu:\n" +
                "bribe - Umožňuje uplatit strážce a odemknout tak hlavní chodbu\n" +
                "end - Ukončí program\n" +
                "explore - Vypíše seznam postav a itemů dostupných v dané místnosti\n" +
                "goto - Umožňuje přechod mezi jednotlivými místnostmi\n" +
                "help - Vypíše seznam dostupných příkazů\n" +
                "hint - Vypíše nápovědu\n" +
                "inventory - Zobrazí obsah inventáře\n" +
                "pickup - Sebere předmět\n" +
                "putdown - Položí předmět\n" +
                "talk - Umožňuje mluvit s postavou";
    }

    @Override
    public boolean exit() {
        return false;
    }
}