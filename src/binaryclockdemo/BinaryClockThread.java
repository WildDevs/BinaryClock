package binaryclockdemo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BinaryClockThread implements Runnable {

	private ArrayList<JLabel> hourboxes;
	private ArrayList<JLabel> minuteboxes;
	private ArrayList<JLabel> secondboxes;
	
	public BinaryClockThread(ArrayList<JLabel> hourboxes, ArrayList<JLabel> minuteboxes, ArrayList<JLabel> secondboxes) {
		this.hourboxes = hourboxes;
		this.minuteboxes = minuteboxes;
		this.secondboxes = secondboxes;
	}

	@Override
	public void run() {
		for(;;){
			
			Calendar cal = Calendar.getInstance();
			
			int h = cal.get(Calendar.HOUR);
			int m = cal.get(Calendar.MINUTE);
			int s = cal.get(Calendar.SECOND);
			int ampm = cal.get(Calendar.AM_PM);
			
			
			for (int i = 4; i >= 0; i--) {
				if(i != 4){
					if (h % 2 == 1) {
						hourboxes.get(i).setOpaque(true);
						hourboxes.get(i).setBackground(Color.GRAY);
					} else {
						hourboxes.get(i).setOpaque(true);
						hourboxes.get(i).setBackground(Color.WHITE);
					}
					h = (int) Math.floor(h / 2);
				} else {
					hourboxes.get(4).setHorizontalAlignment(SwingConstants.CENTER);
					hourboxes.get(4).setVerticalAlignment(SwingConstants.CENTER);
					hourboxes.get(4).setForeground(Color.RED);
					if(ampm == 0){
						hourboxes.get(4).setText("AM");
					} else {
						hourboxes.get(4).setText("PM");
					}
				}
			}
			
			for (int i = 5; i >= 0; i--) {
				if (m % 2 == 1) {
					minuteboxes.get(i).setOpaque(true);
					minuteboxes.get(i).setBackground(Color.GRAY);
				}
				else {
					minuteboxes.get(i).setOpaque(true);
					minuteboxes.get(i).setBackground(Color.WHITE);
				}
				m = (int) Math.floor(m / 2);
			}
			
			for (int i = 5; i >= 0; i--) {
				if (s % 2 == 1) {
					secondboxes.get(i).setOpaque(true);
					secondboxes.get(i).setBackground(Color.GRAY);
				}
				else {
					secondboxes.get(i).setOpaque(true);
					secondboxes.get(i).setBackground(Color.WHITE);
				}
				s = (int) Math.floor(s / 2);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
