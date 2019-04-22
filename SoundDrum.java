/*
 * Copyright (c) 1995-1997 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
import java.applet.*;
import java.awt.*;

public class SoundDrum extends Applet {
	
    SoundList soundList;
    
    String hiTomFile = "Hi-Tom-2.wav";
    String lowTomFile = "Low-Tom-2.wav";
    String snareFile = "snare.wav";
    String hiHatFile = "110chh1.wav"; 
    String midTomFile = "Mid-Tom-2.wav";
    String bassFile = "Deep-Kick.wav";
    String crashFile = "Crash-Cymbal-2.wav";
    String rideFile = "Korg-NS5R-Power-Ride-Cymbal (1).wav";
    String ourFile = "/Users/ruchimangtani/drums.wav";
    
    Button hiTomButton;
    Button lowTomButton;
    Button snareButton;
    Button hiHatButton; 
    Button midTomButton;
    Button bassButton;
    Button crashButton;
    Button rideButton;
    Button recordButton;
    Button playbackButton;
    

    public void init() {
    	
    	setLayout (null);
    	setBackground(Color.BLACK);
    	resize(250, 500 );
    	
      	
        hiTomButton = new Button("hiTom");
        hiTomButton.setSize(125, 100);
        hiTomButton.setLocation(0,100);
        hiTomButton.setForeground(Color.BLUE);
        add(hiTomButton);
        
        lowTomButton = new Button("lowTom");
        lowTomButton.setSize(125, 100);
        lowTomButton.setLocation(0,200);
        add(lowTomButton);
       
        hiHatButton = new Button("hiHat");
        hiHatButton.setSize(125, 100);
        hiHatButton.setLocation(0, 300);
        add(hiHatButton);
        
        snareButton = new Button("Snare");
        snareButton.setSize(125, 100);
        snareButton.setLocation(0, 400);     
        add(snareButton);
        
        midTomButton = new Button ("midTom");
        midTomButton.setSize(125, 100);
        midTomButton.setLocation(125, 100);
        add(midTomButton);
        
        bassButton = new Button ("Bass");
        bassButton.setSize(125,100);
        bassButton.setLocation(125, 200);
        add(bassButton);
        
        crashButton = new Button ("Crash");
        crashButton.setSize(125,100);
        crashButton.setLocation(125, 300);
        add(crashButton);
        
        rideButton = new Button ("Ride");
        rideButton.setSize(125,100);
        rideButton.setLocation(125, 400);
        add(rideButton);
        
        recordButton = new Button("record");
        recordButton.setSize(125,100);
        recordButton.setLocation(0, 500);
        add(recordButton);
        
        playbackButton = new Button("playback");
        playbackButton.setSize(125,100);
        playbackButton.setLocation(125, 500);
        add(playbackButton);
        
        validate();
        startLoadingSounds();
    }

    void startLoadingSounds() {
        //Start asynchronous sound loading.
        soundList = new SoundList(this, getCodeBase());
       
        soundList.startLoading(lowTomFile);
        soundList.startLoading(snareFile); 
        soundList.startLoading(hiTomFile);
        soundList.startLoading(hiHatFile);
        soundList.startLoading(midTomFile);
        soundList.startLoading(bassFile);
        soundList.startLoading(crashFile);
        soundList.startLoading(rideFile);
       
     }

    public boolean action(Event event, Object arg) {
        //hiTom BUTTON
        
    	if (event.target == hiTomButton) 
    		play(hiTomFile);
    	if (event.target == lowTomButton) 
    		play(lowTomFile);
    	if (event.target == snareButton)
    		play(snareFile);
    	if (event.target == hiHatButton)
    		play(hiHatFile);
    	if (event.target == midTomButton)
    		play(midTomFile);
    	if (event.target == bassButton)
    		play(bassFile);
    	if (event.target == crashButton)
    		play(crashFile);
    	if (event.target == rideButton)
    		play(rideFile);
    	if (event.target == recordButton)
    		record();
    	if (event.target == playbackButton) {
    		 play(ourFile);
    	}
    	
        return false; //some event I don't know about...
    }
    
    public boolean play(String whatToPlay) {
  
          
            AudioClip onceClip = null;
            if (onceClip == null) {
                 //Try to get the AudioClip.
                 onceClip = soundList.getClip(whatToPlay);
              
             }

             if (onceClip != null) {  //If the sound is loaded:
                 onceClip.play();     //Play it once.
                 showStatus("Playing sound " + whatToPlay + ".");
             } else {
                 showStatus("Sound " + whatToPlay + " not loaded yet.");
             }
             return true;
         }
    
    
    public void record() {
        final Recording recorder = new Recording();
 
        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
               
                recorder.finish();
                
                soundList.startLoading(ourFile);
                System.out.println("Recorder finished");
            }
        });
        stopper.start();
 
        // start recording
        recorder.startRecording();
    }
    
}
    












