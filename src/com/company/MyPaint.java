package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by zhangrunfeng on 16/5/17.
 */
public class MyPaint {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    JFrame mainFrame;   //主框架
    JMenuBar menuBar;   //菜单栏
    JMenu fileMenu;     //文件菜单
    JMenu helpMenu;     //帮助菜单

    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JMenuItem aboutItem;

    JToolBar lineTool;      //设置线宽工具条
    JToolBar colorTool;     //设置颜色工具条

    JPanel setLinePanel;    //设置线条面板
    JLabel info;
    JButton blackButton;
    JButton whiteButton;
    JButton redButton;
    JButton greenButton;
    JButton blueButton;
    JButton otherButton;
    JColorChooser otherChooser;

    MyPanel drawPanel;      //绘图区面板

    //显示整个用户界面
    public void showPaint() {
        mainFrame = new JFrame();
        mainFrame.setTitle("MyPaint");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setResizable(true); //设置主框架不能改变大小
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showMenu();

        showTool();

        //显示主框架
        mainFrame.setVisible(true);
    }

    //显示菜单界面
    public void showMenu() {
        menuBar = new JMenuBar();

        //定义文件菜单

        fileMenu = new JMenu("文件");
        openItem = new JMenuItem("打开(O)", 'O');
        saveItem = new JMenuItem("保存(S)", 'S');
        exitItem = new JMenuItem("退出(X)", 'X');
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

        //打开菜单项事件监听器,用于打开文件
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //打开文件
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //保存文件
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //退出应用程序
                System.exit(0);
            }
        });

        //定义帮助菜单
        helpMenu = new JMenu("帮助", false);
        aboutItem = new JMenuItem("关于(A)", 'A');
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "这是一个简单的画图程序~", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //设置菜单栏
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);

        mainFrame.setJMenuBar(menuBar);
    }

    //显示工具条
    public void showTool() {
        //设置线宽的工具条的实现
        lineTool = new JToolBar();
        lineTool.setSize(WIDTH / 3, HEIGHT / 5 * 3);

        //使用边界布局的方式,将线宽工具条放在WEST部分
        Container contentPane = mainFrame.getContentPane();
        contentPane.add(lineTool, BorderLayout.WEST);

        //设置线宽的面板的实现
        setLinePanel = new JPanel();
        setLinePanel.setSize(WIDTH / 3, HEIGHT / 5 * 4);
        setLinePanel.setBorder(BorderFactory.createTitledBorder("设置线宽"));
        setLinePanel.setLayout(new GridLayout(6, 1));

        ButtonGroup bg = new ButtonGroup();
        JRadioButton b1 = new JRadioButton(" 1", true);
        JRadioButton b3 = new JRadioButton(" 3");
        JRadioButton b5 = new JRadioButton(" 5");
        JRadioButton b10 = new JRadioButton(" 10");

        b1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == e.SELECTED) {
                    //设置线宽为1
                    drawPanel.setLineWidth(1);
                }
            }
        });

        b3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == e.SELECTED) {
                    //设置线宽为3
                    drawPanel.setLineWidth(3);
                }
            }
        });

        b5.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == e.SELECTED) {
                    //设置线宽为5
                    drawPanel.setLineWidth(5);
                }
            }
        });

        b10.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == e.SELECTED) {
                    //设置线宽为10
                    drawPanel.setLineWidth(10);
                }
            }
        });

        bg.add(b1);
        bg.add(b3);
        bg.add(b5);
        bg.add(b10);
        setLinePanel.add(b1);
        setLinePanel.add(b3);
        setLinePanel.add(b5);
        setLinePanel.add(b10);
        //将设置线宽的面板 加到 设置线宽工具条上
        lineTool.add(setLinePanel);

        //设置颜色工具条的实现
        colorTool = new JToolBar();
        colorTool.setSize(WIDTH, HEIGHT / 3);
        contentPane.add(colorTool, BorderLayout.SOUTH);
        info = new JLabel("设置颜色:");
        blackButton = new JButton("黑");
        whiteButton = new JButton("白");
        redButton = new JButton("红");
        greenButton = new JButton("绿");
        blueButton = new JButton("蓝");
        otherButton = new JButton("自定义");


        //绘图面板的实现
        drawPanel = new MyPanel();
        drawPanel.setSize(WIDTH / 4 * 3, HEIGHT / 5 * 3);
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseMotionListener(drawPanel);
        contentPane.add(drawPanel, BorderLayout.CENTER);

        colorTool.add(info);
        colorTool.add(blackButton);
        colorTool.add(whiteButton);
        colorTool.add(redButton);
        colorTool.add(greenButton);
        colorTool.add(blueButton);
        colorTool.add(otherButton);

        //设置各颜色按钮监听事件
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setLineColor(Color.BLACK);
            }
        });

        whiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setLineColor(Color.WHITE);
            }
        });

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setLineColor(Color.RED);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setLineColor(Color.GREEN);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setLineColor(Color.BLUE);
            }
        });

        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color;
                otherChooser = new JColorChooser();
                color = otherChooser.showDialog(mainFrame, "自定义颜色", drawPanel.getLineColor());
                if (color != null) {
                    drawPanel.setLineColor(color);
                }
            }
        });
    }
}
