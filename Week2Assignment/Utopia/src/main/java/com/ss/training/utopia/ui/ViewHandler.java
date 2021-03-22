/**
 * 
 */
package com.ss.training.utopia.ui;

import java.util.Stack;

/**
 * @author derrianharris
 *
 */
public class ViewHandler {

	private static ViewHandler instance;

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static ViewHandler getInstance() {
		if (instance == null) {
			synchronized (ViewHandler.class) {
				if (instance == null) {
					instance = new ViewHandler();
				}
			}
		}
		return instance;
	}

	private Stack<BaseMenu> menuStack;

	private ViewHandler() {

		menuStack = new Stack<BaseMenu>();
	}

	public void goBack() {
		goBack(1);
	}

	public void goBack(int i) {
		int count = i;
		while (count > 0 && !menuStack.empty()) {
			menuStack.pop();
			count--;
		}
		System.out.println("");
		if (!menuStack.empty()) {
			menuStack.peek().display();
		}
	}
	public void goToMenu(BaseMenu menu) {
		System.out.println("");
		clearScreen();
		menuStack.push(menu);
		menu.display();
	}

	public void start() {
		MainMenu mainMenu = new MainMenu();
		goToMenu(mainMenu);
	}
}
