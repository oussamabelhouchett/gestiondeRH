/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.model.Coments;
import com.pfe.reposotory.ClientJpa;
import com.pfe.scope.ScopeName;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
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
public class Sentementnlp {
   @Autowired
    StanfordCoreNLP  stanfordcorenlp;
   
   @Autowired
           private ClientJpa clientjpa;
    HttpSession session = sessionlog.getSession();
   public String analyse(String text){

     String sentiment="";
        CoreDocument coreDocument =new CoreDocument(text);
        stanfordcorenlp.annotate(coreDocument);
       List<CoreSentence> senetnce =coreDocument.sentences();
        for(CoreSentence sentc : senetnce){
       sentiment=sentc.sentiment();
            System.out.println(sentiment+"\t"+sentc);
            
    }

     return sentiment;  
}

public resultat filter(){
    resultat res=new resultat();
    int nbrpos=0;
    int nbrneg=0;
Client client =(Client) session.getAttribute("client");
synchronized (client) {
  

session.setAttribute("client",clientjpa.findOne(client.getIdclient()));
 client =(Client) session.getAttribute("client");
}
for(Coments c :client.getListcoments()){
  if(analyse(c.getMessage()).indexOf("egative")>0)  {
  nbrneg=nbrneg+1;
  }else{
  nbrpos=nbrpos+1;
  }
}
    res.setComentnegative(nbrneg);
    res.setCommentPositive(nbrpos);
    return res;
}
public void showscan(){
session.setAttribute("active", true);
}
public void disable(){
session.setAttribute("active", false);
}
}
