package com.pfe.bean;


import com.pfe.model.poucentage;
import com.pfe.reposotory.poucentagerepo;
import com.pfe.scope.ScopeName;


import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ScopeName.VIEW)
public class ChartJsView {
     private BarChartModel barModel;

    public BarChartModel getBarModel() {
        return barModel;
    }
@Autowired
private poucentagerepo  repo;
    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
 
    @PostConstruct
    public void init() {
      createBarModel();
     }
  public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();
         List<poucentage> list=new ArrayList<>();
         list.addAll(repo.findAll());
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("nombre des  entreprises ");
         
        List<Number> values = new ArrayList<>();
        values.add(list.get(0).getNbre());
        values.add(list.get(1).getNbre());
        values.add(list.get(2).getNbre());
        values.add(list.get(3).getNbre());
      
       
        barDataSet.setData(values);
         
        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 159, 64, 0.2)");
        bgColor.add("rgba(255, 205, 86, 0.2)");
        bgColor.add("rgba(75, 192, 192, 0.2)");
        bgColor.add("rgba(54, 162, 235, 0.2)");
        bgColor.add("rgba(153, 102, 255, 0.2)");
        bgColor.add("rgba(201, 203, 207, 0.2)");
        barDataSet.setBackgroundColor(bgColor);
         
        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        borderColor.add("rgb(255, 205, 86)");
        borderColor.add("rgb(75, 192, 192)");
        borderColor.add("rgb(54, 162, 235)");
        borderColor.add("rgb(153, 102, 255)");
        borderColor.add("rgb(201, 203, 207)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);
         
        data.addChartDataSet(barDataSet);
         
        List<String> labels = new ArrayList<>();
        labels.add(""+list.get(0).getAnnee());
        labels.add(""+list.get(1).getAnnee());
        labels.add(""+list.get(2).getAnnee());
        labels.add(""+list.get(3).getAnnee());
        
        data.setLabels(labels);
        barModel.setData(data);
         
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
         
    
 
        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);
 
        barModel.setOptions(options);
    }
     
   
     
 

   
 
 
   
}

