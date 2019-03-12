//SKA ABSTRAKTA METODER ANVÄNDAS??

package mindel;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Mikael Granström, Erik Olausson, Sermed Mutter, Amir Rakshan
 *
 */


public class View implements Observer {
	
	protected State state;
	
	
	/**
 	* @param state Simuleringens tillstånd.
 	*/
	
	public View(State state) {
		this.state = state;	
	}
	
	/**
 	* Metod som uppdaterar vyn m.h.a Observer.
 	*/
	
	public void update(Observable arg0, Object arg1) {

		
	}

}
