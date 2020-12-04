package ch.makery.address.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class MarketPriceVisitorTester {
	@Test
	public void testMarketValue() {
		MarketPriceVisitor mpv = new MarketPriceVisitor();
		assertEquals(mpv.getMarketValue(), 0, 0.0000001);
	}
	@Test
	public void testSet() {
		MarketPriceVisitor mpv = new MarketPriceVisitor();
		mpv.setMarketValue(20.45);
		assertEquals(mpv.getMarketValue(), 20.45, 0.0000001);
	}
	@Test
	public void testVisit() {
		MarketPriceVisitor mpv = new MarketPriceVisitor();
		Leaf l = new Leaf(null, 0.50, null, 0, 0, 0, 0, 0, null);
		mpv.visit(l);
		assertEquals(mpv.getMarketValue(), 0.5, 0.0000001);
	}
	@Test
	public void testContainerValue() {
		Container c = new Container(null, 0.5, null, 0, 0, 0, 0, 0, null);
		MarketPriceVisitor mpv = new MarketPriceVisitor();
		assertEquals(mpv.containerValue(c), 0.5, 0.0000001);
	}
	public void testValue() {
		MarketPriceVisitor mpv = new MarketPriceVisitor();
		mpv.setMarketValue(1);
		assertEquals(mpv.getMarketValue(), 0.9, 0.0000001);
	}
}
