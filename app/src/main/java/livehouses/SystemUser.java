package livehouses;

// Represents a loggeable user for the system
public class SystemUser {
    private String email;
    private String fullname;
    private int permissionBits;

    public SystemUser(String email, String fullname, int permissionBits) {
        this.email = email;
        this.fullname = fullname;
        this.permissionBits = permissionBits;
    }

    public SystemUser() {
        this.email = "";
        this.fullname = "";
        this.permissionBits = 0;
    }

    public void printInformation() {
        System.out.println("Email: " + this.email);
        System.out.println("Fullname: " + this.fullname);
        System.out.println("Permissions: " + this.permissionBits);
    }
}
