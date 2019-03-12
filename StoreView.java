package mindel;

import mindel.View;

import java.util.Observable;
import java.util.Observer;

import lab5.Settings;
import mindel.StoreState;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
public class StoreView extends View implements Observer {
	
	private StoreState state;
	private DecimalFormat decFormat1 = new DecimalFormat("0.00");
	private DecimalFormat decFormat2 = new DecimalFormat("0.0");
	
	public StoreView(StoreState state) {
		super(state);
		this.state = state;
		state.addObserver(this);
	}

	//Parametrar
	public void printStart() {
			System.out.println("PARAMETRAR");
			System.out.println("==========");
			System.out.println("Antal kassor, N.......: "+Settings.getMAXCHECKOUTS());
			System.out.println("Max som rymms, M.......: "+Settings.getMAXPEOPLE());
			System.out.println("Ankomsthastighet, lambda......: "+df1.format(Settings.getLAMBDA()));
			System.out.println("Plocktider[P_min..Pmax] ["+Settings.getLOWERP()+".."+Settings.getUPPERP()+"]");
			System.out.println("Betaltider[K_min..Kmax] ["+Settings.getLOWERC()+".."+Settings.getUPPERC()+"]");
			System.out.println("Frö,f  "+Settings.getSEED());
			System.out.println("");
			System.out.println("FÖRLOPP  ");
			System.out.println("=======");
			System.out.println("Tid\tHändelse \tKund\t?\led\ledT\tKunder\tTot\tMissade\tköat\tKöatT\tköar\t[Kassakö..]");
			System.out.println(df.format(Settings.getSTARTTIME())+"  "+"\t START");
		}		

		
	//Alla event	
	public void printEvents() {
		if(state.getPrevEvent() == "CLOSING") {
			
			System.out.println(
					df.format(state.getCurTime())+ 
					"\t"+state.getPrevEvent()+"  "+
					"\t"+"-"+
					"\t"+state.getPrevStoreOpen()+
					"\t"+state.getPrevAvailCheckouts()+
					"\t"+df.format(state.getCheckoutsIdleTime())+"  "+
					"\t"+state.getPrevPeople()+
					"\t"+state.getPrevServed()+
					"\t"+state.getPrevMissed()+
					"\t"+state.getPrevNrQueued()+
					"\t"+df.format(state.getTimeQueue())+
					"\t"+state.getPrevQueueSize()+
					"\t["+state.getPrevCheckoutQueue().toString()+"]"
				);
			
		} else {
		
		System.out.println(
				df.format(state.getCurTime())+ 
				"\t"+state.getPrevEvent()+"  "+
				"\t"+state.getPrevCustomer().getCustomerID()+
				"\t"+state.isStoreOpen()+
				"\t"+state.getPrevAvailCheckouts()+
				"\t"+df.format(state.getCheckoutsIdleTime())+"  "+
				"\t"+state.getPrevPeople()+
				"\t"+state.getPrevServed()+
				"\t"+state.getPrevMissed()+
				"\t"+state.getPrevNrQueued()+
				"\t"+df.format(state.getTimeQueue())+
				"\t"+state.getPrevQueueSize()+
				"\t["+state.getPrevCheckoutQueue()+"]"
			);
		}		
		
	}
	
	public void printClosing() {
		System.out.println("TID  "+"HÄNDELSE  ");
	}
	//Resultat		
	public void printSummary() {
		
		System.out.println(df.format(Settings.getSTOPTIME())+"\tStop");
		System.out.println("");
		System.out.println("RESULTAT");
		System.out.println("========");
		System.out.println(
		"1) Av "+
		//totalt antal kunder
		(state.getServed()+state.getMissed())
		+" kunder handlade "
		//antal kunder som handlat
		+state.getServed()
		+" medan "
		//antal kunder som missades
		+state.getMissed()
		+" missades."
				);
		System.out.println("");
		System.out.println(
		"2) Total tid "
		//antal kassor lediga
		+Settings.getMAXCHECKOUTS()
		+" kassor varit lediga: "
		//total tid dom kassor varit lediga
		+df.format(state.getCheckoutsIdleTime())
		+" te. \n"
		+"   Genomsnittlig ledig kassatid: "
		//Genomsnittlig tid
		+df.format(state.getCheckoutsIdleTime()/state.getAvailCheckouts())
		+" te (dvs "
		+df.format(100*(state.getCheckoutsIdleTime()/Settings.getMAXCHECKOUTS()/state.getLastEventTime()))
		+"% av tiden från öppning tills sista kunden betalat). \n"
				);
		System.out.println(
		"3) Total tid "
		+state.getNrQueued()
		+" kunder tvingats köa: "
		+df.format(state.getTimeQueue())
		+" te. \n"
		+"   Genomsnittlig kötid: "
		+df.format(state.getTimeQueue()/state.getNrQueued())
		+" te."
		
				);	
		
	}
	
	public void update(Observable arg0, Object arg1) {	
		printEvents();
	}
}


