
// slike treba staviti u folder projekta
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Craps_gui extends Application{
	
	public void start(Stage stage) throws IOException{
		//Kreiranje opcija kao dugme
		Button play = new Button("Play");
		Button exit = new Button("Exit");
		Button roll = new Button("Roll");
		Button exit2 = new Button("Exit");
		
		//Kreiramo group kontejner koji se nalazi na vrhu
		Group group = new Group();
		//Postavljamo gif 
		File file = new File("main.gif");
		Image image = new Image(file.toURI().toString());
		//ImageView objekt za pregled kreirane slike
		ImageView iv = new ImageView(image);
		group.getChildren().add(iv);
		
		//Kreiramo Pane kontejner koji se nalazi ispod group kontejnera
		Pane pane = new Pane();
		//Kreiramo Hbox koji postavlja dugmad paralelno
		HBox hbox = new HBox();
		hbox.setSpacing(15);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		hbox.setPrefSize(400, 250);
		hbox.getChildren().addAll(play,exit);
		pane.getChildren().addAll(hbox,group);
		
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(15, 5, 5, 5));
		grid.setHgap(7);
		grid.setVgap(20);
		
		grid.add(roll,1,0);
		Label y_rol = new Label("You Rolled:");
		y_rol.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		
		y_rol.setTextFill(Color.WHITE);
		grid.add(y_rol, 0, 1);
		
		//kreiranje textfield za rezultat bacanja kockica
		javafx.scene.control.TextField you_rolled= new javafx.scene.control.TextField();
		//dodavanje textfield u grid pane
		grid.add(you_rolled,1,1); 
		Label result = new Label("Result:");
		result.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		result.setTextFill(Color.WHITE);
		grid.add(result, 0, 2);
		//kreiranje textfield za rezultat
		final javafx.scene.control.TextField result_txt = new javafx.scene.control.TextField();
		//dodavanje textfield u grid pane
		grid.add(result_txt, 1, 2);
		grid.add(exit2, 3, 3);
		
		StackPane game_pane = new StackPane();
   
       	file = new File("slika.png");
       	Image image_bg = new Image(file.toURI().toString());
       	
       	ImageView iv_bg = new ImageView(image_bg);
        
       	game_pane.getChildren().add(iv_bg);
       
       
       //dodajemo grid na pane
       	game_pane.getChildren().add(grid);
		
		
		//Kreiramo scenu za igricu
		Scene game_scene = new Scene(game_pane,606,300);
		
		//definisanje akcije za dugme play
		play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				stage.setScene(game_scene);
				stage.sizeToScene();
				stage.setResizable(false);
				stage.show();
				
			}
		});
		
		exit.setOnAction(e -> System.exit(0));
		exit2.setOnAction(e -> System.exit(0));
		
		// definisanje akcije za dugme roll 
		roll.setOnAction(new EventHandler<ActionEvent>() {

			
			@Override
			public void handle(ActionEvent event) {
				 
				  int sum = roll();
				 
				  you_rolled.setText( ""+sum);
				  
				  System.out.println(you_rolled.getText());
				  
				   int first = sum;
					// check craps
				  switch (first) {
				  case 2:
				  case 3:
				  case 12:
					  result_txt.setText("You lose. [Roll again]");
				   System.out.println(result_txt.getText());
				   break;
				  case 7:
				  case 11:
					  result_txt.setText("You win. [Roll again]");
				   System.out.println(result_txt.getText());
				   break;
				  
				  default:
					  int n = first;
					you_rolled.setText("Point: " + n+"[rolling]");
					  
				   System.out.println(you_rolled.getText());
				   // next roll
				
				   int next = 0;
				   
				  
				  do {
					  
					  next = roll();
					  you_rolled.setText("Point: " + n+" ,[rolled point: "+next+"]");
					  System.out.println(you_rolled.getText());
					  
					  //pause(1);
						} while (!(next == first || next == 7));
				   	
					 if (next == 7) {
						   result_txt.setText("You lose. [Roll again]");
						   System.out.println(result_txt.getText());
					   
					   } else {
						   result_txt.setText("You win. [Roll again]");
						   System.out.println(result_txt.getText());
					  }
				  }
				 }		
			});
	
		//Kreiramo scenu za pocetnu stranicu
		Scene scene_main = new Scene(pane,380,240);
		//postavljamo scenu na pozornicu
		stage.setScene(scene_main);
		stage.setTitle("Welcome to Craps Game");
		stage.setResizable(false);
		//prikazujemo pozornicu
		stage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
	//simulacija bacanja kocke
	public static int roll(){
		int a = (int)(1+Math.random()*6);
		int b = (int)(1+Math.random()*6);
		int sum = a+b;
		return sum;
	}
	
}