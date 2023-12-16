package fcul.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

import java.io.File;
import java.util.Arrays;
import java.util.List;
/*
 * JavaFX App
 */
public class App extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		Button btFindAny = new Button("Find Any"); 
		Button btFindAll = new Button("Find All");
		Button btReset = new Button("Reset");

		// Custom HBox instantiation
		CustomVBox rootPane = new CustomVBox("MemoriesFX", 10);
		CustomHBox mainRow = new CustomHBox(10);
		rootPane.addNodes(Arrays.asList(mainRow));
		CustomVBox leftColumn = new CustomVBox("Left", 10);
		CustomVBox searchPane = new CustomVBox("Search", 10);
		TextField searchField = new TextField();
		searchField.setPromptText("Enter search query");
		CustomHBox buttonPane = new CustomHBox(10);
		buttonPane.addNodes(Arrays.asList(btFindAll, btFindAny, btReset));
		searchPane.addNodes(Arrays.asList(searchField, buttonPane));
		CustomVBox picturesPane = new CustomVBox(10);
		CustomHBox pictureView = new CustomHBox(10);
		FlowPane photoTags = new FlowPane(5, 5);
		photoTags.getChildren().addAll(Arrays.asList(new Label("tag1"), new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"), new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1")));
		// Add the ImageView to the picturesPane
		picturesPane.addNodes(Arrays.asList(new Label("pictures"), photoTags));
		
		CustomVBox rightColumn = new CustomVBox("Right", 10);
		CustomVBox newTagPane = new CustomVBox("New tag:",0);
		CustomHBox tagNamePane = new CustomHBox(10);
		TextField newTagField = new TextField();
		Button btNewTag = new Button("New");
		tagNamePane.getChildren().addAll(Arrays.asList(newTagField, btNewTag));
		newTagPane.getChildren().add(tagNamePane);
		FlowPane tags = new FlowPane(5,5);
		tags.getChildren().addAll(Arrays.asList(new Label("tag1"), new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"), new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1"),new Label("tag1"), new Label("tag1")));
		rightColumn.getChildren().addAll(Arrays.asList(tags, newTagPane));
		
		leftColumn.addNodes(Arrays.asList(searchPane));
		mainRow.addNodes(Arrays.asList(leftColumn, picturesPane, rightColumn));


        // Create a Scene with the layout pane
        Scene scene = new Scene(rootPane, 800, 450); // Set scene size to match the image

        // Set the scene to the stage and show the stage
        primaryStage.setTitle("Image Display");
        primaryStage.setScene(scene);
        primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	// Custom HBox class
	public static class CustomHBox extends HBox {
		// Constructor
		public CustomHBox(double spacing) {
			super(spacing); // Call the parent constructor with the spacing parameter
			this.setPadding(new Insets(5, 10, 5, 10));
		}

		// Method to add a node
		public void addNodes(List<Node> nodes) {
			this.getChildren().addAll(nodes);
		}

	}

	public static class CustomVBox extends VBox {
		// Constructor
		public CustomVBox(String name, double spacing) {
			super(spacing); // Call the parent constructor with the spacing parameter
			this.setPadding(new Insets(5, 10, 5, 10));
			this.addNodes(Arrays.asList(new Label(name))); // Correct way to add a single label as a list
		}

		public CustomVBox(double spacing) {
			super(spacing); // Call the parent constructor with the spacing parameter
			this.setPadding(new Insets(5, 10, 5, 10));
		}

		// Method to add a node
		public void addNodes(List<Node> nodes) {
			this.getChildren().addAll(nodes);
		}

		// Method to remove the last node if there's more than one
		public void removeNode() {
			// Remove the last node if the list size is greater than one
			if (this.getChildren().size() > 1) {
				this.getChildren().remove(this.getChildren().size() - 1);
			}
		}

		// Method to get all nodes
		public List<Node> getNodes() {
			return this.getChildren();
		}

		public boolean checkFull() {
			return this.getNodes().size() >= 4;

		}

		public boolean checkEmpty() {
			return this.getNodes().size() == 1;
		}
	}
	
}
