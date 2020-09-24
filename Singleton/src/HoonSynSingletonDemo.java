import java.util.concurrent.TimeUnit;

public class HoonSynSingletonDemo {
    private static HoonSynSingletonDemo instance=null;
    private HoonSynSingletonDemo(){
    }

    public  static HoonSynSingletonDemo getInstance(){
        if(null==instance) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (HoonSynSingletonDemo.class){
                instance=new HoonSynSingletonDemo();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(HoonSynSingletonDemo.getInstance());
            }).start();
        }
    }
}
