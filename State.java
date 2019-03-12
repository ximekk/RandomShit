package simulator;

import java.util.Observable;

/**
 * A class which describes the current state of a Simulation
 * @author Erik Olausson, Mikael Granström, Sermed Mutter, Amir Rakshan
 *
 */
public class State extends Observable {
	private double time;
	private boolean flag;
	private EventQueue queue;
	
	/**
	 * Constructor. Creates an object of the type State with the parameters time, flag and queue
	 * @param time
	 * @param flag
	 * @param queue
	 */
	public State(double time, boolean flag, EventQueue queue) {
		this.time = time;
		this.flag = flag;
		this.queue = queue;
	}
	
	public void stopSim() {
		this.flag = false;
	}
	
	/**
	 * Returns the current time of State
	 * @return
	 */
	public double getTime() {
		return this.time;
	}
	
	/**
	 * Sets time time of State
	 * @param setTime
	 */
	public void setTime(double setTime) {
		this.time = setTime;
	}
	
	/**
	 * Returns the event queue of state
	 * @return
	 */
	public EventQueue getEventQueue() {
		return this.queue;
	}
	
	public void update() {
		setChanged();
		notifyObservers();
	}
}	