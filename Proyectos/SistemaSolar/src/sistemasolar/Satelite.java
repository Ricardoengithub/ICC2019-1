/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;
import javafx.scene.paint.Color;

/**
 * Clase que describe astros que giran alrededor de otro.
 * @author blackzafiro
 */
public class Satelite extends Astro {
	
	// Escala para dibujar a los planetas
	private static final double ESCALA_RADIO = 10.0;
	private static final double ESCALA_ORBITA = 400.0;
	private static final double ESCALA_ORBITA_SATELITE = ESCALA_RADIO * 2;
	private static final double ESCALA_TIEMPO = 55.0;
	
	/**
	 * Datos de cada planeta y satélite.
	 * Deben ser ficticios, pues de otro modo la simulación no cabe en pantalla.
	 */
	  
	 
	public enum DatosSatelite {
		MERCURIO(0.25, ESCALA_ORBITA_SATELITE * 0.011, ESCALA_ORBITA_SATELITE * 0.01066, 0.2,"file:./Planetas/mercurio.png"),
		VENUS(0.6, ESCALA_ORBITA_SATELITE * 0.017, ESCALA_ORBITA_SATELITE * 0.016966, 0.3,"file:./Planetas/venus.png"),
		TIERRA(0.65, ESCALA_ORBITA_SATELITE * 0.024, ESCALA_ORBITA_SATELITE * 0.023966, 0.4,"file:./Planetas/tierra.png"),
		MARTE(0.3, ESCALA_ORBITA_SATELITE * 0.032, ESCALA_ORBITA_SATELITE * 0.031966, 0.5,"file:./Planetas/marte.png"),
		JUPITER(2.5, ESCALA_ORBITA_SATELITE * 0.046, ESCALA_ORBITA_SATELITE * 0.045966, 0.6,"file:./Planetas/jupiter.png"),
		SATURNO(2.0, ESCALA_ORBITA_SATELITE * 0.055, ESCALA_ORBITA_SATELITE * 0.054966, 0.7,"file:./Planetas/saturno.png"),
		URANO(1.5, ESCALA_ORBITA_SATELITE * 0.064, ESCALA_ORBITA_SATELITE * 0.063966, 0.8,"file:./Planetas/urano.png"),
		NEPTUNO(1.5, ESCALA_ORBITA_SATELITE * 0.073, ESCALA_ORBITA_SATELITE * 0.072966, 0.9,"file:./Planetas/neptuno.png"),
		PLUTON(0.2, ESCALA_ORBITA_SATELITE * 0.07295, ESCALA_ORBITA_SATELITE * 0.086966, 1.0,"file:./Planetas/mercurio.jpg"),															
		
		LUNA(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.0739,"file:./Planetas/luna.png"),
		SATELITE(0.973, ESCALA_ORBITA_SATELITE * 0.00217, ESCALA_ORBITA_SATELITE * 0.002166, 0.0939,"file:./Planetas/sat.jpg"),
		SATELITE2(0.573, ESCALA_ORBITA_SATELITE * 0.00217, ESCALA_ORBITA_SATELITE * 0.002166, 0.0539,"file:./Planetas/sat.jpg"),
		NAVE(0.973, ESCALA_ORBITA_SATELITE * 0.0217, ESCALA_ORBITA_SATELITE * 0.02166, 0.939,"file:./Planetas/nave.png"),		
		
		
		IO(0.17, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.136,"file:./Planetas/luna.png"),
		EUROPA(0.17, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.336,"file:./Planetas/luna.png"),
		GANYMEDE(0.17, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.736,"file:./Planetas/luna.png"),
		CALLISTO(0.17, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.536,"file:./Planetas/luna.png"),
		
		MARTE1(0.17, ESCALA_ORBITA_SATELITE * 0.00337, ESCALA_ORBITA_SATELITE * 0.003366, 0.336,"file:./Planetas/luna.png"),
		MARTE2(0.13, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.736,"file:./Planetas/luna.png"),
		
		
		S1(0.17, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.336,"file:./Planetas/luna.png"),
		S2(0.17, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.736,"file:./Planetas/luna.png"),
		S3(0.17, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.536,"file:./Planetas/luna.png"),
		S4(0.17, ESCALA_ORBITA_SATELITE * 0.00337, ESCALA_ORBITA_SATELITE * 0.003366, 0.136,"file:./Planetas/luna.png"),
		S5(0.13, ESCALA_ORBITA_SATELITE * 0.00357, ESCALA_ORBITA_SATELITE * 0.003566, 0.936,"file:./Planetas/luna.png"),
				
