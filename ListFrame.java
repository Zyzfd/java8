import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;


public class ListFrame extends JFrame{
    public ListFrame() {
        super("List Pacient");
        createGUI();
    }

    Clients clients = new Clients();
    Items items = new Items();
    Otzivy otzivy = new Otzivy();

    JList<Object> clientsJList;
    DefaultListModel<Object> clientsModel;

    JList<Object> itemsJList;
    DefaultListModel<Object> itemsModel;
    
    JList<Object> otzivyJList;
    DefaultListModel<Object> otzivyModel;

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension textFieldSize = new Dimension(100, 20);
        JPanel panel = new JPanel();
        JPanel clientsPanel = new JPanel();
        JPanel itemsPanel = new JPanel();
        JPanel otzivyPanel = new JPanel();

        JLabel clientsLabel_c = new JLabel("Клиенты");
        JLabel fioLabel_c = new JLabel("ФИО:");
        JLabel niknameLabel_c = new JLabel("Ник:");
        JLabel sityLabel_c = new JLabel("Город:");
        JLabel emailLabel_c = new JLabel("Email:");
        JLabel phoneLabel_c = new JLabel("Телефон:");
        JTextField fioTextField_c = new JTextField();
        fioTextField_c.setPreferredSize(textFieldSize);
        JTextField niknameTextField_c = new JTextField();
        niknameTextField_c.setPreferredSize(textFieldSize);
        JTextField sityTextField_c = new JTextField();
        sityTextField_c.setPreferredSize(textFieldSize);
        JTextField emailTextField_c = new JTextField();
        emailTextField_c.setPreferredSize(textFieldSize);
        JTextField phoneTextField_c = new JTextField();
        phoneTextField_c.setPreferredSize(textFieldSize);

        JLabel itemsLabel_t = new JLabel("Товары");
        JLabel productLabel_t = new JLabel("Название:");
        JLabel costLabel_t = new JLabel("Стоимость:");
        JLabel codeLabel_t = new JLabel("Артикул:");
        JLabel countLabel_t = new JLabel("Количество:");
        JLabel saleLabel_t = new JLabel("Скидочный?:");
        JTextField productTextField_t = new JTextField();
        productTextField_t.setPreferredSize(textFieldSize);
        JTextField costTextField_t = new JTextField();
        costTextField_t.setPreferredSize(textFieldSize);
        JTextField codeTextField_t = new JTextField();
        codeTextField_t.setPreferredSize(textFieldSize);
        JTextField countTextField_t = new JTextField();
        countTextField_t.setPreferredSize(textFieldSize);
        JTextField saleTextField_t = new JTextField();
        saleTextField_t.setPreferredSize(textFieldSize);

        JLabel otzivyLabel_o = new JLabel("Отзывы");
        JLabel starsLabel_o = new JLabel("Звезды:");
        JLabel codeLabel_o = new JLabel("Артикул:");
        JLabel otzivLabel_o = new JLabel("Отзыв:");
        JTextField starsTextField_o = new JTextField();
        starsLabel_o.setPreferredSize(textFieldSize);
        JTextField codeTextField_o = new JTextField();
        codeTextField_o.setPreferredSize(textFieldSize);
        JTextArea otzivTextArea_o = new JTextArea();
        otzivTextArea_o.setPreferredSize(new Dimension(200, 150));
        otzivTextArea_o.setLineWrap(true);

        for (int i = 0; i < 10; i++) {
            clients.Clients.add(new Client("FIO", "Nikname", "Sity", "Email", i));
        }
        for (int i = 0; i < 10; i++) {
            items.Items.add(new Item("Product", 900, i, 78, false));
        }
        for (int i = 0; i < 10; i++) {
            otzivy.Otzivy.add(new Otziv(i, "blablabla", 3));
        }
        
        clientsModel = new DefaultListModel<Object>();
        Object[] cli_to_str = clients.to_String();
        for (int i = 0; i < cli_to_str.length; i++) {
            clientsModel.addElement(cli_to_str[i]);
        }

        itemsModel = new DefaultListModel<Object>();
        Object[] ite_to_str = items.to_String();
        for (int i = 0; i < ite_to_str.length; i++) {
            itemsModel.addElement(ite_to_str[i]);
        }

