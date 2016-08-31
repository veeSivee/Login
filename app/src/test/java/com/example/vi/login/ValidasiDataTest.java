package com.example.vi.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by taufiqotulfaidah on 8/31/16.
 */
public class ValidasiDataTest {

    ValidasiData validasiData;

    @Before
    public void setUp() throws Exception {
        validasiData = new ValidasiData();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsDataNotNull() throws Exception {
        Boolean data = validasiData.isDataNotNull("Tes");
        Boolean exp = true;

        //assertTrue(data);
        assertEquals(exp,data);
    }

    @Test
    public void testIsEmailValid() throws Exception {

    }

    @Test
    public void testIsAccountValid() throws Exception {

    }
}