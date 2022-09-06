package juegoVida;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cuadro extends JLabel implements Observador, Observable {
	
	//Vamos a utilizar el estado para ver si el cuadro está vivo o muerto.
	//Los observadores servirán para informar a un cuadro del perimetro de su cambio de estado. 
	
	private boolean estado;
	private int población;
	private int numObservadores;
	private Observador[] observadores;
	
	public Cuadro(int posicionX, int posicionY, int tam) {
		this.estado= false;
		this.población= 0;
		this.numObservadores= 0;
		this.observadores= new Observador[8];
		this.setOpaque(true);
		this.agregarListenerClick();
		this.agregarBorde();
		this.setBounds(posicionX, posicionY, tam, tam);
		this.reiniciarEstado();
	}	
	
	public void agregarBorde() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1));
	}
	
	public void quitarBorde() {
		this.setBorder(null);
	}
	
	private void agregarListenerClick() {
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarColor();				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {				
			}
			
		});	
	}
	
	public void cambiarColor() {
		if (!getBackground().equals(Color.WHITE)) {
			setBackground(Color.WHITE);
			estado=false;
		}else {
			setBackground(Color.BLACK);
			estado=true;
		}
		
	}
	
	public void reiniciarEstado() {
		setBackground(Color.WHITE);
		estado=false;
	}
	
	
	
	public void CambiarEstado() {
		if(this.población==3) {
			estado=true;
		}else if(población ==2) {
			
		}else {
			estado=false;
		}
		this.cambiarFondo();
		población=0;
	}
	
	private void cambiarFondo() {
		if(estado) {
			this.setBackground(Color.BLACK);
		}else {
			this.setBackground(Color.WHITE);
		}
	}
	
	
	@Override
	public int notificar() {	
		if(estado) {
			return 1;
		}else {
			return 0;
		}
	}
	
	@Override
	public void añadir(Observador o) {
		observadores[numObservadores]=o;		
		numObservadores++;		
	}

	
	
	@Override
	public void informar() {	
		for (int i = 0; i < numObservadores; i++) {
			población+= observadores[i].notificar();
		}		
	}	
	
}
