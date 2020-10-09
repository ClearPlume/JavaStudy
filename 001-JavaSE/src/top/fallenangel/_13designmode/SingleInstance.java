package top.fallenangel._13designmode;

class SingleInstance {
    private static SingleInstance instance;

    private SingleInstance() {}

    public static synchronized SingleInstance getInstance() {
        if (null == instance) {
            //noinspection InstantiationOfUtilityClass
            instance = new SingleInstance();
        }
        return instance;
    }
}