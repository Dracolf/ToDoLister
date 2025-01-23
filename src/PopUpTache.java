import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class PopUpTache extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public boolean isGreen;
    public boolean isRed;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PopUpTache frame = new PopUpTache(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PopUpTache(JTextField text) {
        this.isGreen = false;
        this.isRed = false;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\img\\check.png"));
        setTitle(text.getText());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);

        JButton btnNewButton = new JButton("Oui");
        btnNewButton.setIcon(new ImageIcon(".\\src\\img\\greentick.png"));
        btnNewButton.setBackground(new Color(0, 255, 0));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(new Color(0,255,0));
                Menu.updateNbFaitesVert();

                //////////////////// TESTS ///////////////////////////////
				/* isGreen = true;
				isRed = false;
				System.out.println(isGreen);
				System.out.println(isRed);
				Menu menu = new Menu();
				menu.effectuees.setText("Tâches effectuées : "+(menu.Calendrier.NBFAITES+1));
				menu.Calendrier.NBFAITES++;
				menu.setVisible(true);
				menu.toFront(); */
                /////////////////////////////////////////////////////////

            }
        });
        panel_1.setLayout(new BorderLayout(0, 0));


        JButton btnNewButton_1 = new JButton("Non");
        btnNewButton_1.setIcon(new ImageIcon(".\\src\\img\\redcross.png"));
        btnNewButton_1.setBackground(new Color(255, 0, 0));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(new Color(255,0,0));
                isRed = true;
                isGreen = false;
                System.out.println(isGreen);
                System.out.println(isRed);
            }
        });

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setForeground(new Color(240, 240, 240));
        lblNewLabel_1.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        panel_2.add(lblNewLabel_1);


        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_2 = new JLabel("Avez-vous effectué cette tâche ?");
        lblNewLabel_2.setFont(new Font("Source Sans Pro", Font.BOLD, 15));

        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5, BorderLayout.NORTH);

        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6, BorderLayout.SOUTH);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4, BorderLayout.SOUTH);

        panel_6.add(btnNewButton);
        panel_6.add(btnNewButton_1);
        panel_5.add(lblNewLabel_2);

        JLabel lblNewLabel_1_1 = new JLabel("New label");
        lblNewLabel_1_1.setForeground(UIManager.getColor("Button.background"));
        lblNewLabel_1_1.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        panel_4.add(lblNewLabel_1_1);

        JLabel lblNewLabel = new JLabel("<HTML><U>"+text.getText()+"</U></HTML>");
        lblNewLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        panel.add(lblNewLabel);

    }
}
