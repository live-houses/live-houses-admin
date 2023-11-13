package livehouses.db.models;

public class Locale {
    private int id;
    private int managerAccountId;
    private String name;
    private String address;
    private String geolocation;
    private short capacity;
    private String openingHour;
    private String closingTime;

    // Constructors, getters, and setters

    public Locale() {
    }

    public Locale(int id, int managerAccountId, String name, String address, String geolocation,
                  short capacity, String openingHour, String closingTime) {
        this.id = id;
        this.managerAccountId = managerAccountId;
        this.name = name;
        this.address = address;
        this.geolocation = geolocation;
        this.capacity = capacity;
        this.openingHour = openingHour;
        this.closingTime = closingTime;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManagerAccountId() {
        return managerAccountId;
    }

    public void setManagerAccountId(int managerAccountId) {
        this.managerAccountId = managerAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public Integer getCapacity() {
        return Integer.valueOf(this.capacity);
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}
