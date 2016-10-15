package com.pesahlavan.training.javafx.fxml;

import org.springframework.stereotype.Component;

@Component
public class MainView extends SpringFxmlView {

    private static final String FXML_MAIN = "com/pesahlavan/training/javafx/fxml/main.fxml";

    public MainView() {
        super(MainView.class.getClassLoader().getResource(FXML_MAIN));
    }
}
