package com.firstproject.onlineshop.model;

import com.firstproject.onlineshop.model.subsidiaryModels.HeaderGridItem;
import com.firstproject.onlineshop.repository.ProductRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class MainPageGUI extends HorizontalLayout {
    @Autowired
    public MainPageGUI(ProductRepo productRepo) {
//        VerticalLayout contactLayout = new VerticalLayout();


        Div headerDiv = new Div();
        Icon iconLogo = new Icon(VaadinIcon.COGS);
        TextField searchBar = new TextField("Search Bar");
        searchBar.setPlaceholder("Szukaj...");
        Details contactComponent = new Details("Kontakt:", new Text("Telefon 555-555-555"));
        contactComponent.addContent(new Text("E-mail: KandK@gmail.com"));
        contactComponent.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
        Label labelPhoneContact = new Label("Telefon 555-555-555");
        Label labelEmaillContact = new Label("E-mail: KandK@gmail.com");
        Icon iconCart = new Icon(VaadinIcon.CART);
        Div contactDiv = new Div();
        headerDiv.add(iconLogo, searchBar, contactComponent, iconCart);
        Div productListDiv = new Div();
        Grid<Product> productGrid = new Grid<>(Product.class);
        productGrid.setItems(productRepo.findAll());
        productListDiv.add(productGrid);
        Div productTypeListDiv = new Div();
        ListBox<ProductType> productTypeList = new ListBox<>();
        productTypeList.setItems(ProductType.CPU, ProductType.GPU, ProductType.PSU, ProductType.MOBO, ProductType.RAM, ProductType.HDD_SSD, ProductType.CASE, ProductType.ACCESSORY, ProductType.SOFTWARE);
        productTypeListDiv.add(productTypeList);
        Button filterButton = new Button("Filtruj");
        filterButton.addClickListener(clickEvent -> {
            List<Product> tempList = new ArrayList<>();
            tempList = productRepo.findAll();
            productGrid.setItems(tempList.stream().filter(product -> product.getProductType().equals(productTypeList.getValue())));
        });

//        Grid<HeaderGridItem> contactGrid = new Grid<>(HeaderGridItem.class);
//        List<HeaderGridItem> gridList = new ArrayList<>();
//        gridList.add(new HeaderGridItem(new Icon(VaadinIcon.PHONE), "58 876 54 32"));
//        gridList.add(new HeaderGridItem(new Icon(VaadinIcon.MAILBOX), "kontakt@kandk"));
//        contactGrid.setItems(gridList);
//        Icon icon = new Icon(VaadinIcon.COGS);
//        TextField textField = new TextField("Search Bar");
//        textField.setPlaceholder("What are you looking for?");
//        Button buttonSearch = new Button("Search");
//        Div headerDiv = new Div();
//        headerDiv.add();
//
//
//
//
//        header.add(new Icon(VaadinIcon.COGS),textField,buttonSearch, contactGrid);
        add(headerDiv,filterButton, productGrid, productTypeListDiv);

    }


}
