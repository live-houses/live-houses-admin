package livehouses;

// Represents a loggeable user for the system
public class SystemUser {
    public int id;
    public String email;
    public String fullname;

    public SystemUser(int id, String email, String fullname) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
    }

    public SystemUser() {
        this.email = "";
        this.fullname = "";
    }

    public void printInformation() {
        System.out.println("__\nEmail: " + this.email);
        System.out.println("Fullname: " + this.fullname);
    }
}
