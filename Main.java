package mindel;

import lab5.store.*;
import lab5.simulator.events.*;
import lab5.simulator.Simulator;
import lab5.simulator.EventQueue;
/**
 * @author Mikael Granström, Erik Olausson, Sermed Mutter, Amir Rakshan
 *
 */
/**
 * Denna klass är huvudklassen. Den kör simuleringen och skapar dess instanser.
 *
 */
public class Main {
	
	public static void main(String args[]) {
		
		StoreState state = new StoreState();
		StoreView view = new StoreView(state);
		EventQueue eventQueue=  new EventQueue();		
		
		state.isRunning = true;
		view.printStart();
		new Simulator(eventQueue, state);
		view.printSummary();
	}

}
