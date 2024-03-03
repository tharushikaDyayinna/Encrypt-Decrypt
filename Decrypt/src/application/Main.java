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

  
    static class Decryptor {
        public static String decrypt(String ciphertext, int shift) {
            StringBuilder plaintext = new StringBuilder();

            for (int i = 0; i < ciphertext.length(); i++) {
                char alphabet = ciphertext.charAt(i);

                if (alphabet >= 'a' && alphabet <= 'z') {
                    alphabet = (char) (alphabet - shift);

                    if (alphabet < 'a') {
                        alphabet = (char) (alphabet - 'a' + 'z' + 1);
                    }
                    plaintext.append(alphabet);
                } else if (alphabet >= 'A' && alphabet <= 'Z') {
                    alphabet = (char) (alphabet - shift);

                    if (alphabet < 'A') {
                        alphabet = (char) (alphabet - 'A' + 'Z' + 1);
                    }
                    plaintext.append(alphabet);
                } else {
                    plaintext.append(alphabet);
                }
            }
            return plaintext.toString();
        }
    }

    
    public void start(Stage primaryStage) {
        // Create UI components
        Label cipherTextLabel = new Label("Enter the cipher text:");
        TextField cipherTextField = new TextField();
        Label shiftLabel = new Label("Enter the shift value:");
        TextField shiftTextField = new TextField();
        Button decryptButton = new Button("Decrypt");
        Label resultLabel = new Label();

        // action for the button
        
        decryptButton.setOnAction(e -> {
            String cipherText = cipherTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());

            
            String decryptedText = Decryptor.decrypt(cipherText, shift);

            // result in the Label
            resultLabel.setText("Decrypted text: " + decryptedText);
        });

        // layout
        VBox root = new VBox(10);
        root.getChildren().addAll(cipherTextLabel, cipherTextField, shiftLabel, shiftTextField, decryptButton, resultLabel);
        root.setPadding(new Insets(10));

        // scene
        Scene scene = new Scene(root, 400, 250);

        // scene for the primary stage
        primaryStage.setScene(scene);

        // title of the window
        primaryStage.setTitle("JavaFX Decryption App");

        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
