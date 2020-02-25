import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonAddOk extends JFrame {

    private JTextField jTextFieldNumber;
    private JTextField jTextFieldName;
    private JPanel jPanelOk;
    private JLabel phone;
    private JLabel name;
    private JButton ok;
    private JRootPane jRootPane = new JRootPane();

    public ButtonAddOk() {
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setTitle("Add worker window");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        jPanelOk = new JPanel();
        jPanelOk.setLayout(new GridLayout(6, 1));

        phone = new JLabel("Введите фамилию");
        jTextFieldName = new JTextField();
        name = new JLabel("Введите номер телефона в формате: 58-58 или 5858");
        jTextFieldNumber = new JTextField();

        ok = new JButton("OK");
        ok.addActionListener(new ButtonOkActionListener());


        jPanelOk.add(phone);
        jPanelOk.add(jTextFieldNumber);
        jPanelOk.add(name);
        jPanelOk.add(jTextFieldName);
        jPanelOk.add(ok);

        add(jPanelOk, BorderLayout.CENTER);

        setVisible(true);
    }

    public class ButtonOkActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String strNumber = jTextFieldNumber.getText();
            String strName = jTextFieldName.getText();
            Collekt.addPB(strNumber, strName);
            try {
                Collekt.seveBd();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

}