		ASTEROIDES(0.1, ESCALA_ORBITA_SATELITE * 0.038, ESCALA_ORBITA_SATELITE * 0.037966, 0.06,"file:./Planetas/mercurio.jpg"),
		ASTEROIDES2(0.1, ESCALA_ORBITA_SATELITE * 0.038, ESCALA_ORBITA_SATELITE * 0.037966, 0.05 ,"file:./Planetas/mercurio.jpg"),
		ASTEROIDES3(0.1, ESCALA_ORBITA_SATELITE * 0.038, ESCALA_ORBITA_SATELITE * 0.037966, 0.03,"file:./Planetas/mercurio.jpg"),
		ASTEROIDES4(0.1, ESCALA_ORBITA_SATELITE * 0.038, ESCALA_ORBITA_SATELITE * 0.037966, 0.04,"file:./Planetas/mercurio.jpg"),
		ASTEROIDES5(0.1 	, ESCALA_ORBITA_SATELITE * 0.038, ESCALA_ORBITA_SATELITE * 0.037966, 0.07,"file:./Planetas/mercurio.jpg"),
		
		FUGAZ(0.2, ESCALA_ORBITA_SATELITE * 0.084, ESCALA_ORBITA_SATELITE * 0.083966, 2.0,"file:./Planetas/F.png"),		
		FUGAZ2(0.2, ESCALA_ORBITA_SATELITE * 0.084, ESCALA_ORBITA_SATELITE * 0.083966, 2.001,"file:./Planetas/F.png"),
		FUGAZ3(0.2, ESCALA_ORBITA_SATELITE * 0.084, ESCALA_ORBITA_SATELITE * 0.083966, 2.002,"file:./Planetas/F.png"),
		FUGAZ4(0.2, ESCALA_ORBITA_SATELITE * 0.084, ESCALA_ORBITA_SATELITE * 0.083966, 2.003,"file:./Planetas/F.png"),
		FUGAZ5(0.2, ESCALA_ORBITA_SATELITE * 0.084, ESCALA_ORBITA_SATELITE * 0.083966, 2.004,"file:./Planetas/F.png"),								
				
		;
		
		private final double diametroEcuatorial;
		private final double semiejeMayor;
		private final double semiejeMenor;
		private final double periodoOrbital;
		private final String color;
		
		DatosSatelite(double diametroEcuatorial,
			      double semiejeMayor, double semiejeMenor,
			      double periodoOrbital, String color) {
			this.diametroEcuatorial = diametroEcuatorial;
			this.semiejeMayor = semiejeMayor;
			this.semiejeMenor = semiejeMenor;
			this.periodoOrbital = periodoOrbital;
			this.color = color;
		}
	}
	

	/// Inician atributos
	
	private final DatosSatelite datos;
	private OrbitaTransition orbita;
	private Astro foco;
	
	
	/// Inician métodos
        
	/**
	 * Astro alrededor del cual gira este satélite.
	 * @return astro alrededor del cual girar este satélite.
	 */
	public Astro getFoco() {
		return foco;
	}

	
	/**
	 * Crea la órbita de este planea y lo pone a girar alrededor del foco.
	 */
	private void creaOrbita(Astro foco) {
		foco.getNodo().getChildren().add(this.nodo);
		this.foco = foco;
		
		orbita = new OrbitaTransition(this,
					      datos.semiejeMayor * ESCALA_ORBITA,
					      datos.semiejeMenor * ESCALA_ORBITA,
					      datos.periodoOrbital * ESCALA_TIEMPO
		);
		orbita.play();
	}
	
	
	private void creaOrbita(Astro foco, boolean a) {
		foco.getNodo().getChildren().add(this.nodo);
		this.foco = foco;
		
		orbita = new OrbitaTransition(this,
					      datos.semiejeMayor * ESCALA_ORBITA,
					      datos.semiejeMenor * ESCALA_ORBITA,
					      datos.periodoOrbital * ESCALA_TIEMPO, a
		);
		orbita.play();
	}
	
		
	
	/**
	 * Constructor.
	 * @param datos información del astro y su órbita.
	 * @param foco astro alrededor del cual gira este satélite.
	 */
	public Satelite(DatosSatelite datos, Astro foco) {
		super(datos.diametroEcuatorial * ESCALA_RADIO, datos.color);
		this.datos = datos;
		datos.toString();
		String pluton = getNombre();
//		System.out.println(pluton);
		if(pluton.compareTo("PLUTON") == 0){
			creaOrbita(foco,true);
			
			
		}else{
			creaOrbita(foco);
		}
	}

	
	
	
	/**
	 * Devuelve el nombre de este satélite.
	 * @return nombre
	 */
	public String getNombre() {
		return this.datos.toString();
	}
}
