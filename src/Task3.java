import javafx.application.Application;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//import javax.swing.Timer;;
import java.awt.Component;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.*;
import javax.swing.*;

import javafx.*;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.text.Font;


/*This is the timer class which will display the stop watch in application*/
class MyTimer
{
	 int sec=0;
	 int min=0;
	 int hour=0;
	
	 static boolean check=false;
	 	 
	 String sec1,min1,hour1;
	
	Timer myTimer = new Timer();
	JLabel elapsedStopWatch;
	
	//Constructor that will take label as an parameter to show the stopwatch on
	MyTimer(JLabel elapsedStopWatch)
	{
		this.elapsedStopWatch = elapsedStopWatch;
	}
	
	
	//In this TimerTask task1 we will manage the stop watch
        //this is used for the timer to work on
	TimerTask task1 = new TimerTask() {
		//In this run method we have all the detail for stop watch mean when to increase 
                //minute from seconds and hours from minutes and then display that to the label in the application
		public void run()
		{
			check = true;
			if(sec<59)
			{
				sec++;
				if(sec<10)
				{
					sec1 = "0"+sec;
				}
				else
				{
					sec1 = ""+sec;
				}
			}
			else if(sec == 59 && min<60)
			{
				min++;
				sec = 0;
				sec1 = "00";
				min1="00";
				if(min<10)
				{
					min1 = "0"+min;
					
				}
				else
				{
					min1 = ""+min;
				}
			}
			else if(min == 60)
			{
				hour++;
				min = 0;
				
				if(hour<10)
				{
					hour1 = "0"+hour;
				}
				else
				{
					hour1 = ""+hour;
				}
			}

			if(hour1 == null)
			{
				hour1 = "00";
			}
			if(min1 == null)
			{
				min1 = "00";
			}
			
			elapsedStopWatch.setText(hour1+":"+min1+":"+sec1);
			
		}
		
	};
	
	
	// This will start the stopwatch and will repeat for every second. 
        
	public void start()
	{ 
		//Here myTimer is object of Timer class which repeats it self 
                //here we repeat it after one second
		myTimer.schedule(task1, 1000, 1000);
	}
        //Here the timer will be paused
	public void onPause()
	{
		task1.cancel();
		myTimer.purge();
	}
	
} // End of stopwatch class.



// This is another timer class for another timer in the application.
// This is for the clock in  the application.
class MyTimer1
{
	
	int second;
	int minute;
	int hour;
	
	String secondS;
	String minuteS;
	String hourS;
	
	Timer myTimer = new Timer();
	JLabel labelClock;
        //Constructor that will take label as an parameter to show the clock on
	MyTimer1(JLabel labelClock)
	{
		this.labelClock = labelClock;
	}
        //this is used for the timer to work on
	TimerTask task = new TimerTask() {
		//In this run method we set second , minutes and hours after getting that from Calendar class
		public void run()
		{
			
			//int second, minute, hour;
	        Calendar date = Calendar.getInstance();
	        second = date.get(Calendar.SECOND);
	        minute = date.get(Calendar.MINUTE);
	        hour = date.get(Calendar.HOUR_OF_DAY);
	        labelClock.setText("");
	        if(hour<10)
	        {
	        	hourS = "0"+hour;
	        }
	        else
	        {
	        	hourS = ""+hour;
	        }
	        if(minute<10)
	        {
	        	minuteS = "0" + minute;
	        }
	        else
	        {
	        	minuteS = ""+minute;
	        }
	        if(second<10)
	        {
	        	secondS = "0" + second;
	        }
	        else
	        {
	        	secondS = ""+second;
	        }
	        labelClock.setText(hourS + ":" + minuteS +":" + secondS);
	       
		}
		
	};
        //This will start the timer and will repeat it after one second
	public void start()
	{
		myTimer.scheduleAtFixedRate(task, 1000, 1000);
	}

} // End of clock class


