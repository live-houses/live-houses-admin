package livehouses;

public class Local {
    int managerID;
    String direccion;
    String localName;

    public Local(int managerID, String localName,  String direccion){
        this.managerID = managerID;
        this.localName = localName;
        this.direccion = direccion;
    }

    public Local(){
        this.managerID = 0;
        this.localName = "";
        this.direccion = "";
    }

    public void printInformation() {
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Local Name: " + this.localName);
        System.out.println("Manager ID: " + this.managerID);
    }
}
