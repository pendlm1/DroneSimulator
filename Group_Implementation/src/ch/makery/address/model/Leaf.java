package ch.makery.address.model;
 
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class Leaf extends Component{
	private String name = null;
	private double price = 0.00;
	private int location_x = 0;
	private int location_y = 0;
	private double length = 25.0;
	private double width = 25.0;
	private double height = 25.0;
	private Color color;
	private ImageView image;
	
	
	// Constructor | Called when "+ add Item" is clicked giving an empty Item at the origin.
	public Leaf(String name) {
		this.name = name;
	}
	public Leaf(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public Leaf(String name, ImageView image) {
		this.name = name;
		this.image = image;
	}
	public Leaf(String name, ImageView image, int location_x, int location_y, double length, double width, double height) {
		this.name = name;
		this.image = image;
		this.location_x = location_x;
		this.location_y = location_y;
		this.length = length;
		this.width = width;
		this.height = height;		
	}
	public Leaf(String name, double price, ImageView image, int location_x, int location_y, double length, double width, double height, Color color) {
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
	public ImageView getImage() {
		return this.image;
	}
	
	// Setters ----------------------------------------------------------------------------------------
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setLocationX(int location_x) {
		this.location_x = location_x;
	}
	public void setLocationY(int location_y) {
		this.location_y = location_y;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void deleteItem(Component c) {	
	}
	
//Methods -----------------------------------------------------------------------------------------------
	public String toString() {
		return "Name: "+name+", Price: "+ price+ ", Length: "+length+", Width: "+width+", Height: "+height+", Color: "+color+", Location: "+"("+location_x +","+ location_y+")";
	}
	public void setImage(ImageView image) {
		this.image = image;
	}
	@Override
	public double accept(Visitor v) {
		return v.visit(this);
		
	}

}
