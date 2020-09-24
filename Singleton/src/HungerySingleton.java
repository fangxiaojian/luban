public class HungerySingleton {
    //加载的时候就产生的实例对象,ClassLoader
    private byte[] data=new byte[1024];
    private static HungerySingleton instance=new HungerySingleton();
    private HungerySingleton(){
    }

    //返回实例对象
   public static HungerySingleton getInstance(){
        return instance;
   }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(HungerySingleton.getInstance());
            }).start();
        }
    }
}
