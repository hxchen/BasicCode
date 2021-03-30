package meituan;

/**
 * 单例模式
 * 双重检查+防止指令重排
 * @author haixiangchen
 */
public class Singleton {

    private static volatile Singleton singleton = null;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized(Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
