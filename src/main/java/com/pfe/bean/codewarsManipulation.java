/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;
import com.pfe.model.langage;
import com.pfe.model.Client;
import com.pfe.reposotory.ClientJpa;
import com.pfe.reposotory.langagerepo;
import com.pfe.scope.ScopeName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
/**
 *
 * @author PROGRAMEUR
 */

@Component
@Scope(ScopeName.VIEW)
@ManagedBean
@ViewScoped
public class codewarsManipulation {
    private String username;
    
private List<langage> listlangage=new ArrayList<>();
    HttpSession session =sessionlog.getSession();
    @Autowired
    private ClientJpa clientjpa;
       public void setListlangage(List<langage> listlangage) {
        this.listlangage = listlangage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public List<langage> getListlangage() throws IOException {
        listlangage.clear();
        int idclient =0;
        idclient=(int)session.getAttribute("idclient");
        Client c=new Client();
        c=clientjpa.findOne(idclient);
        if((c.getUsernamecodewars()!=null)){
        JSONObject json=readJsonFromUrl("https://www.codewars.com/api/v1/users/"+c.getUsernamecodewars());
JSONObject que1Obj = json.getJSONObject("ranks");
JSONObject address = que1Obj.getJSONObject("languages"); 
        String ch =address.toString();
   
       String ch1=ch.substring(1,ch.length());
        List<String> list1=new ArrayList<>();
        list1.addAll(Arrays.asList(ch1.split("}")));
        int i=0;
        for(String s :list1){
            String st1="";
            String st2="";
            langage g=new langage();
          
        List<String> list2=new ArrayList<>();
        if(i==0){
      st1=s.substring(0,s.indexOf("{"));
 st2=s.substring(s.indexOf("{"),s.length());

        }else{
     st1=s.substring(1,s.indexOf("{"));
      st2=s.substring(s.indexOf("{"),s.length());}
        
                g.setLangueP(st1.substring(1,st1.length()-2));
          g.setScore(Integer.parseInt(st2.substring(9, st2.indexOf(","))));
         
           listlangage.add(g);
        i++;
        }
  
        
        }
        
        return listlangage;
    }
 public List<langage> getListlangage1( Client c) throws IOException {
        listlangage.clear();
      
        
        if((c.getUsernamecodewars()!=null)){
        JSONObject json=readJsonFromUrl("https://www.codewars.com/api/v1/users/"+c.getUsernamecodewars());
JSONObject que1Obj = json.getJSONObject("ranks");
JSONObject address = que1Obj.getJSONObject("languages"); 
        String ch =address.toString();
   
       String ch1=ch.substring(1,ch.length());
        List<String> list1=new ArrayList<>();
        list1.addAll(Arrays.asList(ch1.split("}")));
        int i=0;
        for(String s :list1){
            String st1="";
            String st2="";
            langage g=new langage();
          
        List<String> list2=new ArrayList<>();
        if(i==0){
      st1=s.substring(0,s.indexOf("{"));
 st2=s.substring(s.indexOf("{"),s.length());

        }else{
     st1=s.substring(1,s.indexOf("{"));
      st2=s.substring(s.indexOf("{"),s.length());}
        
                g.setLangueP(st1.substring(1,st1.length()-2));
          g.setScore(Integer.parseInt(st2.substring(9, st2.indexOf(","))));
    
           listlangage.add(g);
        i++;
        }
  
        
        }
        
        return listlangage;
    }

   private String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  
  }
  
    public void scancodeware() throws IOException{
       
        System.out.println("valeur"+username);
             int idclient =0;
        idclient=(int)session.getAttribute("idclient");
        clientjpa.setnomcodewars(username, idclient);
JSONObject json=readJsonFromUrl("https://www.codewars.com/api/v1/users/"+username);
JSONObject que1Obj = json.getJSONObject("ranks");
JSONObject address = que1Obj.getJSONObject("languages"); 
        String ch =address.toString();
        System.out.println("App.main()"+ch);
        // iterating address Map 
       String ch1=ch.substring(1,ch.length());
        System.out.println("App.main()");
  
        List<String> list1=new ArrayList<>();
        list1.addAll(Arrays.asList(ch1.split("}")));
        int i=0;
       
        for(String s :list1){
            String st1="";
            String st2="";
            langage g=new langage();
            System.out.println("App.main()"+s);
        List<String> list2=new ArrayList<>();
        if(i==0){
      st1=s.substring(0,s.indexOf("{"));
 st2=s.substring(s.indexOf("{"),s.length());

        }else{
     st1=s.substring(1,s.indexOf("{"));
      st2=s.substring(s.indexOf("{"),s.length());}
            System.out.println("App.main()"+st1);
                System.out.println("App.main()"+st2);
                g.setLangueP(st1.substring(1,st1.length()-2));
          g.setScore(Integer.parseInt(st2.substring(9, st2.indexOf(","))));
            System.out.println(g);
        i++;
        }
     
              




 
    
    }
    
}
