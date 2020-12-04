 package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

import ch.makery.address.MainApp;
import ch.makery.address.model.Leaf;
import ch.makery.address.model.MarketPriceVisitor;
import ch.makery.address.model.Component;
import ch.makery.address.model.Container;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.animation.TranslateTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.SequentialTransition;

/**
 * This Object should have the SingleTon in it!!!!
 */
public class FarmLandOverviewController  {
	private Leaf myDrone;
	private ArrayList<Component> myComponents = new ArrayList<Component>();
	private SequentialTransition st = new SequentialTransition();
	private double picX;
	private double picY;
	boolean okClicked;
	
	
	@FXML Pane root;
	@FXML ImageView windowView;
	@FXML private ImageView drone;
	@FXML private GridPane containers;
	
//Containers
	@FXML private ImageView barnHouse;
	@FXML private ImageView silo;
	@FXML private ImageView building;
	@FXML private ImageView barnHouse2;
	@FXML private ImageView house1;
	@FXML private ImageView field;
	@FXML private ImageView house2;
	@FXML private ImageView storage;
	@FXML private ImageView golfCourse;
	@FXML private ImageView windmillHouse;
	@FXML private ImageView sea; 
	@FXML private ImageView road;

//leaves
	@FXML private ImageView bear;
	@FXML private ImageView bull;
	@FXML private ImageView camel;
	@FXML private ImageView cat;
	@FXML private ImageView chick;
	@FXML private ImageView hen;
	@FXML private ImageView rooster;
	@FXML private ImageView cow;
	@FXML private ImageView deer;
	@FXML private ImageView dog;
	@FXML private ImageView duck;
	@FXML private ImageView fish;
	@FXML private ImageView fox;
	@FXML private ImageView giraffe;
	@FXML private ImageView goat;
	@FXML private ImageView horse;
	@FXML private ImageView kangaroo;
	@FXML private ImageView mouse;
	@FXML private ImageView owl;
	@FXML private ImageView peacock;
	@FXML private ImageView pig;
	@FXML private ImageView rabbit;
	@FXML private ImageView sheep;
	@FXML private ImageView snake;
	@FXML private ImageView swan;
	@FXML private ImageView turkey;
	@FXML private ImageView wolf;
	@FXML private ImageView zebra;
	@FXML private ImageView apple;
	@FXML private ImageView banana;
	@FXML private ImageView blueberry;
	@FXML private ImageView cherries;
	@FXML private ImageView coffeeBeans;
	@FXML private ImageView corn;
	@FXML private ImageView eggplant;
	@FXML private ImageView grapes;
	@FXML private ImageView leaf;
	@FXML private ImageView lemon;
	@FXML private ImageView acorn;
	@FXML private ImageView orange;
	@FXML private ImageView peach;
	@FXML private ImageView pepper;
	@FXML private ImageView pineapple;
	@FXML private ImageView pumpkin;
	@FXML private ImageView seeds;
	@FXML private ImageView strawberry;
	@FXML private ImageView tree1;
	@FXML private ImageView tree2;
	@FXML private ImageView vegetables;
	@FXML private ImageView watermellon;
	@FXML private ImageView wheat;
	@FXML private ImageView waterPot;
	@FXML private ImageView screwDriver;
	@FXML private ImageView airplane;
	@FXML private ImageView tools;
	@FXML private ImageView hammer;
	@FXML private ImageView boat;
	@FXML private ImageView car;
	@FXML private ImageView tractor;
	@FXML private ImageView loaderTractor;
	@FXML private ImageView truck;
	@FXML private ImageView USA;
	@FXML private ImageView court;
	@FXML private ImageView desert;
	@FXML private ImageView island;
	@FXML private ImageView mountain;
	@FXML private ImageView mountains;
	@FXML private ImageView volcano;
	@FXML private ImageView field2;
	@FXML private ImageView roadfork;
	@FXML private TitledPane myItems;
	@FXML private TitledPane myContainers;
	@FXML private TitledPane myBackgrounds;
	
	 
//buttons
	@FXML private ColorPicker color;
	@FXML private Button flyto;
	@FXML private Label itemInfo;
	@FXML private Button scan;
	@FXML private Button deleteComp;
	@FXML private TextField name;
	@FXML private TextField Xpos;
	@FXML private TextField Ypos;
	@FXML private TextField length;
	@FXML private TextField width;
	@FXML private TextField height;
	@FXML private TextField price;
	@FXML private TextField marketPrice;
	@FXML private CheckBox isContainer;
	@FXML private Button submitComp;
	@FXML private  Button addToContainer;
	
