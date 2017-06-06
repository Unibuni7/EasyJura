package com.example.slmns.demo;

import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rasmus laptop on 06/06/2017.
 */
public class FakturaActivityTest {
    @Test
    public void addTotalPrice() throws Exception {


        int input1 = 20;
        int input2 = 20;
        int expected = 40;
        int output;



        FakturaActivity fakturaActivity = new FakturaActivity();


        output = fakturaActivity.addTotalPrice(input1, input2);

        assertEquals(expected, output);
    }
    /**
     * Created by Dmitro 6/6/2017.
     */
    @Test
    public void subtractTotalPrice() throws Exception {

        int input1 = 30, input2 = 10, expected = 20, output;

        FakturaActivity fakturaActivity = new FakturaActivity();

        output = fakturaActivity.subtractTotalPrice(input1,input2);


        assertEquals(expected, output);



    }

}
