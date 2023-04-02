package info.kormoporikolpona.ramadanplanner.Model;

public class RamadanIdAndTitle {
    int ramadanId;
    String ramadaTitle;

    public RamadanIdAndTitle(){

    }

    public RamadanIdAndTitle(int ramadanId, String ramadaTitle) {
        this.ramadanId = ramadanId;
        this.ramadaTitle = ramadaTitle;
    }

    public int getRamadanId() {
        return ramadanId;
    }

    public void setRamadanId(int ramadanId) {
        this.ramadanId = ramadanId;
    }

    public String getRamadaTitle() {
        return ramadaTitle;
    }

    public void setRamadaTitle(String ramadaTitle) {
        this.ramadaTitle = ramadaTitle;
    }
}
