package com.firstproject.onlineshop.model;

import com.vaadin.flow.router.Route;

@Route("add")
public class AddProduct {
    TextField textFieldMark = new TextField();
        textFieldMark.setPlaceholder("Car mark");
    TextField textFieldModel = new TextField();
        textFieldModel.setPlaceholder("Car model");
    Button button = new Button("Save car");
    Notification notification = new Notification("Car saved",3000);


    ListBox<CarType> carlist = new ListBox<>();
        carlist.setItems(CarType.SEDAN, CarType.VAN, CarType.SUV, CarType.COUPE, CarType.COMBI);

    DatePicker datePicker = new DatePicker();
}
