package pl.wit.lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lab2ArraysExampleTest {
    
    private Lab2ArraysExample intArray;
    private Lab2ArraysExample stringArray;
    private Lab2ArraysExample boolArray;

    @BeforeEach
    void setUp() {
        intArray = new Lab2ArraysExample(5);
        stringArray = new Lab2ArraysExample("Test");
        boolArray = new Lab2ArraysExample(true);
    }


    @Test
    void testAddElements() {
// 		int
        assertArrayEquals(new int[]{5}, intArray.getIntNumbers());
        intArray.addElement(2);
        assertArrayEquals(new int[]{5, 2}, intArray.getIntNumbers());
        intArray.addElement(5);
        assertArrayEquals(new int[]{5, 2, 5}, intArray.getIntNumbers());

// 		string
        assertArrayEquals(new String[] {"Test"}, stringArray.getStringElements());
        stringArray.addElement("test2");
        assertArrayEquals(new String[] {"Test", "test2"}, stringArray.getStringElements());
        stringArray.addElement("123");
        assertArrayEquals(new String[] {"Test", "test2", "123"}, stringArray.getStringElements());

//      bool  
        assertArrayEquals(new boolean[] {true}, boolArray.getBoolElements());
        boolArray.addElement(false);
        assertArrayEquals(new boolean[] {true, false}, boolArray.getBoolElements());
        boolArray.addElement(false);
        assertArrayEquals(new boolean[] {true, false, false}, boolArray.getBoolElements());
    }

    @Test
    void testGetArraySize() {
        assertEquals(1, intArray.getIntArraySize());
        assertEquals(1, stringArray.getStringArraySize());
        assertEquals(1, boolArray.getbooleanArraySize());
    }

    @Test
    void testPrintArraysToLog() {
        intArray.addElement(10);
        stringArray.addElement("Test 2");
        boolArray.addElement(false);

        assertDoesNotThrow(() -> intArray.printArraysToLog());
        assertDoesNotThrow(() -> stringArray.printArraysToLog());
        assertDoesNotThrow(() -> boolArray.printArraysToLog());
    }
    
    @Test
    void testGetArrayElement() {
    	assertEquals(5, intArray.getIntArrayElement(0));
    	
//    	sprawdzamy wyjątek przy index out of range
    	assertThrows(IndexOutOfBoundsException.class,() ->intArray.getIntArrayElement(10));;
    	
    	assertEquals("Test", stringArray.getStringArrayElement(0));
    	assertThrows(IndexOutOfBoundsException.class,()->stringArray.getStringArrayElement(100));
    	
    	assertEquals(true, boolArray.getBooleanArrayElement(0));
    	assertThrows(IndexOutOfBoundsException.class,()->boolArray.getBooleanArrayElement(13321));
    }

  
}
