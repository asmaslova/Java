import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controller implements KeyListener{

    JLabel label;
    Controller(JLabel label){
        this.label = label;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                label.setLocation(label.getX(), label.getY()-15);
                break;

            case KeyEvent.VK_A:
                label.setLocation(label.getX()-15, label.getY());
                break;

            case KeyEvent.VK_S:
                label.setLocation(label.getX(), label.getY()+15);
                break;

            case KeyEvent.VK_D:
                label.setLocation(label.getX()+15, label.getY());
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}