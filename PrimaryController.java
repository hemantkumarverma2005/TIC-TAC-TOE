package com.mycompany.mavenproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PrimaryController {
    int count=0;
    
    @FXML
    private TextField player1;

    @FXML
    private TextField player2;
    
    @FXML
    private Rectangle box;
    
    @FXML
    private Button START=new Button("PLAY");
    
    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;
    
    @FXML
    private Pane pane;
    
    @FXML
    private Text text=new Text("PRESS PLAY TO START");

    public PrimaryController() {
        this.pane = new Pane();
    }
    
    @FXML
    void markXorO(ActionEvent event) {
        
        if (player1.getText().isEmpty() || player2.getText().isEmpty()) {
            return; // Don't allow moves until names are entered
        }
        
        if(count%2==0)
        {
            ((Button)event.getSource()).setText("X");
            ((Button)event.getSource()).setDisable(true);
            text.setText("PLAYER 1");
        }
        else
        {
            ((Button)event.getSource()).setText("0");
            ((Button)event.getSource()).setDisable(true);
            text.setText("PLAYER 2");
        }
        count++;
        check();
    }
    
    @FXML
    void restart(ActionEvent event) {
            text.setText("PLAYER 1");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            b1.setDisable(false);
            b2.setDisable(false);
            b3.setDisable(false);
            b4.setDisable(false);
            b5.setDisable(false);
            b6.setDisable(false);
            b7.setDisable(false);
            b8.setDisable(false);
            b9.setDisable(false);
        
    }
    
    
    public void check()
    {
        int count=0;
        for(int i=0;i<8;i++)
        {
            String str="";
            switch(i){
                
                case 0:str= b1.getText()+b2.getText()+b3.getText();break;
                case 1:str= b4.getText()+b5.getText()+b6.getText();break;
                case 2:str= b7.getText()+b8.getText()+b9.getText();break;
                case 3:str= b1.getText()+b4.getText()+b7.getText();break;
                case 4:str= b2.getText()+b5.getText()+b8.getText();break;
                case 5:str= b3.getText()+b6.getText()+b9.getText();break;
                case 6:str= b1.getText()+b5.getText()+b9.getText();break;
                case 7:str= b3.getText()+b5.getText()+b7.getText();break;
            }
            if(str.equals("XXX"))
            {
                text.setText(player1.getText()+" WIN!");
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                b5.setDisable(true);
                b6.setDisable(true);
                b7.setDisable(true);
                b8.setDisable(true);
                b9.setDisable(true);
            }
            else if(str.equals("000"))
            {
                text.setText(player2.getText()+" WINS!");
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                b5.setDisable(true);
                b6.setDisable(true);
                b7.setDisable(true);
                b8.setDisable(true);
                b9.setDisable(true);
            }
            else if(str.length()==3)
                count++;
        }
        if(count==8)
            text.setText("DRAW !");
    }
    
    
    public void isHover(MouseEvent event)
    {
    }
}
