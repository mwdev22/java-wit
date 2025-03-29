package pl.wit.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PresentationTest {

    private Presentation presentation;

    // inicjalizacja przed każdym testem
    @BeforeEach
    void setUp() {
      
        presentation = new Presentation("Maciej", "Wojdyna", (byte) 8, (byte) 6, (short) 2002);
    }

    @Test
    void testConstructor() {
        assertNotNull(presentation);
        // testujemy działanie konstruktora dwuargumentowego, jest private więc
        // nie możemy się do niego odwołać bezpośrednio
        // moglibyśmy zmienić go z private na protected, ale treść zadania na to nie pozwala?
        assertEquals("Maciej Wojdyna", presentation.getFullName());
        // test działania pełnego konstruktora 5-argumentowego
        assertEquals("08.06.2002", presentation.getBirthdayDateAsString());
        assertEquals(22, presentation.getAge());
    }
    

    @Test
    void testGetFullName() {
        assertEquals("Maciej Wojdyna", presentation.getFullName());
    }
    

    @Test
    void testGetBirthdayDateAsString() {
        assertEquals("08.06.2002", presentation.getBirthdayDateAsString());
    }
    

    @Test
    void testGetAge() {
        assertEquals(22, presentation.getAge()); 
    }
    
//  sprawdzenie, czy wiek bedzie poprawnie obliczany po zmianie daty
    @Test
    void testGetAgeUpdate() {
    	assertEquals(22, presentation.getAge()); 
    	presentation.setBirthdayDay((byte) 8); 
        presentation.setBirthdayMonth((byte) 6);
        presentation.setBirthdayYear((short) 2000);
        assertEquals(24, presentation.getAge());
    	
    }
    
    

    @Test
    void testAddNewPlace() {
        presentation.addNewPlace("Warszawa");
        presentation.addNewPlace("Praga");
        assertEquals(2, presentation.getVisitedPlaces().length);
        assertEquals("Warszawa", presentation.getVisitedPlaces()[0]);
    }

    @Test
    void testGetPresentationStory() {
//    	setup podstawowych danych
        presentation.setPlaceOfBirth("Warszawa");
        presentation.setFacebookFriendsQuantity((short) 5000);
        presentation.addNewPlace("Warszawa");
        presentation.addNewPlace("Berlin");

//      sprawdzenie, czy historyjka zawiera odpowiednie łańcuchy znaków
        String story = presentation.getPresentationStory();
        System.out.println(story); 
        assertTrue(story.contains("Maciej Wojdyna"));
        assertTrue(story.contains("urodził(a) się w mieście Warszawa"));
        assertTrue(story.contains("i ukończył(a) 22 lat(a)"));
        assertTrue(story.contains("Ma bardzo wielu znajomych na Facebooku"));
        assertTrue(story.contains("Odwiedził(a) takie miejsca jak Warszawa i Berlin"));
    }
}
