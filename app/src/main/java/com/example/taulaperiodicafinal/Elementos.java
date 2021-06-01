package com.example.taulaperiodicafinal;

public class Elementos {

    private String SerieQuimica = " ";
    private String Atomic = " ";
    private String Lletra = " ";
    private String Nom = " ";
    private String Numero = " ";
    private String Pes = " ";
    private String Link = " ";




    public Elementos(String SerieQuimica, String Atomic, String Lletra, String Numero, String Nom, String Pes, String Link ){

        this.SerieQuimica = SerieQuimica;
        this.Atomic = Atomic;
        this.Lletra = Lletra;
        this.Nom = Nom;
        this.Numero = Numero;
        this.Pes = Pes;
        this.Link = Link;

    }

    public void setSerieQuimica(String SerieQuimica) {
        this.SerieQuimica = SerieQuimica;
    }

    public String getSerieQuimica() {
        return this.SerieQuimica;
    }

    public void setAtomic(String Atomic) {
        this.Atomic = Atomic;
    }

    public String getAtomic() {
        return this.Atomic;
    }

    public void setLletra(String Lletra) {
        this.Lletra = Lletra;
    }

    public String getLletra() {
        return this.Lletra;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getNom() {
        return this.Nom;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getNumero() {
        return this.Numero;
    }

    public void setPes(String Pes) {
        this.Pes = Pes;
    }

    public String getPes() {
        return this.Pes;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getLink() {
        return this.Link;
    }
}
