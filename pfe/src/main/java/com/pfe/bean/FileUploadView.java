/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.Service.LoginService;
import com.pfe.model.Client;
import com.pfe.scope.ScopeName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author PROGRAMEUR
 */
@Component
@Scope(ScopeName.VIEW)
 @ManagedBean
        @SessionScoped
public class FileUploadView {
    @Autowired
           private LoginService loginservice;
   private UploadedFile file;
 
   HttpSession session = sessionlog.getSession();
   private Client client;

    public Client getClient() {
        
        client=(Client) session.getAttribute("client");
        System.out.print("ff"+client.getCvForum());
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        System.out.println("hello");
            FacesMessage message = new FacesMessage("Succesful", "hello"+ " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
      
    }
      public void copyfile(String filename,InputStream in) throws IOException {
              OutputStream out;
     
           out = new FileOutputStream(new File("E:\\spring-boot-jsf-master\\src\\main\\resources\\META-INF\\resources\\css\\"+filename));
      
         System.err.println("New file created!");
        int read = 0;
        byte[] bytes = new byte[1024];

     
           while ((read = in.read(bytes)) != -1) {
               out.write(bytes, 0, read);
           }
      
        in.close();
        out.flush();
        out.close();
        System.err.println("New file created!");}
    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("com.pfe.bean.FileUploadView.handleFileUpload()"+file.getFileName());
        try{
            copyfile(file.getFileName(),file.getInputstream());
        }catch(Exception e){
            e.getStackTrace();
        }
     
    }
        public void updatecv(){
            
        client=(Client) session.getAttribute("client");
            System.out.println("hello"+client.getIdclient());
            loginservice.update(file.getFileName(),client.getIdclient());
            session.setAttribute("etat", true);
            
}
}