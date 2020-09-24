import java.net.Socket;
import java.sql.Connection;

//Double-check-locking
public class DCL {
    Connection conn;
    Socket socket;
    private volatile static DCL instance=null;
    private DCL(){
    }

    public  static DCL getInstance(){
        if(null==instance) {
            synchronized (DCL.class){
                if(null==instance) {
                    if(null==instance) {
                        instance=new DCL();
                    }
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(DCL.getInstance());
            }).start();
        }
    }
}

