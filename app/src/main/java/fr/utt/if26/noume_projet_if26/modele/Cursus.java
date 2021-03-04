package fr.utt.if26.noume_projet_if26.modele;

import java.util.ArrayList;
import java.util.List;

public class Cursus {

    private int semestre1;
    private int semestre2;
    private int semestre3;
    private int semestre4;
    private int semestre5;
    private int semestre6;
    private String label;

    public Cursus(String label,int semestre1, int semestre2, int semestre3, int semestre4, int semestre5, int semestre6) {
        this.label = label;
        this.semestre1 = semestre1;
        this.semestre2 = semestre2;
        this.semestre3 = semestre3;
        this.semestre4 = semestre4;
        this.semestre5 = semestre5;
        this.semestre6 = semestre6;
    }

    public int getSemestre1() {
        return semestre1;
    }

    public int getSemestre2() {
        return semestre2;
    }

    public int getSemestre3() {
        return semestre3;
    }

    public int getSemestre4() {
        return semestre4;
    }

    public int getSemestre5() {
        return semestre5;
    }

    public int getSemestre6() {
        return semestre6;
    }

    public void setSemestre1(int semestre1) {
        this.semestre1 = semestre1;
    }

    public String getLabel() {
        return label;
    }

    public void setSemestre2(int semestre2) {
        this.semestre2 = semestre2;
    }

    public void setSemestre3(int semestre3) {
        this.semestre3 = semestre3;
    }

    public void setSemestre4(int semestre4) {
        this.semestre4 = semestre4;
    }

    public void setSemestre5(int semestre5) {
        this.semestre5 = semestre5;
    }

    public void setSemestre6(int semestre6) {
        this.semestre6 = semestre6;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
