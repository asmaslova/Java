import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    private Clip backgroundMusic;

    public void playMusic() {
        try {
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(AudioSystem.getAudioInputStream(new File("music/super_beat1.wav")));
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
