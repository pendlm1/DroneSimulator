package ch.makery.address.model;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import javafx.scene.paint.Color;

public class LeafTester {
	@Test
	public void testToString() {
		Color co = new Color(0, 0, 0, 0);
		Leaf l = new Leaf("name", 0, null, 0, 0, 0, 0, 0, co);
		assertEquals(l.toString(), "Name: name, Price: 0.0, Length: 0.0, Width: 0.0, Height: 0.0, Color: 0x00000000, Location: (0,0)");	
	}

	@Test
	public void testGetters() {
		Color co = new Color(0, 0, 0, 0);
		Leaf l = new Leaf("name", 1, null, 2, 3, 4, 5, 6, co);
		
		assertEquals(l.getColor(), new Color(0, 0, 0, 0));
		assertEquals(l.getHeight(), 6, 0.0000001);
		assertEquals(l.getWidth(), 5, 0.0000001);
		assertEquals(l.getLength(), 4, 0.000001);
		assertEquals(l.getLocationY(), 3);
		assertEquals(l.getLocationX(), 2);
		assertEquals(l.getPrice(), 1, 0.0000001);
		assertEquals(l.getName(), "name");
	}
	
	@Test
	public void testSetters() {
		Color co = new Color(0, 0, 0, 0);
		Color co2 = new Color(1, 1, 1, 1);
		Leaf l = new Leaf("name", 0, null, 0, 0, 0, 0, 0, co);
		
		l.setColor(co2);
		l.setName("new name");
		l.setHeight(6);
		l.setWidth(5);
		l.setLength(4);
		l.setLocationY(3);
		l.setLocationX(2);
		l.setPrice(1);
		
		assertEquals(l.getColor(), new Color(1, 1, 1, 1));
		assertEquals(l.getHeight(), 6, 0.0000001);
		assertEquals(l.getWidth(), 5, 0.0000001);
		assertEquals(l.getLength(), 4, 0.0000001);
		assertEquals(l.getLocationY(), 3);
		assertEquals(l.getLocationX(), 2);
		assertEquals(l.getPrice(), 1, 0.0000001);
		assertEquals(l.getName(), "new name");
		
		assertEquals(l.toString(), "Name: new name, Price: 1.0, Length: 4.0, Width: 5.0, Height: 6.0, Color: 0xffffffff, Location: (2,3)");
	}
	
	@Test
	public void testVisit() {
		Leaf l = new Leaf("name", 0.5, null, 0, 0, 0, 0, 0, null);
		MarketPriceVisitor mpv = new MarketPriceVisitor();
		l.accept(mpv);
		assertEquals(mpv.getMarketValue(), 0.5, 0.0000001);
	}
}
