package com;

public class Customer {
    String Nom, Prenom, CIN, SF;
    int Age, NbrEnfant;
    double Salaire, Depense;

    public Customer(){
        Nom = "";
        Prenom = "";
        CIN = "";
        SF = "";
        Age = 0;
        NbrEnfant = 0;
        Salaire = 0.0;
        Depense = 0.0;
    }

    public Customer( String _Nom , String _Prenom , String _Cin , int _Age){
        Nom = _Nom;
        Prenom = _Prenom;
        CIN = _Cin;
        SF = "";
        Age = _Age;
        NbrEnfant = 0;
        Salaire = 0.0;
        Depense = 0.0;
    }

    public Customer( Customer newCustomer ){
        Nom = newCustomer.getNom();
        Prenom = newCustomer.getPrenom();
        CIN = newCustomer.getCIN();
        SF = newCustomer.getSF();
        Age = newCustomer.getAge();
        NbrEnfant = newCustomer.getNbrEnfant();
        Salaire = newCustomer.getSalaire();
        Depense = newCustomer.getDepense();
    }

    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
    public String getCIN() {
        return CIN;
    }
    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
    public String getSF() {
        return SF;
    }
    public void setSF(String SF) {
        this.SF = SF;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public int getNbrEnfant() {
        return NbrEnfant;
    }
    public void setNbrEnfant(int nbrEnfant) {
        NbrEnfant = nbrEnfant;
    }
    public double getSalaire() {
        return Salaire;
    }
    public void setSalaire(double salaire) {
        Salaire = salaire;
    }
    public double getDepense() {
        return Depense;
    }
    public void setDepense(double depense) {
        Depense = depense;
    }
}
