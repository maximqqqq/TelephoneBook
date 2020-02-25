import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {

    JPanel jPanelUp = new JPanel();
    JPanel jPanelCentr = new JPanel();
    JPanel jPanelDown = new JPanel();
    private JScrollPane jScrollPane;
    private JButton jButtonFind;
    private JTextField jTextField;
    DefaultListModel defaultListModel;
    JList jList;
    private JButton buttonAdd;
    DefaultListModel ListModel;

    public MainFrame() {
        setSize(500, 500);
        setTitle("Телефонная книга");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

//        jPanelUp.setLayout(new BoxLayout(jPanelUp,BoxLayout.PAGE_AXIS));
        jPanelUp.setBorder(new TitledBorder(new EtchedBorder(), "Поиск"));

        jTextField = new JTextField(30);
        jPanelUp.add(jTextField);

        jButtonFind = new JButton("Найти");
        jButtonFind.setActionCommand("jButtonFind");
        jButtonFind.addActionListener(new ButtonFind());
        jPanelUp.add(jButtonFind);

        defaultListModel = new DefaultListModel();
        jPanelCentr.setBorder(new TitledBorder(new EtchedBorder(), "Результат"));
        jList = new JList(defaultListModel);
        jScrollPane = new JScrollPane(jList);
        jPanelCentr.add(jScrollPane);

        buttonAdd = new JButton("Добавить");
        buttonAdd.setActionCommand("buttonAdd");
        buttonAdd.addActionListener(this);
        jPanelDown.add(buttonAdd);

        add(jPanelUp, BorderLayout.NORTH);
        add(jPanelCentr, BorderLayout.CENTER);
        add(jPanelDown, BorderLayout.SOUTH);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String res = e.getActionCommand();

        switch (res) {
            case "buttonAdd":
                new ButtonAddOk();
                break;
            case "jButtonFind":
                new ButtonFind();
                break;
            default:
                this.dispose();
                break;
        }
    }

    public class ButtonFind implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Диологовое окно
//           JOptionPane.showMessageDialog(jTextArea,"111");
            String strF = jTextField.getText();
            try {
                Collekt.loadPB();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String[] numbers = Collekt.FindNumberPhone(strF);

            for (String number : numbers) {
                System.out.println(number);
                defaultListModel.addElement(number);
            }
        }
    }
}
