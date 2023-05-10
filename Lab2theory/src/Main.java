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
    Main(){
        super("the best game in the world");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);

        //panel
        JPanel gamePanel = new JPanel();
        gamePanel.setBounds(0,0,600,600);
        gamePanel.setLayout(null);
        add(gamePanel);

        JButton gameButton = new JButton("GamemaG");
        gameButton.setBounds(0,0,100,20);
        add(gameButton);
        gameButton.addActionListener(new ActionListener() {

            boolean visible = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                visible=!visible;
                gamePanel.setVisible(visible);
            }
        });

        //buttons
        JButton button = new JButton("Click me once");
        button.setBounds(20,20,300,100);
        add(button);
        gamePanel.add(button);
        button.addActionListener(new Listener(button));

        JButton button2 = new JButton("Click me twice");
        button2.setBounds(350,20,300,100);
        add(button2);
        button2.addActionListener(new Listener(button2));

        Listener listener2 = new Listener(button2);
        button2.addActionListener(listener2);
        button.addActionListener(listener2);

        //text, chat
        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 140, 300, 100);
        add(textArea);

        JTextField textField = new JTextField();
        textField.setBounds(20, 260, 300, 100);
        add(textField);

        textArea.setFont(new Font("Arial", Font.BOLD, 20));

        Chat chat = new Chat(textField, textArea);
        textField.addActionListener(chat);

        JLabel label = new JLabel(new ImageIcon("icons8-cat-24.png"));
        label.setBounds(400, 200, 100, 100);
        add(label);
        gamePanel.add(label);

        Controller controller = new Controller(label);
        button.addKeyListener(controller);

        JButton runningButton = new JButton("Color");
        runningButton.setBounds(gamePanel.getWidth()/2, gamePanel.getHeight()/2, 80, 40);
        gamePanel.add(runningButton);
        runningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rng = new Random();
                runningButton.setBackground(new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256)));
                runningButton.setForeground(new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256)));
            }
        });
        runningButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random rng = new Random();
                int dx = rng.nextInt(-80, 80);
                int dy = rng.nextInt(-20, 20);
                int x = runningButton.getX()+dx;
                if(x<0) x=0;
                if (x+runningButton.getWidth()>gamePanel.getWidth()) x=gamePanel.getWidth()-runningButton.getWidth();
                int y = runningButton.getY()+dy;
                if(y<0) y=0;
                if (y+runningButton.getHeight()>gamePanel.getHeight()) y=gamePanel.getHeight()-runningButton.getHeight();
                runningButton.setLocation(runningButton.getX()+dx, runningButton.getY()+dy);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Random rng = new Random();
                int dx = rng.nextInt(-80, 80);
                int dy = rng.nextInt(-20, 20);
                int x = runningButton.getX()+dx;
                if(x<0) x=0;
                if (x+runningButton.getWidth()>gamePanel.getWidth()) x=gamePanel.getWidth()-runningButton.getWidth();
                int y = runningButton.getY()+dy;
                if(y<0) y=0;
                if (y+runningButton.getHeight()>gamePanel.getHeight()) y=gamePanel.getHeight()-runningButton.getHeight();
                runningButton.setLocation(x, y);
                runningButton.setLocation(x,y);
                if(runningButton.getBounds().intersects(button.getBounds())) button.setEnabled(false);
                else button.setEnabled(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setLocation(label.getX()+1, label.getY());
            }
        });
        timer.start();


        setVisible(true);
    }


    public static void main(String[] args) {
       new Main();

    }
}