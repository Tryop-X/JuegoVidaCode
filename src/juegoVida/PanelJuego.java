package juegoVida;

import javax.swing.JPanel;

public class PanelJuego extends JPanel {
	private Cuadro[][] cuadros;
	private int tam;
	private int filas;
	private int columnas;
	
	private int valorAleatoriedad;
	
	
	public PanelJuego(int tam, int valorAleatoriedad) {
		

		this.valorAleatoriedad= valorAleatoriedad;
		this.setLayout(null);
		this.setBounds(10, 100, 1300, 620);
		this.tam=tam;
		filas= this.getHeight()/tam;
		columnas= this.getWidth()/tam;
		cuadros = new Cuadro[columnas][filas];
		
		this.agregarCuadros();
		this.establecerObservadores();
		
	}
	
	
	public void agregarCuadros() {

		
		for (int posC=0; posC<columnas; posC++) {			
			for (int posF=0; posF<filas; posF++) {
				cuadros[posC][posF]= new Cuadro(posC*tam,posF*tam,tam);
				this.add(cuadros[posC][posF]);
			}			
		}
	}
	
	public void establecerObservadores() {
		
		int[][] numerosPos= {{-1,-1}, {0,-1},{1,-1}, 
							{-1,0}, {1,0},
							{-1,1}, {0,1}, {1,1}};
		
		for(int posC=0; posC<columnas; posC++) {
			for (int posF = 0; posF < filas; posF++) {
				for (int[] is : numerosPos) {
					if((posC+is[0]>=0) && (posC+is[0]<columnas) && (posF+is[1]>=0) &&  (posF+is[1]<filas)) {
						cuadros[posC][posF].añadir(cuadros[posC+is[0]][posF+is[1]]);
					}
				}
			}
		}
	}
	
	public void definirColores(boolean esAleatorio) {
		

		for (Cuadro[] cuadros2 : cuadros) {
			for (Cuadro cuadros3 :  cuadros2) {
				cuadros3.informar();
			}
		}
		
		for (Cuadro[] cuadros2 : cuadros) {
			for (Cuadro cuadros3 :  cuadros2) {
				cuadros3.CambiarEstado();
				if(esAleatorio) aleatoriedad(cuadros3);
			}
		}
		
	}
	
	public void aleatoriedad(Cuadro cuadro) {
		
		int valor_1= (int)(Math.random()*valorAleatoriedad);
		int valor_2= (int)(Math.random()*valorAleatoriedad);
		
		if(valor_1==valor_2) {
			cuadro.cambiarColor();
		}
	}
	
	
	
	
}
