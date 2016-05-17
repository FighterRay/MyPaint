package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhangrunfeng on 16/5/17.
 */
public class MyPanel extends JPanel implements MouseMotionListener {
    //定义输入输出流,用来调用和保存图像文件
    private ObjectInputStream input;
    private ObjectOutputStream output;

    private int lineWidth = 1;
    private Color lineColor = Color.BLACK;
    private Drawings[] itemList;    //用来存放绘制过的点的数组
    private int index = -1;         //已绘制基本点的下标,初值为-1表示没有绘图

    public MyPanel() {
        itemList = new Drawings[20000];
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    //保存一个图形的文件
    public void saveFile() {

    }

    //打开一个图形的文件()
    public void openFile() {

    }

    //自动重画方法,当绘图区被激活的时候会自动调用
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int j = 0;
        while (j <= index) {
            draw(g, itemList[j]);
            j ++;
        }
    }

    //画点
    void draw(Graphics g, Drawings i) {
        Color color = new Color(i.R, i.G, i.B);
        g.setColor(color);
        g.fillRect(i.x, i.y, i.width, i.width);
    }

    //实现 MouseMotionListener 接口的方法
    public void mouseDragged(MouseEvent e) {
        //获取画笔
        Graphics myCanvas = getGraphics();
        index ++;
        itemList[index] = new Drawings();
        itemList[index].x = e.getX();
        itemList[index].y = e.getY();
        itemList[index].R = lineColor.getRed();
        itemList[index].G = lineColor.getGreen();
        itemList[index].B = lineColor.getBlue();
        itemList[index].width = lineWidth;

        myCanvas.setColor(lineColor);
        myCanvas.fillRect(e.getX(), e.getY(), lineWidth, lineWidth);
    }


    public void mouseMoved(MouseEvent e) {}

}
