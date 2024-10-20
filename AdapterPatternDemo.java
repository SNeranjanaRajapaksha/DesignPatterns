// MediaPlayer interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// VlcPlayer class
class VlcPlayer {
    void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }
}

// Adapter class implementing MediaPlayer interface
class MediaAdapter implements MediaPlayer {

    VlcPlayer vlcPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            vlcPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            vlcPlayer.playVlc(fileName);
        }
    }
}

// AudioPlayer class implementing MediaPlayer interface
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// Testing the Adapter Pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("mp3", "song.mp3");
    }
}

