package br.com.estudo.test;

import javax.persistence.Persistence;

public class CriandoTabelas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Persistence.createEntityManagerFactory("EstudoJavaPU");
	}

}
