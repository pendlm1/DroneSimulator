package ch.makery.address.model;

import java.util.Iterator;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Container extends Component{
	private String name = null;
	private double price = 0.00; //Watch it; doubles still are subject to fp errors, not that that's
	private int location_x = 0; //relevant to our purposes; this code'll never see prod anyway
	private int location_y = 0;
	private double length = 50.0;
	private double width = 50.0;
	private double height = 50.0;
	private Color color = null;
	private ArrayList<Component> items = new ArrayList<Component>();
	private ImageView image;
	
	
	
	public Container(String name) {
		this.name = name;
	}
	public Container(String name, ArrayList<Component> items) {
		this.name = name;
		this.items = items;
	}
	public Container(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public Container(String name, ImageView image) {
		this.name = name;
		this.image = image;
	}
	public Container(String name, ImageView image, int location_x, int location_y, double length, double width, double height) {
		this.name = name;
		this.image = image;
		this.location_x = location_x;
		this.location_y = location_y;
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public Container(String name, double price, ImageView image, int location_x, int location_y, double length, double width, double height, Color color) {
		this.name = name;
		this.price = price;
		this.location_x = location_x;
		this.location_y = location_y;
		this.length = length;
		this.width = width;
		this.height = height;
		this.color = color;
		this.image = image;
	}
	
//Methods ________________________________________________________________________________________
	public String toString() {
		return "Name: "+name+", Price: "+ price+ ", Length: "+length+", Width: "+width+", Height: "+height+", Color: "
	+color+", Location: "+"("+location_x +","+ location_y+")"+" Items: "+items;
	}
	public void deleteContainer(){

	}
	public void deleteItem(Component item){
		items.remove(item);	
	}
	public void addItem(Component leaf) {
		items.add(leaf);
	}
	public ArrayList<String> getItemNames(){
		Iterator<Component> i = items.iterator();
		ArrayList<String> names = new ArrayList<String>();
		while(i.hasNext()) {
			Component c = (Component)i.next();
			names.add(c.getName());
		}
		return names;
	}
	public double getTotalPrice(){
		Iterator<Component> i = items.iterator();
		double total = price;
		while(i.hasNext()) {
			Component c = (Component)i.next();
			total += c.getPrice();
		}
		return total;
	}
//Getters -----------------------------------------------------------------------------------------
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public int getLocationX() {
		return this.location_x;
	}
	public int getLocationY() {
		return this.location_y;
	}
	public double getLength() {
		return this.length;
	}
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	
	public Color getColor() {
		return this.color;
	}
	public ArrayList<Component> getItems() {
		return this.items;
	}
	public ImageView getImage() {
		return this.image;
	}

//setters____________________________________________________________________________________________
	public void setName(String name){
		this.name = name;	
	}
	public void setPrice(double price){
		this.price = price;	
	}
	public void setLocationX (int location_x){
		this.location_x = location_x;
	}
	public void setLocationY (int location_y){
		this.location_y = location_y;	
	}
	public void setLength (double length) {
		this.length = length;
	}
	public void setWidth (double width) {
		this.width = width;	
	}
	public void setHeight (double height){
		this.height = height;
	}
	public void setColor (Color color) {
		this.color = color;
	}
	public void setImage(ImageView image) {
		this.image = image;
		
	}
	@Override
	public double accept(Visitor v) {
		return v.visit(this);		
	}

}
