package com.firstproject.onlineshop.model;

import com.firstproject.onlineshop.model.subsidiaryModels.HeaderGridItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("main")
public class MainPageGUI extends VerticalLayout {

    public class Header extends HorizontalLayout {
        Icon logo = new Icon(VaadinIcon.COGS);

    }
    public class Center extends VerticalLayout {


    }
    public MainPageGUI(){
        Grid<HeaderGridItem> contactGrid = new Grid<>(HeaderGridItem.class);
        List<HeaderGridItem> gridList = new ArrayList<>();
        gridList.add(new HeaderGridItem(new Icon(VaadinIcon.PHONE), "58 876 54 32"));
        gridList.add(new HeaderGridItem(new Icon(VaadinIcon.MAILBOX), "kontakt@kandk"));
        contactGrid.setItems(gridList);
        Header header = new Header();
        Icon icon = new Icon(VaadinIcon.COGS);
        TextField textField = new TextField("Search Bar");
        textField.setPlaceholder("What are you looking for?");
        Button buttonSearch = new Button("Search");


        header.add(new Icon(VaadinIcon.COGS),textField,buttonSearch, contactGrid);
        add(header);

    }



}
