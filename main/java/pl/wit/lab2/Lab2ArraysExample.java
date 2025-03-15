/**
 * 
 */
package pl.wit.lab2;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** 
 * Klasa z przykładami metod operującymi na tablicach
 * @author mwdev22
 *
 */
public class Lab2ArraysExample {
	
	protected static final Logger Log =
			LogManager.getLogger(Lab2ArraysExample.class.getName());
	
	private int intNumbers[]=null;
	private String stringElements[]=null;
	private boolean boolElements[]=null;
	
//	konstruktor prywatny, bezparametryczny
	private Lab2ArraysExample() {
		intNumbers = new int[0];
		stringElements = new String[0];
		boolElements = new boolean[0];		
	}
	
//	konstruktory parametryczne
	public Lab2ArraysExample(int intValue) {
		this();
		intNumbers = Arrays.copyOf(intNumbers, 1);
		intNumbers[0] = intValue;
	}
	
	public Lab2ArraysExample(String strValue) {
		this();
		stringElements = Arrays.copyOf(stringElements, 1);
		stringElements[0] = strValue;
	}
	
	public Lab2ArraysExample(boolean boolValue) {
		this();
		boolElements = Arrays.copyOf(boolElements,1);
		boolElements[0] = boolValue;
	}
	
//	metoda wyświetlająca elementy w tablicach
	public void printArraysToLog() {
		if (intNumbers!= null) {
			for (int el:intNumbers) {
				Log.info(""+el+", ");
			}
		}
		
		if (stringElements!= null) {
			for (String el:stringElements) {
				Log.info(""+el+", ");
			}
		}
		
		if (intNumbers!= null) {
			for (boolean el:boolElements) {
				Log.info(""+el+", ");
			}
		}
	}
	
//	metody dodające element do danej tablicy
	public void addElement(int element) {
		intNumbers = Arrays.copyOf(intNumbers, intNumbers.length+1);
		intNumbers[intNumbers.length - 1] = element;
		}
	
	public void addElement(String element) {
		stringElements = Arrays.copyOf(stringElements, stringElements.length + 1);
		stringElements[stringElements.length - 1] = element;
	}
	
	public void addElement(boolean element) {
		boolElements = Arrays.copyOf(boolElements, boolElements.length + 1);
		boolElements[boolElements.length - 1] = element;
	}
	
//	metody pobierające element z tablicy pod odpowiednim indeksem
	public int getIntArrayElement(int index) {
		if (intNumbers == null) {
	        throw new IllegalStateException("tablica intNumbers nie została zainicjalizowana.");
	    }
	    if (index < 0 || index >= intNumbers.length) {
	        throw new IndexOutOfBoundsException("nieprawidłowy index: " + index);
	    }
	    
	    return intNumbers[index];
	}

	public String getStringArrayElement(int index) {
		if (stringElements == null) {
	        throw new IllegalStateException("tablica stringElements nie została zainicjalizowana.");
	    }
	    if (index < 0 || index >= stringElements.length) {
	        throw new IndexOutOfBoundsException("nieprawidłowy index: " + index);
	    }
	    return stringElements[index];
	}

	public boolean getBooleanArrayElement(int index) {
	    if (boolElements == null) {
	        throw new IllegalStateException("tablica boolElements nie została zainicjalizowana.");
	    }
	    if (index < 0 || index >= boolElements.length) {
	        throw new IndexOutOfBoundsException("nieprawidłowy index: " + index);
	    }
	    return boolElements[index];
	}

//	metody zwracające rozmiary tablic
	public int getIntArraySize() {
		if (intNumbers != null)
			return intNumbers.length;
		else 
			return -1;
	}
	public int getStringArraySize() {
		if (stringElements != null)
			return stringElements.length;
		else 
			return -1;
	}
	
	public int getbooleanArraySize() {
		if (boolElements != null)
			return boolElements.length;
		else 
			return -1;
	}
	
	
	
	public int[] getIntNumbers() {
		return intNumbers;
	}
	public String[] getStringElements() {
		return stringElements;
	}
	public boolean[] getBoolElements() {
		return boolElements;
	}
	
	
	

}
