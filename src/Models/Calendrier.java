package Models;

import java.util.List;

public class Calendrier {
    public List<Tache> Taches;
    public int NBFAITES = 0;
    public int NBPASFAITES = 0;
    public int NBTACHES;


    public Calendrier(List<Tache> Taches) {
        this.Taches = Taches;
        this.NBTACHES = this.Taches.size();
    }

    public void updateStats() {
        for (int i=0; i<NBTACHES; i++) {
            if (this.Taches.get(i).isEffectuée() == 1) {
                NBFAITES = NBFAITES + 1;
            } else if (this.Taches.get(i).isEffectuée() == 0) {
                NBPASFAITES = NBPASFAITES + 1;
            }
        }
    }
}
