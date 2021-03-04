package fr.utt.if26.noume_projet_if26.modele;

import java.util.ArrayList;
import java.util.Iterator;

public class ProgrammeISI {
    private ArrayList<Module> profil;

    public ProgrammeISI() {
        profil = new ArrayList();
        init();
    }

    public void ajoute(Module m) {
        profil.add(m);
    }

    public void init() {
        ajoute(new Module("GL02", "CS", "TCBR", 6));
        ajoute(new Module("NF16", "CS", "TCBR", 6));
        ajoute(new Module("NF20", "CS", "TCBR", 6));
        ajoute(new Module("IF09", "TM", "TCBR", 6));
        ajoute(new Module("IF14", "TM", "TCBR", 6));
        ajoute(new Module("LO02", "TM", "TCBR", 6));
        ajoute(new Module("NF21", "TM", "TCBR", 6));
        ajoute(new Module("IF03", "TM", "TCBR", 6));
        ajoute(new Module("LO12", "TM", "TCBR", 6));

        ajoute(new Module("IF05", "CS", "FIL", 6));
        ajoute(new Module("IF19", "CS", "FIL", 6));
        ajoute(new Module("IF11", "TM", "FIL", 6));
        ajoute(new Module("IF22", "TM", "FIL", 6));
        ajoute(new Module("IF24", "TM", "FIL", 6));
        ajoute(new Module("LO10", "TM", "FIL", 6));

        ajoute(new Module("IF10", "CS", "FIL", 6));
        ajoute(new Module("IF15", "CS", "FIL", 6));
        ajoute(new Module("IF16", "TM", "FIL", 6));
        ajoute(new Module("IF17", "TM", "FIL", 6));
        ajoute(new Module("IF20", "TM", "FIL", 6));
        ajoute(new Module("IF26", "TM", "FIL", 6));

        ajoute(new Module("LE02", "EC", "TCBR", 4));
        ajoute(new Module("LE03", "EC", "TCBR", 4));
        ajoute(new Module("LE08", "EC", "TCBR", 4));
        ajoute(new Module("LE11", "EC", "TCBR", 4));

        ajoute(new Module("GE21", "HE", "TCBR", 4));
        ajoute(new Module("GE31", "HE", "TCBR", 4));
        ajoute(new Module("GE34", "HE", "TCBR", 4));

        ajoute(new Module("SO05", "CT", "TCBR", 4));
        ajoute(new Module("SO10", "CT", "TCBR", 4));
        ajoute(new Module("SE01", "CT", "TCBR", 4));

        ajoute(new Module("TN09", "ST", "TCBR", 30));
        ajoute(new Module("TN10", "ST", "FIL", 30));
    }

    public ArrayList<String> getSigles() {
        ArrayList res = new ArrayList();
        Iterator iterateur = profil.iterator();
        while (iterateur.hasNext()) {
            Module m = (Module) (iterateur.next());
            res.add(m.getSigle());
        }
        return res;
    }


    public ArrayList<Module> getModules() {
        System.out.println(profil.toString());
        return profil;
    }
}

