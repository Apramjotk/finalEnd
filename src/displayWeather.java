import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class displayWeather{
    private JTextArea movieInfo;
    private JTextField movieEntryField;
    private ArrayList<weather> nowPlaying;
    private weatherLink client;

    public displayWeather()
    {
        movieInfo = new JTextArea(20, 35);
        movieEntryField = new JTextField();
        nowPlaying = new ArrayList<>();
        client = new weatherLink();  // our "networking client"
        loadNowPlaying();

        // setup GUI and load Now Playing list
    }
    private void loadNowPlaying()
    {
        // use client to make network call to Now Playing, which returns an arraylist
        // which gets assigned to the nowPlaying instance variable
        nowPlaying = client.forecast();

        // build the string to display in the movieInfo label
        String labelStr = "";
        int count = 1;
        for (weather movie : nowPlaying)
        {

            labelStr += count + ". " + movie.getLocation() + "\n";
            count++;

        }
        movieInfo.setText(labelStr);
    }

}
