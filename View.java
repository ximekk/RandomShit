package mindel;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
	
	protected State state;
	
	public View(State state) {
		
		this.state = state;
		
	}
	

	
	public void update(Observable arg0, Object arg1) {

		
	}

}

