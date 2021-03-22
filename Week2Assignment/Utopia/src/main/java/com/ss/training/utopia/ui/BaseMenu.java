/**
 * 
 */
package com.ss.training.utopia.ui;

import java.util.Scanner;

import com.ss.training.utopia.service.ServiceHandler;

/**
 * @author derrianharris
 *
 */
public abstract class BaseMenu {

	public Scanner scanner;
	ServiceHandler service;
	public BaseMenu() {
		this.scanner = new Scanner(System.in);
		service = new ServiceHandler();
		fetchUpdatedData();
	}

	public abstract void display();

	public abstract void fetchUpdatedData();
}
