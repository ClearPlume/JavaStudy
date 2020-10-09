package top.fallenangel._10Radix;

public enum RadixEnum {
    BIN(2, "二进制"), OCT(8, "八进制"), DEC(10, "十进制"), HEX(16, "十六进制");

    private final int base;
    private final String label;

    RadixEnum(int base, String label) {
        this.base = base;
        this.label = label;
    }

    public int getBase() {
        return base;
    }

    public String getLabel() {
        return label;
    }

    public static String[] labels() {
        String[] labels = new String[values().length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = values()[i].getLabel();
        }
        return labels;
    }
}