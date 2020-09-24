public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(EnumSingleton.INSTANCE);
            }).start();
        }
    }
}

//holder
//枚举
//DCL
