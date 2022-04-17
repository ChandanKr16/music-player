package AppPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3Class 
{
    
    public Player player=null;
    FileInputStream FIS;
    BufferedInputStream BIS;
    public long pauseLocation;
    public long songTotalLength;
    public String fileName;
     
    public void stop()
    {
        if(player!=null)
        {
            player.close();
            songTotalLength = 0;
            pauseLocation = 0;
            fileName = "";
        }
    }
    
    
    public void play(String path)
    {
        try 
        {
            if(player!=null)
              {
                    player.close();
              }
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            songTotalLength = FIS.available();
            fileName = path+"";
        } 
        catch (FileNotFoundException | JavaLayerException e) 
        {
            
        } catch (IOException ex) {
            
        }
        new Thread()
        {
            public void run()
            {
                try 
                {
                   
                  player.play();
                 
                  if(player.isComplete() && HomeGUI.count==1)
                  {
                      play(fileName);
                  }
                } 
                catch (JavaLayerException ex) 
                {
                  
                }
            }
        
        }.start();
    
    }
    
    
    public void pause()
    {
        if(player !=null)
        {
            try 
            {
                pauseLocation = FIS.available();
                player.close();
            } 
            catch (IOException e) 
            {
            }
        }
    
    }
    
    public void resume() 
    {
        try 
        {
            FIS = new FileInputStream(fileName);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(songTotalLength - pauseLocation);
           
        } 
        catch (FileNotFoundException | JavaLayerException ex) 
        {
        } catch (IOException ex) 
        {
        }
          new Thread()
            {
                public void run()
                {
                    try 
                    {
                        player.play();
                    } 
                catch (JavaLayerException ex) 
                {
                }
                }
        
            }.start(); 
            
        
    
    
    }
    
}
