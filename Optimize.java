package lab5;

import java.util.Random;
import lab5.simulator.EventQueue;
import lab5.store.StoreState;
import lab5.store.StoreView;
import lab5.Options; //???
import lab5.simulator.Simulator;

public class Optimize {
	private static int missed;

	public static void main(String[]args) {
	
		int klar = metod_2();
		System.out.println("Bästa antalet kassor som minskar missade är" +missed +klar);
	}
	
	/**
	 * metod_1() kör en simulering där alla parametrar är fixerade.
	 * simuleringen är densamma som huvudprogrammet runsim
	 * @return Sluttillståndet state.
	 */
	public static StoreState metod_1() {
		StoreState state = new StoreState();
		StoreView view = new StoreView(state);
		EventQueue eventQueue=  new EventQueue();		
		
		state.flag = true;
		view.printStart();
		new Simulator(eventQueue, state);
		view.printSummary();
		
		return state;
	}

	/**
	 * Metod_2() ska genom flera körda simuleringar med hjälp av antal kassor minimera antalet missed 
	 * antal missade är en avtagande funktion i antal kassor
	 * @return optimerad antal kassor.
	 */
	public static int metod_2() {
		int antalkassor = 0; // börjar med att sätta antal kassor = 0
		int optimized = Integer.MAX_VALUE; // bästa antalet kassor

		for (int i = 1; i<=Options.getCustomersMax(); i++) { // om största antalet människor i affären => i
			i = Options.getCashierMax(); // lika många kassor som maximalt ryms människor
			StoreState state = metod_1(); // använder metod 1 

	//		if(state.getCustomersMissedCurrent() == 0) { // om ingen kund missas
	//			antalkassor = i; // maximalt m�nniskor som ryms 
	//			missed = state.getCustomersMissedCurrent(); 
	//			break;
				 if (state.getCustomersMissedCurrent() < optimized ) {
					 optimized = state.getCustomersMissedCurrent();
					 antalkassor = i;
			}else if(i >0.1*optimized + antalkassor && state.getCustomersMissedCurrent() == optimized) {
				break;
	//			optimized = state.getCustomersMissedCurrent();
	//			antalkassor = i;
	//			missed = state.getCustomersMissedCurrent();
			}
		}
		return antalkassor;
	}
	 /**
	 * Metoden runnar metod_2() för att ta reda på bästa möjliga antal kassor mha slumpmässigt genererade tal .
	 * @param seed för slumpmässig generering.
	 * @return bästa möjliga antal kassor.
	 */
	public static int metod_3(long seed) { // tar frö som argument
		Random fro = new Random(seed); //variabel av typen random
		int calculator = 0; // loopar tills calc / antalet kassor är 1
		int antal = 0; //antalet
		int maxantal = 0; //maxantalet
		

		while (true) {
			if (calculator == 100) { // bryt loopen när vi når 100
				break;
			}
			Options.seed = fro.nextInt(10000); // psuedorandom genererad int
			antal = metod_2();	//metod 2 körs

			if(antal > maxantal) { //så länge antalet är större än maxantalet resetar vi calc till 0
				maxantal = antal;
				calculator = 0;
			}else{
				calculator++; // annars +1 tills vi når 100
			}
		}
		return maxantal;	// return maxantalet
	}
}