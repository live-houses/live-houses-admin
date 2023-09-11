package livehouses;

public class Local {
    int managerID;
    String direccion;

    public Local(int managerID, String direccion){
        this.managerID = managerID;
        this.direccion = direccion;
    }

    public Local(){
        this.managerID = 0;
        this.direccion = "";
    }

    public void printInformation() {
        System.out.println("Direccion: " + this.direccion);
    }
}