// This is the main class for the task 3
public  class Task3 
{
	//These for the Light control panel in the application.
        //for first row
	static int lightRowOneCounter = 0;
        //for second row
	static int lightRowTwoCounter = 0;
        //for third row
	static int lightRowThreeCounter = 0;
	static AnimationTimer at;
	
	
	/*This is the main method for the application to run the app.*/
	public static void main(String [] args) throws InterruptedException
	{
		
		
		/*This is the start for the GUI of the application.*/
                //this is the initial frame of the application
		JFrame myFrame = new JFrame("Surgery Control Panel");
		myFrame.setVisible(true);
		myFrame.setSize(1000, 1000);
		myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		
                //this is the main panel on myFrame of the application 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(109, 76, 36));
		panel.setVisible(true);
                //setting layout ot null means we will add controls with bounds
		panel.setLayout(null);
		myFrame.add(panel);
		
                
		//These are the seven panels used in whole application 
                
                //this is for day time clock
                JPanel dayTimeClock = new JPanel();
                //this is for the Elapsed Time
		JPanel elapsedTime = new JPanel();
                //this is for Temperature Control
		JPanel TemperatureControl = new JPanel();
                //This is for Hunidity Control
		JPanel HumidityControl = new JPanel();
                //This is for Pressure Control
		JPanel PressureControl = new JPanel();
                //This is for Light Control
		JPanel LightControl = new JPanel();
                //This is for Medical Gases
		JPanel MedicalGases = new JPanel();
		
                
                //Start of Day Time Clock Panel
		dayTimeClock.setLayout(null);
		dayTimeClock.setBounds(15, 20 , 645 , 200);
		dayTimeClock.setBackground(new Color(109, 76, 36));
		dayTimeClock.setBorder(BorderFactory.createTitledBorder("Day Time Clock"));
		((javax.swing.border.TitledBorder)dayTimeClock.getBorder()).setTitleColor(Color.WHITE);
		
                //this is the label used for showing the clock
		JLabel labelClock = new JLabel("");
		labelClock.setBounds(150,25,500,150);
		labelClock.setFont(new java.awt.Font("Tahoma",20, 60));
		labelClock.setForeground(new Color(29, 131, 72));
		
		//Show current time in app.
		MyTimer1 m = new MyTimer1(labelClock);
		m.start();
		dayTimeClock.add(labelClock);
		//End of Day Time Clock Panel
                
                
                //Start of Elapse Time Panel
		elapsedTime.setLayout(null);
		elapsedTime.setBounds(700, 20 , 650 , 200);
		elapsedTime.setBackground(new Color(109, 76, 36));
		elapsedTime.setBorder(BorderFactory.createTitledBorder("Elapsed Time"));
		((javax.swing.border.TitledBorder)elapsedTime.getBorder()).setTitleColor(Color.WHITE);
		
		//This is the initial value of the Elapsed Time
		JLabel elapsedStopWatch = new JLabel("00:00:00");
		elapsedStopWatch.setBounds(170,25,500,150);
		elapsedStopWatch.setFont(new java.awt.Font("Tahoma",20, 60));
		elapsedStopWatch.setForeground(Color.red);
		elapsedTime.add(elapsedStopWatch);
		
                //This is the timer for the Elapsed time
		MyTimer myTimer = new MyTimer(elapsedStopWatch);
		
                //This is the start button of the Elapsed Time
		JButton start = new JButton("Start");
		start.setBackground(Color.blue);
		start.setForeground(Color.white);
		start.setBounds(550,40,70,30);
		
		//An actionlistener which will show stopwatch time in the application.
		start.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
			
				if(MyTimer.check==true)
				{
					JOptionPane.showMessageDialog(null,"Limit reached...");
				}
				else
				{
					myTimer.start();
				}
				
					
			} 
	    });  
		
		//This is the stop button of the Elapsed Time
		JButton stop = new JButton("Stop");
		stop.setBackground(Color.blue);
		stop.setForeground(Color.white);
		stop.setBounds(550,80,70,30);
                //This is the actionListener for the stop button
		stop.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				myTimer.onPause();
					
			} 
	    });  
		
                //This is the reset button of the Elapsed Time
		JButton reset = new JButton("Reset");
		reset.setBackground(Color.blue);
		reset.setForeground(Color.white);
		reset.setBounds(550,120,70,30);
                //This is the actionListener for the reset button
		reset.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				myTimer.onPause();
				elapsedStopWatch.setText("00:00:00");
				
			} 
	    });  
		elapsedTime.add(start);		
		elapsedTime.add(stop);
		elapsedTime.add(reset);
		//This is the end of Elapsed Time Panel
                
		//This is start of the temperature control panel in the application.
		TemperatureControl.setLayout(null);
		TemperatureControl.setBounds(15, 255 , 420 , 200);
		TemperatureControl.setBackground(new Color(109, 76, 36));
		TemperatureControl.setBorder(BorderFactory.createTitledBorder("Temperature Control"));
		((javax.swing.border.TitledBorder)TemperatureControl.getBorder()).setTitleColor(Color.WHITE);
		
                //This is the label for showing the image icon for the temperature
		JLabel iconTC= new JLabel("");
		iconTC.setHorizontalAlignment(SwingConstants.CENTER);
		iconTC.setIcon(new ImageIcon("images\\thermometer-icon.png"));
		iconTC.setBounds(15,30,120,90);
		TemperatureControl.add(iconTC);
		
                //This is the label for the temperature to be increase or decreased
		JLabel tempText = new JLabel("20.0");
		tempText.setForeground(Color.red);
		tempText.setBounds(150,30, 120, 90);
		tempText.setFont(new java.awt.Font("Tahoma",20, 50));
		
		TemperatureControl.add(tempText);
		
                //This label is only used for showing the degree celcius
		JLabel tempTextUnit = new JLabel("°C");
		tempTextUnit.setForeground(Color.white);
		tempTextUnit.setBounds(255,40,100,80);
		tempTextUnit.setFont(new java.awt.Font("Tahoma",40,30));
		
		TemperatureControl.add(tempTextUnit);
		
		// Up button operation for the temperature
		JButton TBtnUp = new JButton("");
		TBtnUp.setBounds(160,120,40,40);
		TBtnUp.setHorizontalAlignment(SwingConstants.CENTER);
		TBtnUp.setIcon(new ImageIcon("images\\up-icon.png"));
		TBtnUp.setBackground(new Color(100,0,0,0));
                //ActionListener for the up button
		TBtnUp.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				double value = Double.parseDouble(tempText.getText());
				
				//increase the temperature label by 0.1 and if reached to greater than 27.5 then show limit reached popup box
				value += 0.1;
				if(value==27.6)
				{
					JOptionPane.showMessageDialog(null, "Temperature limit reached...");
				}
				else
				{
					tempText.setText(String.format("%.1f", value));
				}
	        }  
	    });  
				
		TemperatureControl.add(TBtnUp);
		
		// Down button operation for the temperature
		JButton TBtnDown = new JButton("");
		TBtnDown.setBounds(220,120,40,40);
		TBtnDown.setHorizontalAlignment(SwingConstants.CENTER);
		TBtnDown.setIcon(new ImageIcon("images\\down-icon.png"));
                //ActionListener for the down button
		TBtnDown.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				double value = Double.parseDouble(tempText.getText());
				
				//Decrease the temperature label by 0.1 and if reached to less than 10 then show limit reached popup box
				value -= 0.1;
				if(value<10)
				{
					JOptionPane.showMessageDialog(null, "Temperature limit reached...");
				}
				else
				{
					tempText.setText(String.format("%.1f", value));
				}
	        }  
	    });  
		TemperatureControl.add(TBtnDown);
		
                //End of Temperature Control Panel
                
                
		// Humadity Control panel start
		HumidityControl.setLayout(null);
		HumidityControl.setBounds(485, 255 , 400 , 200);
		HumidityControl.setBackground(new Color(109, 76, 36));
		HumidityControl.setBorder(BorderFactory.createTitledBorder("Humidity Control"));
		((javax.swing.border.TitledBorder)HumidityControl.getBorder()).setTitleColor(Color.WHITE);
		
                //label for Image icon for the humidity control
		JLabel iconHC= new JLabel("");
		iconHC.setHorizontalAlignment(SwingConstants.CENTER);
		iconHC.setIcon(new ImageIcon("images\\humidity-icon.png"));
		
		iconHC.setBounds(15,30,120,90);
		HumidityControl.add(iconHC);
		
		//Label of humidity control for increasing and decreasing
		JLabel humText = new JLabel("40");
		humText.setForeground(Color.red);
		humText.setBounds(150,30, 120, 90);
		humText.setFont(new java.awt.Font("Tahoma",20, 50));
		
		HumidityControl.add(humText);
		//Label for only showing the %
		JLabel humTextUnit = new JLabel("%");
		humTextUnit.setForeground(Color.white);
		humTextUnit.setBounds(255,40,100,80);
		humTextUnit.setFont(new java.awt.Font("Tahoma",40,30));
		
		HumidityControl.add(humTextUnit);
		
		//Humadity button up operations.
                //Image icon for the up button
		JButton HBtnUp = new JButton("");
		HBtnUp.setBounds(160,120,40,40);
		HBtnUp.setHorizontalAlignment(SwingConstants.CENTER);
		HBtnUp.setIcon(new ImageIcon("images\\up-icon.png"));
		HBtnUp.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				int value = Integer.parseInt(humText.getText());
				
				//increase the humidity label by 1 and if reached to greater than 55 then show limit reached popup box
				value += 1;
				if(value>55)
				{
					JOptionPane.showMessageDialog(null, "Humidity limit reached...");
				}
				else
				{
					humText.setText(""+value);
				}
	        }  
	    });  
		HBtnUp.setBackground(new Color(100,0,0,0));
		HumidityControl.add(HBtnUp);
		
		/*Humadity button down operations.*/
		JButton HBtnDown = new JButton("");
		HBtnDown.setBounds(220,120,40,40);
		HBtnDown.setHorizontalAlignment(SwingConstants.CENTER);
		HBtnDown.setIcon(new ImageIcon("images\\down-icon.png"));
		HBtnDown.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				int value = Integer.parseInt(humText.getText());
				
				//decrease the humidity label by 0.1 and if reached to less than 30 then show limit reached popup box
				value -= 1;
				if(value<30)
				{
					JOptionPane.showMessageDialog(null, "Humidity limit reached...");
				}
				else
				{
					humText.setText(""+value);
				}
	        }  
	    });  
		HumidityControl.add(HBtnDown);
		//Humidity control panel end
                
		//Presure control in application start
		PressureControl.setLayout(null);
		PressureControl.setBounds(935, 255 , 415 , 200);
		PressureControl.setBackground(new Color(109, 76, 36));
		PressureControl.setBorder(BorderFactory.createTitledBorder("Pressure Control"));
		((javax.swing.border.TitledBorder)PressureControl.getBorder()).setTitleColor(Color.WHITE);
		
                //Image icon for the Pressure Control panel
		JLabel iconPC= new JLabel("");
		iconPC.setHorizontalAlignment(SwingConstants.CENTER);
		iconPC.setIcon(new ImageIcon("images\\pressure-icon.png"));
		
		iconPC.setBounds(15,30,120,90);
		PressureControl.add(iconPC);
		
		//Label of Pressure control for increasing and decreasing
		JLabel pressureText = new JLabel("70");
		pressureText.setForeground(Color.red);
		pressureText.setBounds(150,30, 120, 90);
		pressureText.setFont(new java.awt.Font("Tahoma",20, 50));
		
		PressureControl.add(pressureText);
		
                //Label only for showing the kPa
		JLabel pressureTextUnit = new JLabel("kPa");
		pressureTextUnit.setForeground(Color.white);
		pressureTextUnit.setBounds(255,40,100,80);
		pressureTextUnit.setFont(new java.awt.Font("Tahoma",40,30));
		
		PressureControl.add(pressureTextUnit);
		
		//Presure up button logic
		JButton PBtnUp = new JButton("");
		PBtnUp.setBounds(160,120,40,40);
		PBtnUp.setHorizontalAlignment(SwingConstants.CENTER);
                //Image icon for up button
		PBtnUp.setIcon(new ImageIcon("images\\up-icon.png"));
		PBtnUp.setBackground(new Color(100,0,0,0));
		PBtnUp.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				int value = Integer.parseInt(pressureText.getText());
				
				//Increase label of pressure by 10 and if become greater than 120 then show popup of limit reached
				value += 10;
				if(value>120)
				{
					JOptionPane.showMessageDialog(null, "Pressure limit reached...");
				}
				else
				{
					pressureText.setText(""+value);
				}
	        }  
	    });  
		PressureControl.add(PBtnUp);
		
		//Presure down button logic
		JButton PBtnDown = new JButton("");
		PBtnDown.setBounds(220,120,40,40);
		PBtnDown.setHorizontalAlignment(SwingConstants.CENTER);
                //image icon for down button
		PBtnDown.setIcon(new ImageIcon("images\\down-icon.png"));
		PBtnDown.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				int value = Integer.parseInt(pressureText.getText());
                                
                                //Decrease label of pressure by 10 and if become lese than 50 then show popup of limit reached
				value -= 10;
				if(value<50)
				{
					JOptionPane.showMessageDialog(null, "Pressure limit reached...");
				}
				else
				{
					pressureText.setText(""+value);
				}
	        }  
	    });  
		PressureControl.add(PBtnDown);
		//End of Pressure Control Panel
                
		// Start of Light control
		LightControl.setLayout(null);
		LightControl.setBounds(15, 490 , 645 , 200);
		LightControl.setBackground(new Color(109, 76, 36));
		LightControl.setBorder(BorderFactory.createTitledBorder("Light Control"));
		((javax.swing.border.TitledBorder)LightControl.getBorder()).setTitleColor(Color.WHITE);
		
		
                //Labels for lights of first row
                
		Label l1r1 = new Label("");
		l1r1.setBounds(95,50,55,30);
		l1r1.setBackground(new Color(20, 60, 50));
		LightControl.add(l1r1);
		
		Label l2r1 = new Label("");
		l2r1.setBounds(155,50,55,30);
		l2r1.setBackground(new Color(20, 60, 50 ));
		LightControl.add(l2r1);
		
		Label l3r1 = new Label("");
		l3r1.setBounds(215,50,55,30);
		l3r1.setBackground(new Color(20, 60, 50));
		LightControl.add(l3r1);
		
		Label l4r1 = new Label("");
		l4r1.setBounds(275,50,55,30);
		l4r1.setBackground(new Color(20, 60, 50));
		LightControl.add(l4r1);
		
		Label l5r1 = new Label("");
		l5r1.setBounds(335,50,55,30);
		l5r1.setBackground(new Color(20, 60, 50));
		LightControl.add(l5r1);
		
		Label l6r1 = new Label("");
		l6r1.setBounds(395,50,55,30);
		l6r1.setBackground(new Color(20, 60, 50));
		LightControl.add(l6r1);
		
		Label l7r1 = new Label("");
		l7r1.setBounds(455,50,55,30);
		l7r1.setBackground(new Color(20, 60, 50));
		LightControl.add(l7r1);
		
		//Labels for lights of second row
		Label l1r2 = new Label("");
		l1r2.setBounds(95,90,55,30);
		l1r2.setBackground(new Color(20, 60, 50));
		LightControl.add(l1r2);
		
		Label l2r2 = new Label("");
		l2r2.setBounds(155,90,55,30);
		l2r2.setBackground(new Color(20, 60, 50));
		LightControl.add(l2r2);
		
		Label l3r2 = new Label("");
		l3r2.setBounds(215,90,55,30);
		l3r2.setBackground(new Color(20, 60, 50));
		LightControl.add(l3r2);
		
		Label l4r2 = new Label("");
		l4r2.setBounds(275,90,55,30);
		l4r2.setBackground(new Color(20, 60, 50));
		LightControl.add(l4r2);
		
		Label l5r2 = new Label("");
		l5r2.setBounds(335,90,55,30);
		l5r2.setBackground(new Color(20, 60, 50));
		LightControl.add(l5r2);
		
		Label l6r2 = new Label("");
		l6r2.setBounds(395,90,55,30);
		l6r2.setBackground(new Color(20, 60, 50));
		LightControl.add(l6r2);
		
		Label l7r2 = new Label("");
		l7r2.setBounds(455,90,55,30);
		l7r2.setBackground(new Color(20, 60, 50));
		LightControl.add(l7r2);
		

		
		//Labels for lights of third row
		Label l1r3 = new Label("");
		l1r3.setBounds(95,130,55,30);
		l1r3.setBackground(new Color(20, 60, 50));
		LightControl.add(l1r3);
		
		Label l2r3 = new Label("");
		l2r3.setBounds(155,130,55,30);
		l2r3.setBackground(new Color(20, 60, 50));
		LightControl.add(l2r3);
		
		Label l3r3 = new Label("");
		l3r3.setBounds(215,130,55,30);
		l3r3.setBackground(new Color(20, 60, 50));
		LightControl.add(l3r3);
		
		Label l4r3 = new Label("");
		l4r3.setBounds(275,130,55,30);
		l4r3.setBackground(new Color(20, 60, 50));
		LightControl.add(l4r3);
		
		Label l5r3 = new Label("");
		l5r3.setBounds(335,130,55,30);
		l5r3.setBackground(new Color(20, 60, 50));
		LightControl.add(l5r3);
		
		Label l6r3 = new Label("");
		l6r3.setBounds(395,130,55,30);
		l6r3.setBackground(new Color(20, 60, 50));
		LightControl.add(l6r3);
		
		Label l7r3 = new Label("");
		l7r3.setBounds(455,130,55,30);
		l7r3.setBackground(new Color(20, 60, 50));
		LightControl.add(l7r3);
		
		/************ START ******************************/
		/***** This will perform operation for the light control *****/
                
                //This button will decrement the light color for row One
		JButton r1M = new JButton("-");
		r1M.setBackground(new Color(109, 76, 36));
		r1M.setForeground(Color.white);
		r1M.setBounds(40,50,50,30);
		r1M.setFont(new java.awt.Font("Tahoma",40,18));
		r1M.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				//Here we will decrement the lighRowOneCounter for every time r1M button get Pressed
                                //If lighRowOneCounter becomes equal to 0 we will show popup message that limit reached
				if(lightRowOneCounter==0)
				{
					JOptionPane.showMessageDialog(null, "Light Color Limit reached...");
				}
				else
				{
					
					
					if(lightRowOneCounter==1)
					{
						l1r1.setBackground(new Color(20, 60, 50));
					}
					else if(lightRowOneCounter==2)
					{
						l2r1.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowOneCounter==3)
					{
						l3r1.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowOneCounter==4)
					{
						l4r1.setBackground(new Color(20, 60, 50));
					} 
					else if(lightRowOneCounter==5)
					{
						l5r1.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowOneCounter==6)
					{
						l6r1.setBackground(new Color(20, 60, 50));
					} 
					else if(lightRowOneCounter==7)
					{
						l7r1.setBackground(new Color(20, 60, 50));
					}
					lightRowOneCounter--;
				}
	        }  
	    });  
		LightControl.add(r1M);
		
                //This button will decrement the light color for row Two
		JButton r2M = new JButton("-");
		r2M.setBackground(new Color(109, 76, 36));
		r2M.setForeground(Color.white);
		r2M.setBounds(40,90,50,30);
		r2M.setFont(new java.awt.Font("Tahoma",40,18));
		r2M.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				//Here we will decrement the lighRowTwoCounter for every time r2M button get Pressed
                                //If lighRowTwoCounter becomes equal to 0 we will show popup message that limit reached
				
				if(lightRowTwoCounter==0)
				{
					JOptionPane.showMessageDialog(null, "Light Color Limit reached...");
				}
				else
				{
					
					if(lightRowTwoCounter==1)
					{
						l1r2.setBackground(new Color(20, 60, 50));
					}
					else if(lightRowTwoCounter==2)
					{
						l2r2.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowTwoCounter==3)
					{
						l3r2.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowTwoCounter==4)
					{
						l4r2.setBackground(new Color(20, 60, 50));
					} 
					else if(lightRowTwoCounter==5)
					{
						l5r2.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowTwoCounter==6)
					{
						l6r2.setBackground(new Color(20, 60, 50));
					} 
					else if(lightRowTwoCounter==7)
					{
						l7r2.setBackground(new Color(20, 60, 50));
					}
					lightRowTwoCounter--;
				}
	        }  
	    });  
		LightControl.add(r2M);
		
                //This button will decrement the light color for row Three
		JButton r3M = new JButton("-");
		r3M.setBackground(new Color(109, 76, 36));
		r3M.setForeground(Color.white);
		r3M.setBounds(40,130,50,30);
		r3M.setFont(new java.awt.Font("Tahoma",40,18));
		r3M.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				
				//Here we will decrement the lighRowThreeCounter for every time r3M button get Pressed
                                //If lighRowThreeCounter becomes equal to 0 we will show popup message that limit reached
				if(lightRowThreeCounter==0)
				{
					JOptionPane.showMessageDialog(null, "Light Color Limit reached...");
				}
				else
				{
					
					if(lightRowThreeCounter==1)
					{
						l1r3.setBackground(new Color(20, 60, 50));
					}
					else if(lightRowThreeCounter==2)
					{
						l2r3.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowThreeCounter==3)
					{
						l3r3.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowThreeCounter==4)
					{
						l4r3.setBackground(new Color(20, 60, 50));
					} 
					else if(lightRowThreeCounter==5)
					{
						l5r3.setBackground(new Color(20, 60, 50 ));
					} 
					else if(lightRowThreeCounter==6)
					{
						l6r3.setBackground(new Color(20, 60, 50));
					} 
					else if(lightRowThreeCounter==7)
					{
						l7r3.setBackground(new Color(20, 60, 50));
					}
					lightRowThreeCounter--;
				}
	        }  
	    });  
		LightControl.add(r3M);
		
		
		//This button will increment the light color for row One
		JButton r1P = new JButton("+");
		r1P.setBackground(new Color(109, 76, 36));
		r1P.setForeground(Color.white);
		r1P.setBounds(515,50,50,30);
		r1P.setFont(new java.awt.Font("Tahoma",40,15));
		r1P.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
                            //Here we will increment the lighRowOneCounter for every time r1M button get Pressed
                            //If lighRowOneCounter becomes equal to 7 we will show popup message that limit reached
                            
				if(lightRowOneCounter==7)
				{
					JOptionPane.showMessageDialog(null, "Light Color Limit Reached");
				}
				else
				{
					lightRowOneCounter++;
					//System.out.println(lightRowOneCounter);
					if(lightRowOneCounter==1)
					{
						l1r1.setBackground(new Color(154, 125, 10));
					}
					else if(lightRowOneCounter==2)
					{
						l2r1.setBackground(new Color(183, 149, 11 ));
					} 
					else if(lightRowOneCounter==3)
					{
						l3r1.setBackground(new Color(212, 172, 13 ));
					} 
					else if(lightRowOneCounter==4)
					{
						l4r1.setBackground(new Color(241, 196, 15));
					} 
					else if(lightRowOneCounter==5)
					{
						l5r1.setBackground(new Color(247, 220, 111 ));
					} 
					else if(lightRowOneCounter==6)
					{
						l6r1.setBackground(new Color(249, 231, 159 ));
					} 
					else if(lightRowOneCounter==7)
					{
						l7r1.setBackground(new Color(254, 249, 231));
					}
				}
	        }  
	    });  
		LightControl.add(r1P);
		
                //This button will increment the light color for row Two
		JButton r2P = new JButton("+");
		r2P.setBackground(new Color(109, 76, 36));
		r2P.setForeground(Color.white);
		r2P.setBounds(515,90,50,30);
		r2P.setFont(new java.awt.Font("Tahoma",40,15));
		r2P.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
                            //Here we will increment the lighRowTwoCounter for every time r2M button get Pressed
                            //If lighRowTwoCounter becomes equal to 7 we will show popup message that limit reached
				
				if(lightRowTwoCounter==7)
				{
					JOptionPane.showMessageDialog(null, "Light Color Limit Reached");
				}
				else
				{
                                        lightRowTwoCounter++;
					if(lightRowTwoCounter==1)
					{
						l1r2.setBackground(new Color(154, 125, 10));
					}
					else if(lightRowTwoCounter==2)
					{
						l2r2.setBackground(new Color(183, 149, 11 ));
					} 
					else if(lightRowTwoCounter==3)
					{
						l3r2.setBackground(new Color(212, 172, 13 ));
					} 
					else if(lightRowTwoCounter==4)
					{
						l4r2.setBackground(new Color(241, 196, 15));
					} 
					else if(lightRowTwoCounter==5)
					{
						l5r2.setBackground(new Color(247, 220, 111 ));
					} 
					else if(lightRowTwoCounter==6)
					{
						l6r2.setBackground(new Color(249, 231, 159 ));
					} 
					else if(lightRowTwoCounter==7)
					{
						l7r2.setBackground(new Color(254, 249, 231));
					}
				}
	        }  
	    });  
		LightControl.add(r2P);
		
                //This button will increment the light color for row Three
		JButton r3P = new JButton("+");
		r3P.setBackground(new Color(109, 76, 36));
		r3P.setForeground(Color.white);
		r3P.setBounds(515,130,50,30);
		r3P.setFont(new java.awt.Font("Tahoma",40,15));
		r3P.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent ae)
			{  
				//Here we will increment the lighRowThreeCounter for every time r3M button get Pressed
                                //If lighRowThreeCounter becomes equal to 7 we will show popup message that limit reached
				
				if(lightRowThreeCounter==7)
				{
					JOptionPane.showMessageDialog(null, "Light Color Limit Reached");
				}
				else
				{
					lightRowThreeCounter++;
					if(lightRowThreeCounter==1)
					{
						l1r3.setBackground(new Color(154, 125, 10));
					}
					else if(lightRowThreeCounter==2)
					{
						l2r3.setBackground(new Color(183, 149, 11 ));
					} 
					else if(lightRowThreeCounter==3)
					{
						l3r3.setBackground(new Color(212, 172, 13 ));
					} 
					else if(lightRowThreeCounter==4)
					{
						l4r3.setBackground(new Color(241, 196, 15));
					} 
					else if(lightRowThreeCounter==5)
					{
						l5r3.setBackground(new Color(247, 220, 111 ));
					} 
					else if(lightRowThreeCounter==6)
					{
						l6r3.setBackground(new Color(249, 231, 159 ));
					} 
					else if(lightRowThreeCounter==7)
					{
						l7r3.setBackground(new Color(254, 249, 231));
					}
				}
	        }  
	    });  
		LightControl.add(r3P);
		
		/****************************************************************************/
		/********** END OF Light Control operations **************************************/
		
		//Medical Gase Control Panel
		MedicalGases.setLayout(null);
		MedicalGases.setBounds(700, 490 , 650 , 200);
		MedicalGases.setBackground(new Color(109, 76, 36));
		MedicalGases.setBorder(BorderFactory.createTitledBorder("Medical Gases"));
		((javax.swing.border.TitledBorder)MedicalGases.getBorder()).setTitleColor(Color.WHITE);
		
		
                //These are labels to show the data of Medical gases. There is no interaction with these 
                //These are just viewable not for any kind of interactions
		JLabel l = new JLabel("O2");
		l.setBounds(70,35,60,50);
		l.setForeground(Color.yellow);
		
		JLabel low = new JLabel("           Low");
		low.setOpaque(true);
		low.setBackground(new Color(250, 83, 66 ));
		low.setBounds(25,75,100,70);
		
		JLabel l1 = new JLabel("N20");
		l1.setBounds(190,35,60,50);
		l1.setForeground(Color.yellow);

		JLabel high = new JLabel("           High");
		high.setOpaque(true);
		high.setBackground(new Color(250, 83, 66 ));
		high.setBounds(150,75,100,70);
		
		
		
		JLabel l2 = new JLabel("AIR1");
		l2.setBounds(310,35,60,50);
		l2.setForeground(Color.yellow);
		
		JLabel norm = new JLabel("           Norm");
		norm.setOpaque(true);
		norm.setBackground(new Color(66, 250, 130  ));
		norm.setBounds(275,75,100,70);
		
		
		JLabel l3 = new JLabel("CO2");
		l3.setBounds(440,35,60,50);
		l3.setForeground(Color.yellow);
		
		JLabel norm1 = new JLabel("           Norm");
		norm1.setOpaque(true);
		norm1.setBackground(new Color(66, 250, 130  ));
		norm1.setBounds(400,75,100,70);
		
		
		
		JLabel l4 = new JLabel("VAC");
		l4.setBounds(560,35,60,50);
		l4.setForeground(Color.yellow);
		
		
		
		JLabel high1 = new JLabel("           High");
		high1.setOpaque(true);
		high1.setBackground(new Color(250, 83, 66 ));
		high1.setBounds(525,75,100,70);
		
		
                //Adding all the labels to MedicalGases Panel
		MedicalGases.add(l);
		MedicalGases.add(l1);
		MedicalGases.add(l2);
		MedicalGases.add(l3);
		MedicalGases.add(l4);
		MedicalGases.add(low);
		MedicalGases.add(high);
		MedicalGases.add(norm);
		MedicalGases.add(norm1);
		MedicalGases.add(high1);
		
		
		//Adding all the panels of the application to the main panel
		panel.add(dayTimeClock);
		panel.add(elapsedTime);
		panel.add(TemperatureControl);
		panel.add(HumidityControl);
		panel.add(PressureControl);
		panel.add(LightControl);
		panel.add(MedicalGases);
		
		
                //revalidate the panels is to show the application as it is 
		panel.revalidate();
		dayTimeClock.revalidate();
		elapsedTime.revalidate();
		TemperatureControl.revalidate();
		HumidityControl.revalidate();
		PressureControl.revalidate();
		LightControl.revalidate();
		MedicalGases.revalidate();
		
                //panels repainted for showing it the way application is
		panel.repaint();
		dayTimeClock.repaint() ;
		elapsedTime.repaint() ;
		TemperatureControl.repaint();
		HumidityControl.repaint();
		PressureControl.repaint();
		LightControl.repaint();
		MedicalGases.repaint();
		
		
                //Adding main panel to the myFrame
		myFrame.getContentPane().add(panel);
		
		
		//myFrame is setVisible and revalidate to see as it is and to close on close operation
		myFrame.setVisible(true);
		myFrame.revalidate();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    

	} // End of main method.

	
}// End of main class.


