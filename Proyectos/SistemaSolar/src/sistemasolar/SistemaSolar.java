/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import javafx.scene.media.AudioClip;

/**
 * Simulación del sistema solar utilizando JavaFX
 * https://docs.oracle.com/javase/8/javafx/api/index.html
 * @author blackzafiro
 */
public class SistemaSolar extends Application {
	
	private final static int ANCHO_VENTANA_INICIAL = 1200;
	private final static int ALTO_VENTANA_INICIAL = 800;
	private final static int RADIO_SOL = 50;
	
	private Astro sol;
	private Satelite tierra;
	private Satelite luna, sat, sat2, nave, io, europa, ganymede, callisto, fobos , deimos, s1, s2 , s3, s4 ,s5;
	private Satelite mercurio, venus, marte, jupiter, saturno, urano, neptuno, pluton;
	private Satelite[] asteroides, fugaz;
	
	public static int getSolCentroX() {
		return ANCHO_VENTANA_INICIAL/2;
	}
	
	public static int getSolCentroY() {
		return ALTO_VENTANA_INICIAL/2;
	}
	
	/**
	 * Crea al sol, los planteas y sus satélites, asignando quien gira
	 * alrededor de quien.
	 */
	private void creaAstros() {
		sol = new Astro(RADIO_SOL, "file:./Planetas/sol.png");
		mercurio = new Satelite(Satelite.DatosSatelite.MERCURIO, sol);
		venus = new Satelite(Satelite.DatosSatelite.VENUS, sol);
		tierra = new Satelite(Satelite.DatosSatelite.TIERRA, sol);
		marte = new Satelite(Satelite.DatosSatelite.MARTE, sol);
		jupiter = new Satelite(Satelite.DatosSatelite.JUPITER, sol);
		saturno = new Satelite(Satelite.DatosSatelite.SATURNO, sol);						
		urano = new Satelite(Satelite.DatosSatelite.URANO, sol);		
		neptuno = new Satelite(Satelite.DatosSatelite.NEPTUNO, sol);
		pluton = new Satelite(Satelite.DatosSatelite.PLUTON, sol);				
		luna = new Satelite(Satelite.DatosSatelite.LUNA, tierra);
		nave = new Satelite(Satelite.DatosSatelite.NAVE, sol);		
		sat = new Satelite(Satelite.DatosSatelite.SATELITE, tierra);
		sat2 = new Satelite(Satelite.DatosSatelite.SATELITE2, tierra);
		io = new Satelite(Satelite.DatosSatelite.IO, jupiter);
		europa = new Satelite(Satelite.DatosSatelite.EUROPA, jupiter);
		ganymede = new Satelite(Satelite.DatosSatelite.GANYMEDE, jupiter);				
		callisto = new Satelite(Satelite.DatosSatelite.CALLISTO, jupiter);
		fobos = new Satelite(Satelite.DatosSatelite.MARTE1, marte);		
		deimos = new Satelite(Satelite.DatosSatelite.MARTE2, marte);
		
		s1 = new Satelite(Satelite.DatosSatelite.S1, saturno);
		s2 = new Satelite(Satelite.DatosSatelite.S2, saturno);				
		s3 = new Satelite(Satelite.DatosSatelite.S3, saturno);
		s4 = new Satelite(Satelite.DatosSatelite.S4, saturno);		
		s5 = new Satelite(Satelite.DatosSatelite.S5, saturno);
		
						
		
		fugaz = new Satelite[100];		
		asteroides = new Satelite[1000];
		for(int x = 0; x<500; x++){
			int res = x % 5;
			switch(res){
			case 1: asteroides[x] = new Satelite(Satelite.DatosSatelite.ASTEROIDES, sol);
					break;			
			case 2: asteroides[x] = new Satelite(Satelite.DatosSatelite.ASTEROIDES2, sol);
					break;
			case 3: asteroides[x] = new Satelite(Satelite.DatosSatelite.ASTEROIDES3, sol);
					break;
			case 4: asteroides[x] = new Satelite(Satelite.DatosSatelite.ASTEROIDES4, sol);	
					break;
			default: asteroides[x] = new Satelite(Satelite.DatosSatelite.ASTEROIDES5, sol);
					break;
					
					
			}		
		}
		for(int x = 0; x< 100; x++){
			int res = x % 5;
			switch(res){
			case 1: fugaz[x] = new Satelite(Satelite.DatosSatelite.FUGAZ, sol);
					break;			
			case 2: fugaz[x] = new Satelite(Satelite.DatosSatelite.FUGAZ2, sol);
					break;
			case 3: fugaz[x] = new Satelite(Satelite.DatosSatelite.FUGAZ3, sol);
					break;
			case 4: fugaz[x] = new Satelite(Satelite.DatosSatelite.FUGAZ4, sol);	
					break;
			default: fugaz[x] = new Satelite(Satelite.DatosSatelite.FUGAZ5, sol);
					break;
		}
		}
			
	}
	
	/**
	 * Crea la escena y agrega los primeros nodos, sobre los cuales
	 * se han agregado a los demás astros.
	 * @return la escena con el sol, planetas y satélites.
	 */
	private Scene montaNodos() {
		AnchorPane root = new AnchorPane();
		root.setLayoutX(getSolCentroX() - RADIO_SOL);
		root.setLayoutY(getSolCentroY() - RADIO_SOL);
		//Image image = new Image("file:./Planetas/1.jpg");
		//ImageView m = new ImageView();
		//m.setImage(image);
		
		//root.getChildren().add(m);
		root.getChildren().add(sol.getNodo());
		
		Scene scene = new Scene(root, ANCHO_VENTANA_INICIAL, ALTO_VENTANA_INICIAL);
		return scene;
	}
	
	/**
	 * Acomoda los elementos en la intefaz e inicia la animación.
	 * @param primaryStage
	 * @throws Exception 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		creaAstros();
		Scene scene = montaNodos();
		
		AudioClip audio = new AudioClip("file:./Planetas/2.wav");
		audio.play();
		audio.setCycleCount(2);
		audio.setVolume(0.85);
		
		
		primaryStage.setTitle("Sistema solar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Inicia la simulación.
	 * @param args 
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
