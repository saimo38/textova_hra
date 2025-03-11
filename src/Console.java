import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private WorldMap m = new WorldMap();

    public void inicialization(){
        map.put("goto", new GoTo(m));
    }

    public void run (){
        System.out.print(">>");
        String command = sc.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        if(map.containsKey(command)){
            System.out.println(">> "+ map.get(command).execute());
        }else{
            System.out.println(">> Wrong command");
        }
    }

    public void start(){
        inicialization();
        m.loadMap();
        try {
            do {
                run();
            } while (!exit);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
