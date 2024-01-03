package Sound;
import Domain.GameController;
import Utils.AssetLoader;
import jdk.dynalink.beans.StaticClass;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class DJ {
    
    public static DJ DJInstance;
    Clip BackgroundSound;
    Clip EffectSound;
    
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
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    public void setAndStartBackgroundSound(BackgroundSounds path) {
        setBackgroundSound(path);
        startBackgroundSound();
    }
    
    public void adjustBackgroundVolume(float volume) {
        if (BackgroundSound != null) {
            // Get the FloatControl for controlling volume
            FloatControl gainControl = (FloatControl) BackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
            
            // Set the new volume (in decibels)
            gainControl.setValue(volume);
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
            adjustBackgroundVolume(-20.0f);
            EffectSound.start();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    public void setAndStartEffectSound(EffectSounds path) {
        setEffectSound(path);
        startEffectSound();
    }
    
    
    public enum BackgroundSounds {
        TRACK1("Sounds/Background/Rick-Astley-Never-Gonna-Give-You-Up-_Official-Music-Video_ (1).wav"),
        
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
        TRACK1("Sounds/Effects/leaves-rustling.wav"),
        
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
