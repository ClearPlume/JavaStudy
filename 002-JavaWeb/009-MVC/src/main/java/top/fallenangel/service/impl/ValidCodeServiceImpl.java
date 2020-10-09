package top.fallenangel.service.impl;

import top.fallenangel.service.IValidCodeService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;

public class ValidCodeServiceImpl implements IValidCodeService {
    private final StringBuilder validCode = new StringBuilder();
    private final Random random = new Random(new Date().getTime());

    @Override
    public BufferedImage getValidCodeImage(int width, int height, int type) {
        BufferedImage validImage = new BufferedImage(width, height, type);

        Graphics2D graphics = validImage.createGraphics();
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0, 0, width, height);

        for (int i = 0; i < 4; i++) {
            graphics.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            graphics.setColor(randomColor());
            String s = randomChar();
            validCode.append(s);
            graphics.drawString(s, 5 + i * 20, 22);
        }

        return validImage;
    }

    @Override
    public String getValidCode() {
        String s = validCode.toString();
        validCode.replace(0, validCode.length(), "");
        return s;
    }

    private Color randomColor() {
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }

    private String randomChar() {
        String cs = "abcdefghigkmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        int randomChar = random.nextInt(cs.length() - 1);
        return cs.substring(randomChar, randomChar + 1);
    }
}