package lesson7;

class ShopWorker implements Runnable {
    static Thread zhangSan, liSi, boss;

    ShopWorker() {
        zhangSan = new Thread(this, "张三");
        liSi = new Thread(this, "李四");
        boss = new Thread(this, "老板");
    }

    public void run() {
        int i = 0;
        if (Thread.currentThread() == zhangSan) {
            while (true) {
                try {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "已搬了" + i + "箱货物，休息一会儿");
                    if (i == 3) {
                        return;
                    }
                    zhangSan.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println(boss.getName()+"让"+Thread.currentThread().getName()+"继续工作");
                }
            }
        }else if(Thread.currentThread() == boss){
            while (true) {
                zhangSan.start();
                liSi.start();
                if(!(zhangSan.isAlive() || liSi.isAlive())){
                    System.out.println("下班了！");
                    return;
                }
            }
        }
    }
}

public class ShopWork {
    public static void main(String[] args){
        ShopWorker shop = new ShopWorker();
        shop.liSi.start();
        shop.boss.start();
    }
}
