/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.scope.ScopeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DragDropEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author PROGRAMEUR
 */
@Component
@Scope(ScopeName.VIEW)
@ManagedBean
@ViewScoped
public class ItemsBean {
  private List<String> items;
  private List<String> selectedItems = new ArrayList<>();

  @PostConstruct
  public void postConstruct() {
      items = new ArrayList<>(Arrays.asList(
              "Shane", "Amber", "Kiley"));
  }

  public List<String> getItems() {
      return items;
  }

  public void onItemDropped(DragDropEvent event) {
      String item = (String) event.getData();
      selectedItems.add(item);
      items.remove(item);
  }

  public List<String> getSelectedItems() {
      return selectedItems;
  }
}