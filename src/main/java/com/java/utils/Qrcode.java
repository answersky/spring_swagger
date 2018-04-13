package com.java.utils;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * @author answer
 *         2018/2/11
 */
public class Qrcode {
    public static void main(String[] args) {
        String outPutPath = "C:\\Users\\zoe\\Desktop\\";
        String img="D:\\myworkspace\\spring-mvc\\src\\main\\resources\\xmyrz.jpg";
        String url = "http://www.baidu.com";
        try {
            VisualQRCode.createQRCode(url,
                    img,
                    outPutPath+"LARGEIMG.png",
                    'H',
                    new Color(170, 24, 67),
                    800,
                    420,
                    200,
                    false,
                    VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE,
                    VisualQRCode.FILL_SHAPE_MODEL_RECTANGLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
