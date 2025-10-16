package com.client;

import com.model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class InventoryApp extends Application {
    
    private Inventory inventory;
    private TextArea resultsArea;
    
    @Override
    public void start(Stage primaryStage) {
        inventory = new Inventory();
        
        // Créer les onglets
        TabPane tabPane = new TabPane();
        
        Tab vendorTab = new Tab("Vendeur - Ajouter Instrument");
        vendorTab.setClosable(false);
        vendorTab.setContent(createVendorPane());
        
        Tab buyerTab = new Tab("Acheteur - Rechercher");
        buyerTab.setClosable(false);
        buyerTab.setContent(createBuyerPane());
        
        tabPane.getTabs().addAll(vendorTab, buyerTab);
        
        Scene scene = new Scene(tabPane, 900, 700);
        primaryStage.setTitle("Gestion Inventaire d'Instruments");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Panneau Vendeur
    private VBox createVendorPane() {
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        
        Label titleLabel = new Label("Ajouter un instrument à l'inventaire");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        // Type d'instrument
        HBox typeBox = new HBox(10);
        typeBox.setAlignment(Pos.CENTER_LEFT);
        Label typeLabel = new Label("Type d'instrument:");
        typeLabel.setPrefWidth(150);
        ComboBox<String> typeCombo = new ComboBox<>(
            FXCollections.observableArrayList("Guitar", "Mandolin", "Banjo")
        );
        typeCombo.setValue("Guitar");
        typeBox.getChildren().addAll(typeLabel, typeCombo);
        
        // Numéro de série
        HBox serialBox = new HBox(10);
        serialBox.setAlignment(Pos.CENTER_LEFT);
        Label serialLabel = new Label("Numéro de série:");
        serialLabel.setPrefWidth(150);
        TextField serialField = new TextField();
        serialBox.getChildren().addAll(serialLabel, serialField);
        
        // Prix
        HBox priceBox = new HBox(10);
        priceBox.setAlignment(Pos.CENTER_LEFT);
        Label priceLabel = new Label("Prix:");
        priceLabel.setPrefWidth(150);
        TextField priceField = new TextField();
        priceBox.getChildren().addAll(priceLabel, priceField);
        
        // Fabricant
        HBox builderBox = new HBox(10);
        builderBox.setAlignment(Pos.CENTER_LEFT);
        Label builderLabel = new Label("Fabricant:");
        builderLabel.setPrefWidth(150);
        ComboBox<Builder> builderCombo = new ComboBox<>(
            FXCollections.observableArrayList(Builder.values())
        );
        builderCombo.setValue(Builder.FENDER);
        builderBox.getChildren().addAll(builderLabel, builderCombo);
        
        // Modèle
        HBox modelBox = new HBox(10);
        modelBox.setAlignment(Pos.CENTER_LEFT);
        Label modelLabel = new Label("Modèle:");
        modelLabel.setPrefWidth(150);
        TextField modelField = new TextField();
        modelBox.getChildren().addAll(modelLabel, modelField);
        
        // Type (Acoustic/Electric)
        HBox acousticBox = new HBox(10);
        acousticBox.setAlignment(Pos.CENTER_LEFT);
        Label acousticLabel = new Label("Type:");
        acousticLabel.setPrefWidth(150);
        ComboBox<Type> acousticCombo = new ComboBox<>(
            FXCollections.observableArrayList(Type.values())
        );
        acousticCombo.setValue(Type.ACOUSTIC);
        acousticBox.getChildren().addAll(acousticLabel, acousticCombo);
        
        // Bois arrière
        HBox backWoodBox = new HBox(10);
        backWoodBox.setAlignment(Pos.CENTER_LEFT);
        Label backWoodLabel = new Label("Bois arrière:");
        backWoodLabel.setPrefWidth(150);
        ComboBox<Wood> backWoodCombo = new ComboBox<>(
            FXCollections.observableArrayList(Wood.values())
        );
        backWoodCombo.setValue(Wood.MAHOGANY);
        backWoodBox.getChildren().addAll(backWoodLabel, backWoodCombo);
        
        // Bois dessus
        HBox topWoodBox = new HBox(10);
        topWoodBox.setAlignment(Pos.CENTER_LEFT);
        Label topWoodLabel = new Label("Bois dessus:");
        topWoodLabel.setPrefWidth(150);
        ComboBox<Wood> topWoodCombo = new ComboBox<>(
            FXCollections.observableArrayList(Wood.values())
        );
        topWoodCombo.setValue(Wood.MAPLE);
        topWoodBox.getChildren().addAll(topWoodLabel, topWoodCombo);
        
        // Champs spécifiques
        // Nombre de cordes (Guitar/Banjo)
        HBox stringsBox = new HBox(10);
        stringsBox.setAlignment(Pos.CENTER_LEFT);
        Label stringsLabel = new Label("Nombre de cordes:");
        stringsLabel.setPrefWidth(150);
        TextField stringsField = new TextField("6");
        stringsBox.getChildren().addAll(stringsLabel, stringsField);
        
        // Style (Mandolin)
        HBox styleBox = new HBox(10);
        styleBox.setAlignment(Pos.CENTER_LEFT);
        Label styleLabel = new Label("Style:");
        styleLabel.setPrefWidth(150);
        ComboBox<Style> styleCombo = new ComboBox<>(
            FXCollections.observableArrayList(Style.values())
        );
        styleCombo.setValue(Style.A);
        styleBox.getChildren().addAll(styleLabel, styleCombo);
        styleBox.setVisible(false);
        styleBox.setManaged(false);
        
        // Gérer l'affichage des champs selon le type
        typeCombo.setOnAction(e -> {
            String selected = typeCombo.getValue();
            if ("Mandolin".equals(selected)) {
                stringsBox.setVisible(false);
                stringsBox.setManaged(false);
                styleBox.setVisible(true);
                styleBox.setManaged(true);
            } else {
                stringsBox.setVisible(true);
                stringsBox.setManaged(true);
                styleBox.setVisible(false);
                styleBox.setManaged(false);
            }
        });
        
        // Bouton d'ajout
        Button addButton = new Button("Ajouter à l'inventaire");
        addButton.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        
        Label statusLabel = new Label();
        statusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        
        addButton.setOnAction(e -> {
            try {
                String serialNumber = serialField.getText();
                double price = Double.parseDouble(priceField.getText());
                Builder builder = builderCombo.getValue();
                String model = modelField.getText();
                Type type = acousticCombo.getValue();
                Wood backWood = backWoodCombo.getValue();
                Wood topWood = topWoodCombo.getValue();
                
                InstrumentSpec spec = null;
                String instrumentType = typeCombo.getValue();
                
                if ("Guitar".equals(instrumentType)) {
                    int nbrStrings = Integer.parseInt(stringsField.getText());
                    spec = new GuitarSpec(builder, model, type, backWood, topWood, nbrStrings);
                } else if ("Mandolin".equals(instrumentType)) {
                    Style style = styleCombo.getValue();
                    spec = new MandolinSpec(builder, model, type, backWood, topWood, style);
                } else if ("Banjo".equals(instrumentType)) {
                    int nbrStrings = Integer.parseInt(stringsField.getText());
                    spec = new BanjoSpec(builder, model, type, backWood, topWood, nbrStrings);
                }
                
                inventory.addInstrument(serialNumber, price, spec);
                statusLabel.setText("✓ Instrument ajouté avec succès !");
                
                // Réinitialiser les champs
                serialField.clear();
                priceField.clear();
                modelField.clear();
                
            } catch (NumberFormatException ex) {
                statusLabel.setText("❌ Erreur: Vérifiez le prix et le nombre de cordes");
                statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
        });
        
        vbox.getChildren().addAll(
            titleLabel,
            new Separator(),
            typeBox,
            serialBox,
            priceBox,
            builderBox,
            modelBox,
            acousticBox,
            backWoodBox,
            topWoodBox,
            stringsBox,
            styleBox,
            addButton,
            statusLabel
        );
        
        return vbox;
    }
    
    // Panneau Acheteur
    private VBox createBuyerPane() {
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        
        Label titleLabel = new Label("Rechercher un instrument");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        // Type d'instrument
        HBox typeBox = new HBox(10);
        typeBox.setAlignment(Pos.CENTER_LEFT);
        Label typeLabel = new Label("Type d'instrument:");
        typeLabel.setPrefWidth(150);
        ComboBox<String> typeCombo = new ComboBox<>(
            FXCollections.observableArrayList("Guitar", "Mandolin", "Banjo")
        );
        typeCombo.setValue("Guitar");
        typeBox.getChildren().addAll(typeLabel, typeCombo);
        
        // Fabricant
        HBox builderBox = new HBox(10);
        builderBox.setAlignment(Pos.CENTER_LEFT);
        Label builderLabel = new Label("Fabricant:");
        builderLabel.setPrefWidth(150);
        ComboBox<Builder> builderCombo = new ComboBox<>(
            FXCollections.observableArrayList(Builder.values())
        );
        builderCombo.setValue(Builder.FENDER);
        builderBox.getChildren().addAll(builderLabel, builderCombo);
        
        // Modèle
        HBox modelBox = new HBox(10);
        modelBox.setAlignment(Pos.CENTER_LEFT);
        Label modelLabel = new Label("Modèle (optionnel):");
        modelLabel.setPrefWidth(150);
        TextField modelField = new TextField();
        modelBox.getChildren().addAll(modelLabel, modelField);
        
        // Type (Acoustic/Electric)
        HBox acousticBox = new HBox(10);
        acousticBox.setAlignment(Pos.CENTER_LEFT);
        Label acousticLabel = new Label("Type:");
        acousticLabel.setPrefWidth(150);
        ComboBox<Type> acousticCombo = new ComboBox<>(
            FXCollections.observableArrayList(Type.values())
        );
        acousticCombo.setValue(Type.ACOUSTIC);
        acousticBox.getChildren().addAll(acousticLabel, acousticCombo);
        
        // Bois arrière
        HBox backWoodBox = new HBox(10);
        backWoodBox.setAlignment(Pos.CENTER_LEFT);
        Label backWoodLabel = new Label("Bois arrière:");
        backWoodLabel.setPrefWidth(150);
        ComboBox<Wood> backWoodCombo = new ComboBox<>(
            FXCollections.observableArrayList(Wood.values())
        );
        backWoodCombo.setValue(Wood.MAHOGANY);
        backWoodBox.getChildren().addAll(backWoodLabel, backWoodCombo);
        
        // Bois dessus
        HBox topWoodBox = new HBox(10);
        topWoodBox.setAlignment(Pos.CENTER_LEFT);
        Label topWoodLabel = new Label("Bois dessus:");
        topWoodLabel.setPrefWidth(150);
        ComboBox<Wood> topWoodCombo = new ComboBox<>(
            FXCollections.observableArrayList(Wood.values())
        );
        topWoodCombo.setValue(Wood.MAPLE);
        topWoodBox.getChildren().addAll(topWoodLabel, topWoodCombo);
        
        // Nombre de cordes (Guitar/Banjo)
        HBox stringsBox = new HBox(10);
        stringsBox.setAlignment(Pos.CENTER_LEFT);
        Label stringsLabel = new Label("Nombre de cordes:");
        stringsLabel.setPrefWidth(150);
        TextField stringsField = new TextField("6");
        stringsBox.getChildren().addAll(stringsLabel, stringsField);
        
        // Style (Mandolin)
        HBox styleBox = new HBox(10);
        styleBox.setAlignment(Pos.CENTER_LEFT);
        Label styleLabel = new Label("Style:");
        styleLabel.setPrefWidth(150);
        ComboBox<Style> styleCombo = new ComboBox<>(
            FXCollections.observableArrayList(Style.values())
        );
        styleCombo.setValue(Style.A);
        styleBox.getChildren().addAll(styleLabel, styleCombo);
        styleBox.setVisible(false);
        styleBox.setManaged(false);
        
        // Gérer l'affichage des champs selon le type
        typeCombo.setOnAction(e -> {
            String selected = typeCombo.getValue();
            if ("Mandolin".equals(selected)) {
                stringsBox.setVisible(false);
                stringsBox.setManaged(false);
                styleBox.setVisible(true);
                styleBox.setManaged(true);
            } else {
                stringsBox.setVisible(true);
                stringsBox.setManaged(true);
                styleBox.setVisible(false);
                styleBox.setManaged(false);
            }
        });
        
        // Bouton de recherche
        Button searchButton = new Button("Rechercher");
        searchButton.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        
        // Zone de résultats
        resultsArea = new TextArea();
        resultsArea.setEditable(false);
        resultsArea.setPrefHeight(300);
        resultsArea.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px;");
        
        searchButton.setOnAction(e -> {
            try {
                Builder builder = builderCombo.getValue();
                String model = modelField.getText();
                Type type = acousticCombo.getValue();
                Wood backWood = backWoodCombo.getValue();
                Wood topWood = topWoodCombo.getValue();
                
                InstrumentSpec searchSpec = null;
                String instrumentType = typeCombo.getValue();
                
                if ("Guitar".equals(instrumentType)) {
                    int nbrStrings = Integer.parseInt(stringsField.getText());
                    searchSpec = new GuitarSpec(builder, model, type, backWood, topWood, nbrStrings);
                } else if ("Mandolin".equals(instrumentType)) {
                    Style style = styleCombo.getValue();
                    searchSpec = new MandolinSpec(builder, model, type, backWood, topWood, style);
                } else if ("Banjo".equals(instrumentType)) {
                    int nbrStrings = Integer.parseInt(stringsField.getText());
                    searchSpec = new BanjoSpec(builder, model, type, backWood, topWood, nbrStrings);
                }
                
                List matchingInstruments = inventory.search(searchSpec);
                
                if (!matchingInstruments.isEmpty()) {
                    StringBuilder results = new StringBuilder();
                    results.append("=== Instruments trouvés (" + matchingInstruments.size() + ") ===\n\n");
                    for (Object obj : matchingInstruments) {
                        Instrument instrument = (Instrument) obj;
                        results.append("Numéro de série: ").append(instrument.getSerialNumber()).append("\n");
                        results.append("Prix: ").append(instrument.getPrice()).append(" €\n");
                        results.append("Spécifications: ").append(instrument.getSpec()).append("\n");
                        results.append("-------------------------------------------\n");
                    }
                    resultsArea.setText(results.toString());
                } else {
                    resultsArea.setText("Désolé, nous n'avons rien trouvé correspondant à vos critères.");
                }
                
            } catch (NumberFormatException ex) {
                resultsArea.setText("Erreur: Vérifiez le nombre de cordes");
            }
        });
        
        vbox.getChildren().addAll(
            titleLabel,
            new Separator(),
            typeBox,
            builderBox,
            modelBox,
            acousticBox,
            backWoodBox,
            topWoodBox,
            stringsBox,
            styleBox,
            searchButton,
            new Label("Résultats:"),
            resultsArea
        );
        
        return vbox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}