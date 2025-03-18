public class Hint implements Command{
    @Override
    public String execute() {
        return "Zkus použít příkaz prozkoumat a následně buď sebrat itemy nebo se dát do řeči s postavami.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
