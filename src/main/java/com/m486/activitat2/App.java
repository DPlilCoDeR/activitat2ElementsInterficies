package com.m486.activitat2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(15);
        root.setVgap(10);

        //Primera Part
        Label title = new Label("Configuració de l'Esdeveniment");
        title.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold");
        root.add(title,0,0, 2, 1);

        Label nomField =  new Label("Nom de l'Esdeveniment:");
        root.add(nomField,0,1);

        TextField nomFieldT = new TextField();
        nomFieldT.setPromptText("Nom de l'Esdeveniment");
        root.add(nomFieldT,1,1);

        Label passField =  new Label("Password:");
        root.add(passField,0,2);
        PasswordField passFieldT = new PasswordField();
        passFieldT.setPromptText("*****");
        root.add(passFieldT,1,2);

        Label descriptionField =  new Label("Description:");
        root.add(descriptionField,0,3);
        TextArea DescriptionField = new TextArea();
        DescriptionField.setPromptText("Descripcio de l'esdeveniment");
        root.add(DescriptionField,1,3);

        //Segona Part
        Label tipusLabel =  new Label("Tipus d'Accés:");
        root.add(tipusLabel,0,4);
        ToggleGroup tipusGroup = new ToggleGroup();
        RadioButton presencialBtn = new RadioButton("Presencial");
        RadioButton onlineBtn = new RadioButton("Online");
        RadioButton hibridBtn = new RadioButton("Hibrid");
        presencialBtn.setToggleGroup(tipusGroup);
        presencialBtn.alignmentProperty();
        onlineBtn.setToggleGroup(tipusGroup);
        hibridBtn.setToggleGroup(tipusGroup);
        GridPane radioButtons = new GridPane();
        radioButtons.setPadding(new Insets(5));
        radioButtons.setHgap(10);
        radioButtons.add(presencialBtn,0,0);
        radioButtons.add(onlineBtn,1,0);
        radioButtons.add(hibridBtn,2,0);
        root.add(radioButtons,1,4);

        Label aditionalLable =  new Label("Serveis Adicionals:");
        root.add(aditionalLable,0,5);
        CheckBox cateringCheckBox = new CheckBox("Catering");
        CheckBox vipCheckBox = new CheckBox("Zona Vip");
        CheckBox hdCheckBox = new CheckBox("Enregistrament HD");
        GridPane aditionalGrid = new GridPane();
        aditionalGrid.setPadding(new Insets(5));
        aditionalGrid.setHgap(10);
        aditionalGrid.add(cateringCheckBox,0,0);
        aditionalGrid.add(vipCheckBox,1,0);
        aditionalGrid.add(hdCheckBox,2,0);
        root.add(aditionalGrid,1,5);

        Label estatLabel =  new Label("Estat de l'Edicio:");
        root.add(estatLabel,0,6);
        ToggleButton estatBtn = new ToggleButton("Estat Esborrany");
        root.add(estatBtn,1,6);

        Hyperlink hyperlink = new Hyperlink("Obrir politica de privacitat");
        root.add(hyperlink,0,7);

        Label recursoLabel =  new Label("Recursos:");
        root.add(recursoLabel,0,8);
        MenuButton menuButton = new MenuButton("PDF");
        menuButton.getItems().addAll(new MenuItem("PNG"));
        for(MenuItem item : menuButton.getItems()){
            item.setOnAction(e -> menuButton.setText(item.getText()));
        }
        root.add(menuButton,1,8);

        //Tercera Part
        Label dateLabel =  new Label("Data:");
        root.add(dateLabel,0,9);
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        root.add(datePicker,1,9);

        Label cityLabel =  new Label("Ciutat:");
        root.add(cityLabel,0,10);
        ObservableList<String> items = FXCollections.observableArrayList("Barcelona", "Girona", "Lleida", "Tarragona");
        ComboBox<String> cityCombo = new ComboBox<>(items);
        cityCombo.getSelectionModel().selectFirst();
        root.add(cityCombo,1,10);

        Label choiceLabel =  new Label("Categoria:");
        root.add(choiceLabel,0,11);
        ObservableList<String> choiceItems = FXCollections.observableArrayList("Concert", "Conferencia", "Taller", "Esport");
        ChoiceBox<String> choiceBox = new ChoiceBox<String>(choiceItems);
        choiceBox.getSelectionModel().selectFirst();
        root.add(choiceBox,1,11);

        Label entradesLabel =  new Label("Entrades:");
        root.add(entradesLabel,0,12);
        Spinner<Integer> entraSpin = new Spinner<>(1,10,1);
        entraSpin.setEditable(true);
        root.add(entraSpin,1,12);

        Label sliLabel =  new Label("Descompte aplicable:");
        root.add(sliLabel,0,13);
        Slider sli = new Slider(0,50,20);
        sli.setShowTickLabels(true);
        sli.setMajorTickUnit(10);
        root.add(sli,1,13);

        Label colorLabel =  new Label("Color del Tiquet:");
        root.add(colorLabel,0,14);
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLUE);
        colorPicker.setPrefHeight(35);
        root.add(colorPicker,1,14);



        SplitMenuButton desaMBtn =  new SplitMenuButton();
        desaMBtn.setText("Desar");
        desaMBtn.getItems().addAll(new MenuItem("Desar Esdeveniment"),new MenuItem("Desar i Publicar"));
        for(MenuItem item : desaMBtn.getItems()){
            item.setOnAction(e -> desaMBtn.setText(item.getText()));
        }
        root.add(desaMBtn,1,15,2,1);
        GridPane.setHalignment(desaMBtn, HPos.RIGHT);


        Scene scene = new Scene(root,600,750);
        stage.setScene(scene);
        stage.show();
    }

}
