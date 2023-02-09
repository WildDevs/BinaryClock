package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import binaryclockdemo.BinaryClockThread;
import binaryclockdemo.ClockBox;
import binaryclockdemo.DigitalClockThread;

public class MainFrame extends JFrame {
	private final String TAG = "MainFrame";
	
	private JPanel top;
	private JPanel center;
	
	public MainFrame() {
		super();
		
		// MainFrame settings
		super.setTitle("BinaryClock");
		super.setSize(300, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());
		super.setLocationRelativeTo(null);
		
		// TOP PANEL -------------------------------------------------------------
		top = new JPanel();
		
		JLabel digitalclock = new JLabel();
		digitalclock.setVisible(true);
		
		// Add digitalclock to Top Panel
		top.add(digitalclock);
		top.setVisible(true);
		
		new Thread(new DigitalClockThread(digitalclock)).start();
		// ------------------------------------------------------------------------

		// CENTER PANEL -----------------------------------------------------------
		center = new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(new BorderLayout());
		
			// HOURS PANEL ------------------------
			JPanel hours = new JPanel();
			hours.setBackground(Color.WHITE);
			hours.setPreferredSize(new Dimension(100, this.getHeight()));
      
			// Create and add boxes
			ArrayList<JLabel> hourboxes = new ArrayList<JLabel>();
			for(int i = 0; i < 5; i++){
				ClockBox box = new ClockBox();
				hourboxes.add(box);
				hours.add(box);
			}
			// ------------------------------------
			
			// MINUTES PANEL ----------------------
			JPanel minutes = new JPanel();
			minutes.setBackground(Color.WHITE);
			minutes.setPreferredSize(new Dimension(100, this.getHeight()));
			
			// Create and add boxes
			ArrayList<JLabel> minuteboxes = new ArrayList<JLabel>();
			for(int i = 0; i < 6; i++){
				ClockBox box = new ClockBox();
				minuteboxes.add(box);
				minutes.add(box);
			}
			// ------------------------------------
			
			// SECONDS PANEL ----------------------
			JPanel seconds = new JPanel();
			seconds.setBackground(Color.WHITE);
			seconds.setPreferredSize(new Dimension(100, this.getHeight()));
			
			// Create and add boxes
			ArrayList<JLabel> secondboxes = new ArrayList<JLabel>();
			for(int i = 0; i < 6; i++){
				ClockBox box = new ClockBox();
				secondboxes.add(box);
				seconds.add(box);
			}
			// ------------------------------------
			
		// Add Panels to Center Panel
		center.add(hours, BorderLayout.WEST);
		center.add(minutes, BorderLayout.CENTER);
		center.add(seconds, BorderLayout.EAST);
		
		new Thread(new BinaryClockThread(hourboxes, minuteboxes, secondboxes)).start();
		
		center.setVisible(true);
		// ------------------------------------------------------------------------
		
		// Add Panels to MainFrame
		super.add(top, BorderLayout.NORTH);
		super.add(center, BorderLayout.CENTER);
		super.setVisible(true);
	}
}
