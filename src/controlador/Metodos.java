package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author angel
 */
public class Metodos {

	private String ruta;
	private String fullPath;
	private char extensionSeparator;
	long tamanio;
	
	int tm;
	int item [] = new int [tm];
	int voto [] = new int [tm];
	


	public Metodos() {
		ruta = null;
	}

	public String getRuta() {
		JFileChooser j = new JFileChooser();
		j.showOpenDialog(j);
		String path = j.getSelectedFile().getAbsolutePath();
		return path;
	}

	public long tamanioArchivo(File ar) {
		return (long) Math.ceil(ar.length() / 1024.0);
	}

	public boolean verificarExtension(String str) {
		boolean estado = false;
		String txt = "txt";
		String csv = "csv";
		String dat = "dat";
		fullPath = str;
		
		extensionSeparator = '.';
		int dot = fullPath.lastIndexOf(extensionSeparator);
		if (fullPath.substring(dot + 1).equals(txt) || fullPath.substring(dot + 1).equals(csv)
				|| fullPath.substring(dot + 1).equals(dat)) {
			estado = true;
		}
		return estado;
	}

	public DefaultTableModel listaVotos(String ruta, String separador, JLabel segundos) {
		Vector cabeceras = new Vector();
		long TFin = 0, tiempo = 0;
		long NumeroLineas = 0;
		cabeceras.addElement("USUARIO");
		cabeceras.addElement("ITEM");
		cabeceras.addElement("VOTO");
		DefaultTableModel tblVotos = new DefaultTableModel(cabeceras, 0);
		long startTime = System.currentTimeMillis();
		try {
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			String d;
			while ((d = br.readLine()) != null) {
				
				StringTokenizer dato = new StringTokenizer(d, separador);
				
				Vector x = new Vector();
				while (dato.hasMoreTokens()) {
					x.addElement(dato.nextToken());
					
					System.out.println(x);

				}
				tblVotos.addRow(x);
				NumeroLineas++;
			}
			TFin = System.currentTimeMillis();
			tiempo = TFin - startTime;
			segundos.setText(String.valueOf(Math.round(tiempo * 0.001) + " segundos"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);
		}
		return tblVotos;
	}

	public ArrayList<Integer> mostrarVotosUsuario(JTable tblVotos, int usuario) {
		ArrayList<Integer> votos = new ArrayList<Integer>();
		for (int i = 0; i < tblVotos.getRowCount(); i++) {
			// if (Integer.parseInt(tblVotos.getValueAt(i, 0).toString()) ==
			// usuario) {
			votos.add(Integer.parseInt(tblVotos.getValueAt(i, 2).toString()));
			// }
		}
		return votos;
	}

	public ArrayList<Integer> mostrarItemsUsuario(JTable tblVotos, int usuario) {
		ArrayList<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < tblVotos.getRowCount(); i++) {
			// if (Integer.parseInt(tblVotos.getValueAt(i, 0).toString()) ==
			// usuario) {
			items.add(Integer.parseInt(tblVotos.getValueAt(i, 1).toString()));
			// }
		}
		return items;
	}

	public int contarVotos(JTable tblVotos, int item) {
		int total = 0;
		for (int i = 0; i < tblVotos.getRowCount(); i++) {
			if (Integer.parseInt(tblVotos.getValueAt(i, 1).toString()) == item) {
				total = total + Integer.parseInt(tblVotos.getValueAt(i, 2).toString());
			}
		}
		return total;
	}

	public long getTamanio() {
		return tamanio;
	}

	public void setTamanio(long tamanio) {
		this.tamanio = tamanio;
	}
}
