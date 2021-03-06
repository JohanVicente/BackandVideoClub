package co.edu.sena.adsi.rest.utils;

import co.edu.sena.adsi.jpa.entities.Usuario;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class SendEmail {
    
    private static final String HOSTNAME = "smtp.gmail.com"; 
    private static final String EMAIL = "pruebas.software.rrv@gmail.com"; 
    private static final String PASSWORD = "prueba2016"; 
    private static final int PUERTO = 465; 
    private static final boolean ISSSL = true; 
    private static final boolean ISAUTHENTICATION = true; 
    
    public void sendEmailRegistroUsuario(Usuario user, String pass){
        
        /*HtmlEmail email = new HtmlEmail();
        email.setHostName(HOSTNAME);
        email.setSmtpPort(PUERTO);
        email.setAuthenticator(
            new DefaultAuthenticator(EMAIL,PASSWORD));
        if(ISAUTHENTICATION){
            email.setAuthentication(EMAIL, PASSWORD);
        }
        
        email.setSSLOnConnect(ISSSL);
        email.setFrom(EMAIL);
        email.setCharset("UTF-8");
        email.setSubject("Registro OK");*/
        
       try{
          HtmlEmail email = new HtmlEmail();
          email.setHostName(HOSTNAME);
          email.setSmtpPort(PUERTO);
          email.setAuthenticator(
            new DefaultAuthenticator(EMAIL,PASSWORD));
        if(ISAUTHENTICATION){
            email.setAuthentication(EMAIL, PASSWORD);
        }
        
        email.setSSLOnConnect(ISSSL);
        email.setFrom(EMAIL);
        email.setCharset("UTF-8");
        email.setSubject("Registro OK");
        
        //Start contenido Email
        
        StringBuilder sb = new StringBuilder();  
        sb.append("Bienvenido "); 
        sb.append("Plataforma ADSI ");
        sb.append("EJEMPLO! ");
        sb.append("Bienvenido ");
        sb.append("<h1>Este es el h1</h1>");
        sb.append("Su nombre es: ");
        sb.append(user.getNombres());
        sb.append("Su password es: ");
        sb.append(pass);
        
        email.setHtmlMsg(sb.toString());
        //End contenido Email
        email.addTo(user.getEmail());
        email.send();
        
       }catch(EmailException e) {
           System.out.println("ERROR "+ e);
         
       }
        
        
    }//final del metodo sendEmailRegistroUsuario
    
      
}//final de sendEmail
