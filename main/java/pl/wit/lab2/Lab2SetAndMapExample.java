package pl.wit.lab2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * Klasa z przykładami metod operującymi na HashMapie i HashSet
 * @author 
 *
 */
public class Lab2SetAndMapExample {
	private Set<String> setCars = null;
	private Map<String, Integer> mapCarPower=null;
	
	private static final Logger log = LogManager.getLogger(Lab2SetAndMapExample.class.getName());
//	konstruktor
	public Lab2SetAndMapExample() {
		setCars = new HashSet<String>();
		mapCarPower = new HashMap<String, Integer>();
		
	}
	
//	wyświetlanie elementów hashmapy oraz hashsetu
	public void printSetToLog() {
		if(setCars!=null) {
			for(String el:setCars)
				log.info(""+el+", ");
		} 
	}
	
	public void printMapToLog() {
		if (mapCarPower != null) {
			for (String el : mapCarPower.keySet())
				log.info("" + el + "=" + mapCarPower.get(el) + ",");
		} 
	}
	
	public void addElement(String element) {
		if (setCars != null)
			setCars.add(element);
	}

	public void addElement(String key, Integer value) {
		if (mapCarPower != null)
			mapCarPower.put(key, value);
	}
	
	public Integer getMapValue(String key) {
		if (mapCarPower != null) {
			if (mapCarPower.containsKey(key))
				return mapCarPower.get(key);
		}
//		fallback value
		return -1;	
	}
	
	public boolean isSetContains(String element) {
		return setCars != null && setCars.contains(element);
	}
	
//	GETTERY I SETTERY
	public Set<String> getSetCars() {
		return setCars;
	}
	public void setSetCars(Set<String> setCars) {
		this.setCars = setCars;
	}
	public Map<String, Integer> getMapCarPower() {
		return mapCarPower;
	}
	public void setMapCarPower(Map<String, Integer> mapCarPower) {
		this.mapCarPower = mapCarPower;
	}
	
}
