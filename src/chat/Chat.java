/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author bombaster
 */
public class Chat extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JavaFX Welcome"); //Название окошка
        GridPane grid = new GridPane(); //Сетка(как GridLayout в Qt)
        grid.setAlignment(Pos.CENTER); //Устанавливаем позицию всегда по центру
        grid.setHgap(10); //Пробелы междустроками и столбцами
        grid.setVgap(10); // -//-
        grid.setPadding(new Insets(25, 25, 25, 25)); //Пространство вокруг сетки Порядок перечисления в insets: вверху, справа, снизу и слева. 

        Scene scene = new Scene(grid, 300, 275); //Создаем сцену с Grid в качестве корневого узла
        primaryStage.setScene(scene);
 
        Text scenetitle = new Text("Welcome"); //Устанавливаем неизменяему надпись
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); //Её свойства
        grid.add(scenetitle, 0, 0, 2, 1); //И добавляем в сетку

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField(); //Текстовое поле(сюда будем вводить имя пользователя)
        grid.add(userTextField, 1, 1); //Добавляем в сетку

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();//Специальное пле для пароля
        grid.add(pwBox, 1, 2);//Добавляем в сетку
        
        Button btn = new Button("Sign in");//Создаём кнопочку входа
        HBox hbBtn = new HBox(10); //Создаём для неё вспомогательный объект для выравнивания по правому краю
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);//Именно этот объект и добавляем в сетку
        
        final Text actiontarget = new Text(); //Добавляем элемент Text, для отображения информации
        grid.add(actiontarget, 1, 6);

        //Обработка события нажатия на кнопку:
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");//Здесь и меняем текст вывода
            }
        });
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
