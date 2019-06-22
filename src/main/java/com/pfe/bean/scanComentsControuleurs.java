/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.model.Entreprise;
import com.pfe.reposotory.ClientJpa;
import com.pfe.scope.ScopeName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ScopeName.VIEW)
 @ManagedBean
        @SessionScoped
public class scanComentsControuleurs {
    private boolean active =false;
    private PieChartModel livePieModel;
       @Autowired
           private ClientJpa clientjpa;
    private HorizontalBarChartModel horizontalBarModel;
 HttpSession session =sessionlog.getSession();
    public boolean isActive() {
        active =(boolean) session.getAttribute("active");
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Sentementnlp getSe() {
        return se;
    }

    public void setSe(Sentementnlp se) {
        this.se = se;
    }
    
    @PostConstruct
    public void init() {
        createPieModels();
        createBarModels();
       session.setAttribute("active",false);
    }
  public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  @Autowired
          private Sentementnlp se;
    public PieChartModel getLivePieModel() {
        Client client =(Client) session.getAttribute("client");
    synchronized (client) {
  

session.setAttribute("client",clientjpa.findOne(client.getIdclient()));
 client =(Client) session.getAttribute("client");
}

        livePieModel.getData().put("Positive", se.filter().getCommentPositive());
        livePieModel.getData().put("Negative", se.filter().getComentnegative());
        livePieModel.setTitle("Comments");
        livePieModel.setLegendPosition("ne");
        return livePieModel;
    }
    private void createPieModels() {
        createLivePieModel();
    }
    private void createLivePieModel() {
        livePieModel = new PieChartModel();
 
        livePieModel.set("Positive", se.filter().getCommentPositive());
        livePieModel.set("Negative", se.filter().getComentnegative());
    } 
     private void createBarModels() {

        createHorizontalBarModel();
    }
 

 
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Aceptation");
        boys.set("valide", 50);
      
 
       
        horizontalBarModel.addSeries(boys);

 
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
 
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("%");
        xAxis.setMin(0);
        xAxis.setMax(100);
 
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }
    
   public String cheak(){
    Client e = (Client)session.getAttribute("client");
   String ch="";
    if(e==null){
    ch="LoginForClient";
    
    }
    return ch;}
}
