import java.util.HashMap;
import java.util.Set;

public class TrackList{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Under Pressure", "Pressure pushing down on me...");
        trackList.put("Psycho Killer", "I can't seem to face up to the facts...");
        trackList.put("Alone Again", "In a little while from now...");
        trackList.put("Don't Stop Me Now", "Tonight, I'm gonna have myself a real good time...");

        Set<String> titles = trackList.keySet();
        for(String title : titles) {
            System.out.println(title + ": " + trackList.get(title));
        }
    }
}