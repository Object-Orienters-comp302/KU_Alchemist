package Sound;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;



public class DJ {
    
    public static DJ DJInstance;
    Clip BackgroundSound,EffectSound;
    int backStoppedAt=0;
    Boolean backgroundRunning=false;
    
    public DJ(){}
    
    public static DJ getDJ(){
        if (DJInstance==null){
            DJInstance= new DJ();
        }
        return DJInstance;
    }
    
    public void setBackgroundSound(BackgroundSounds path) {
        try {
            File file = new File(path.getPath());
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            BackgroundSound = AudioSystem.getClip();
            BackgroundSound.open(stream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    public void startBackgroundSound() {
        try {
            BackgroundSound.start();
            backStoppedAt=0;
            backgroundRunning=true;
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    public void stopBackgroundSound(){
        if(BackgroundSound!=null){
            BackgroundSound.stop();
            backgroundRunning=false;
        }
    }
    public void pauseBackgroundSound() {
        backStoppedAt = BackgroundSound.getFrameLength() - BackgroundSound.getFramePosition();
        if (BackgroundSound != null) {
            BackgroundSound.stop();
            backgroundRunning=false;
        }
    }
    
    public void continueBackgroundSound() {
        BackgroundSound.setFramePosition(BackgroundSound.getFrameLength() - backStoppedAt);
        BackgroundSound.start();
        backgroundRunning=true;
    }
    
    public void setAndStartBackgroundSound(BackgroundSounds path) {
        stopBackgroundSound();
        setBackgroundSound(path);
        startBackgroundSound();
    }
    
    public void adjustBackgroundVolume(float volume) {
        if (BackgroundSound != null) {
            // Get the FloatControl for controlling volume
            FloatControl gainControl = (FloatControl) BackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
            
            // Set the new volume (in decibels)
            gainControl.setValue(gainControl.getValue()+volume);
        }
    }
    
    public void setEffectSound(EffectSounds path) {
        try {
            File file = new File(path.getPath());
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            EffectSound = AudioSystem.getClip();
            EffectSound.open(stream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    public void startEffectSound() {
        try {
            EffectSound.start();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    public void startEffectSound(int ms) {
        try {
            if (backgroundRunning) {
                pauseBackgroundSound();
                EffectSound.start();
                Timer timer = new Timer(1530, (e) -> {
                    continueBackgroundSound();
                });
                timer.setRepeats(false);
                timer.start();
            }
            else {
                EffectSound.start();
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    public void setAndStartEffectSound(EffectSounds path) {
        setEffectSound(path);
        startEffectSound();
    }
    public void setAndStartEffectSound(EffectSounds path,int ms) {
        setEffectSound(path);
        startEffectSound(ms);
    }
    
    
    public static enum BackgroundSounds {
        TRACK1("resources/Sounds/Background/Rick-Astley-Never-Gonna-Give-You-Up-_Official-Music-Video_ (1).wav"),
        TRACK2("resources/Sounds/Background/Enchanter.wav"),
        TRACK3("resources/Sounds/Background/Around the fire.wav"),
        TRACK4("resources/Sounds/Background/Taverns of Azeroth.wav"),
        TRACK5("resources/Sounds/Background/Reverse Dance.wav")
        
        ;
        
        
        private final String path;
        
        BackgroundSounds(String path) {
            this.path = path;
        }
        
        public String getPath() {
            return path;
        }
    }
    
    public enum EffectSounds {
        LEAVES("resources/Sounds/Effects/leaves-rustling.wav"),
        CHACHING("resources/Sounds/Effects/cha_ching.wav"),
        COIN("resources/Sounds/Effects/coins.wav"),
        BUTTON("resources/Sounds/Effects/buttonSound.wav"),
        FIRE("resources/Sounds/Effects/fire.wav"),
        EXPLOSION("resources/Sounds/Effects/magicExplosion.wav"),
        ;
        
        
        private final String path;
        
        EffectSounds(String path) {
            this.path = path;
        }
        
        public String getPath() {
            return path;
        }
    }

}
