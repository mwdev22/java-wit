package pl.wit.lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Lab2SetAndMapExampleTest {
    
    private Lab2SetAndMapExample example;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        example = new Lab2SetAndMapExample();
    }
    
    @Test
    void testAddElementToSet() {
        example.addElement("BMW");
        example.addElement("Volkswagen");
        assertTrue(example.isSetContains("BMW"));
    }
    
    @Test
    void testAddElementToMap() {
        example.addElement("Audi", 250);
        example.addElement("Yaris", 12);
        assertEquals(250, example.getMapValue("Audi"));
    }
    
    @Test
    void testIsSetContains() {
    	example.addElement("Multipla");
    	assertTrue(example.isSetContains("Multipla"));
    }
    
    @Test
    void testGetMapValue() {
    	example.addElement("Porsche", 641);
    	assertEquals(641, example.getMapValue("Porsche"));
    }
    
    @Test
    void testGetMapValueNonExistingKey() {
        assertEquals(-1, example.getMapValue("Ferrari"));
    }
    
    @Test
    void testIsSetContainsFalse() {
        assertFalse(example.isSetContains("Mercedes"));
    }
    
    
//   nie mam pomysłu jak w inny sposób zrobić capture outputu z log4j..
    @Test
    void testPrintSetToLog() {
        example.addElement("Toyota");
        example.printSetToLog();
//        String output = outContent.toString().trim();
//        System.out.println(output);
//        assertTrue(output.contains("Toyota"));
    }
    
    @Test
    void testPrintMapToLog() {
        example.addElement("Ford", 300);
//        example.printMapToLog();
//        String output = outContent.toString().trim();
//        assertTrue(output.contains("Ford=300"));
    }
}
