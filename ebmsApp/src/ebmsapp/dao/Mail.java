/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import java.util.Properties;    
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;    
import javax.mail.internet.*;

/**
 *
 * @author Thug17
 */
public class Mail {
    
    final String username = "cabreltchomte97@gmail.com";
    final String password = "Allemagne";
    
    public void sendMail(String from,String to,String sub,String msg,String filename)
    {
         Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(username,password);  
           }    
          }); 
          
          try {
            
              MimeMessage message = new MimeMessage(session);
              message.setFrom(new InternetAddress(from));
              message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
              message.setSubject(sub);
              BodyPart messageBodyPart = new MimeBodyPart();
              messageBodyPart.setText(msg);
              Multipart multipart = new MimeMultipart();
              multipart.addBodyPart(messageBodyPart);
              
              if(filename.equals("")){
                  message.setContent(multipart);
                  Transport.send(message);
              }else{
                  messageBodyPart = new MimeBodyPart();
                  DataSource source = new FileDataSource(filename);
                  messageBodyPart.setDataHandler(new DataHandler(source));
                  messageBodyPart.setFileName(filename);
                  multipart.addBodyPart(messageBodyPart);
                  message.setContent(multipart);
                  Transport.send(message);
              }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
          
    }
}
