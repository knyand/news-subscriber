package loc.zank;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private String serverAddress;
    private int serverPort;
    private JTextArea newsArea = new JTextArea(20, 40);

    private Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        initComponents();
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Pass the server address and port as the sole command line argument");
            return;
        }

        new Client(args[0], Integer.parseInt(args[1])).run();
    }

    private void initComponents() {

        JFrame frame = new JFrame("News Subscriber");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        newsArea.setEditable(false);
        newsArea.setLineWrap(true);

        panel.add(new JLabel("News"), BorderLayout.NORTH);
        panel.add(new JScrollPane(newsArea), BorderLayout.CENTER);

        frame.pack();

    }

    private void run() {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            DataInputStream in = new DataInputStream(socket.getInputStream());

            while (true) {
                newsArea.append(in.readUTF() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
