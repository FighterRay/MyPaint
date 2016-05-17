package com.company;

/**
 * Created by zhangrunfeng on 16/5/17.
 */
public class Drawings {
    public int x, y;    //坐标
    public int R, G, B; //色彩
    public int width;   //线条粗细

    public Drawings() {

    }

    public void copyData(Drawings s) {
        x = s.x;
        y = s.y;
        R = s.R;
        G = s.G;
        B = s.B;
        width = s.width;
    }
}
