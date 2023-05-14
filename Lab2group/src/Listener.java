import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Listener implements ActionListener {

    JButton button1, button2;
    JPanel panel;
    boolean visible = false;
    Listener(JButton button1, JButton button2, JPanel panel){
        this.button1 = button1;
        this.button2 = button2;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        visible = !visible;
        panel.setVisible(visible);
    }
}


/*
    boolean visible = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                visible = !visible;
                mainMenu.setVisible(visible);
                gamePanel.setVisible(!visible);
            }
        });
 */