package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.image.Image;

import java.io.IOException;

public class Main extends Application {

    final Label lab1 = new Label("QQ账号:");
    final Label lab2 = new Label("密码:");
    final Label lab3 = new Label("          找回密码");
    final Label lab4 = new Label("  注册账号");
    final Label lab_space = new Label("                        ");
    final PasswordField pf = new PasswordField();
    final TextField tf = new TextField();

    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane rootPane = new GridPane();
        rootPane.setPadding(new Insets(0, 0, 0, 0));
        rootPane.setHgap(5);
        rootPane.setVgap(9);
//        rootPane.setGridLinesVisible(true);
//      设置背景图
        Image ima_login = new Image("file:src/resource/4545d8e1db93fbea7811011f2f9753b0.jpg");
        ImageView imgView_login = new ImageView(ima_login);
//        imgView_login.setPreserveRatio(true);
        imgView_login.setFitWidth(450);
        imgView_login.setFitHeight(150);
        imgView_login.autosize();
        imgView_login.setSmooth(true);
        imgView_login.setCache(true);
        tf.setPromptText("请输入QQ账号");
        pf.setPromptText("输入密码");
        HBox HB_checkbox = new HBox(30);
        CheckBox cb1 = new CheckBox("自动登录");
        CheckBox cb2 = new CheckBox("记住密码");
        HB_checkbox.getChildren().add(cb1);
        HB_checkbox.getChildren().add(cb2);
        HB_checkbox.getChildren().add(lab3);
        Button bt1 = new Button("登录");
        bt1.setPrefSize(240, 50);
        rootPane.add(bt1, 1, 4, 4, 1);
        rootPane.add(imgView_login, 0, 0, 4, 1);
        rootPane.add(lab_space, 0, 1);
        rootPane.add(lab4, 0, 6);
        rootPane.add(lab1, 1, 1);
        rootPane.add(tf, 2, 1, 2, 1);
        rootPane.add(lab2, 1, 2);
        rootPane.add(pf, 2, 2, 2, 1);
        rootPane.add(cb1, 1, 3);
        rootPane.add(cb2, 2, 3);
        rootPane.add(lab3, 3, 3);
        Scene scene = new Scene(rootPane, 425, 300);
        primaryStage.setTitle("腾讯QQ  Author: Chris 1986985788");
        primaryStage.getIcons().add(new Image("file:src/resource/qq.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
