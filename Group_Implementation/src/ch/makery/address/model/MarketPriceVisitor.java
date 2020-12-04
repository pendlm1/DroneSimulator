package ch.makery.address.model;

import java.util.ArrayList;
import java.util.Iterator;

public class MarketPriceVisitor implements Visitor{
	private double marketValue;
	
	public MarketPriceVisitor() {
		marketValue = 0;
	}
	public MarketPriceVisitor(double price) {
		this.marketValue = price;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double price) {
		this.marketValue = price;
	}
	public double getTotalMarketValue(Container c) {
		Iterator<Component> i = c.getItems().iterator();
		double total = marketValue;
		while(i.hasNext()) {
			Component c1 = (Component)i.next();
			total += c1.accept(this);
		}
		return total;
		
	}	
	@Override
	public double visit(Component c) {
		return marketValue;
		
	}
	public double containerValue(Container c) {
		return marketValue += c.accept(this);
		}
	public double  Value() {
		return marketValue;
		
		}
		
	}
	

