/*
 *  Project: Guess the Number Game
 *  Programmer:  Chris C Stevenson
 *  Date: 3/28/2018
 *  Description: A program that generates a randonm number for the user to guess.

    This program asks the user to enter a number between 1 and 10, then compares 
    that number to the one the program generated, and informs the user if they are 
    right or wrong. The user can then try again, or close the program.
*/

package guessthenumber;
 
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class GuessTheNumber
 {
   public static void main(String[] args)
   {
    boolean retry = true;
     String tryAgain;
    while (retry == true)
          {
            Random randomNumber = new Random();
            int RNG = randomNumber.nextInt(10) + 1;
            System.out.println(RNG);
            int answer = Integer.parseInt(JOptionPane.showInputDialog("I'm thinking of a number between 1 and 10, what is it?"));
            if (answer == RNG)
                {
                try
                    {
                    InputStream win = GuessTheNumber.class.getResourceAsStream("/guessthenumber/audio/fanfare.wav");
                    InputStream bufferedWin = new BufferedInputStream(win);
                    AudioInputStream audioWin = AudioSystem.getAudioInputStream(bufferedWin);
           
                    DataLine.Info info = new DataLine.Info(Clip.class, audioWin.getFormat());
                    Clip clip = (Clip)AudioSystem.getLine(info);
                    clip.open(audioWin);
                    clip.start();
                    }
                catch (Exception e)
                    {
                    JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
                    }
                tryAgain = JOptionPane.showInputDialog("You Win! \r\n Would you like to try again? (Y/N)");
                }
                else 
                    {
                    try
                        {
                        InputStream lose = GuessTheNumber.class.getResourceAsStream("/guessthenumber/audio/8bitLose.wav");
                        InputStream bufferedLose = new BufferedInputStream(lose);
           
                        AudioInputStream audioLose = AudioSystem.getAudioInputStream(bufferedLose);
           
                        DataLine.Info info = new DataLine.Info(Clip.class, audioLose.getFormat());
                        Clip clip = (Clip)AudioSystem.getLine(info);
                        clip.open(audioLose);
                        clip.start();
                        }
                    catch (IOException | LineUnavailableException | UnsupportedAudioFileException e)
                        {
                        JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
                        }
         
                    tryAgain = JOptionPane.showInputDialog("You Lose! \r\n Would you like to try again? (Y/N)");
                    }
                
                
                
                
                if (tryAgain.equalsIgnoreCase("n"))
                    {
                        retry = false;
                    }
                    
         
           }
      
    }
       
}
