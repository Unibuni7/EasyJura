package com.example.slmns.demo;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created by MouNj on 6/5/2017.
 */
public class ProfileUserTest  {
@Test
        public void profileUser(){

    String firmaNavn="Aldi",branche="nil",Fornavn="Dima",efterNavn="niles",
    adress="solparken", email="a@hotmail.com", by="Næstved", cvr="222",postNr="4700";

    String [] testExpected={firmaNavn,branche,Fornavn,efterNavn,adress,email,by,cvr,postNr};

    ProfileUser profile1 = new ProfileUser(firmaNavn,branche,Fornavn,efterNavn,adress,email,by,cvr,postNr);

    String [] testoutput={profile1.firmaNavn,profile1.branche,profile1.Fornavn
     ,profile1.efterNavn,profile1.adress,profile1.email,profile1.by,profile1.cvr,profile1.postNr};



   // Checks that the object is notnull.
    assertNotNull("Checks that the object is notnull",profile1);

}}