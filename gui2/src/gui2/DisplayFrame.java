/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Student
 */
public class DisplayFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel content = new JPanel();

    HashMap<String, JLabel> labels;
    HashMap<String, JTextField> textFields;
    HashMap<String, JButton> buttons;
    Code code;

    public DisplayFrame() throws Exception {
        code = new Code();
        frame.add(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        switchContent(mainMenu(), "Main Menu");
        frame.setVisible(true);

    }

    public JPanel mainMenu() {
        JPanel menu = new JPanel();

        this.labels = new HashMap<>();
        this.textFields = new HashMap<>();
        this.buttons = new HashMap<>();
        menu.add(generateMenu());
        menu.add(generateForm());
        menu.setSize(500, 500);
        menu.setLayout(null);
        menu.setVisible(true);

        return menu;
    }

    public JPanel editFrame() {
        JPanel panel = new JPanel();

        this.labels = new HashMap<>();
        this.textFields = new HashMap<>();
        this.buttons = new HashMap<>();
        String[] keys = {"Next", "Previous", "Delete Record", "Save Edit", "Main Menu"};
        panel.add(generateMenu(keys));
        panel.add(generateForm());
        panel.setSize(500, 500);
        panel.setLayout(null);
        panel.setVisible(true);
        populateEditForm();
        return panel;
    }

    public void switchContent(JPanel panel, String title) {
        frame.remove(content);
        content = panel;
        frame.add(content);
        frame.repaint();
        content.repaint();
        frame.setTitle(title);
    }

    public void populateEditForm() {
        String[] keys = {"First Name", "Last Name", "Age", "Record #"};
        System.out.println(code.getCurr());
        if (code.getCurr() != -1) {
            Person person = code.getCurrentPerson();
            String[] personInfo = {person.getFirstName(), person.getLastName(), "" + person.getAge(), "" + person.getRecordNumber()};

            for (int i = 0; i < keys.length; i++) {
                JTextField field = textFields.get(keys[i]);
                field.setText(personInfo[i]);
            }
        } else {
            for (String key : keys) {
                JTextField field = textFields.get(key);
                field.setText("No Persons Found");
                field.setEnabled(false);
            }
        }

    }

    public JPanel generateForm() {
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 200, 500);
        panel.setLayout(null);
        //panel.setBackground(Color.gray);

        String[] keys = {"First Name", "Last Name", "Age", "Record #"};

        for (int i = 0, y = 0; i < keys.length; i++, y += 50) {

            int x;

            x = 90;
            this.textFields.putIfAbsent(keys[i], new JTextField());
            this.textFields.get(keys[i]).setBounds(x, y, 120, 30);

            if (keys[i].equals("Record #")) {
                int recordNum = 1;
                if (!code.getPersons().isEmpty()) {
                    int size = code.getPersons().size();
                    recordNum = code.getPersons().get(size - 1).getRecordNumber() + 1;
                }
                this.textFields.get(keys[i]).setText(recordNum + "");
                this.textFields.get(keys[i]).setEnabled(false);

            }

            panel.add(this.textFields.get(keys[i]));

            x = 10;
            this.labels.putIfAbsent(keys[i], new JLabel(keys[i]));
            this.labels.get(keys[i]).setBounds(x, y, 100, 30);
            panel.add(this.labels.get(keys[i]));

        }
        return panel;
    }

    public JPanel generateMenu() {
        JPanel panel = new JPanel();
        panel.setBounds(225, 10, 200, 300);
        panel.setLayout(null);
        //panel.setBackground(Color.gray);

        String[] keys = {"Add", "Save", "Clear", "Edit", "Exit"};

        for (int i = 0, y = 0; i < keys.length; i++, y += 50) {

            this.buttons.putIfAbsent(keys[i], new JButton(keys[i]));
            int x = 50;
            this.buttons.get(keys[i]).setBounds(x, y, 120, 30);
            this.buttons.get(keys[i]).addActionListener(this);
            panel.add(this.buttons.get(keys[i]));

        }
        return panel;

    }

    public JPanel generateMenu(String[] keys) {
        JPanel panel = new JPanel();
        int panelHeight = 55 * keys.length;
        panel.setBounds(225, 10, 200, panelHeight);
        panel.setLayout(null);
        //panel.setBackground(Color.gray);

        for (int i = 0, y = 0; i < keys.length; i++, y += 50) {

            this.buttons.putIfAbsent(keys[i], new JButton(keys[i]));
            int x = 50;
            this.buttons.get(keys[i]).setBounds(x, y, 120, 30);
            this.buttons.get(keys[i]).addActionListener(this);
            panel.add(this.buttons.get(keys[i]));

        }
        return panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Add":
                code.add(textFields);
                break;
            case "Clear":
                code.clear(textFields);
                break;
            case "Save": {
                try {
                    code.save();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(DisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Save Edit": {
                try {
                    code.saveEdit(textFields);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(DisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "Edit":
                switchContent(editFrame(), "Edit");
                break;
            case "Delete Record":
                code.delete();
                populateEditForm();
                break;

            case "Main Menu":
                switchContent(mainMenu(), "Main Menu");
                break;
            case "Next":
                code.next();
                populateEditForm();
                break;
            case "Previous":
                code.previous();
                populateEditForm();
                break;

            case "Exit":
                System.exit(0);

        }
    }

}
