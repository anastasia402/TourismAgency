import Domain.Angajat;
import Domain.Bilet;
import Domain.Client;
import Domain.Zbor;
import com.sun.javafx.fxml.BeanAdapter;
import com.sun.prism.Image;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import UI.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class HelloApplication extends Application {

    ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
    Controller ui = (Controller) context.getBean("ui"); // Assign to class-level 'ui' field
    Label nameLabel = new Label("Name:");
    TextField nameTextField = new TextField();
    Label addressLabel = new Label("Address:");
    TextField addressTextField = new TextField();
    Label idLabelClient = new Label("ID:");
    TextField idTextFieldClient = new TextField();
    Label idLabelAngajat = new Label("ID:");
    TextField idTextFieldAngajat = new TextField();
    Label numeLabelAngajat = new Label("Nume:");
    TextField numeTextFieldAngajat = new TextField();
    Label userLabelAngajat = new Label("Username:");
    TextField userTextFieldAngajat = new TextField();
    Label passLabelAngajat = new Label("Password:");
    TextField passTextFieldAngajat = new TextField();

    Label idLabelZbor = new Label("ID:");
    TextField idTextFieldZbor = new TextField();
    Label destLabel = new Label("Destinatie:");
    TextField destTextField = new TextField();
    Label dataLabel = new Label("Data:");
    TextField dataTextField = new TextField();
    Label oraLabel = new Label("Ora:");
    TextField oraTextField = new TextField();
    Label aeroportTextLabel = new Label("Aeroport:");
    TextField aeroportTextField = new TextField();
    Label locDisponibileLabel = new Label("Locuri Disponibile:");
    TextField locDisponibileTextField = new TextField();
    Label idZborLabel = new Label("Zbor");
    TextField idZborTextField = new TextField();
    Label idClientLabel = new Label("Client:");
    TextField idClientTextField = new TextField();
    Label turistiLabel = new Label("Turisti:");
    TextField turistiTextField = new TextField();
    Label nrLocurLabel = new Label("Nr locuri:");
    TextField nrLocuriTextField = new TextField();


    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
        // Create buttons for various operations
//        Tab clientiTab = new Tab("Clienti");
//        clientiTab.setContent(clientiPane()); // Assuming getClientiPane() returns the content for the "Clienti" tab

//        Tab angajatiTab = new Tab("Angajati");
//        angajatiTab.setContent(angajatiPane());

//        Tab zboruriTab = new Tab("Zboruri");
//        zboruriTab.setContent(zboruriPane());

        Tab bileteTab = new Tab("Bilete");
        bileteTab.setContent(biletePane());

        // Create a TabPane and add tabs to it
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(bileteTab);

        // Create the root layout and add the TabPane to it
        BorderPane root = new BorderPane();
        root.setCenter(tabPane);

        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        // Create the scene and set it on the stage

        // Set the title and show the stage
        stage.setTitle("Agentie de turism");
        stage.show();

    }

    //public Pane clientiPane(){
