package binaryclockdemo;

import java.util.Calendar;

import javax.swing.JLabel;

public class DigitalClockThread implements Runnable{

	JLabel clock;
	
	public DigitalClockThread(JLabel clock){
		this.clock = clock;
	}

	@Override
	public void run() {
		for(;;){	
			try {
				Calendar cal = Calendar.getInstance();
				
				String h = cal.get(Calendar.HOUR_OF_DAY) > 9 ? String.valueOf(cal.get(Calendar.HOUR_OF_DAY)) : "0" + cal.get(Calendar.HOUR_OF_DAY);  
				String m = cal.get(Calendar.MINUTE) > 9 ? String.valueOf(cal.get(Calendar.MINUTE)) : "0" + cal.get(Calendar.MINUTE);  
				String s = cal.get(Calendar.SECOND) > 9 ? String.valueOf(cal.get(Calendar.SECOND)) : "0" + cal.get(Calendar.SECOND);  
				
				String time = h + ":" + m + ":" + s;
				clock.setText(time);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
