package top.fallenangel.service.impl;

import top.fallenangel.service.IRandomColorService;

import java.util.Random;

public class RandomColorServiceImpl implements IRandomColorService {
    private final Random random = new Random();

    @Override
    public String getRandomColor() {
        return '#' + Integer.toHexString(random.nextInt(255) + 1) + Integer.toHexString(random.nextInt(255) + 1) + Integer.toHexString(random.nextInt(255) + 1);
    }
}