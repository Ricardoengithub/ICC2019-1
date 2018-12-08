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
	GridPane gridPane;
	int simulation, umbral, t;
	int malla, media;
	int[] valores;

    public Automata(Group root) {
	    scanner = new Scanner(System.in); 
        this.root = root;
        text = new Text ("Inicio");
        text.setStroke(Color.WHITE);
        text.setY(200);
        Line line = new Line(0, 210, 800, 210);
        line.setStroke(Color.WHITE);
        root.getChildren().add(text);
        
						
		System.out.println("1) Actividad Sismica\n2) Propagación de epidemias");
		simulation = scanner.nextInt();
		System.out.println("Ingresa numero de celdas:");
		malla = scanner.nextInt();
		System.out.println("Ingresa umbral: ");
		umbral = scanner.nextInt();

		System.out.println("Ingresa t:");
		t = scanner.nextInt();
		
   		botones = new Button[malla];
		valores = new int[malla];
		media = umbral / 2;

		gridPane = new GridPane();
		
		for(int x = 0; x < malla; x++){
			botones[x] = new Button(" ");
			gridPane.add(botones[x], x%malla, x%30, 30, 1);
		}


		switch(simulation){
			case 1: for(int x = 0; x < malla; x++){		
						int aleatorio = (int) (Math.random() * malla);

						switch(aleatorio % 25){
							case 0: botones[x].setStyle("-fx-background-color: #ffffff; ");
									break;
							case 1: botones[x].setStyle("-fx-background-color: #ffff00; ");
									valores[x] = 1;
									break;
							case 2: botones[x].setStyle("-fx-background-color: #ff4000; ");
									valores[x] = media;
									break;
							default: botones[x].setStyle("-fx-background-color: #ffffff; ");
									break;														
						}	
					}
					break;
			default: break;
		}
		
		this.botones = botones;
		this.malla = malla;

        //actualiza();
        root.getChildren().add(gridPane);
        root.getChildren().add(line);

		//actualiza();
	}
    

void actualiza(){
	GridPane tmp = new GridPane();

		
	for(int x = 0; x < malla; x++){
		tmp.add(botones[x], x%malla, x%30, 30, 1);
	}	

	for(int x = 0; x < malla; x++){
				try
		{
    		Thread.sleep(1000);
		}
		catch(InterruptedException ex)
		{
    		Thread.currentThread().interrupt();
		}
		botones[x].setStyle("-fx-background-color: #ffffff; ");
	}
    root.getChildren().add(tmp);
}


    @Override
    public void handle(long now) {
        text.setText("tiempo " + now);
    }
    
}
