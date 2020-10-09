package top.fallenangel.springtransaction.controller;

import top.fallenangel.service.IRandomColorService;
import top.fallenangel.service.impl.RandomColorServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@WebServlet("/randomColor")
public class RandomColorServlet extends HttpServlet {
    private final Random random = new Random(new Date().getTime());
    private final IRandomColorService randomColorService = new RandomColorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(randomColorService.getRandomColor());
    }
}