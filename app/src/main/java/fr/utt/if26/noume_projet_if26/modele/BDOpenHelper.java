package fr.utt.if26.noume_projet_if26.modele;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class BDOpenHelper extends SQLiteOpenHelper {

    // Definitions pour la base
    public static final int DATABASE_VERSION = 12;
    public static final String DATABASE_NAME = "Cursus.db";

    // Définition d'un tag pour les Log
    private String TAG = "BDHelper";

    // ===========================================================================
    // Définitions pour la table des modules
    private static final String MODULE_TABLE_NAME = "modules";
    private static final String MODULE_ATTRIBUT_SIGLE = "sigle";
    private static final String MODULE_ATTRIBUT_CATEGORIE = "categorie";
    private static final String MODULE_ATTRIBUT_PARCOURS = "parcours";
    private static final String MODULE_ATTRIBUT_CREDITS = "crédits";

    // definitions pour la table semestre
    private static final String SEMESTRE_TABLE_NAME = "semestres";
    private static final String SEMESTRE_ATTRIBUT_ID = "ID";
    private static final String SEMESTRE_ATTRIBUT_SEMESTRE = "semestre";
    private static final String SEMESTRE_ATTRIBUT_MODULE1 = "module1";
    private static final String SEMESTRE_ATTRIBUT_MODULE2 = "module2";
    private static final String SEMESTRE_ATTRIBUT_MODULE3 = "module3";
    private static final String SEMESTRE_ATTRIBUT_MODULE4 = "module4";
    private static final String SEMESTRE_ATTRIBUT_MODULE5 = "module5";
    private static final String SEMESTRE_ATTRIBUT_MODULE6 = "module6";
    private static final String SEMESTRE_ATTRIBUT_MODULE7 = "module7";

    // definitions pour la table cursus
    private static final String CURSUS_TABLE_NAME = "cursus";
    private static final String CURSUS_ATTRIBUT_LABEL = "label";
    private static final String CURSUS_ATTRIBUT_SEMESTRE1 = "semestre1";
    private static final String CURSUS_ATTRIBUT_SEMESTRE2 = "semestre2";
    private static final String CURSUS_ATTRIBUT_SEMESTRE3 = "semestre3";
    private static final String CURSUS_ATTRIBUT_SEMESTRE4 = "semestre4";
    private static final String CURSUS_ATTRIBUT_SEMESTRE5 = "semestre5";
    private static final String CURSUS_ATTRIBUT_SEMESTRE6 = "semestre6";

    private final String MODULE_TABLE_CREATE =  "create table " + MODULE_TABLE_NAME + "(" +
            MODULE_ATTRIBUT_SIGLE + " TEXT primary key, " +
            MODULE_ATTRIBUT_CATEGORIE + " TEXT, " +
            MODULE_ATTRIBUT_PARCOURS + " TEXT, " +
            MODULE_ATTRIBUT_CREDITS + " INT)";

    private final String SEMESTRE_TABLE_CREATE =  "create table " + SEMESTRE_TABLE_NAME + "(" +
            SEMESTRE_ATTRIBUT_ID + " INTEGER primary key AUTOINCREMENT NOT NULL, " +
            SEMESTRE_ATTRIBUT_SEMESTRE + " INT, " +
            SEMESTRE_ATTRIBUT_MODULE1 + " TEXT, " +
            SEMESTRE_ATTRIBUT_MODULE2 + " TEXT, " +
            SEMESTRE_ATTRIBUT_MODULE3 + " TEXT, " +
            SEMESTRE_ATTRIBUT_MODULE4 + " TEXT, " +
            SEMESTRE_ATTRIBUT_MODULE5 + " TEXT, " +
            SEMESTRE_ATTRIBUT_MODULE6 + " TEXT," +
            SEMESTRE_ATTRIBUT_MODULE7 + " TEXT," +
            "FOREIGN KEY (" + SEMESTRE_ATTRIBUT_MODULE1 + ") REFERENCES " + MODULE_TABLE_NAME + "(" +  MODULE_ATTRIBUT_SIGLE + ")," +
            "FOREIGN KEY (" + SEMESTRE_ATTRIBUT_MODULE2 + ") REFERENCES " + MODULE_TABLE_NAME + "(" +  MODULE_ATTRIBUT_SIGLE + ")," +
            "FOREIGN KEY (" + SEMESTRE_ATTRIBUT_MODULE3 + ") REFERENCES " + MODULE_TABLE_NAME + "(" +  MODULE_ATTRIBUT_SIGLE + ")," +
            "FOREIGN KEY (" + SEMESTRE_ATTRIBUT_MODULE4 + ") REFERENCES " + MODULE_TABLE_NAME + "(" +  MODULE_ATTRIBUT_SIGLE + ")," +
            "FOREIGN KEY (" + SEMESTRE_ATTRIBUT_MODULE5 + ") REFERENCES " + MODULE_TABLE_NAME + "(" +  MODULE_ATTRIBUT_SIGLE + ")," +
            "FOREIGN KEY (" + SEMESTRE_ATTRIBUT_MODULE6 + ") REFERENCES " + MODULE_TABLE_NAME + "(" +  MODULE_ATTRIBUT_SIGLE + ")," +
            "FOREIGN KEY (" + SEMESTRE_ATTRIBUT_MODULE7 + ") REFERENCES " + MODULE_TABLE_NAME + "(" +  MODULE_ATTRIBUT_SIGLE + ")" +
            ")";

    private final String CURSUS_TABLE_CREATE =  "create table " + CURSUS_TABLE_NAME + "(" +
            CURSUS_ATTRIBUT_LABEL + " TEXT primary key, " +
            CURSUS_ATTRIBUT_SEMESTRE1 + " INT, " +
            CURSUS_ATTRIBUT_SEMESTRE2 + " INT, " +
            CURSUS_ATTRIBUT_SEMESTRE3 + " INT, " +
            CURSUS_ATTRIBUT_SEMESTRE4 + " INT, " +
            CURSUS_ATTRIBUT_SEMESTRE5 + " INT, " +
            CURSUS_ATTRIBUT_SEMESTRE6 + " INT," +
            "FOREIGN KEY (" + CURSUS_ATTRIBUT_SEMESTRE1 + ") REFERENCES " + SEMESTRE_TABLE_NAME + "(" + SEMESTRE_ATTRIBUT_ID + ")," +
            "FOREIGN KEY (" + CURSUS_ATTRIBUT_SEMESTRE1 + ") REFERENCES " + SEMESTRE_TABLE_NAME + "(" + SEMESTRE_ATTRIBUT_ID + ")," +
            "FOREIGN KEY (" + CURSUS_ATTRIBUT_SEMESTRE1 + ") REFERENCES " + SEMESTRE_TABLE_NAME + "(" + SEMESTRE_ATTRIBUT_ID + ")," +
            "FOREIGN KEY (" + CURSUS_ATTRIBUT_SEMESTRE1 + ") REFERENCES " + SEMESTRE_TABLE_NAME + "(" + SEMESTRE_ATTRIBUT_ID + ")," +
            "FOREIGN KEY (" + CURSUS_ATTRIBUT_SEMESTRE1 + ") REFERENCES " + SEMESTRE_TABLE_NAME + "(" + SEMESTRE_ATTRIBUT_ID + ")," +
            "FOREIGN KEY (" + CURSUS_ATTRIBUT_SEMESTRE1 + ") REFERENCES " + SEMESTRE_TABLE_NAME + "(" + SEMESTRE_ATTRIBUT_ID + ")," +
            "FOREIGN KEY (" + CURSUS_ATTRIBUT_SEMESTRE1 + ") REFERENCES " + SEMESTRE_TABLE_NAME + "(" + SEMESTRE_ATTRIBUT_ID + ")" +
            ")";

    private final String MODULE_TABLE_DROP = "drop table if exists " + MODULE_TABLE_NAME;
    private final String SEMESTRE_TABLE_DROP = "drop table if exists " + SEMESTRE_TABLE_NAME;
    private final String CURSUS_TABLE_DROP = "drop table if exists " + CURSUS_TABLE_NAME;

    // ===========================================================================
    
    
    // -----o-----o-----o-----o-----o-----o-----o-----o-----o
    // Constructeur
    public BDOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // 3eme paramètre est une instance de SQLiteDatabase.CursorFactory (ici = NULL)
    }

    // -----o-----o-----o-----o-----o-----o-----o-----o-----o
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Liste des créations de tables
        db.execSQL(MODULE_TABLE_CREATE);
        db.execSQL(SEMESTRE_TABLE_CREATE);
        db.execSQL(CURSUS_TABLE_CREATE);
        // Remarque importante :
        // Ne pas faire d'insertion dans le onCreate !
    }

    // -----o-----o-----o-----o-----o-----o-----o-----o-----o
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Supression des tables si elles existent
        db.execSQL(MODULE_TABLE_DROP);
        db.execSQL(SEMESTRE_TABLE_DROP);
        db.execSQL(CURSUS_TABLE_DROP);
        // Création des tables
        onCreate(db);
    }

    public void supprimerSemestre(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SEMESTRE_TABLE_DROP);
        onCreate(db);
        db.close();
    }

    // ===========================================================================
    // MODULE CRUD (create, read, update, delete)
    // ===========================================================================
    public void createModule(Module module) {

        // preparation du ContentValue avec les data d'un tuple
        ContentValues tuple = new ContentValues();
        tuple.put(MODULE_ATTRIBUT_SIGLE, module.getSigle());
        tuple.put(MODULE_ATTRIBUT_CATEGORIE, module.getCategorie());
        tuple.put(MODULE_ATTRIBUT_PARCOURS, module.getParcours());
        tuple.put(MODULE_ATTRIBUT_CREDITS, module.getCredit());

        Log.i(TAG + ":createEtudiant:t = ", tuple.toString());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(MODULE_TABLE_NAME, null, tuple);
        db.close();
    }

    public void createSemestre(Semestre semestre) {

        // preparation du ContentValue avec les data d'un tuple
        ContentValues tuple = new ContentValues();
        //tuple.put(SEMESTRE_ATTRIBUT_ID, semestre.getId());
        tuple.put(SEMESTRE_ATTRIBUT_SEMESTRE, semestre.getSemstre());
        tuple.put(SEMESTRE_ATTRIBUT_MODULE1, semestre.getModule1());
        tuple.put(SEMESTRE_ATTRIBUT_MODULE2, semestre.getModule2());
        tuple.put(SEMESTRE_ATTRIBUT_MODULE3, semestre.getModule3());
        tuple.put(SEMESTRE_ATTRIBUT_MODULE4, semestre.getModule4());
        tuple.put(SEMESTRE_ATTRIBUT_MODULE5, semestre.getModule5());
        tuple.put(SEMESTRE_ATTRIBUT_MODULE6, semestre.getModule6());
        tuple.put(SEMESTRE_ATTRIBUT_MODULE7, semestre.getModule7());

        Log.i(TAG + ":createSemestre:t = ", tuple.toString());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(SEMESTRE_TABLE_NAME, null, tuple);
        db.close();
    }

    public void createCursus(Cursus cursus) {

        // preparation du ContentValue avec les data d'un tuple
        ContentValues tuple = new ContentValues();
        //tuple.put(SEMESTRE_ATTRIBUT_ID, semestre.getId());
        tuple.put(CURSUS_ATTRIBUT_LABEL, cursus.getLabel());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE1, cursus.getSemestre1());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE2, cursus.getSemestre2());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE3, cursus.getSemestre3());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE4, cursus.getSemestre4());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE5, cursus.getSemestre5());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE6, cursus.getSemestre6());

        Log.i(TAG + ":createCursus:t = ", tuple.toString());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(CURSUS_TABLE_NAME, null, tuple);
        db.close();
    }

    public Module getModule(String sigle) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from " + MODULE_TABLE_NAME + " where " + MODULE_ATTRIBUT_SIGLE + " = " + "'" + sigle + "'";
        Log.i(TAG + ":getModule:q = ", query);

        Cursor curseur = db.rawQuery(query, null);
        if (curseur != null) curseur.moveToFirst();

        Module tuple = new Module(null,null,null,0);
        tuple.setSigle(curseur.getString(curseur.getColumnIndex(MODULE_ATTRIBUT_SIGLE)));
        tuple.setCategorie(curseur.getString(curseur.getColumnIndex(MODULE_ATTRIBUT_CATEGORIE)));
        tuple.setParcours(curseur.getString(curseur.getColumnIndex(MODULE_ATTRIBUT_PARCOURS)));
        tuple.setCredit(curseur.getInt(curseur.getColumnIndex(MODULE_ATTRIBUT_CREDITS)));
        db.close();
        return tuple;
    }

    public Semestre getSemestre(int position) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from " + SEMESTRE_TABLE_NAME + " where " + SEMESTRE_ATTRIBUT_ID + " = " + "'" + position + "'";
        Log.i(TAG + ":getSemestre:q = ", query);

        Cursor curseur = db.rawQuery(query, null);
        if (curseur != null) curseur.moveToFirst();

        Semestre tuple = new Semestre(0,null,null,null,null,null,null,null);
        tuple.setSemstre(curseur.getInt(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_SEMESTRE)));
        tuple.setModule1(curseur.getString(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_MODULE1)));
        tuple.setModule2(curseur.getString(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_MODULE2)));
        tuple.setModule3(curseur.getString(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_MODULE3)));
        tuple.setModule4(curseur.getString(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_MODULE4)));
        tuple.setModule5(curseur.getString(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_MODULE5)));
        tuple.setModule6(curseur.getString(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_MODULE6)));
        tuple.setModule7(curseur.getString(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_MODULE7)));
        //db.close();
        return tuple;
    }

    public Cursus getCursus(String label) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from " + CURSUS_TABLE_NAME + " where " + CURSUS_ATTRIBUT_LABEL + " = " + "'" + label + "'";
        Log.i(TAG + ":getCursus:q = ", query);

        Cursor curseur = db.rawQuery(query, null);
        if (curseur != null) curseur.moveToFirst();

        Cursus tuple = new Cursus(null,0,0,0,0,0,0);
        tuple.setLabel(curseur.getString(curseur.getColumnIndex(CURSUS_ATTRIBUT_LABEL)));
        tuple.setSemestre1(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE1)));
        tuple.setSemestre2(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE2)));
        tuple.setSemestre3(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE3)));
        tuple.setSemestre4(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE4)));
        tuple.setSemestre5(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE5)));
        tuple.setSemestre6(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE6)));
        db.close();
        return tuple;
    }

    @SuppressLint("LongLogTag")
    public ArrayList<Module> getAllModules() {
        ArrayList<Module> listeModules = new ArrayList<Module>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from " + MODULE_TABLE_NAME;
        Log.i(TAG + ":getAllModules:q = ", query);

        Cursor curseur = db.rawQuery(query, null);
        if (curseur.moveToFirst()) {
            do {
                Module tuple = new Module(null,null,null,0);
                tuple.setSigle(curseur.getString(0));
                tuple.setCategorie(curseur.getString(1));
                tuple.setParcours(curseur.getString(2));
                tuple.setCredit(curseur.getInt(3));

                // Ajout du tuple de la base dans la liste résultat
                Log.i(TAG + ":getAllEtudiants:t = ", tuple.toString());
                listeModules.add(tuple);
            } while (curseur.moveToNext());
        }
        //db.close();
        return listeModules;
    }

    @SuppressLint("LongLogTag")
    public ArrayList<Cursus> getAllCursus() {
        ArrayList<Cursus> listeCursus = new ArrayList<Cursus>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from " + CURSUS_TABLE_NAME;
        Log.i(TAG + ":getAllCursus:q = ", query);

        Cursor curseur = db.rawQuery(query, null);
        if (curseur.moveToFirst()) {
            do {
                Cursus tuple  = new Cursus(null,0,0,0,0,0,0);
                tuple.setLabel(curseur.getString(curseur.getColumnIndex(CURSUS_ATTRIBUT_LABEL)));
                tuple.setSemestre1(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE1)));
                tuple.setSemestre2(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE2)));
                tuple.setSemestre3(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE3)));
                tuple.setSemestre4(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE4)));
                tuple.setSemestre5(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE5)));
                tuple.setSemestre6(curseur.getInt(curseur.getColumnIndex(CURSUS_ATTRIBUT_SEMESTRE6)));

                // Ajout du tuple de la base dans la liste résultat
                Log.i(TAG + ":getAllCursus:t = ", tuple.toString());
                listeCursus.add(tuple);
            } while (curseur.moveToNext());
        }
        db.close();
        return listeCursus;
    }

    @SuppressLint("LongLogTag")
    public int updateModule(Module module) {
        // preparation du ContentValue avec les data
        ContentValues tuple = new ContentValues();
        tuple.put(MODULE_ATTRIBUT_SIGLE, module.getSigle());
        tuple.put(MODULE_ATTRIBUT_CATEGORIE, module.getCategorie());
        tuple.put(MODULE_ATTRIBUT_PARCOURS, module.getParcours());
        tuple.put(MODULE_ATTRIBUT_CREDITS, module.getCredit());
        Log.i(TAG + ":updateEtudiant:t = ", tuple.toString());

        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.update(MODULE_TABLE_NAME, tuple,
                MODULE_ATTRIBUT_SIGLE + " = ?",
                new String[] { String.valueOf(module.getSigle()) });
        db.close();
        return result;
    }

    @SuppressLint("LongLogTag")
    public int updateCursus(Cursus cursus) {
        // preparation du ContentValue avec les data
        ContentValues tuple = new ContentValues();
        tuple.put(CURSUS_ATTRIBUT_LABEL, cursus.getLabel());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE1, cursus.getSemestre1());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE2, cursus.getSemestre2());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE3, cursus.getSemestre3());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE4, cursus.getSemestre4());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE5, cursus.getSemestre5());
        tuple.put(CURSUS_ATTRIBUT_SEMESTRE6, cursus.getSemestre6());
        Log.i(TAG + ":updateCurus:t = ", tuple.toString());

        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.update(CURSUS_TABLE_NAME, tuple,
                CURSUS_ATTRIBUT_LABEL + " = ?",
                new String[] { String.valueOf(cursus.getLabel()) });
        db.close();
        return result;
    }

    public void deleteModule(Module module) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MODULE_TABLE_NAME, MODULE_ATTRIBUT_SIGLE + " = ?",
                new String[] { String.valueOf(module.getSigle()) });
        db.close();
    }

    public int countModule() {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + MODULE_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        result = cursor.getCount();
        cursor.close();
        return result;
    }

    public void initModules() {
        ProgrammeISI isi = new ProgrammeISI();
        ArrayList<Module> data = isi.getModules();

        // insertion des tuples dans la table
        for (Module module : data) {
            createModule(module);
        }
    }

    public void initCursus() {
        Semestre semestre1_ko =  new Semestre(1, "GL02", "", "IF09", "", "LE03", "","");
        Semestre semestre2_ko =  new Semestre(2, "", "NF21", "", "IF03", "LE08", "GE21","");
        Semestre semestre3_kp =  new Semestre(3, "", "", "", "", "", "","TN09");
        Semestre semestre4_ko =  new Semestre(4, "IF05", "IF19", "", "IF22", "GE31", "","");
        Semestre semestre5_ko =  new Semestre(5, "", "IF15", "IF16", "", "LE11", "","");
        Semestre semestre6_ko =  new Semestre(6, "", "", "", "", "", "","TN10");
        this.createSemestre(semestre1_ko);
        this.createSemestre(semestre2_ko);
        this.createSemestre(semestre3_kp);
        this.createSemestre(semestre4_ko);
        this.createSemestre(semestre5_ko);
        this.createSemestre(semestre6_ko);
        Cursus cursus_1 = new Cursus("cursus_1",1,2,3,4,5,6);
        this.createCursus(cursus_1);

        Semestre semestre1_ok =  new Semestre(1, "GL02", "NF16", "IF09", "IF14", "LE03", "SO05","");
        Semestre semestre2_ok =  new Semestre(2, "NF20", "NF21", "LO02", "IF03", "LE08", "LO12","");
        Semestre semestre3_ok =  new Semestre(3, "", "", "", "", "", "","TN09");
        Semestre semestre4_ok =  new Semestre(4, "IF05", "IF19", "IF11", "IF22", "GE31", "SO10","");
        Semestre semestre5_ok =  new Semestre(5, "IF10", "IF15", "IF16", "IF17", "LE11", "GE34","");
        Semestre semestre6_ok =  new Semestre(6, "", "", "", "", "", "","TN10");
        this.createSemestre(semestre1_ok);
        this.createSemestre(semestre2_ok);
        this.createSemestre(semestre3_ok);
        this.createSemestre(semestre4_ok);
        this.createSemestre(semestre5_ok);
        this.createSemestre(semestre6_ok);
        Cursus cursus_2 = new Cursus("cursus_2",7,8,9,10,11,12);
        this.createCursus(cursus_2);
    }


    public int max(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select MAX(ID) as ID from " + SEMESTRE_TABLE_NAME;

        Cursor curseur = db.rawQuery(query, null);
        if (curseur != null) curseur.moveToFirst();

        int max;
        max = curseur.getInt(curseur.getColumnIndex(SEMESTRE_ATTRIBUT_ID));
        db.close();

        return max;
    }

}

