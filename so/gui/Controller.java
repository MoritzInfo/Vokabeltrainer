package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class Controller {

    @FXML
    private Button button1;

    @FXML
    private Label label1;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;
    
    private Model model;
    
    public Controller(){
        model = new Model();
        
    }

    public void addToDo(){
        String beschreibung = textField1.getText();
        int    prio         = Integer.parseInt(textField2.getText()); 
        model.addToDo(beschreibung, prio);
        
        List<ToDo> toDoList = model.getToDoList();
        toDoList.toFirst();
        String ausgabe="";
        while(toDoList.hasAccess()){
            beschreibung = toDoList.getContent().getBeschreibung();
            prio         = toDoList.getContent().getPrioritaet();
            ausgabe     += beschreibung +" - "+prio+"\n";
            toDoList.next();
        }
        label1.setText(ausgabe);
    }

}

