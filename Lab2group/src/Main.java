import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Main extends JFrame {
    Main() {
        super("Hatsune Miku: Yandere Love");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);

        JPanel gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 1920, 1080);
        gamePanel.setLayout(null);
        add(gamePanel);

        JPanel mainMenu = new JPanel();
        mainMenu.setBounds(685, 404, 550, 272);
        mainMenu.setLayout(null);
        add(mainMenu);

        JButton continueGame = new JButton("Продолжить");
        continueGame.setBounds(725, 447, 469, 70);
        add(continueGame);
        mainMenu.add(continueGame);

        JButton gameMenu = new JButton("Главное меню");
        gameMenu.setBounds(44, 44, 456, 63);
        add(gameMenu);
        gamePanel.add(gameMenu);

        JLabel label = new JLabel(new ImageIcon("pngegg.png"));
        label.setBounds(685, 404, 550, 272);
        add(label);
        mainMenu.add(label);

        Listener menucontinueListener = new Listener(continueGame, gameMenu, mainMenu);
        continueGame.addActionListener(menucontinueListener);
        gameMenu.addActionListener(menucontinueListener);

        setVisible(true);
    }

        public static void main (String[]args){
            new Main();

        }
    }
