import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Chat implements ActionListener{

    JTextField input;
    JTextArea output;
    Chat(JTextField input, JTextArea output){
        this.input = input;
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        output.setText(output.getText() + "\n" + input.getText());
        //input.setText();
    }
}