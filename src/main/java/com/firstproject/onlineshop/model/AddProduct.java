package com.firstproject.onlineshop.model;

import com.firstproject.onlineshop.repository.ProductRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Route("add")
public class AddProduct extends VerticalLayout {
    public ProductRepo repo;

    @Autowired
    public AddProduct(ProductRepo repo) {
        TextField textFieldName = new TextField();
        textFieldName.setPlaceholder("Product Type");
        TextField textFieldPrice = new TextField();
        Button button = new Button("Save product");
        Notification notification = new Notification("Product saved", 3000);
        ListBox<ProductType> productList = new ListBox<>();
        productList.setItems(ProductType.CPU, ProductType.GPU, ProductType.PSU, ProductType.MOBO, ProductType.RAM, ProductType.HDD_SSD, ProductType.CASE, ProductType.ACCESSORY, ProductType.SOFTWARE);
        double price = Double.parseDouble(textFieldPrice.getValue());


        button.addClickListener(clickEvent -> {
            Product newProduct = new Product();
            newProduct.setName(textFieldName.getValue());
            newProduct.setPrice(price);
            newProduct.setProductType(productList.getValue());
            repo.save(newProduct);
            notification.open();
        });

        add(textFieldName, textFieldPrice, productList, button);

    }


}
