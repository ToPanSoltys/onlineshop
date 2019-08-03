package com.firstproject.onlineshop.model;

import com.firstproject.onlineshop.repository.CartRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.HasItems;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("cart")
public class CartGUI extends VerticalLayout {

@Autowired
    public void CartGUI(CartRepo cartRepo)

    {
        Label cartLabel = new Label("Twój Koszyk");

    //Lista poroduktów w koszyku
        Grid<Product> productGrid = new Grid<>(Product.class);
        productGrid.setItems(cartRepo.findAll());
        add(cartLabel,productGrid);

    }
}
