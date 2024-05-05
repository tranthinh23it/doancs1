package org.example.doancoso1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatApplication extends Application {
    private Stage stage;
    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Hello!");
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setScene(scene);
        stage.show();

        // Tạo một luồng mới để kết nối với máy chủ
        new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 7000);
                handleServerConnection(socket, controller);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleServerConnection(Socket socket, LoginController controller) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            // Xử lý việc nhận và hiển thị tin nhắn từ máy chủ
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = reader.readLine()) != null) {
                        //tí sửa lại thành setText cho textField
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // Luồng để gửi tin nhắn từ client tới server
            while (true) {
                String message = scanner.nextLine();
                writer.write(message + "\n");
                writer.flush();
                if ("exit".equalsIgnoreCase(message)) {
                    break; // Thoát khỏi vòng lặp nếu người dùng nhập 'exit'
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
