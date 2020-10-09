package top.fallenangel._10Radix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadixPractice {
    private final JFrame mainFrame;
    private final Label initialRadixTipLabel;
    private final Choice initialRadixChoice;
    private final TextField initialRadixTextField;
    private final Label targetRadixTipLabel;
    private final Choice targetRadixChoice;
    private final TextField targetRadixTextField;
    private final Button convertBtn;

    private RadixEnum curRadix;
    private RadixEnum tarRadix;

    public static void main(String[] args) {
        new RadixPractice();
    }

    public RadixPractice() {
        mainFrame = new JFrame("整数进制转换");
        initialRadixTipLabel = new Label("初始进制：");
        initialRadixChoice = new Choice();
        initialRadixTextField = new TextField();
        targetRadixTipLabel = new Label("目标进制：");
        targetRadixChoice = new Choice();
        targetRadixTextField = new TextField();
        convertBtn = new Button("转换");

        bindEvents();

        setupComponents();

        mainFrame.setVisible(true);
    }

    public void bindEvents() {
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                convertBtn.requestFocus();
                checkInputValid();
            }
        });

        initialRadixTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (initialRadixTextField.getText().equals("输入要转换的数字")) {
                    initialRadixTextField.setText("");
                    initialRadixTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (initialRadixTextField.getText().length() == 0) {
                    initialRadixTextField.setText("输入要转换的数字");
                    initialRadixTextField.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        initialRadixChoice.addItemListener(event -> {
            curRadix = RadixEnum.values()[initialRadixChoice.getSelectedIndex()];
            checkInputValid();
        });

        initialRadixTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (initialRadixTextField.getText().equals("输入要转换的数字")) {
                    initialRadixTextField.setText("");
                    initialRadixTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                checkInputValid();
                if (initialRadixTextField.getText().length() == 0) {
                    initialRadixTextField.setText("输入要转换的数字");
                    initialRadixTextField.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        targetRadixChoice.addItemListener(event -> tarRadix = RadixEnum.values()[targetRadixChoice.getSelectedIndex()]);

        convertBtn.addActionListener(event -> targetRadixTextField.setText(convert(initialRadixTextField.getText())));
    }

    public void setupComponents() {
        mainFrame.setSize(300, 150);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        curRadix = RadixEnum.BIN;
        tarRadix = RadixEnum.BIN;

        for (String radix : RadixEnum.labels()) {
            initialRadixChoice.add(radix);
            targetRadixChoice.add(radix);
        }

        initialRadixTextField.setText("输入要转换的数字");
        initialRadixTextField.setForeground(Color.LIGHT_GRAY);

        targetRadixTextField.setEditable(false);
        targetRadixTextField.setFocusable(false);

        initialRadixTipLabel.setBounds(10, 5, 60, 25);
        initialRadixChoice.setBounds(75, 5, 80, 20);
        initialRadixTextField.setBounds(165, 8, 110, 20);
        targetRadixTipLabel.setBounds(10, 30, 60, 25);
        targetRadixChoice.setBounds(75, 30, 80, 20);
        targetRadixTextField.setBounds(165, 33, 110, 20);
        convertBtn.setBounds(90, 70, 100, 25);

        mainFrame.add(initialRadixTipLabel);
        mainFrame.add(initialRadixChoice);
        mainFrame.add(initialRadixTextField);
        mainFrame.add(targetRadixTipLabel);
        mainFrame.add(targetRadixChoice);
        mainFrame.add(targetRadixTextField);
        mainFrame.add(convertBtn);
    }

    public String convert(String num) {
        if (curRadix.equals(tarRadix)) {
            return num;
        }
        return ten2n(n2ten(num));
    }

    private int n2ten(String num) {
        int base = curRadix.getBase();
        int result = 0;
        int curIndex = num.length() - 1;
        for (int i = 0; i < num.length(); i++) {
            int parseInt = Integer.parseInt(num.substring(curIndex, curIndex + 1), base);
            curIndex = curIndex - 1;
            result = (int) (result + parseInt * Math.pow(base, i));
        }
        return result;
    }

    private String ten2n(int num) {
        if (tarRadix.equals(RadixEnum.DEC)) {
            return Integer.toString(num);
        }
        int base = tarRadix.getBase();
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, Integer.toString(num % base, base).toUpperCase());
            num = num / base;
        }
        return result.toString();
    }

    private void checkInputValid() {
        String inNumber = initialRadixTextField.getText();
        boolean valid;
        String regex;
        switch (curRadix) {
            case BIN:
                regex = "^1[01]*$";
                break;
            case OCT:
                regex = "^[1-7][0-7]*$";
                break;
            case DEC:
                regex = "^[1-9]\\d*$";
                break;
            default:
                regex = "^[1-9a-fA-F][\\da-fA-F]*$";
                break;
        }
        if (inNumber.matches(regex)) {
            valid = true;
        } else {
            valid = inNumber.length() == 1 && "0".equals(inNumber);
        }
        convertBtn.setEnabled(valid);
    }
}