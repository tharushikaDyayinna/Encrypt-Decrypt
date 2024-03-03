package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    
    static class Encryptor {
        public static String encrypt(String plaintext, int shift) {
            StringBuilder ciphertext = new StringBuilder();

            for (int i = 0; i < plaintext.length(); i++) {
                char alphabet = plaintext.charAt(i);

                if (alphabet >= 'a' && alphabet <= 'z') {
                    alphabet = (char) (alphabet + shift);

                    if (alphabet > 'z') {
                        alphabet = (char) (alphabet + 'a' - 'z' - 1);
                    }
                    ciphertext.append(alphabet);
                } else if (alphabet >= 'A' && alphabet <= 'Z') {
                    alphabet = (char) (alphabet + shift);

                    if (alphabet > 'Z') {
                        alphabet = (char) (alphabet + 'A' - 'Z' - 1);
                    }
                    ciphertext.append(alphabet);
                } else {
                    ciphertext.append(alphabet);
                }
            }
            return ciphertext.toString();
        }
    }

   
    public void start(Stage primaryStage) {
       
        Label plainTextLabel = new Label("Enter the plain text:");
        TextField plainTextField = new TextField();
        Label shiftLabel = new Label("Enter the shift value:");
        TextField shiftTextField = new TextField();
        Button encryptButton = new Button("Encrypt");
        Label resultLabel = new Label();

        // action for the button
        encryptButton.setOnAction(e -> {
            String plainText = plainTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());

            
            String encryptedText = Encryptor.encrypt(plainText, shift);

            // result in the Label
            resultLabel.setText("Encrypted text: " + encryptedText);
        });

        // layout and add the components to it
        VBox root = new VBox(10);
        root.getChildren().addAll(plainTextLabel, plainTextField, shiftLabel, shiftTextField, encryptButton, resultLabel);
        root.setPadding(new Insets(10));

        // scene
        Scene scene = new Scene(root, 400, 250);

        // scene for the primary stage
        primaryStage.setScene(scene);

        // title
        primaryStage.setTitle("JavaFX Encryption App");

       
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
