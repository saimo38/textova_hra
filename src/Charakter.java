public class Charakter {

    private String name;
    private String role;
    private int locationId;

    public Charakter(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Charakter(){}

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
