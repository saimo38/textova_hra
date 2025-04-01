import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    private Console console;
    private WorldMap worldMap;
    private Player player;

    @BeforeEach
    public void setUp() {
        console = new Console();
        worldMap = new WorldMap();
        worldMap.loadMap();
        player = new Player("Eldric", new Inventory(2), worldMap.getCurrentLocation(worldMap.getStart()));
        console.inicialization();
    }

    @Test
    void testLoadMap() {
        assertFalse(worldMap.getWorld().isEmpty(), "Mapa by neměla být prázdná po načtení");

        int startId = worldMap.getStart();
        assertTrue(worldMap.getWorld().containsKey(startId), "Startovní lokace by měla být v mapě");
    }

    @Test
    public void testLoadCharacters() {
        console.loadCharacters();
        Location location = worldMap.getCurrentLocation(3);
        assertNotNull(location, "Lokace s ID 3 by měla existovat.");
        System.out.println("Počet postav v lokaci 3: " + location.getCharacters().size());
        assertFalse(location.getCharacters().isEmpty(), "Lokace by měla obsahovat alespoň jednu postavu.");
    }

    @Test
    public void testLoadItems() {
        console.loadItems();  // Načítání předmětů
        Location location = worldMap.getCurrentLocation(3);  // Předpokládáme, že se nějaká lokace načítá
        assertNotNull(location, "Lokace s ID 3 by měla existovat.");
        System.out.println("Počet předmětů v lokaci 3: " + location.getItems().size());
        assertFalse(location.getItems().isEmpty(), "Lokace by měla obsahovat alespoň jeden předmět.");
    }


    @Test
    public void testStartLocation() {
        Location startLocation = worldMap.getCurrentLocation(worldMap.getStart());
        assertNotNull(startLocation, "Startovní lokace by měla existovat.");
        assertEquals(3, startLocation.getId(), "Startovní lokace by měla být 3 (podle předchozích úprav)");
    }


}