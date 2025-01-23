package Models;

import javax.swing.JTextField;

public class Tache {
    public String libellé;
    //JTextField TextField;
    public int effectuée;

    public Tache(String libellé) {
        this.libellé = libellé;
        this.effectuée = 3;
    }

    public void setEffectuée(int effectuée) {
        this.effectuée = effectuée;
    }

    public int isEffectuée() {
        return this.effectuée;
    }

}
