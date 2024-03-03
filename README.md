# JavaFX Encrypt and Decrypt App

## Features:
1. Encryption
Input: Users can enter a plain text message in the provided text field.
Shift Value: Users can specify a shift value for encryption.
Action: Clicking the "Encrypt" button performs encryption on the input text using a shift cipher.

2. Decryption
Input: Users can input a cipher text message.
Shift Value: Specify the same shift value used for encryption.
Action: Clicking the "Decrypt" button performs decryption on the input text using the same shift cipher.

![Screenshot (522)](https://github.com/tharushikaDyayinna/Encrypt-Decrypt/assets/102175958/1878b993-caf0-44fd-b65c-86b3e73304ce)

![Screenshot (523)](https://github.com/tharushikaDyayinna/Encrypt-Decrypt/assets/102175958/55b74fb6-3e8d-49fa-a60d-4c80928b93d0)

## How to Run:
Prerequisites:
Java JDK (version 21): Ensure that you have Java installed on your machine.
JavaFX SDK (version 21): JavaFX is used for building the graphical user interface.

## Build and Run:

1.Clone the Repository:
git clone https://github.com/tharushikaDyayinna/Encrypt-Decrypt.git

2.Compile the Java Code (if needed):
javac -d out src/application/Main.java

3.Run the JavaFX Application:
java --module-path /path/to/javafx-sdk-21/lib --add-modules javafx.controls,javafx.fxml -cp out application.Main



