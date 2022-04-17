package AppPackage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Configuration 
{
    public static Properties prop = new Properties();
    public String readFB()
    {
        String line = "";
        try 
        {
               
             prop.load(new FileInputStream("Configuration.config"));
             line = prop.getProperty("Facebook");
            
        } 
        catch (IOException e) 
        {
            
        }
       return line;
       
    }
         public String readTwitter()
    {
        String line = "";
        try 
        {
               
             prop.load(new FileInputStream("Configuration.config"));
             line = prop.getProperty("Twitter");
            
        } 
        catch (IOException e) 
        {
            
        }
       return line;
       
    }
        public String readWhatsapp()
    {
        String line = "";
        try 
        {
               
             prop.load(new FileInputStream("Configuration.config"));
             line = prop.getProperty("Whatsapp");
            
        } 
        catch (IOException e) 
        {
            
        }
       return line;
       
    }
         public String readYoutube()
    {
        String line = "";
        try 
        {
               
             prop.load(new FileInputStream("Configuration.config"));
             line = prop.getProperty("Youtube");
            
        } 
        catch (IOException e) 
        {
            
        }
       return line;
       
    }
}
