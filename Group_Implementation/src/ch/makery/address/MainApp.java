package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Container;
import ch.makery.address.model.Leaf;
import ch.makery.address.model.MarketPriceVisitor;
import ch.makery.address.view.FarmLandOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public MainApp() {
		
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FarmLand");	
		initRootLayout();
		showFarmLandDroneOverview();
	}
	

	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();           
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();          
        } catch (IOException e) {
            e.printStackTrace();
       }
    }
    
    
    public void showFarmLandDroneOverview() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            FarmLandOverviewController FLOController = FarmLandOverviewController.FLOController();         
            loader.setLocation(MainApp.class.getResource("view/FarmLandDroneOverview.fxml"));
            loader.setController(FLOController);           
            AnchorPane overview = (AnchorPane) loader.load();
            rootLayout.setCenter(overview);           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * Returns the main stage.
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
		
	public static void main(String[] args) {
		Leaf corn = new Leaf("Corn");
		corn.setPrice(1.75);		
		Leaf water = new Leaf("water");
		water.setPrice(1.5);		
		Container bucket = new Container("bucket");
		bucket.setPrice(2.00);
		bucket.addItem(corn);
		bucket.addItem(water);	
		Container cornField = new Container("Corn Field");
		cornField.setPrice(3000);
		cornField.addItem(bucket);		
		System.out.println(cornField.toString());
		System.out.println(corn.toString());
		System.out.println(cornField.getItemNames());
		System.out.println(cornField.getTotalPrice());
		MarketPriceVisitor mp = new MarketPriceVisitor();
		corn.accept(mp);
		System.out.println("MarketVale:" +mp.getMarketValue());	
		launch(args);
	}
}
