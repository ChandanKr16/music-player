package AppPackage;

import static AppPackage.HomeGUI.jLabel44;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.HeadlessException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextField;



public class SendEmail 
{
    
  
    
    
    
    protected Voice voice=null;
    private final String voicename = "mbrola_us1";
    private String user = "";
    private String pass = "";
    
    
    
    
    
    
    
    
    SendEmail(String to,String sub,String msg)
    {
    
        user = HomeGUI.jTextField4.getText();
        pass = HomeGUI.jTextField3.getText();
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
        {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
                                
            return new javax.mail.PasswordAuthentication(user, pass);
           
            }
                    
  
        });
        try 
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            Transport.send(message);
            if(voice!=null)
           {
             voice.deallocate();
        
           }
            new Thread()
        {
            @Override
            public void run()
            {
                System.setProperty("mbrola.base", "D:\\mbrola");
                voice =  VoiceManager.getInstance().getVoice(voicename);
                voice.allocate();
                voice.speak("Message Sent Successfully.");
                           
            }
        }.start(); 
            HomeGUI.jLabel44.setText("<html><body><b><font color=\"22B14C\" >Message : </font></b> Message Sent Successfully.</body</html>");
            
        } catch (HeadlessException | MessagingException e) 
        {
             if(voice!=null)
           {
             voice.deallocate();
        
           }
            new Thread()
        {
            @Override
            public void run()
            {
                System.setProperty("mbrola.base", "D:\\mbrola");
                voice =  VoiceManager.getInstance().getVoice(voicename);
                voice.allocate();
                voice.speak("Message Sending Failed. Please ensure that you are connected to the Internet.");
                           
            }
        }.start();
           HomeGUI.jLabel44.setText("<html><body><b><font color=\"C55D61\" >Error : </font></b> Message Sending Failed, Please ensure that you are connected to the Internet.</body</html>");
        }
        
        
    
    }
    
    
    
}
