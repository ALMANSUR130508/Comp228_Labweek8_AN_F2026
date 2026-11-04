package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();

        // TOP
        HBox navigator = new HBox();
        navigator.setAlignment(Pos.CENTER);
        navigator.setPadding(new Insets(10));

        Label lblTitle = new Label("College Student Registration");
        navigator.getChildren().add(lblTitle);

        pane.setTop(navigator);

        // LEFT MENU
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(15));

        Button btnDashboard = new Button("Dashboard");
        Button btnRegistration = new Button("Registration");
        Button btnCourses = new Button("Courses");
        Button btnHelp = new Button("Help");

       

        vBox.getChildren().addAll(
                btnDashboard,
                btnRegistration,
                btnCourses,
                btnHelp
        );

        pane.setLeft(vBox);

        // FORM
        GridPane form = new GridPane();

        form.setPadding(new Insets(10));
        form.setHgap(5);
        form.setVgap(10);
        form.setAlignment(Pos.TOP_LEFT);

        TextField tfId = new TextField();
        tfId.setPromptText("Enter ID");
        tfId.setPrefWidth(150);

        TextField tfName = new TextField();
        tfName.setPromptText("Enter Name");
        tfName.setPrefWidth(150);

        TextField tfEmail = new TextField();
        tfEmail.setPromptText("Enter Email");
        tfEmail.setPrefWidth(150);

        ComboBox<String> cboProgram = new ComboBox<>();
        cboProgram.getItems().addAll(
                "Computer Science",
                "Business",
                "Engineering",
                "Cyber Security",
                "Information Technology"
        );

        cboProgram.setPromptText("Select Program");
        cboProgram.setPrefWidth(150);

        form.add(new Label("Student ID:"), 0, 0);
        form.add(tfId, 1, 0);

        form.add(new Label("Full Name:"), 0, 1);
        form.add(tfName, 1, 1);

        form.add(new Label("Email:"), 0, 2);
        form.add(tfEmail, 1, 2);

        form.add(new Label("Program:"), 0, 3);
        form.add(cboProgram, 1, 3);

        // BUTTONS
        HBox buttons = new HBox(10);

        Button btnRegister = new Button("Register");
        Button btnClear = new Button("Clear");

        btnRegister.setStyle("-fx-background-color: #ffcccc;");
        btnClear.setStyle("-fx-background-color: #ffcccc;");

        buttons.getChildren().addAll(
                btnRegister,
                btnClear
        );

        Label lblStatus = new Label();

        // CENTER
        VBox center = new VBox(10);
        center.setPadding(new Insets(20));
        center.setAlignment(Pos.TOP_LEFT);

        center.getChildren().addAll(
                form,
                buttons,
                lblStatus
        );

        pane.setCenter(center);

        // REGISTER
        btnRegister.setOnAction(e -> {

            if (tfId.getText().equals("")
                    || tfName.getText().equals("") || tfEmail.getText().equals("") || cboProgram.getValue() == null) {

                lblStatus.setText("Fill all fields");
            }
            else {

                lblStatus.setText("Student registered");
            }
        });

        // CLEAR
        btnClear.setOnAction(e -> {

            tfId.clear();
            tfName.clear();
            tfEmail.clear();

            cboProgram.setValue(null);

            lblStatus.setText("");
        });

        Scene scene = new Scene(pane, 650, 350);

        primaryStage.setTitle("Student Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}