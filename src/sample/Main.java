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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main extends Application {

    final Label lab1 = new Label("QQ账号:");
    final Label lab2 = new Label("密码:");
    final Button button1 = new Button("找回密码");
    final Button button2 = new Button("注册账号");
    final PasswordField pf = new PasswordField();
    final TextField tf = new TextField();

    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane rootPane = new GridPane();
        rootPane.setPadding(new Insets(0, 0, 0, 0));
        rootPane.setVgap(5);
//        rootPane.setGridLinesVisible(true);
//      设置背景图
        Image ima_login = new Image("file:src/resource/4545d8e1db93fbea7811011f2f9753b0.jpg");
        ImageView imgView_login = new ImageView(ima_login);
        imgView_login.setFitWidth(400);
        imgView_login.setFitHeight(173);
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
        HB_checkbox.getChildren().add(button1);
        Button bt1 = new Button("登录");
//        设置按钮事件
        bt1.setPrefSize(240, 50);
        button1.setId("button_web");
        button2.setId("button_web");
        bt1.setOnAction(event -> {
            FriendList friendList = new FriendList();
            try {
                friendList.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            primaryStage.hide();
        });
        button1.setOnAction(event -> {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://aq.qq.com/v2/uv_aq/html/reset_pwd/pc_reset_pwd_input_account.html?v=3.0&old_ver_account=1986985788"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        button2.setOnAction(event -> {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://ssl.zc.qq.com/v3/index-chs.html?type=0"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        rootPane.add(bt1, 1, 4, 4, 1);
        rootPane.add(imgView_login, 0, 0, 4, 1);
        rootPane.add(button2, 0, 5);
        rootPane.add(lab1, 1, 1);
        rootPane.add(tf, 2, 1, 2, 1);
        rootPane.add(lab2, 1, 2);
        rootPane.add(pf, 2, 2, 2, 1);
        rootPane.add(cb1, 1, 3);
        rootPane.add(cb2, 2, 3);
        rootPane.add(button1, 3, 3);
        rootPane.setMargin(bt1, new Insets(0, 0, 0, 40));
        rootPane.setMargin(lab1, new Insets(0, 0, 0, 40));
        rootPane.setMargin(tf, new Insets(0, 0, 0, 0));
        rootPane.setMargin(lab2, new Insets(0, 0, 0, 40));
        rootPane.setMargin(pf, new Insets(0, 0, 0, 0));
        rootPane.setMargin(cb1, new Insets(0, 0, 0, 40));
        rootPane.setMargin(cb2, new Insets(0, 0, 0, 10));
        rootPane.setMargin(button1, new Insets(0, 0, 0, 30));
        rootPane.setMargin(button2, new Insets(0, 0, 5, 0));
        Scene scene = new Scene(rootPane, 425, 300);
        rootPane.setStyle("-fx-background-color:White;");
        primaryStage.setTitle("腾讯QQ  Author: Chris 1986985788");
        primaryStage.getIcons().add(new Image("file:src/resource/qq.png"));
        scene.getStylesheets().add(
                getClass().getResource("Main.css")
                        .toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
