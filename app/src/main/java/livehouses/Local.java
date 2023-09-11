package livehouses;

import livehouses.utils.pretty.Printer;

public class Local {
    public int managerID;
    public String direccion;
    public String localName;

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
        Printer.print(this.localName, 244, 173, 244);
        Printer.newLine();
        Printer.print("Direccion: " + this.direccion);
        Printer.newLine();
        Printer.print("Manager ID: " + this.managerID);
        Printer.newLine();
        Printer.newLine();
    }
}
