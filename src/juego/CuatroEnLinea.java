package juego;

/**
 * Juego Cuatro en Lí­nea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero está vacío.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	
	//Atributos
	
	private int filas;
	private int columnas;
	private String jugadorRojo;
	private String jugadorAmarillo;
	private Casillero[][] matrizJuego;
	private int turnoDeJugador; //Si el valor es impar, es turno del amarillo. Sino es rojo
	private boolean juegoTerminado;
	private boolean noHayMasEspacio;
	private boolean gano;
	private String nombreDelGanador;
	//Contructor
	
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) { 
		//Corroboramos que el usuario ingrese la cantidad correcta de filas y columnas
		if(filas<4 || columnas<4){ 
			throw new Error("La cantidad de filas y columnas, debe ser mayor o igual a 4");
		} 
		
		this.filas = filas;
		this.columnas = columnas;
		this.jugadorRojo = jugadorRojo;
		this.jugadorAmarillo = jugadorAmarillo;
		this.matrizJuego = new Casillero[filas][columnas];
		for(int i=0;i<this.filas-1;i++){
			for(int j=0;j<this.columnas-1;j++){
				this.matrizJuego[i][j]=Casillero.VACIO;
			}
		}
		this.turnoDeJugador=1;//Se inicializa en uno, para que empiece el amarillo
		this.gano = false;
		this.noHayMasEspacio = false;
		this.juegoTerminado = false; //No significa que el juego terminó, pero el usuario al acceder al metodo juego.termino(), si termina que devuelva true de que terminó o false de que sigue
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		
		return this.filas;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		
		return this.columnas;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()],
	 * 		 columnas está en el intervalo [1, contarColumnas()].
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		//Corroboramos la posicion a la cual quiere acceder con respecto a las filas
		if(fila<1 || fila>this.filas){
			throw new Error("La posición a la cual quiere acceder es inválida");
		}else if(columna<1 || columna>this.columnas){ //Corroboramos la posicion a la cual quiere acceder con respecto a las columnas
			throw new Error("La posición a la cual quiere acceder es inválida");
		} else{		
		Casillero valor = this.matrizJuego[fila][columna];
		
		return valor;
		}
	}
	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	public void soltarFicha(int columna) {
//		if(!this.juegoTerminado){
//			if(columna>0 && columna<=this.columnas){
//				for(int i=this.filas-1;i>=0;i--){
//					if(this.matrizJuego[i][columna] == Casillero.VACIO){
//						if(this.turnoDeJugador %2 == 0){
//							this.matrizJuego[i][columna] = Casillero.ROJO;
//							break;
//						} else{
//							this.matrizJuego[i][columna] = Casillero.AMARILLO;
//							break;
//						}
//					}
//				}
//				this.turnoDeJugador ++;	
//			} else{
//				throw new Error("La posición a la cual quiere acceder es inválida");
//			} 
//			
//		
//		}else{
//			throw new Error("El juego terminó");
//		}
	}
	
	/**
	 * post: indica si el juego terminó porque uno de los jugadores
	 * 		 ganó o no existen casilleros vacíos.
	 */
	public boolean termino() {
		//Hay dos casos, o alguien gano, o no hay más espacios para jugar
		//Caso de no haber más espacios
//		for(int i=0;i<this.columnas-1;i++){
//			for(int j=0;j<this.filas-1;j++){
//				if(this.matrizJuego[i][j] != Casillero.VACIO){
//					this.noHayMasEspacio = true;
//				}
//			}
//		}
//		
//		//Caso de ganar
//		for(int i=0;i<this.columnas-1;i++){
//			for(int j=0;j<this.filas-1;j++){
//				if(this.matrizJuego[i][j] == Casillero.AMARILLO){
//					if(j+3 <= this.filas){
//						if((this.matrizJuego[i][j+1]==Casillero.AMARILLO) && (this.matrizJuego[i][j+2]==Casillero.AMARILLO) && (this.matrizJuego[i][j+3]==Casillero.AMARILLO)){
//							this.gano = true;
//						}
//					}
//					if(i+3 <= this.columnas){
//						if((this.matrizJuego[i+1][j]==Casillero.AMARILLO) && (this.matrizJuego[i+2][j]==Casillero.AMARILLO) && (this.matrizJuego[i+3][j]==Casillero.AMARILLO)){
//							this.gano = true;
//						}
//					}
//				} else if(this.matrizJuego[i][j] == Casillero.ROJO){
//					if(j+3 <= this.filas){
//						if((this.matrizJuego[i][j+1]==Casillero.ROJO) && (this.matrizJuego[i][j+2]==Casillero.ROJO) && (this.matrizJuego[i][j+3]==Casillero.ROJO)){
//							this.gano = true;
//						}
//					}
//					if(i+3 <= this.columnas){
//						if((this.matrizJuego[i+1][j]==Casillero.ROJO) && (this.matrizJuego[i+2][j]==Casillero.ROJO) && (this.matrizJuego[i+3][j]==Casillero.ROJO)){
//							this.gano = true;
//						}
//					}
//				}
//					
//			}
//				
//		}
//		
//		if(gano || noHayMasEspacio){
//			this.juegoTerminado=true;
//		}
//		return this.juegoTerminado;
		return false;
	}

	/**
	 * post: indica si el juego terminó y tiene un ganador.
	 */
	public boolean hayGanador() {
		//Variable auxiliar
//		boolean exito; // Exito es si terminoe el juego porque alguien gano
//		if(juegoTerminado && gano){
//			exito = true;
//		} else{
//			exito=false;
//		}
		return false;
	}

	/**
	 * pre : el juego terminó.
	 * post: devuelve el nombre del jugador que ganó el juego.
	 */
	public String obtenerGanador() {
//		if(turnoDeJugador%2 == 0){
//			nombreDelGanador = this.jugadorRojo;
//		} else{
//			nombreDelGanador = this.jugadorAmarillo;
//		}
		return "casa";
	}
	
}
