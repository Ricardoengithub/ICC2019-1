/*
 * Autómatas
 */
package automatas;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane; 


/**
 *
 * @author blackzafiro
 */
public class Automata extends AnimationTimer {
    
  	private Scanner scanner;
    private Group root;
    private Text text;
    private Button[] botones;
       

    public Automata(Group root) {
	    scanner = new Scanner(System.in); 
        this.root = root;
        text = new Text ("Inicio");
        text.setStroke(Color.WHITE);
        text.setY(200);
        Line line = new Line(0, 210, 800, 210);
        line.setStroke(Color.WHITE);
        root.getChildren().add(text);
        
        
   		botones = new Button[1800];

		GridPane gridPane = new GridPane();
		
		for(int x = 0; x < 1200; x++){
			botones[x] = new Button(" ");
			gridPane.add(botones[x], x%1200, x%30, 30, 1);
		}
						
		System.out.println("1) Actividad Sismica\n2) Propagación de epidemias");
		int simulation = scanner.nextInt();
		System.out.println("Ingresa umbral: ");
		int umbral = scanner.nextInt();
		System.out.println("Ingresa t:");
		int t = scanner.nextInt();
		
		

		switch(simulation){
			case 1: Sismos casillas = new Sismos(5, t);
					casillas.inicio();
					int[] set = casillas.getCasillas();
					for(int x = 0; x < 1200; x++){
						System.out.println(casillas.getIndex(x));
						
						
						switch(casillas.getIndex(x)){
							case 0: botones[x].setStyle("-fx-background-color: #ffffff; ");
									break;
							case 1: botones[x].setStyle("-fx-background-color: #00ff00; ");
									break;
							case 2: botones[x].setStyle("-fx-background-color: #ffff00; ");
									break;
							case 3: botones[x].setStyle("-fx-background-color: #317f43; ");
									break;									
							case 4: botones[x].setStyle("-fx-background-color: #ff0000; ");
									break;
							default: botones[x].setStyle("-fx-background-color: #ffffff; ");
									break;									
						}						
					}
					for(int x = 0; x < t; x++){
						int castmp = (int) (Math.random() * 1200);
						int numero = casillas.getIndex(castmp);
						casillas.setCasilla(castmp, numero+1);						
					}




//					for(int x = 0; x < t; x++){
//						int castmp = (int) (Math.random() * 1200);
//						if(x == 10){
//							int numero = casillas.getIndex(castmp);
//							casillas.setCasilla(castmp, numero+1);
//						}
//					}
					
					break;
			default: break;
		}
		

        
        root.getChildren().add(gridPane);
        root.getChildren().add(line);
    }
    
    

    @Override
    public void handle(long now) {
        text.setText("tiempo " + now);
    }
    
}
