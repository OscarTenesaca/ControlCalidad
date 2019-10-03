/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.Vista;

/**
 *
 * @author angel
 */
public class Main {

	// public String identifyFileTypeUsingFilesProbeContentType(final String
	// fileName) {
	// String fileType = "Undetermined";
	// final File file = new File(fileName);
	// try {
	// fileType = Files.probeContentType(file.toPath());
	// } catch (IOException ioException) {
	// out.println(
	// "ERROR: Unable to determine file type for " + fileName
	// + " due to exception " + ioException);
	// }
	// System.out.println(fileType);
	// return fileType;
	// }
	//
	// public static void main(String[] args) {
	// Main main = new Main();
	// main.identifyFileTypeUsingFilesProbeContentType("C:\\Users\\angel\\Desktop\\SQL.txt");
	// }
	private String fullPath;
	private char extensionSeparator;

	public Main() {

	}

	public boolean extension(String str) {
		boolean estado = false;
		String txt = "txt";
		fullPath = str;
		extensionSeparator = '.';
		int dot = fullPath.lastIndexOf(extensionSeparator);
		if (fullPath.substring(dot + 1).equals(txt)) {
			estado = true;
		}
		return estado;
	}

	// public String filename() { // gets filename without extension
	// int dot = fullPath.lastIndexOf(extensionSeparator);
	// int sep = fullPath.lastIndexOf(pathSeparator);
	// return fullPath.substring(sep + 1, dot);
	// }
	//
	// public String path() {
	// int sep = fullPath.lastIndexOf(pathSeparator);
	// return fullPath.substring(0, sep);
	// }
	public static void main(String[] args) {
		final String FPATH = "C:\\Users\\angel\\Desktop\\SQL.txt";
		Main myHomePage = new Main();
		Vista ventana = new Vista();
		System.out.println("Extension = " + myHomePage.extension(FPATH));
		// System.out.println("Filename = " + myHomePage.filename());
		// System.out.println("Path = " + myHomePage.path());
	}
}
