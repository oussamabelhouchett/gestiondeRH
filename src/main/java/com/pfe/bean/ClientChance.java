package com.pfe.bean;

import com.pfe.model.langage;
import com.pfe.model.Client;
import com.pfe.model.Demande;
import com.pfe.model.SkilParDemande;
import com.pfe.reposotory.demandJpa;
import com.pfe.scope.ScopeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@Scope(ScopeName.VIEW)
public class ClientChance {
    
private  List<DemandeScore> list=new ArrayList<>();

    public List<DemandeScore> getList() {
    try {
        list.addAll(calculSkils());
    } catch (IOException ex) {
        Logger.getLogger(ClientChance.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
    }

    public void setList(List<DemandeScore> list) {
        this.list = list;
    }

    @Autowired
    private demandJpa demandejpa;
    HttpSession session = sessionlog.getSession();

    Client c1 = (Client) session.getAttribute("client");

    public class DemandeScore {
        private Demande demnade;
        private double score;

        public DemandeScore() {
        }

        public Demande getDemnade() {
            return demnade;
        }

        public void setDemnade(Demande demnade) {
            this.demnade = demnade;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

      
    }

    public List<DemandeScore> calculscoreexperience() {
        List<DemandeScore> listresultat = new ArrayList<>();
        List<Demande> list = new ArrayList<>();
        list.addAll(demandejpa.findAll());
        System.out.println("com.pfe.bean.ClientChance.calculscoreexperience()"+c1.getNom());
        for (Demande d : list) {
            int score = 0;
            if ((d.getExperience() == 0) && (c1.getNbrExperience() == 0))
                score = 10;
            if (d.getExperience() == c1.getNbrExperience())
                score = 10;
            if (c1.getNbrExperience() > d.getExperience()) {
                score = (c1.getNbrExperience() - d.getExperience()) * 20;
            }
            if (score > 30) {
                score = 30;
            }
            System.out.println("com.pfe.bean.ClientChance.calculscoreexperience()"+score);
            DemandeScore dem1 = new DemandeScore();
            dem1.setDemnade(d);
            dem1.setScore(score);
            listresultat.add(dem1);
        }
        return listresultat;
    }

    public List<DemandeScore> calculniveau() {
        List<DemandeScore> listresulta = new ArrayList<>();
        listresulta.addAll(calculscoreexperience());
        for (DemandeScore d : listresulta) {
            if (d.demnade.getNiveau().equals(c1.getNiveauScolaire()))
                d.setScore(d.getScore() + 10);
              System.err.println("niveau"+ d.getScore());
        }
        System.err.println("niveau");
        return listresulta;
    }

    @Autowired
    codewarsManipulation codewar;

    public List<DemandeScore> calculSkils() throws IOException {
        List<DemandeScore> listresulta = new ArrayList<>();
        listresulta.addAll(calculniveau());
        List<langage> listlangage = new ArrayList<>();
        listlangage.addAll(codewar.getListlangage());
        for (DemandeScore d : listresulta) {
           double s = 0;
            for (SkilParDemande de : d.getDemnade().getListskils()) {
                System.out.println("com.pfe.bean.ClientChance.calculSkils()"+de.getSkilsdemande());
                for (langage g : listlangage) {
                    if (g.getLangueP().equalsIgnoreCase(de.getSkilsdemande())) {
                          System.out.println("skils"+g.getScore());
                        s = s+(0.12*g.getScore());
                          System.out.println("skils"+(0.12*g.getScore()));
                     double score=0;
                      score=d.getScore()+s;
                      if(d.getScore()+s>=100)
                          score=90;
            d.setScore(score);
             System.out.println("s"+d.score);
                
                    }

                }
            }
           
            
        }
return listresulta;
    }

}