        otzivyModel = new DefaultListModel<Object>();
        Object[] otz_to_str = otzivy.to_String();
        for (int i = 0; i < otz_to_str.length; i++) {
            otzivyModel.addElement(otz_to_str[i]);
        }

        clientsPanel.setLayout(new FlowLayout());
        itemsPanel.setLayout(new FlowLayout());
        otzivyPanel.setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(1,3));


        clientsPanel.add(clientsLabel_c);

        clientsJList = new JList<Object>(clientsModel);
        clientsJList.setPreferredSize(new Dimension(400, 400));
        clientsPanel.add(new JScrollPane(clientsJList));

        JPanel fioJPanel_c = new JPanel();
        fioJPanel_c.setLayout(new GridLayout(1,2));
            fioJPanel_c.add(fioLabel_c);
            fioJPanel_c.add(fioTextField_c);
        clientsPanel.add(fioJPanel_c);
        
        JPanel niknameJPanel_c = new JPanel();
        niknameJPanel_c.setLayout(new GridLayout(1,2));
            niknameJPanel_c.add(niknameLabel_c);
            niknameJPanel_c.add(niknameTextField_c);
        clientsPanel.add(niknameJPanel_c);
        
        JPanel sityJPanel_c = new JPanel();
        sityJPanel_c.setLayout(new GridLayout(1,2));
            sityJPanel_c.add(sityLabel_c);
            sityJPanel_c.add(sityTextField_c);
        clientsPanel.add(sityJPanel_c);
        
        JPanel emailJPanel_c = new JPanel();
        emailJPanel_c.setLayout(new GridLayout(1,2));
            emailJPanel_c.add(emailLabel_c);
            emailJPanel_c.add(emailTextField_c);
        clientsPanel.add(emailJPanel_c);
        
        JPanel phoneJPanel_c = new JPanel();
        phoneJPanel_c.setLayout(new GridLayout(1,2));
            phoneJPanel_c.add(phoneLabel_c);
            phoneJPanel_c.add(phoneTextField_c);
        clientsPanel.add(phoneJPanel_c);

        JPanel clientsbuttonBlock = new JPanel();
        clientsbuttonBlock.setLayout(new GridLayout(1,2));
            JButton add_button_c = new JButton("Добавить");
            add_button_c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clients.Clients.add(new Client(fioTextField_c.getText(), niknameTextField_c.getText(), sityTextField_c.getText(), emailTextField_c.getText(), Long.parseLong(phoneTextField_c.getText())));
                    clientsModel.clear();
                    Object[] cli_to_str = clients.to_String();
                    for (int i = 0; i < cli_to_str.length; i++) {
                        clientsModel.addElement(cli_to_str[i]);
                    }
                }
            });
            clientsbuttonBlock.add(add_button_c);

            JButton del_button_c = new JButton("Удалить");
            del_button_c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clients.Clients.remove(clientsJList.getSelectedValue());
                    clientsModel.clear();
                    Object[] cli_to_str = clients.to_String();
                    for (int i = 0; i < cli_to_str.length; i++) {
                        clientsModel.addElement(cli_to_str[i]);
                    }
                }
            });
            clientsbuttonBlock.add(del_button_c);
        clientsPanel.add(clientsbuttonBlock);

        String[] clientsMassFilterComboBox = {"ФИО", "Ник", "Город", "Email", "Телефон"};
        JComboBox<String> clientsFilterComboBox = new JComboBox<String>(clientsMassFilterComboBox);
        JTextField clientsFilterTextField = new JTextField();
        clientsFilterTextField.setPreferredSize(textFieldSize);
        JButton clientsFilterButton = new JButton("Отфильтровать");
        JButton clientsUnfilterButton = new JButton("Очистить фильтр");
        
        clientsFilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valueComboBox = (String)clientsFilterComboBox.getSelectedItem();
                String valueTextField = clientsFilterTextField.getText();
                clientsModel.clear();
                List<Client> tempp = clients.Filter(valueComboBox, valueTextField);
                for (Client temp : tempp) {
                    clientsModel.addElement(temp);
                }
            }
        });

        clientsUnfilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientsModel.clear();
                Object[] cli_to_str = clients.to_String();
                for (int i = 0; i < cli_to_str.length; i++) {
                    clientsModel.addElement(cli_to_str[i]);
                }
            }
        });
        clientsPanel.add(clientsFilterComboBox);
        clientsPanel.add(clientsFilterTextField);
        clientsPanel.add(clientsFilterButton);
        clientsPanel.add(clientsUnfilterButton);



        itemsPanel.add(itemsLabel_t);

        itemsJList = new JList<Object>(itemsModel);
        itemsJList.setPreferredSize(new Dimension(400, 400));
        itemsPanel.add(new JScrollPane(itemsJList));

        JPanel productJPanel_t = new JPanel();
        productJPanel_t.setLayout(new GridLayout(1,2));
            productJPanel_t.add(productLabel_t);
            productJPanel_t.add(productTextField_t);
        itemsPanel.add(productJPanel_t);
        
        JPanel costJPanel_t = new JPanel();
        costJPanel_t.setLayout(new GridLayout(1,2));
            costJPanel_t.add(costLabel_t);
            costJPanel_t.add(costTextField_t);
        itemsPanel.add(costJPanel_t);
        
        JPanel codeJPanel_t = new JPanel();
        codeJPanel_t.setLayout(new GridLayout(1,2));
            codeJPanel_t.add(codeLabel_t);
            codeJPanel_t.add(codeTextField_t);
        itemsPanel.add(codeJPanel_t);
        
        JPanel countJPanel_t = new JPanel();
        countJPanel_t.setLayout(new GridLayout(1,2));
            countJPanel_t.add(countLabel_t);
            countJPanel_t.add(countTextField_t);
        itemsPanel.add(countJPanel_t);
        
        JPanel saleJPanel_t = new JPanel();
        saleJPanel_t.setLayout(new GridLayout(1,2));
            saleJPanel_t.add(saleLabel_t);
            saleJPanel_t.add(saleTextField_t);
        itemsPanel.add(saleJPanel_t);
        
        JPanel itemsbuttonBlock = new JPanel();
        itemsbuttonBlock.setLayout(new GridLayout(1,2));
            JButton add_button_t = new JButton("Добавить");
            add_button_t.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    items.Items.add(new Item(productTextField_t.getText(), Integer.parseInt(costTextField_t.getText()), Integer.parseInt(codeTextField_t.getText()), Integer.parseInt(countTextField_t.getText()), Boolean.parseBoolean(saleTextField_t.getText())));
                    itemsModel.clear();
                    Object[] ite_to_str = items.to_String();
                    for (int i = 0; i < ite_to_str.length; i++) {
                        itemsModel.addElement(ite_to_str[i]);
                    }
                }
            });
            itemsbuttonBlock.add(add_button_t);

            JButton del_button_t = new JButton("Удалить");
            del_button_t.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    items.Items.remove(itemsJList.getSelectedValue());
                    itemsModel.clear();
                    Object[] ite_to_str = items.to_String();
                    for (int i = 0; i < ite_to_str.length; i++) {
                        itemsModel.addElement(ite_to_str[i]);
                    }
                }
            });
            itemsbuttonBlock.add(del_button_t);
        itemsPanel.add(itemsbuttonBlock);

        String[] itemsMassFilterComboBox = {"Название", "Стоимость", "Артикул", "Количество", "Скидочный?"};
        JComboBox<String> itemsFilterComboBox = new JComboBox<String>(itemsMassFilterComboBox);
        JTextField itemsFilterTextField = new JTextField();
        itemsFilterTextField.setPreferredSize(textFieldSize);
        JButton itemsFilterButton = new JButton("Отфильтровать");
        JButton itemsUnfilterButton = new JButton("Очистить фильтр");
        
        itemsFilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valueComboBox = (String)itemsFilterComboBox.getSelectedItem();
                String valueTextField = itemsFilterTextField.getText();
                itemsModel.clear();
                List<Item> tempp = items.Filter(valueComboBox, valueTextField);
                for (Item temp : tempp) {
                    itemsModel.addElement(temp);
                }
            }
        });

        itemsUnfilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itemsModel.clear();
                Object[] ite_to_str = items.to_String();
                for (int i = 0; i < ite_to_str.length; i++) {
                    itemsModel.addElement(ite_to_str[i]);
                }
            }
        });
        itemsPanel.add(itemsFilterComboBox);
        itemsPanel.add(itemsFilterTextField);
        itemsPanel.add(itemsFilterButton);
        itemsPanel.add(itemsUnfilterButton);


        otzivyPanel.add(otzivyLabel_o);

        otzivyJList = new JList<Object>(otzivyModel);
        otzivyJList.setPreferredSize(new Dimension(400, 400));
        otzivyPanel.add(new JScrollPane(otzivyJList));

        JPanel starsJPanel_o = new JPanel();
        starsJPanel_o.setLayout(new GridLayout(1,2));
            starsJPanel_o.add(starsLabel_o);
            starsJPanel_o.add(starsTextField_o);
        otzivyPanel.add(starsJPanel_o);
        
        JPanel codeJPanel_o = new JPanel();
        codeJPanel_o.setLayout(new GridLayout(1,2));
            codeJPanel_o.add(codeLabel_o);
            codeJPanel_o.add(codeTextField_o);
        otzivyPanel.add(codeJPanel_o);
        
        JPanel otzivJPanel_o = new JPanel();
        otzivJPanel_o.setLayout(new GridLayout(1,2));
            otzivJPanel_o.add(otzivLabel_o);
            otzivJPanel_o.add(otzivTextArea_o);
        otzivyPanel.add(otzivJPanel_o);
        
        JPanel otzivybuttonBlock = new JPanel();
        otzivybuttonBlock.setLayout(new GridLayout(1,2));
            JButton add_button_o = new JButton("Добавить");
            add_button_o.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    otzivy.Otzivy.add(new Otziv(Integer.parseInt(starsTextField_o.getText()), otzivTextArea_o.getText(), Integer.parseInt(codeTextField_o.getText())));
                    otzivyModel.clear();
                    Object[] otz_to_str = otzivy.to_String();
                    for (int i = 0; i < otz_to_str.length; i++) {
                        otzivyModel.addElement(otz_to_str[i]);
                    }
                }
            });
            otzivybuttonBlock.add(add_button_o);

            JButton del_button_o = new JButton("Удалить");
            del_button_o.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    otzivy.Otzivy.remove(otzivyJList.getSelectedValue());
                    otzivyModel.clear();
                    Object[] otz_to_str = otzivy.to_String();
                    for (int i = 0; i < otz_to_str.length; i++) {
                        otzivyModel.addElement(otz_to_str[i]);
                    }
                }
            });
            otzivybuttonBlock.add(del_button_o);
        otzivyPanel.add(otzivybuttonBlock);

        String[] otzivyMassFilterComboBox = {"Звезды", "Артикул", "Отзыв"};
        JComboBox<String> otzivyFilterComboBox = new JComboBox<String>(otzivyMassFilterComboBox);
        JTextField otzivyFilterTextField = new JTextField();
        otzivyFilterTextField.setPreferredSize(textFieldSize);
        JButton otzivyFilterButton = new JButton("Отфильтровать");
        JButton otzivyUnfilterButton = new JButton("Очистить фильтр");
        
        otzivyFilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valueComboBox = (String)otzivyFilterComboBox.getSelectedItem();
                String valueTextField = otzivyFilterTextField.getText();
                otzivyModel.clear();
                List<Otziv> tempp = otzivy.Filter(valueComboBox, valueTextField);
                for (Otziv temp : tempp) {
                    otzivyModel.addElement(temp);
                }
            }
        });

        otzivyUnfilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                otzivyModel.clear();
                Object[] otz_to_str = otzivy.to_String();
                for (int i = 0; i < otz_to_str.length; i++) {
                    otzivyModel.addElement(otz_to_str[i]);
                }
            }
        });
        otzivyPanel.add(otzivyFilterComboBox);
        otzivyPanel.add(otzivyFilterTextField);
        otzivyPanel.add(otzivyFilterButton);
        otzivyPanel.add(otzivyUnfilterButton);


        panel.add(clientsPanel);
        panel.add(itemsPanel);
        panel.add(otzivyPanel);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(false);
                ListFrame frame = new ListFrame();
                //frame.setResizable(false);
                frame.setPreferredSize(new Dimension(1300, 500));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
