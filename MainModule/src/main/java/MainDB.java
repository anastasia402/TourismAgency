import Domain.Client;
import UI.UI;
import Repository.ClientRepository;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainDB extends Application {
    public static void main(String[] args) {

//        Properties props=new Properties();
//        try {
//            props.load(new FileReader("/Users/anastasiacutulima/Desktop/mpp-proiect-java-anastasia402/lab2/src/main/java/agentie.config"));
//        } catch (IOException e) {
//            System.out.println("Cannot find agentie.config "+e);
//        }
//
//        ClientRepository clientRepository=new ClientRepository(props);
//        //clientRepository.add(new Client(1,"Ana", "str. Stefan cel Mare"));
//        System.out.println("Toti clientii din db");
//        for(Client client:clientRepository.getAll())
//            System.out.println(client);

    //    ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        // Retrieve the beans you need from the context
//        ClientRepository clientRepository = (ClientRepository) context.getBean("repoClient");
//        // Similarly, retrieve other beans as needed
//
//        // Use the retrieved beans
//
//        UI ui = (UI) context.getBean("ui");
//        //ui.addClient("Ion", "Dunarii 23");
//        if (ui.getAllClient().size()==0)
//            System.out.println("nu sunt clienti");
//        else {
//            System.out.println("Toti clientii din db");
//            for (Client client : ui.getAllClient())
//                System.out.println(client);
//        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("SortingTasks Example");
//        FXMLLoader loader=new FXMLLoader(getClass().getResource("view/tasks.fxml"));
//        Pane myPane = (Pane) loader.load();
//        SortingTasksFXML ctrl=loader.getController();
//
//        ctrl.setTasksService(getTasksService());
//        Scene myScene = new Scene(myPane);
//        // myScene.getRoot().setStyle("-fx-font-family: 'serif'");
//        primaryStage.setScene(myScene);
//
//
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent we) {
//                ctrl.close();
//            }
//        });
//        primaryStage.show();
    }
}
