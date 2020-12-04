package ch.makery.address.model;


import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public abstract class Component{
	public abstract void deleteItem(Component c);
	public abstract void setName(String name);
	public abstract void setPrice(double price);
	public abstract void setLocationX (int x);
	public abstract void setLocationY (int y);
	public abstract void setLength (double length);
	public abstract void setWidth (double width);
	public abstract void setHeight (double height);
	public abstract void setColor (Color color);
	public abstract double getPrice();
	public abstract int getLocationX();
	public abstract int getLocationY();
	public abstract double getLength();
	public abstract double getWidth();
	public abstract double getHeight();
	public abstract String getName();
	public abstract Color getColor();
	public abstract ImageView getImage();
	public abstract void setImage(ImageView image);
	public abstract double accept(Visitor v);
	
}
