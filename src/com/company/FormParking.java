package com.company;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormParking extends JFrame {

    private JFrame frame;
    private JPanel contentPane;
    private JTextField textField;
    private Itruck truck;
    private MultiLevelParking parking; // / Îáúåêò îò êëàññà ìíîãîóðîâíåâîé
    // ïàðêîâêè
    private final int countLevel = 5; // Êîëè÷åñòâî óðîâíåé-ïàðêîâîê

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormParking frame = new FormParking();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the application.
     */
    public FormParking() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        PanelParking panelParking = new PanelParking();
        panelParking.setBounds(10, 11, 630, 432);
        contentPane.add(panelParking);

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < countLevel; i++) {
            listModel.addElement("Level " + Integer.toString(i + 1));
        }

        JList listLevels = new JList(listModel);
        listLevels.setBounds(701, 40, 170, 124);
        contentPane.add(listLevels);
        listLevels
                .setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listLevels.setSelectedIndex(0);

        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                panelParking.repaint();
            }
        };
        listLevels.addListSelectionListener(listSelectionListener);

        parking = new MultiLevelParking(countLevel, panelParking.getWidth(),
                panelParking.getHeight());
        panelParking.setParking(parking);
        panelParking.setList(listLevels);

        JButton buttonSetTruck = new JButton(
                "\u041F\u0440\u0438\u043F\u0430\u0440\u043A\u043E\u0432\u0430\u0442\u044C \u0433\u0440\u0443\u0437\u043E\u0432\u0438\u043A");
        buttonSetTruck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (listLevels.getSelectedIndex() > -1) {
                    Color firstColor = JColorChooser.showDialog(null,
                            "Choose a Color", Color.WHITE);
                    truck = new Truck(100, 1000, firstColor);
                    int place = parking.getParking(
                            listLevels.getSelectedIndex()).addTransport(
                            truck);
                    if (place != -1) {
                        panelParking.repaint();
                    }
                    panelParking.repaint();
                }
            }
        });
        buttonSetTruck.setBounds(665, 167, 245, 25);
        contentPane.add(buttonSetTruck);
        JButton buttonSetTruckTrailer = new JButton(
                "\u041F\u0440\u0438\u043F\u0430\u0440\u043A\u043E\u0432\u0430\u0442\u044C \u0433\u0440\u0443\u0437\u043E\u0432\u0438\u043A-\u043F\u043E\u043B\u0443\u043F\u0440\u0438\u0446\u0435\u043F");
        buttonSetTruckTrailer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (listLevels.getSelectedIndex() > -1) {
                    Color firstColor = JColorChooser.showDialog(null,
                            "Choose a Color", Color.WHITE);
                    Color secondColor = JColorChooser.showDialog(null,
                            "Choose a Color", Color.WHITE);
                    truck = new Benzovoz(100, 1000, firstColor,
                            secondColor);
                    int place = parking.getParking(
                            listLevels.getSelectedIndex()).addTransport(
                            truck);
                    if (place != -1) {
                        panelParking.repaint();
                    }
                    panelParking.repaint();
                }
            }
        });
        buttonSetTruckTrailer.setBounds(665, 205, 245, 25);
        contentPane.add(buttonSetTruckTrailer);
        JPanel panelGroupElements = new JPanel();
        panelGroupElements.setBounds(665, 244, 500, 260);
        contentPane.add(panelGroupElements);
        panelGroupElements.setLayout(null);
        JLabel lblNewLabel = new JLabel("\u041C\u0435\u0441\u0442\u043E");
        lblNewLabel.setBounds(26, 14, 40, 14);
        panelGroupElements.add(lblNewLabel);
        PanelForPaint panelTakeTrain = new PanelForPaint();
        panelTakeTrain.setBounds(10, 72, 400, 200);
        panelGroupElements.add(panelTakeTrain);
        JButton buttonTakeTruck = new JButton(
                "\u0417\u0430\u0431\u0440\u0430\u0442\u044C ");
        buttonTakeTruck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if (listLevels.getSelectedIndex() == -1) {
                    return;
                }
                int numberOfPlace = 0;
                try {
                    numberOfPlace = Integer.parseInt(textField.getText());
                } catch (Exception ex) {
                    textField.setText("Invalid input");
                    return;
                }
                truck = parking.getParking(listLevels.getSelectedIndex())
                        .removeTransport(numberOfPlace);
                if (truck != null) {
                    truck.SetPosition(5, 5, panelTakeTrain.getWidth(),
                            panelTakeTrain.getHeight());
                }
                panelTakeTrain.setTruck(truck);
                panelTakeTrain.repaint();
                panelParking.repaint();
            }
        });

        buttonTakeTruck.setBounds(10, 39, 223, 23);
        panelGroupElements.add(buttonTakeTruck);
        textField = new JTextField();
        textField.setBounds(78, 11, 79, 20);
        panelGroupElements.add(textField);
        textField.setColumns(10);

        JLabel levelsLabel = new JLabel("\u0423\u0440\u043E\u0432\u043D\u0438:");
        levelsLabel.setBounds(756, 11, 56, 16);
        contentPane.add(levelsLabel);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}