package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ChatPane extends Application {
    Image image_call = new Image("file:src/resource/call.png", 26, 26, true, true);
    Image image_video = new Image("file:src/resource/video.png");
    Image image_shenglue = new Image("file:src/resource/shenglue.png");
    Image image_face = new Image("file:src/resource/face.png");
    Image image_cut = new Image("file:src/resource/cut.png");
    Image image_file = new Image("file:src/resource/file.png");
    Image image_doc = new Image("file:src/resource/doc.png");
    Image image_image = new Image("file:src/resource/image.png");
    Image image_shake = new Image("file:src/resource/shake.png");
    Image image_full = new Image("file:src/resource/full.png");
    Image image_history = new Image("file:src/resource/history.png");

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
//        rootPane.setGridLinesVisible(true);
//        设置顶部工具栏
        HBox hBox_top_toolbar = new HBox();
        ImageView imageView_call = new ImageView(image_call), imageView_video = new ImageView(image_video), imageView_shenglue = new ImageView(image_shenglue);
        Button button_call = new Button("", imageView_call);
        Button button_video = new Button("", imageView_video);
        Button button_shenglue = new Button("", imageView_shenglue);
        button_call.setId("button_top");
        button_video.setId("button_top");
        button_shenglue.setId("button_top");
//        设置对话框
        TextArea textArea_dialog = new TextArea("小明\n今天中午一起吃饭吗？");
        textArea_dialog.setPrefSize(160, 290);
        textArea_dialog.setWrapText(true);
        textArea_dialog.setEditable(false);
        textArea_dialog.setId("textarea");
//      设置中部工具栏
        ImageView imageView_face = new ImageView(image_face), imageView_cut = new ImageView(image_cut), imageView_file = new ImageView(image_file), imageView_doc = new ImageView(image_doc), imageView_image = new ImageView(image_image), imageView_shake = new ImageView(image_shake), imageView_full = new ImageView(image_full), imageView_history = new ImageView(image_history);
        ImageView[] imageViews = new ImageView[8];
        imageViews[0] = imageView_face;
        imageViews[1] = imageView_cut;
        imageViews[2] = imageView_file;
        imageViews[3] = imageView_doc;
        imageViews[4] = imageView_image;
        imageViews[5] = imageView_shake;
        imageViews[6] = imageView_full;
        imageViews[7] = imageView_history;
        Button[] buttons = new Button[8];
        for (int i = 0; i < imageViews.length; i++) {
            buttons[i] = new Button("", imageViews[i]);
            buttons[i].setId("button_center");
        }
        HBox hBox_center_button = new HBox();
        //        设置本地文本区域
        TextArea textArea_buttom = new TextArea();
        textArea_buttom.setPrefSize(160, 60);
        textArea_buttom.setWrapText(true);
        textArea_buttom.setEditable(true);
        textArea_buttom.setId("textarea");
        textArea_buttom.setPromptText("请在此输入");
//        设置底部发送按钮和退出按钮
        Button button_send = new Button("发送(S)");
        Button button_close = new Button("关闭(C)");
        button_send.setId("button_send");
        button_close.setId("button_close");
        //        设置腾讯文档按钮动作
        Main main = new Main();
        main.openWebsite(buttons[3], "https://docs.qq.com/desktop/");
//        设置退出事件
        button_close.setOnAction(event -> Platform.exit());
        for (Button button : buttons) {
            hBox_center_button.getChildren().add(button);
        }
        rootPane.add(hBox_center_button, 0, 2, 8, 1);
        hBox_top_toolbar.getChildren().addAll(button_call, button_video, button_shenglue);
        rootPane.add(button_close, 6, 4);
        rootPane.add(button_send, 7, 4);
        rootPane.add(textArea_buttom, 0, 3, 8, 1);
        rootPane.add(textArea_dialog, 0, 1, 8, 1);
        rootPane.add(hBox_top_toolbar, 0, 0, 8, 1);
        GridPane.setMargin(textArea_dialog, new Insets(4, 0, 0, 0));
        HBox.setMargin(button_call, new Insets(0, 0, 0, 20));
        GridPane.setMargin(button_close, new Insets(5, 0, 0, 280));
        GridPane.setMargin(button_send, new Insets(5, 0, 0, 10));
        GridPane.setMargin(hBox_top_toolbar, new Insets(0, 0, 0, 320));
        HBox.setMargin(buttons[7], new Insets(0, 0, 0, 125));
        Scene scene = new Scene(rootPane, 460, 460);
        primaryStage.setTitle("聊天界面");
        primaryStage.getIcons().add(new Image("file:src/resource/qq.png"));
        rootPane.setStyle("-fx-background-color:White;");
        scene.getStylesheets().add(
                getClass().getResource("ChatPaneStyle.css")
                        .toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