//        Button addButtonClient = new Button("Add");
//        Button deleteButtonClient = new Button("Delete");
//        Button updateButtonClient = new Button("Update");
//
//        TableView<Client> clientTableView = new TableView<>(ui.getClientObservableList());
//
//        TableColumn<Client, String> idColumn = new TableColumn<>("ID");
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Client, String> nameColumn = new TableColumn<>("Nume");
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nume"));
//        nameColumn.setPrefWidth(200);
//
//        TableColumn<Client, String> addressColumn = new TableColumn<>("Adresa");
//        addressColumn.setCellValueFactory(new PropertyValueFactory<>("adresa"));
//        addressColumn.setPrefWidth(200);
//
//        clientTableView.getColumns().addAll(idColumn, nameColumn, addressColumn);
//
//
//        addButtonClient.setOnMouseClicked(event -> {
//            String name = nameTextField.getText();
//            String address = addressTextField.getText();
//            ui.addClient(name, address);
//            clientTableView.setItems(ui.getClientObservableList());
//            clientTableView.refresh();
//            nameTextField.clear();
//            addressTextField.clear();
//        });
//
//
//        deleteButtonClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
//                    if (selectedClient != null) {
//                        ui.deleleClient(selectedClient.getId());
//                        clientTableView.getItems().remove(selectedClient);
//                        nameTextField.clear();
//                        addressTextField.clear();
//                    } else {
//
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Warning");
//                        alert.setContentText("Please select a client to delete.");
//                        alert.show();
//                    }
//                } catch (Exception e) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setContentText("Error deleting client: " + e.getMessage());
//                    alert.show();
//                }
//            }
//        });
//
//        updateButtonClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
//                    if (selectedClient != null) {
//                        int id = selectedClient.getId();
//                        String newName = nameTextField.getText();
//                        String newAddress = addressTextField.getText();
//                        ui.updateClient(newName, newAddress, id);
//
//                        clientTableView.refresh();
//                        nameTextField.clear();
//                        addressTextField.clear();
//                    } else {
//
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Warning");
//                        alert.setContentText("Please select a client to update.");
//                        alert.show();
//                    }
//                } catch (Exception e) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setContentText("Error updating client: " + e.getMessage());
//                    alert.show();
//                }
//            }
//        });
//
//
//
//
//        VBox clientBox = new VBox(idLabelClient, idTextFieldClient, nameLabel, nameTextField, addressLabel, addressTextField, addButtonClient, deleteButtonClient, updateButtonClient);
//        clientBox.setSpacing(10);
//        clientBox.setPadding(new Insets(10));
//
//        clientTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//
//                nameTextField.setText(newValue.getNume());
//                addressTextField.setText(newValue.getAdresa());
//                idTextFieldClient.setText(String.valueOf(newValue.getId()));
//            } else {
//
//                nameTextField.clear();
//                addressTextField.clear();
//                idTextFieldClient.clear();
//            }
//        });
//
//
//        BorderPane clientRoot = new BorderPane();
//        clientRoot.setLeft(clientBox);
//        clientRoot.setCenter(clientTableView);
//
//
//        return clientRoot;
//    }
//
//    public Pane angajatiPane(){
//        Button addButtonAngajati = new Button("Add");
//        Button deleteButtonAngajati = new Button("Delete");
//        Button updateButtonAngajati = new Button("Update");
//
//        TableView<Angajat> angajatTableView = new TableView<>(ui.getAngajatObservableList());
//
//        TableColumn<Angajat, String> idColumn = new TableColumn<>("ID");
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Angajat, String> nameColumn = new TableColumn<>("Name");
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nume"));
//        nameColumn.setPrefWidth(100);
//
//        TableColumn<Angajat, String> userColumn = new TableColumn<>("Username");
//        userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
//        userColumn.setPrefWidth(100);
//
//        TableColumn<Angajat, String> passColumn = new TableColumn<>("Password");
//        passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
//        passColumn.setPrefWidth(100);
//
//        angajatTableView.getColumns().addAll(idColumn, nameColumn, userColumn, passColumn);
//
//
//        addButtonAngajati.setOnMouseClicked(event -> {
//            String name = numeTextFieldAngajat.getText();
//            String user = userTextFieldAngajat.getText();
//            String pass = passTextFieldAngajat.getText();
//            ui.addAnjajat(name, user, pass);
//            angajatTableView.setItems(ui.getAngajatObservableList());
//            angajatTableView.refresh();
//            numeTextFieldAngajat.clear();
//            userTextFieldAngajat.clear();
//            passTextFieldAngajat.clear();
//        });
//
//
//        deleteButtonAngajati.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    Angajat selectedClient = angajatTableView.getSelectionModel().getSelectedItem();
//                    if (selectedClient != null) {
//                        ui.deleteAngajat(selectedClient.getId());
//                        angajatTableView.getItems().remove(selectedClient);
//                        numeTextFieldAngajat.clear();
//                        userTextFieldAngajat.clear();
//                        passTextFieldAngajat.clear();
//                    } else {
//                        // Show an alert if no client is selected
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Warning");
//                        alert.setContentText("Please select a client to delete.");
//                        alert.show();
//                    }
//                } catch (Exception e) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setContentText("Error deleting client: " + e.getMessage());
//                    alert.show();
//                }
//            }
//        });
//
//        updateButtonAngajati.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    Angajat selectedClient = angajatTableView.getSelectionModel().getSelectedItem();
//                    if (selectedClient != null) {
//                        int id = selectedClient.getId();
//                        String newName = numeTextFieldAngajat.getText();
//                        String newUser = addressTextField.getText();
//                        String newPass = passTextFieldAngajat.getText();
//                        ui.updateAngajat(newName, newUser, newPass, id);
//
//                        angajatTableView.refresh();
//                        numeTextFieldAngajat.clear();
//                        userTextFieldAngajat.clear();
//                        passTextFieldAngajat.clear();
//                    } else {
//                        // Show an alert if no client is selected
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Warning");
//                        alert.setContentText("Please select a client to update.");
//                        alert.show();
//                    }
//                } catch (Exception e) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setContentText("Error updating client: " + e.getMessage());
//                    alert.show();
//                }
//            }
//        });
//
//
//
//
//        VBox angajatBox = new VBox(idLabelAngajat, idTextFieldAngajat, numeLabelAngajat, numeTextFieldAngajat, userLabelAngajat,
//                userTextFieldAngajat, passLabelAngajat, passTextFieldAngajat, addButtonAngajati, deleteButtonAngajati, updateButtonAngajati);
//        angajatBox.setSpacing(10);
//        angajatBox.setPadding(new Insets(10));
//
//        angajatTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//
//                numeTextFieldAngajat.setText(newValue.getNume());
//                userTextFieldAngajat.setText(newValue.getUsername());
//                passTextFieldAngajat.setText(newValue.getPassword());
//            } else {
//
//                numeTextFieldAngajat.clear();
//                userTextFieldAngajat.clear();
//                passTextFieldAngajat.clear();
//            }
//        });
//
//
//        BorderPane angajatRoot = new BorderPane();
//        angajatRoot.setLeft(angajatBox);
//        angajatRoot.setCenter(angajatTableView);
//
//
//        return angajatRoot;
//    }
//
//    public Pane zboruriPane(){
//        Button addButtonZboruri = new Button("Add");
//        Button deleteButtonZboruri = new Button("Delete");
//        Button updateButtonZboruri = new Button("Update");
//
//        TableView<Zbor> zboruriTableView = new TableView<>(ui.getZborObservableList());
//
//        TableColumn<Zbor, String> idColumn = new TableColumn<>("ID");
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Zbor, String> destColumn = new TableColumn<>("Destinatie:");
//        destColumn.setCellValueFactory(new PropertyValueFactory<>("destinatie"));
//        destColumn.setPrefWidth(100);
//
//        TableColumn<Zbor, String> dataColumn = new TableColumn<>("Data:");
//        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
//        dataColumn.setPrefWidth(100);
//
//        TableColumn<Zbor, String> oraColumn = new TableColumn<>("Ora:");
//        oraColumn.setCellValueFactory(new PropertyValueFactory<>("ora"));
//        oraColumn.setPrefWidth(100);
//
//        TableColumn<Zbor, String> aeropColumn = new TableColumn<>("Aerport:");
//        aeropColumn.setCellValueFactory(new PropertyValueFactory<>("aeroport"));
//        aeropColumn.setPrefWidth(100);
//
//        TableColumn<Zbor, String> nrColumn = new TableColumn<>("Locuri disponibile:");
//        nrColumn.setCellValueFactory(new PropertyValueFactory<>("nrLocuri"));
//        nrColumn.setPrefWidth(100);
//
//        zboruriTableView.getColumns().addAll(idColumn, destColumn, dataColumn, oraColumn, aeropColumn, nrColumn);
//
//
//        addButtonZboruri.setOnMouseClicked(event -> {
//            String dest = destTextField.getText();
//            String data = dataTextField.getText();
//            String ora = oraTextField.getText();
//            String aerop = aeroportTextField.getText();
//            int nr = Integer.parseInt(locDisponibileTextField.getText());
//            ui.addZbor(dest, data, ora, aerop, nr);
//            zboruriTableView.setItems(ui.getZborObservableList());
//            zboruriTableView.refresh();
//            destTextField.clear();
//            dataTextField.clear();
//            oraTextField.clear();
//            aeroportTextField.clear();
//            locDisponibileTextField.clear();
//        });
//
//        deleteButtonZboruri.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    Zbor selectedZbor = zboruriTableView.getSelectionModel().getSelectedItem();
//                    if (selectedZbor != null) {
//                        ui.deleteZbor(selectedZbor.getId());
//                        zboruriTableView.getItems().remove(selectedZbor);
//                        destTextField.clear();
//                        dataTextField.clear();
//                        oraTextField.clear();
//                        aeroportTextField.clear();
//                        locDisponibileTextField.clear();
//                    } else {
//
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Warning");
//                        alert.setContentText("Please select a client to delete.");
//                        alert.show();
//                    }
//                } catch (Exception e) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setContentText("Error deleting client: " + e.getMessage());
//                    alert.show();
//                }
//            }
//        });
//
//        updateButtonZboruri.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    Zbor selectedZbor = zboruriTableView.getSelectionModel().getSelectedItem();
//                    if (selectedZbor != null) {
//                        int id = selectedZbor.getId();
//                        String newDest = destTextField.getText();
//                        String newData = dataTextField.getText();
//                        String newOra = oraTextField.getText();
//                        String newAerop = aeroportTextField.getText();
//                        int nr = Integer.parseInt(locDisponibileTextField.getText());
//                        ui.updateZbor(newDest, newData, newOra, newAerop, nr, id);
//
//                        zboruriTableView.refresh();
//                        destTextField.clear();
//                        dataTextField.clear();
//                        oraTextField.clear();
//                        aeroportTextField.clear();
//                        locDisponibileTextField.clear();
//                    } else {
//
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Warning");
//                        alert.setContentText("Please select a client to update.");
//                        alert.show();
//                    }
//                } catch (Exception e) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setContentText("Error updating client: " + e.getMessage());
//                    alert.show();
//                }
//            }
//        });
//
//
//
//
//        VBox zboruriBox = new VBox(destLabel, destTextField, dataLabel, dataTextField, oraLabel, oraTextField,
//                aeroportTextLabel, aeroportTextField, locDisponibileLabel, locDisponibileTextField, addButtonZboruri, deleteButtonZboruri, updateButtonZboruri);
//        zboruriBox.setSpacing(10);
//        zboruriBox.setPadding(new Insets(10));
//
//        zboruriTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//
//                destTextField.setText(newValue.getDestinatie());
//                dataTextField.setText(newValue.getData());
//                oraTextField.setText(newValue.getOra());
//                aeroportTextField.setText(newValue.getAeroport());
//                locDisponibileTextField.setText(Integer.toString(newValue.getNrLocuri()));
//            } else {
//                destTextField.clear();
//                dataTextField.clear();
//                oraTextField.clear();
//                aeroportTextField.clear();
//                locDisponibileTextField.clear();
//            }
//        });
//
//
//        BorderPane angajatRoot = new BorderPane();
//        angajatRoot.setLeft(zboruriBox);
//        angajatRoot.setCenter(zboruriTableView);
//
//        return angajatRoot;
//    }
//
    public Pane biletePane(){
        Button addButtonBilete = new Button("Buy");
        Button deleteButtonBilete = new Button("Delete");
        Button updateButtonBilete = new Button("Update");

        TableView<Bilet> bileteTableView = new TableView<>(ui.getBiletObservableList());

        TableColumn<Bilet, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Bilet, String> zborColumn = new TableColumn<>("Zbor");
        zborColumn.setCellValueFactory(new PropertyValueFactory<>("zbor"));
        zborColumn.setPrefWidth(100);

        TableColumn<Bilet, String> clientColumn = new TableColumn<>("Client");
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
        clientColumn.setPrefWidth(100);

        TableColumn<Bilet, String> turistiColumn = new TableColumn<>("Turisti");
        turistiColumn.setCellValueFactory(new PropertyValueFactory<>("listaTuristi"));
        turistiColumn.setPrefWidth(100);

        TableColumn<Bilet, String> locColumn = new TableColumn<>("Nr locuri");
        locColumn.setCellValueFactory(new PropertyValueFactory<>("nrLocuri"));
        locColumn.setPrefWidth(100);


        bileteTableView.getColumns().addAll(idColumn, zborColumn, clientColumn, turistiColumn, locColumn);

        addButtonBilete.setOnMouseClicked(event -> {
            try {
                String zborText = idZborTextField.getText();
                String clientText = idClientTextField.getText();
                String nrLocuriText = nrLocuriTextField.getText();


                int zbor = Integer.parseInt(zborText);
                int client = Integer.parseInt(clientText);
                int nr = Integer.parseInt(nrLocuriText);
                String turisti = turistiTextField.getText();

                ui.cumparaBilet(zbor, client, turisti, nr);
                bileteTableView.setItems(ui.getBiletObservableList());
                bileteTableView.refresh();
                idZborTextField.clear();
                idClientTextField.clear();
                turistiTextField.clear();
                nrLocuriTextField.clear();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Invalid input. Please enter valid numbers for Zbor, Client, and Nr locuri.");
                alert.show();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Error adding Bilet: " + e.getMessage());
                alert.show();
            }

        });

        deleteButtonBilete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Bilet selectedBilet = bileteTableView.getSelectionModel().getSelectedItem();
                    if (selectedBilet != null) {
                        ui.deleteBilet(selectedBilet.getId());
                        bileteTableView.getItems().remove(selectedBilet);
                        idZborTextField.clear();
                        idClientTextField.clear();
                        turistiTextField.clear();
                        nrLocuriTextField.clear();
                    } else {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setContentText("Please select a client to delete.");
                        alert.show();
                    }
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Error deleting client: " + e.getMessage());
                    alert.show();
                }
            }
        });

        updateButtonBilete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Bilet selectedBilet = bileteTableView.getSelectionModel().getSelectedItem();
                    if (selectedBilet != null) {
                        int id = selectedBilet.getId();
                        int newZbor = Integer.parseInt(idZborTextField.getText());
                        int newClient = Integer.parseInt(idClientTextField.getText());
                        String newTuristi = turistiTextField.getText();
                        int nr = Integer.parseInt(nrLocuriTextField.getText());
                        ui.updateBilet(newZbor, newClient, newTuristi, nr, id);

                        bileteTableView.refresh();
                        idZborTextField.clear();
                        idClientTextField.clear();
                        turistiTextField.clear();
                        nrLocuriTextField.clear();
                        nrLocuriTextField.clear();
                    } else {
                        // Show an alert if no client is selected
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setContentText("Please select a client to update.");
                        alert.show();
                    }
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Error updating client: " + e.getMessage());
                    alert.show();
                }
            }
        });




        VBox biletBox = new VBox(idZborLabel, idZborTextField, idClientLabel,
                idClientTextField, turistiLabel, turistiTextField, nrLocurLabel, nrLocuriTextField, addButtonBilete, deleteButtonBilete, updateButtonBilete);
        biletBox.setSpacing(10);
        biletBox.setPadding(new Insets(10));

        bileteTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                idZborTextField.setText(Integer.toString(newValue.getZbor()));
                idClientTextField.setText(Integer.toString(newValue.getClient()));
                turistiTextField.setText(newValue.getListaTuristi());
                nrLocuriTextField.setText(Integer.toString(newValue.getNrLocuri()));
            } else {
                idZborTextField.clear();
                idClientTextField.clear();
                turistiTextField.clear();
                nrLocuriTextField.clear();
            }
        });


        Label searchDestLabel = new Label("Destination:");
        TextField searchDestTextField = new TextField();
        Label searchDataLabel = new Label("Date:");
        TextField searchDataTextField = new TextField();
        Button searchButton = new Button("Search");

        TableView<Zbor> searchResultsTableView = new TableView<>();
        TableColumn<Zbor, String> searchIdColumn = new TableColumn<>("ID");
        searchIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Zbor, String> destColumn = new TableColumn<>("Destinatie:");
        destColumn.setCellValueFactory(new PropertyValueFactory<>("destinatie"));
        destColumn.setPrefWidth(100);

        TableColumn<Zbor, String> dataColumn = new TableColumn<>("Data:");
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        dataColumn.setPrefWidth(100);

        TableColumn<Zbor, String> oraColumn = new TableColumn<>("Ora:");
        oraColumn.setCellValueFactory(new PropertyValueFactory<>("ora"));
        oraColumn.setPrefWidth(100);

        TableColumn<Zbor, String> aeropColumn = new TableColumn<>("Aerport:");
        aeropColumn.setCellValueFactory(new PropertyValueFactory<>("aeroport"));
        aeropColumn.setPrefWidth(100);

        TableColumn<Zbor, String> nrColumn = new TableColumn<>("Locuri disponibile:");
        nrColumn.setCellValueFactory(new PropertyValueFactory<>("nrLocuri"));
        nrColumn.setPrefWidth(100);
        searchResultsTableView.getColumns().addAll(searchIdColumn, destColumn, dataColumn, oraColumn, aeropColumn, nrColumn);

        searchButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String dest = searchDestTextField.getText();
                String date = searchDataTextField.getText();
                ObservableList<Zbor> searchResults = ui.findZboruri(dest, date);
                searchResultsTableView.setItems(searchResults);
            }
        });


        VBox searchBox = new VBox(10);
        searchBox.getChildren().addAll(
                new HBox(10, searchDestLabel, searchDestTextField),
                new HBox(10, searchDataLabel, searchDataTextField),
                searchButton
        );
        searchBox.setPadding(new Insets(10));

        VBox searchAndResultsBox = new VBox(10);
        searchAndResultsBox.getChildren().addAll(searchBox, searchResultsTableView);
        searchAndResultsBox.setPadding(new Insets(10));

        VBox biletControlsBox = new VBox(10);
        biletControlsBox.getChildren().addAll(biletBox, bileteTableView);
        biletControlsBox.setPadding(new Insets(10));

        BorderPane biletRoot = new BorderPane();
        biletRoot.setRight(searchAndResultsBox);
        biletRoot.setLeft(biletControlsBox);
        return biletRoot;

    }



    public static void main(String[] args) {
        launch();
    }
}