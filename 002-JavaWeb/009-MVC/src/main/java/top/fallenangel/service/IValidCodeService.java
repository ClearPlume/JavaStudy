package top.fallenangel.service;

import java.awt.image.BufferedImage;

public interface IValidCodeService {
    int TYPE_INT_RGB = BufferedImage.TYPE_INT_RGB;

    BufferedImage getValidCodeImage(int width, int height, int type);
    String getValidCode();
}