package com.example.slmns.demo;

/**
 * Created by MouNj on 5/29/2017.
 */
// Vi lavet en ny klasse som giver os tilladelse at gemme flere variabler i databasen.
public class ProfileUser {
    public  String firmaNavn, branche, fornavn, efterNavn, adress, email, by, cvr, postNr;

    // Empty constructor, initialize ProfileUser object.
    public ProfileUser() {
        this.firmaNavn = "";
        this.branche = "";
        this.fornavn = "";
        this.efterNavn = "";
        this.adress = "";
        this.email = "";
        this.by = "";
        this.cvr = "";
        this.postNr = "";
    }

    public ProfileUser(String firmaNavn, String branche, String fornavn, String efterNavn,
                       String adress, String email, String by, String cvr, String postNr) {
        this.firmaNavn = firmaNavn;
        this.branche = branche;
        this.fornavn = fornavn;
        this.efterNavn = efterNavn;
        this.adress = adress;
        this.email = email;
        this.by = by;
        this.cvr = cvr;
        this.postNr = postNr;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfterNavn() {
        return efterNavn;
    }

    public void setEfterNavn(String efterNavn) {
        this.efterNavn = efterNavn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getPostNr() {
        return postNr;
    }

    public void setPostNr(String postNr) {
        this.postNr = postNr;
    }
}
