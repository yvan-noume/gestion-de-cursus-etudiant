package fr.utt.if26.noume_projet_if26.modele;

import java.io.Serializable;

public class Semestre implements Serializable {

    //private int id;
    private int semestre;
    private String module1;
    private String module2;
    private String module3;
    private String module4;
    private String module5;
    private String module6;
    private String module7;

    public Semestre(int semestre, String module1, String module2, String module3, String module4, String module5, String module6, String module7) {
        //this.id = id;
        this.semestre = semestre;
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
        this.module4 = module4;
        this.module5 = module5;
        this.module6 = module6;
        this.module7 = module7;
    }

    /*public int getId() {
        return id;
    }*/

    public int getSemstre() {
        return semestre;
    }

    public String getModule1() {
        return module1;
    }

    public String getModule2() {
        return module2;
    }

    public String getModule3() {
        return module3;
    }

    public String getModule4() {
        return module4;
    }

    public String getModule5() {
        return module5;
    }

    public String getModule6() {
        return module6;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getModule7() {
        return module7;
    }

    public void setSemstre(int semstre) {
        this.semestre = semstre;
    }

    public void setModule1(String module1) {
        this.module1 = module1;
    }

    public void setModule2(String module2) {
        this.module2 = module2;
    }

    public void setModule3(String module3) {
        this.module3 = module3;
    }

    public void setModule4(String module4) {
        this.module4 = module4;
    }

    public void setModule5(String module5) {
        this.module5 = module5;
    }

    public void setModule6(String module6) {
        this.module6 = module6;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setModule7(String module7) {
        this.module7 = module7;
    }
}
