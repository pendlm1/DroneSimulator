package ch.makery.address.model;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import javafx.scene.paint.Color;

public class ContainerTester {

	@Test
	public void testToString() {
		Color co = new Color(0, 0, 0, 0);
		Container c = new Container("name", 0, null, 0, 0, 0, 0, 0, co);
		assertEquals(c.toString(), "Name: name, Price: 0.0, Length: 0.0, Width: 0.0, Height: 0.0, Color: 0x00000000, Location: (0,0) Items: []");
	}

	@Test
	public void testGetters() {
		Color co = new Color(0, 0, 0, 0);
		Container c = new Container("name", 1, null, 2, 3, 4, 5, 6, co);
		
		assertEquals(c.getColor(), new Color(0, 0, 0, 0));
		assertEquals(c.getHeight(), 6, 0.0000001);
		assertEquals(c.getWidth(), 5, 0.0000001);
		assertEquals(c.getLength(), 4, 0.000001);
		assertEquals(c.getLocationY(), 3);
		assertEquals(c.getLocationX(), 2);
		assertEquals(c.getPrice(), 1, 0.0000001);
		assertEquals(c.getName(), "name");
	}
	
	@Test
	public void testSetters() {
		Color co = new Color(0, 0, 0, 0);
		Color co2 = new Color(1, 1, 1, 1);
		Container c = new Container("name", 0, null, 0, 0, 0, 0, 0, co);
		
		c.setColor(co2);
		c.setName("new name");
		c.setHeight(6);
		c.setWidth(5);
		c.setLength(4);
		c.setLocationY(3);
		c.setLocationX(2);
		c.setPrice(1);
		
		assertEquals(c.getColor(), new Color(1, 1, 1, 1));
		assertEquals(c.getHeight(), 6, 0.0000001);
		assertEquals(c.getWidth(), 5, 0.0000001);
		assertEquals(c.getLength(), 4, 0.0000001);
		assertEquals(c.getLocationY(), 3);
		assertEquals(c.getLocationX(), 2);
		assertEquals(c.getPrice(), 1, 0.0000001);
		assertEquals(c.getName(), "new name");
		
		assertEquals(c.toString(), "Name: new name, Price: 1.0, Length: 4.0, Width: 5.0, Height: 6.0, Color: 0xffffffff, Location: (2,3) Items: []");
	}
	
	@Test
	public void testAddItem() {
		Color co = new Color(0, 0, 0, 0);
		Container c = new Container("name", 0, null, 0, 0, 0, 0, 0, co);
		Leaf l = new Leaf("just a name");
		c.addItem(l);
		assertEquals(c.toString(), "Name: name, Price: 0.0, Length: 0.0, Width: 0.0, Height: 0.0, Color: 0x00000000, Location: (0,0) Items: [Name: just a name, Price: 0.0, Length: 25.0, Width: 25.0, Height: 25.0, Color: null, Location: (0,0)]");
	}
	
	@Test
	public void testDeleteItem() {
		Color co = new Color(0, 0, 0, 0);
		Container c = new Container("name", 0, null, 0, 0, 0, 0, 0, co);
		Leaf l = new Leaf("just a name");
		c.addItem(l);
		c.deleteItem(l);
		assertEquals(c.toString(), "Name: name, Price: 0.0, Length: 0.0, Width: 0.0, Height: 0.0, Color: 0x00000000, Location: (0,0) Items: []");
	}
	
	@Test
	public void testGetTotalPrice() {
		Color co = new Color(0, 0, 0, 0);
		Container c = new Container("name", 0, null, 0, 0, 0, 0, 0, co);
		Leaf l1 = new Leaf("name1", 1, null, 0, 0, 0, 0, 0, co);
		Leaf l2 = new Leaf("name2", 2, null, 0, 0, 0, 0, 0, co);
		Leaf l3 = new Leaf("name3", 3, null, 0, 0, 0, 0, 0, co);
		c.addItem(l1);
		c.addItem(l2);
		c.addItem(l3);
		
		assertEquals(c.getTotalPrice(), 6, 0.0000001);
	}
	
	@Test
	public void testGetItemNames() {
		Color co = new Color(0, 0, 0, 0);
		Container c = new Container("name", 0, null, 0, 0, 0, 0, 0, co);
		Leaf l1 = new Leaf("name1", 1, null, 0, 0, 0, 0, 0, co);
		Leaf l2 = new Leaf("name2", 2, null, 0, 0, 0, 0, 0, co);
		Leaf l3 = new Leaf("name3", 3, null, 0, 0, 0, 0, 0, co);
		c.addItem(l1);
		c.addItem(l2);
		c.addItem(l3);
		
		//https://stackoverflow.com/a/2761019/9295513
		assertEquals(c.getItemNames(), new ArrayList<String>(Arrays.asList("name1", "name2", "name3")));
	}
	
	@Test
	public void testNesting() {
		Container c = new Container("egg");
		Leaf l1 = new Leaf("leaf");
		c.addItem(l1);
		
		Container cc = new Container("nest");
		cc.addItem(c);
		
		assertEquals(cc.toString(), "Name: nest, Price: 0.0, Length: 50.0, Width: 50.0, Height: 50.0, Color: null, Location: (0,0) Items: [Name: egg, Price: 0.0, Length: 50.0, Width: 50.0, Height: 50.0, Color: null, Location: (0,0) Items: [Name: leaf, Price: 0.0, Length: 25.0, Width: 25.0, Height: 25.0, Color: null, Location: (0,0)]]");
	}
	
}
