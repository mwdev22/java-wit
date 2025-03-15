package pl.wit.lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest {
	
	private Point point;
    private final float step = 2.46f;
	
	@BeforeEach
	void setUp() {
		point = new Point(4.15f, 9.14f);
	}

	@Test
	void moveXTest() {
		// act
		point.moveX(step);
		
		// assert
		assertEquals(6.61f, point.getX());
	}
	
	@Test
	void moveYTest() {
		// act
		point.moveY(step);
		
		// assert
		assertEquals(11.6f, point.getY());
	}
	
	@Test
	void testAdd() {
		// arrange
		Point p = new Point(12.15f, 12.22f);
		Point pt = new Point(1.3f, 2.6f);
		
		// act
		p.add(pt);
		
		// assert
		assertEquals(13.45f, p.getX());
		assertEquals(14.82f, p.getY());
	}
	
	@Test
	void testAddNull() {
		// arrange
		Point p = new Point(12.15f, 12.22f);
		
		//act
		assertDoesNotThrow(() -> p.add(null));
		
		// assert
		assertEquals(12.15f, p.getX());
		assertEquals(12.22f, p.getY());
		
		
	}
	
	@Test
    void testSubtract() {
		// arrange
		Point p = new Point(5, 10);
        Point pt = new Point(3, 4);
        
        // act
        p.substract(pt);
        
        // assert
        assertEquals(2, p.getX());
        assertEquals(6, p.getY());
    }
    
    @Test
    void testSubtractNull() {
    	// arrange
    	Point p = new Point(5, 10);
    	
    	// act
        assertDoesNotThrow(() -> p.substract(null));
        
        // assert
        assertEquals(5, p.getX());
        assertEquals(10, p.getY());
    }
    
    @Test
    void testCreateAndAdd() {
        // arrange
    	Point p = new Point(4.55f, 3.1f);
        Point pt = new Point(12.2f, 8.4f);

        // act
        Point result = p.createAndAdd(pt);
        
        // assert
        assertNotNull(result);
        assertEquals(16.75f, result.getX());
        assertEquals(11.5f, result.getY());
        
        // initial point should stay unchanged
        assertEquals(4.55f, p.getX());
        assertEquals(3.1f, p.getY());
    }
    
    @Test
    void testCreateAndAddNull() {
    	// arrange
    	Point p = new Point(4.55f, 3.1f);
    	
    	// act
        Point result = p.createAndAdd(null);
        
        // assert
        assertNull(result);
        // same case, initial point should be the same
        assertEquals(4.55f, p.getX());
        assertEquals(3.1f, p.getY());
    }
    
   

}
