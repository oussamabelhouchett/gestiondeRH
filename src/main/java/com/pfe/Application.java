package com.pfe;

import com.pfe.bean.codewarsManipulation;
import com.pfe.model.Client;
import com.pfe.model.langage;
import com.pfe.reposotory.ClientJpa;
import com.pfe.reposotory.langagerepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.pfe.scope.SessionReplicationAwareScopeMetadataResolver;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication


@ComponentScan(scopeResolver = SessionReplicationAwareScopeMetadataResolver.class)
public class Application  implements CommandLineRunner{

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        openHomePage();
    }
      private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8090/Home.xhtml");
    }
       @Autowired
 langagerepo lange;
          @Autowired
    private ClientJpa clientjpa;
         
public void save1() throws IOException  {
 List<langage> list1=new ArrayList<langage>();
        List<langage> list2=new ArrayList<langage>();
      List<Client> listclient =new ArrayList<>();
   listclient.addAll(clientjpa.findAll());
      for(Client c :listclient){
         
              list1.clear();
   if(c.getUsernamecodewars()!=null){
         list1.addAll(getListlangage1(c));
    
              System.out.println("size"+list1.size());
  langage var = (langage) list1.stream().max(Comparator.comparingInt(langage::getScore)).get(); 

  var.setIdclient1(c.getIdclient());

 
            list2.add(var);}
          } 
     List<langage> list3=new  ArrayList<>();
     list3.addAll(list2);
     list2.clear();
         list2.addAll(list3.stream().sorted(Comparator.comparing(langage::getScore)).collect(Collectors.toList()));
         for(langage l :list2){
       lange.save(l);
             System.out.println("com.pfe.Scheduler.save()"+l);
       
   }}
    @Override
    public void run(String... strings) {
    final URL url;
        try {
            url = new URL("http://www.google.com");
       
        final URLConnection conn = url.openConnection();
        conn.connect();
        conn.getInputStream().close();
        lange.deleteAll();
       save1();
            System.out.println("ok");
     } catch (MalformedURLException ex) {
        } catch (IOException ex) {
            System.out.println("thris no cnx work with local mode");
        }}
     public List<langage> getListlangage1( Client c) throws IOException {
         List<langage> listlangage =new ArrayList<>();
      
      
        
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
  
  
}
