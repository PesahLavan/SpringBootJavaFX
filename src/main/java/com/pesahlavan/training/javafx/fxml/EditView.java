package com.pesahlavan.training.javafx.fxml;

import org.springframework.stereotype.Component;

@Component
public class EditView extends SpringFxmlView {

        private static final String FXML_EDIT = "com/pesahlavan/training/javafx/fxml/edit.fxml";

        public EditView() {
                super(MainView.class.getClassLoader().getResource(FXML_EDIT));
        }


}
