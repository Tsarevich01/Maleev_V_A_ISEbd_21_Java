package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FormTruckGUI {
    private Itruck truck;

    public JFrame frame;
    private PanelForPaint panel;

    public FormTruckGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel first_panel = new JPanel();
        frame.getContentPane().add(first_panel, BorderLayout.CENTER);
        first_panel.setLayout(new BorderLayout(0, 0));

        JPanel create_panel = new JPanel();
        create_panel.setLayout(new BorderLayout(0,0));
        first_panel.add(create_panel, BorderLayout.NORTH);

        panel = new PanelForPaint(null);
        first_panel.add(panel, BorderLayout.CENTER);

        JPanel for_control_panel = new JPanel();
        for_control_panel.setLayout(new BorderLayout(0,0));
        first_panel.add(for_control_panel, BorderLayout.SOUTH);

        JButton upgrade_button = new JButton();
        upgrade_button.setText("Upgrade");
        upgrade_button.addActionListener(e -> {
            Random rnd = new Random();

            truck = new Benzovoz(
                    rnd.nextInt(200) + 100,
                    rnd.nextInt(1000) + 1000,
                    Color.RED,
                    Color.BLACK);

            truck.SetPosition(
                    rnd.nextInt(90) + 10,
                    rnd.nextInt(90) + 10,
                    panel.getWidth(),
                    panel.getHeight());

            panel.setTruck(truck);
            panel.repaint();
        });
        create_panel.add(upgrade_button, BorderLayout.EAST);

        JButton create_button = new JButton();
        String create_string = "Create";
        create_button.setText(create_string);
        create_button.addActionListener(e -> {
            Random rnd = new Random();

            truck = new Truck(
                    rnd.nextInt(200) + 100,
                    rnd.nextInt(1000) + 1000,
                    Color.RED, Color.BLACK);

            truck.SetPosition(
                    rnd.nextInt(90) + 10,
                    rnd.nextInt(90) + 10,
                    panel.getWidth(),
                    panel.getHeight());

            panel.setTruck(truck);
            panel.repaint();
        });
        create_panel.add(create_button, BorderLayout.WEST);

        JPanel control_panel = new JPanel();
        control_panel.setLayout(new GridLayout(2, 1));
        for_control_panel.add(control_panel, BorderLayout.EAST);

        JPanel up_control_panel = new JPanel();
        up_control_panel.setLayout(new FlowLayout());
        control_panel.add(up_control_panel);

        JPanel down_control_panel = new JPanel();
        down_control_panel.setLayout(new FlowLayout());
        control_panel.add(down_control_panel);

        JButton up_button = new JButton();
        up_button.setText("\uD83E\uDC45");
        up_button.addActionListener(e -> {
            truck.MoveTransport(Direction.Up);
            panel.repaint();
        });
        up_control_panel.add(up_button);

        JButton left_button = new JButton();
        left_button.setText("\uD83E\uDC44");
        left_button.addActionListener(e -> {
            truck.MoveTransport(Direction.Left);
            panel.repaint();
        });
        down_control_panel.add(left_button);

        JButton down_button = new JButton();
        down_button.setText("\uD83E\uDC47");
        down_button.addActionListener(e -> {
            truck.MoveTransport(Direction.Down);
            panel.repaint();
        });
        down_control_panel.add(down_button);

        JButton right_button = new JButton();
        right_button.setText("\uD83E\uDC46");
        right_button.addActionListener(e -> {
            truck.MoveTransport(Direction.Right);
            panel.repaint();
        });
        down_control_panel.add(right_button);
    }
}