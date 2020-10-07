package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FriendList extends Application {

    final String[] friendListName = new String[]{"好友", "家人", "老师", "陌生人", "黑名单"};
    final TitledPane[] tps = new TitledPane[friendListName.length];
    final Label label = new Label("TEST");

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
//        rootPane.setGridLinesVisible(true);
//        设置背景图
        Image image_bg = new Image("file:src/resource/FriendList_bg.png");
        ImageView imageView_bg = new ImageView(image_bg);
        imageView_bg.setFitWidth(286);
        imageView_bg.setFitHeight(112);
        imageView_bg.setSmooth(true);
        imageView_bg.setCache(true);
//        用按钮实现选项卡功能，分别实现消息、联系人
        ToggleButton button_contact = new ToggleButton("联系人");
        ToggleButton button_message = new ToggleButton("消息");
        button_contact.setId("tab_button");
        button_message.setId("tab_button");
//        设置好友列表
        final Accordion accordion = new Accordion();
        for (int i = 0; i < friendListName.length; i++) {
            tps[i] = new TitledPane(friendListName[i], label);
            tps[i].setAnimated(false);
        }
        accordion.getPanes().addAll(tps);
        accordion.setExpandedPane(tps[0]);
//        设置消息列表
        VBox vBox_message = new VBox();
        String[] name = new String[]{"小明", "小王", "小红", "小军"};
        Button[] buttons = new Button[name.length];
        for (int i = 0; i < name.length; i++) {
            buttons[i] = new Button(name[i]);
            buttons[i].setId("button_messageList");
        }
        vBox_message.getChildren().addAll(buttons);
        //        设置按钮事件
        button_contact.setSelected(true);
        button_contact.setOnAction(event -> {
            button_message.setSelected(false);
            rootPane.getChildren().remove(vBox_message);
            rootPane.add(accordion, 0, 2, 6, 1);
        });
        button_message.setOnAction(event -> {
            button_contact.setSelected(false);
            rootPane.getChildren().remove(accordion);
            rootPane.add(vBox_message, 0, 2, 6, 1);
        });
        buttons[0].setOnAction(event -> {
            ChatPane chatPane = new ChatPane();
            try {
                chatPane.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            primaryStage.hide();
        });
//        实现底部功能栏
        HBox hBox_buttom = new HBox();
        hBox_buttom.setStyle("-fx-border-width: 1px 1px 1px 1px");
        Image image_manu = new Image("file:src/resource/manu.png");
        Image image_friend = new Image("file:src/resource/friend.png");
        Image image_doc = new Image("file:src/resource/doc.png");
        Image image_weiyun = new Image("file:src/resource/weiyun.png");
        Image image_ying = new Image("file:src/resource/ying.png");
        ImageView iv1 = new ImageView(image_manu), iv2 = new ImageView(image_friend), iv3 = new ImageView(image_doc), iv4 = new ImageView(image_weiyun), iv5 = new ImageView(image_ying);
        ImageView[] imageViews = new ImageView[5];
        imageViews[0] = iv1;
        imageViews[1] = iv2;
        imageViews[2] = iv3;
        imageViews[3] = iv4;
        imageViews[4] = iv5;
        Button[] buttons1 = new Button[5];
        for (int i = 0; i < imageViews.length; i++) {
            buttons1[i] = new Button("", imageViews[i]);
            buttons1[i].setId("button_buttom");
        }
//        设置腾讯文档按钮动作
        Main main = new Main();
        main.openWebsite(buttons1[2], "https://docs.qq.com/desktop/");
        for (Button button : buttons1) {
            hBox_buttom.getChildren().add(button);
        }
        rootPane.add(hBox_buttom, 0, 3, 6, 1);
        rootPane.add(imageView_bg, 0, 0, 6, 1);
        rootPane.add(button_contact, 0, 1, 3, 1);
        rootPane.add(button_message, 3, 1, 3, 1);
        rootPane.add(accordion, 0, 2, 6, 1);
        GridPane.setMargin(hBox_buttom, new Insets(230, 0, 0, 0));
        HBox.setMargin(buttons1[4], new Insets(0, 0, 0, 70));
        Scene scene = new Scene(rootPane, 275, 554);
        primaryStage.setTitle("好友列表");
        primaryStage.getIcons().add(new Image("file:src/resource/qq.png"));
        rootPane.setStyle("-fx-background-color:White;");
        scene.getStylesheets().add(
                getClass().getResource("FriendListStyle.css")
                        .toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