	private TranslateTransition transition;
	
	
	// Reference call to main application
	private MainApp mainApp;
	
	
	
// SingleTon Stuff --------------------------------------------------------------------------------
	// Static var to check if an instance has been initiated.
	private static FarmLandOverviewController single_instance=null;
	/**
	 * Private constructor restricted to the class itself is needed in order to ensure Singleton
	 */
	private FarmLandOverviewController() {
	}
	
	public static FarmLandOverviewController FLOController() {
		if(single_instance == null) {
			single_instance = new FarmLandOverviewController();
		}
		return single_instance;
	}
	
	public void hideCheckBox() {
		isContainer.setVisible(false);
		isContainer.setSelected(false);
		marketPrice.setVisible(true);	
		
	}
	
	public void hideMarketPrice() {
		if(marketPrice.isVisible()){
			marketPrice.setVisible(false);
		}
		else {
			marketPrice.setVisible(true);
			
		}
	}
	
	public void showCheckBox() {
		isContainer.setVisible(true);
		isContainer.setSelected(true);
		marketPrice.setVisible(false);
		marketPrice.setText("0");
		
	}
	// Adds the drone to the root Pane
	@FXML
	private void addDrone() {
		if (myDrone == null) {
		Color c = Color.BLACK;
		ImageView v = new ImageView(drone.getImage());
		myDrone = new Leaf("DJI Phantom 4 RTK",8419,v,0,0,50,50,50,c);
		root.getChildren().add(myDrone.getImage());
		myDrone.getImage().setX(myDrone.getLocationX());
		myDrone.getImage().setY(myDrone.getLocationY());
		myDrone.getImage().setFitWidth(myDrone.getWidth());
		myDrone.getImage().setFitHeight(myDrone.getHeight());
		}
	}
	// Moves the Drone to a (x,y) based on a pictures location
	@FXML
	private void droneGoTo() {
		
		transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(3));
		transition.setToX(picX);
		transition.setToY(picY);
		transition.setAutoReverse(true);
		transition.setCycleCount(2);
		transition.setNode(myDrone.getImage());
		transition.play();
		
	}
	
	//Sends the drone to all ImageView locations by iterating a list of components and back to it's original location
	@FXML
	private void droneGoToAll(){
		Iterator<Component> i = myComponents.iterator();
		while(i.hasNext()) {
			Component c = (Component)i.next();
			Timeline timeline = new Timeline();
			timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000),
					new KeyValue (myDrone.getImage().translateXProperty(), c.getLocationX())));
			timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000),
					new KeyValue (myDrone.getImage().translateYProperty(), c.getLocationY())));
			timeline.setCycleCount(1);
			timeline.setAutoReverse(false);
			st.getChildren().add(timeline);
		}
		st.setCycleCount(2);
		st.setAutoReverse(true);
		st.play();
		st.getChildren().clear();
	}
	
	/**
	 * Ensures input data is correct, activates the clickable drone image,
	 * Instantiates a component and places it image on the pane,
	 * makes the delete and travel to button usable.   
	 */
	@FXML
	private void submitItem() {
		ImageView v;
		
		if(isVaildInput()) {
			//makes the drone image active
			drone.setDisable(false);
		//Ha	
		if(isContainer.isSelected()) {
			System.out.println("this item is a container");
			v = new ImageView(windowView.getImage());
			Container container = new Container(name.getText(), Double.parseDouble(price.getText()),v,Integer.parseInt(Xpos.getText()),Integer.parseInt(Ypos.getText()),
					Double.parseDouble(length.getText()),Double.parseDouble(width.getText()),Double.parseDouble(height.getText()), color.getValue());
			
			root.getChildren().add(container.getImage());
			container.getImage().setX(container.getLocationX());
			container.getImage().setY(container.getLocationY());
			container.getImage().setFitWidth(container.getWidth());
			container.getImage().setFitHeight(container.getHeight());
			container.getImage().setOnMouseClicked(event ->{
				
				if(event.getClickCount() == 1) {
				
				picX = container.getImage().getX();
				picY = container.getImage().getY();System.out.println(picX+","+picY);
					deleteComp.setOnMouseClicked(e ->{myComponents.remove(container);
						container.getImage().imageProperty().set(null);picX=0;picY=0;
						itemInfo.setText("");
						addToContainer.setVisible(false);});
					addToContainer.setVisible(true);
					addToContainer.setOnMouseClicked(e ->{
						Container c;
						c = new Container(name.getText(), Double.parseDouble(price.getText()),v,Integer.parseInt(Xpos.getText()),Integer.parseInt(Ypos.getText()),
								Double.parseDouble(length.getText()),Double.parseDouble(width.getText()),Double.parseDouble(height.getText()), color.getValue());
								container.addItem(c);
								System.out.println(container.getItems());});
					
					MarketPriceVisitor mp = new MarketPriceVisitor();
					container.accept(mp);
					mp.setMarketValue(Double.parseDouble(price.getText()));
					System.out.println("MarketVale: " +mp.getMarketValue());
					
				
					itemInfo.setText("Name: "+container.getName()+" Price: "+container.getTotalPrice()+" Market Value: "+(mp.getTotalMarketValue(container)-mp.getMarketValue()));
					System.out.println(itemInfo.getText());
					
					
					
				}
				if(event.getClickCount() == 2) {
					addToContainer.setVisible(false);		
				}
				
			});					
			myComponents.add(container);
			
			
			
		}
		else{
			System.out.println("this item is not a container");
			v = new ImageView(windowView.getImage());
			Leaf leaf = new Leaf(name.getText(), Double.parseDouble(price.getText()),v,Integer.parseInt(Xpos.getText()),Integer.parseInt(Ypos.getText()),
					Double.parseDouble(length.getText()),Double.parseDouble(width.getText()),Double.parseDouble(height.getText()), color.getValue());
			
			root.getChildren().add(leaf.getImage());
			leaf.getImage().setX(leaf.getLocationX());
			leaf.getImage().setY(leaf.getLocationY());
			leaf.getImage().setFitWidth(leaf.getWidth());
			leaf.getImage().setFitHeight(leaf.getHeight());
			leaf.getImage().setOnMouseClicked(event ->{picX = leaf.getImage().getX();
				picY = leaf.getImage().getY();System.out.println(picX+","+picY);
					deleteComp.setOnMouseClicked(e ->{myComponents.remove(leaf);
						leaf.getImage().imageProperty().set(null);picX=0;picY=0;});
					MarketPriceVisitor mpv = new MarketPriceVisitor();
					leaf.accept(mpv);
					mpv.setMarketValue(Double.parseDouble(price.getText()));
					System.out.println("MarketVale: " +mpv.getMarketValue());
					
				
					itemInfo.setText("Name: "+leaf.getName()+" Price: "+leaf.getPrice()+" Market Value: "+mpv.getMarketValue());
					System.out.println(itemInfo.getText());
							
					});
			myComponents.add(leaf);
			}
		}
	}
	//Verifies input data types ALERT
	@FXML
	private boolean isVaildInput() {
		String errorMessage = "";

        if (name.getText() == null || name.getText().length() == 0) {
            errorMessage += "Invalid name!\n"; 
        }
        if (Xpos.getText() == null || Xpos.getText().length() == 0) {
            errorMessage += "Invalid x position!\n"; 
        } else {
            // try to parse the x code into an int.
            try {
            	int a = Integer.parseInt(Xpos.getText());
                if(a > 700) {errorMessage += "Invalid x position (x <= 700)!\n";}
            } catch (NumberFormatException e) {
                errorMessage += "Invalid x position (Type = integer)!\n"; 
            }
        }
        if (Ypos.getText() == null || Ypos.getText().length() == 0) {
            errorMessage += "Invalid y position!\n"; 
        } else {
            // try to parse the y position into an int.
            try {
                int a = Integer.parseInt(Ypos.getText());
                if(a > 500) {errorMessage += "Invalid y position (y <= 500)!\n";}
            } catch (NumberFormatException e) {
                errorMessage += "Invalid y position (Type = integer)!\n"; 
            }
        }
        
        if (length.getText() == null || length.getText().length() == 0) {
            errorMessage += "Invalid length position code!\n"; 
        } else {
            // try to parse the length into an double.
            try {
                Double.parseDouble(length.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid length (format = 1 or 1.0)!\n"; 
            }
        }
        if (width.getText() == null || width.getText().length() == 0) {
            errorMessage += "Invalid width position code!\n"; 
        } else {
            // try to parse the width into an double.
            try {
                Double.parseDouble(width.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid width (format = 1 or 1.0)!\n"; 
            }
        }
        if (height.getText() == null || height.getText().length() == 0) {
            errorMessage += "Invalid height position code!\n"; 
        } else {
            // try to parse the length into an double.
            try {
                Double.parseDouble(height.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid height (format = 1 or 1.0)!\n"; 
            }
        }
        if (price.getText() == null || price.getText().length() == 0) {
            errorMessage += "Invalid price position code!\n"; 
        } else {
            // try to parse the price into an double.
            try {
                Double.parseDouble(price.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid price (format = 1 or 1.0)!\n"; 
            }
        }
       
            // try to parse the market price into an double.
            try {
                Double.parseDouble(marketPrice.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid market price (format = 1 or 1.0)!\n"; 
            }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);           
            alert.showAndWait();
            return false;
        }
	}
	
	//makes the Title Pane images clickable and enlarges them 
	@FXML
	private void enlargeImage() {
			bear.setOnMouseClicked(event ->{windowView.setImage(bear.getImage());});
			barnHouse.setOnMouseClicked(event ->{windowView.setImage(barnHouse.getImage());});
			silo.setOnMouseClicked(event ->{windowView.setImage(silo.getImage());});
			building.setOnMouseClicked(event ->{windowView.setImage(building.getImage());});
			barnHouse2.setOnMouseClicked(event ->{windowView.setImage(barnHouse2.getImage());});
			house1.setOnMouseClicked(event ->{windowView.setImage(house1.getImage());});
			field.setOnMouseClicked(event ->{windowView.setImage(field.getImage());});
			house2.setOnMouseClicked(event ->{windowView.setImage(house2.getImage());});
			storage.setOnMouseClicked(event ->{windowView.setImage(storage.getImage());});
			golfCourse.setOnMouseClicked(event ->{windowView.setImage(golfCourse.getImage());});
			windmillHouse.setOnMouseClicked(event ->{windowView.setImage(windmillHouse.getImage());});
			sea.setOnMouseClicked(event ->{windowView.setImage(sea.getImage());});
			road.setOnMouseClicked(event ->{windowView.setImage(road.getImage());});		
			camel.setOnMouseClicked(event ->{windowView.setImage(camel.getImage());});
			cat.setOnMouseClicked(event ->{windowView.setImage(cat.getImage());});
			chick.setOnMouseClicked(event ->{windowView.setImage(chick.getImage());});
			hen.setOnMouseClicked(event ->{windowView.setImage(hen.getImage());});
			rooster.setOnMouseClicked(event ->{windowView.setImage(rooster.getImage());});
			cow.setOnMouseClicked(event ->{windowView.setImage(cow.getImage());});
			deer.setOnMouseClicked(event ->{windowView.setImage(deer.getImage());});
			dog.setOnMouseClicked(event ->{windowView.setImage(dog.getImage());});
			duck.setOnMouseClicked(event ->{windowView.setImage(duck.getImage());});
			fish.setOnMouseClicked(event ->{windowView.setImage(fish.getImage());});
			fox.setOnMouseClicked(event ->{windowView.setImage(fox.getImage());});
			giraffe.setOnMouseClicked(event ->{windowView.setImage(giraffe.getImage());});
			goat.setOnMouseClicked(event ->{windowView.setImage(goat.getImage());});
			horse.setOnMouseClicked(event ->{windowView.setImage(horse.getImage());});
			kangaroo.setOnMouseClicked(event ->{windowView.setImage(kangaroo.getImage());});
			mouse.setOnMouseClicked(event ->{windowView.setImage(mouse.getImage());});
			owl.setOnMouseClicked(event ->{windowView.setImage(owl.getImage());});
			peacock.setOnMouseClicked(event ->{windowView.setImage(peacock.getImage());});
			pig.setOnMouseClicked(event ->{windowView.setImage(pig.getImage());});
			rabbit.setOnMouseClicked(event ->{windowView.setImage(rabbit.getImage());});
			sheep.setOnMouseClicked(event ->{windowView.setImage(sheep.getImage());});
			snake.setOnMouseClicked(event ->{windowView.setImage(snake.getImage());});
			swan.setOnMouseClicked(event ->{windowView.setImage(swan.getImage());});
			turkey.setOnMouseClicked(event ->{windowView.setImage(turkey.getImage());});
			wolf.setOnMouseClicked(event ->{windowView.setImage(wolf.getImage());});
			zebra.setOnMouseClicked(event ->{windowView.setImage(zebra.getImage());});
			apple.setOnMouseClicked(event ->{windowView.setImage(apple.getImage());});
			banana.setOnMouseClicked(event ->{windowView.setImage(banana.getImage());});
			blueberry.setOnMouseClicked(event ->{windowView.setImage(blueberry.getImage());});
			cherries.setOnMouseClicked(event ->{windowView.setImage(cherries.getImage());});
			coffeeBeans.setOnMouseClicked(event ->{windowView.setImage(coffeeBeans.getImage());});
			corn.setOnMouseClicked(event ->{windowView.setImage(corn.getImage());});
			eggplant.setOnMouseClicked(event ->{windowView.setImage(eggplant.getImage());});
			grapes.setOnMouseClicked(event ->{windowView.setImage(grapes.getImage());});
			leaf.setOnMouseClicked(event ->{windowView.setImage(leaf.getImage());});
			lemon.setOnMouseClicked(event ->{windowView.setImage(lemon.getImage());});
			acorn.setOnMouseClicked(event ->{windowView.setImage(acorn.getImage());});
			orange.setOnMouseClicked(event ->{windowView.setImage(orange.getImage());});
			peach.setOnMouseClicked(event ->{windowView.setImage(peach.getImage());});
			pepper.setOnMouseClicked(event ->{windowView.setImage(pepper.getImage());});
			pineapple.setOnMouseClicked(event ->{windowView.setImage(pineapple.getImage());});
			pumpkin.setOnMouseClicked(event ->{windowView.setImage(pumpkin.getImage());});
			seeds.setOnMouseClicked(event ->{windowView.setImage(seeds.getImage());});
			strawberry.setOnMouseClicked(event ->{windowView.setImage(strawberry.getImage());});
			tree1.setOnMouseClicked(event ->{windowView.setImage(tree1.getImage());});
			tree2.setOnMouseClicked(event ->{windowView.setImage(tree2.getImage());});
			vegetables.setOnMouseClicked(event ->{windowView.setImage(vegetables.getImage());});
			watermellon.setOnMouseClicked(event ->{windowView.setImage(watermellon.getImage());});
			wheat.setOnMouseClicked(event ->{windowView.setImage(wheat.getImage());});
			waterPot.setOnMouseClicked(event ->{windowView.setImage(waterPot.getImage());});
			screwDriver.setOnMouseClicked(event ->{windowView.setImage(screwDriver.getImage());});
			airplane.setOnMouseClicked(event ->{windowView.setImage(airplane.getImage());});
			tools.setOnMouseClicked(event ->{windowView.setImage(tools.getImage());});
			hammer.setOnMouseClicked(event ->{windowView.setImage(hammer.getImage());});
			boat.setOnMouseClicked(event ->{windowView.setImage(boat.getImage());});
			car.setOnMouseClicked(event ->{windowView.setImage(car.getImage());});
			tractor.setOnMouseClicked(event ->{windowView.setImage(tractor.getImage());});
			loaderTractor.setOnMouseClicked(event ->{windowView.setImage(loaderTractor.getImage());});
			truck.setOnMouseClicked(event ->{windowView.setImage(truck.getImage());});
			USA.setOnMouseClicked(event ->{windowView.setImage(USA.getImage());});
			court.setOnMouseClicked(event ->{windowView.setImage(court.getImage());});
			desert.setOnMouseClicked(event ->{windowView.setImage(desert.getImage());});
			island.setOnMouseClicked(event ->{windowView.setImage(island.getImage());});
			mountain.setOnMouseClicked(event ->{windowView.setImage(mountain.getImage());});
			volcano.setOnMouseClicked(event ->{windowView.setImage(volcano.getImage());});
			field2.setOnMouseClicked(event ->{windowView.setImage(field2.getImage());});
			roadfork.setOnMouseClicked(event ->{windowView.setImage(roadfork.getImage());});
			
			
	}
// Initializations and Main App call functions --------------------------------------------------------
	 /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize
    }
    
	/**
     * Is called by the main application to give a reference back to itself.
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public boolean isOkClicked() {
        return okClicked;
    }

	
}
