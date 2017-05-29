package com.example.slmns.demo;

/**
 * Created by MouNj on 5/29/2017.
 */
// Vi lavet en ny klasse som giver os tilladelse at gemme flere variabler i databasen.
public class ProfileUser {
    public  String firmaNavn,branche,fornavn,efterNavn,forNavn,adress,email,by;
    public String cvr,postNr;

    public ProfileUser(String firmaNavn, String branche, String fornavn, String efterNavn, String adress, String email, String by, String cvr, String postNr) {
        this.firmaNavn = firmaNavn;
        this.branche = branche;
        this.fornavn = fornavn;
        this.efterNavn = efterNavn;
        this.forNavn = forNavn;
        this.adress = adress;
        this.email = email;
        this.by = by;
        this.cvr = cvr;
        this.postNr = postNr;
    }

}
