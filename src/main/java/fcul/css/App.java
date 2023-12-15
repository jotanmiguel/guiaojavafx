package fcul.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private String str = "JavaFX"; // Variable to store the string to be printed

    @Override
    public void start(Stage primaryStage) {
        // Creating buttons
        Button btPlus = new Button("Plus");
        Button btMinus = new Button("Minus");

        // Custom HBox instantiation
        CustomHBox hbox1 = new CustomHBox(10);
        CustomVBox vbox1 = new CustomVBox("vbox1",10);
        CustomVBox vbox2 = new CustomVBox("vbox2",10);
        CustomVBox vbox3 = new CustomVBox("vbox3",10);
        hbox1.addNodes(Arrays.asList(vbox1, vbox2, vbox3));
        vbox1.addNodes(Arrays.asList(btPlus, btMinus));

        // Setting actions for the buttons
        btPlus.setOnAction(event -> {
        	if(!vbox2.checkFull()) {
            	vbox2.addNodes(Arrays.asList(new Label(str)));
        	}
        	else if (!vbox3.checkFull()) {
        		vbox3.addNodes(Arrays.asList(new Label(str)));
			}
        	else {
            	System.out.println("Caixas todas cheias!");
        	}
        });
        btMinus.setOnAction(event -> {
        	if(!vbox3.checkEmpty()) {
        		vbox3.removeNode();
        	}
        	else if (!vbox2.checkEmpty()) {
				vbox2.removeNode();
			}
        	else {
        		System.out.println("Caixas Vazias!");
        	}
        });

        // Setting up the scene and stage
        Scene scene = new Scene(hbox1, 600, 500); // Adjust the scene size to accommodate the CustomHBox
        primaryStage.setTitle("Example with Buttons");
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
