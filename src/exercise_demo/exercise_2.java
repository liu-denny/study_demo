package exercise_demo;

/**
 * @author yudong
 * @create 2019-07-25 15:39
 */

/**
 * 题目
 * 子线程运行10次，主线程运行5次。这样交替运行3次
 */
public class exercise_2 {
    public static void main(String[] args) {
        final Bussiness bussiness = new Bussiness();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    bussiness.subMethod();
                }
            }
        }).start();

        for(int i = 0;i<3;i++){
            bussiness.mainMethod();
        }
    }

    static class Bussiness{
        private boolean subFlag = true;

        public synchronized void mainMethod(){
            while (subFlag){
                try {
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            for(int i =0; i<5;i++){
                System.out.println(Thread.currentThread().getName()
                +": main thread running loop count --" + i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            subFlag = true;
            notify();
        }

        public synchronized void subMethod(){
            while (!subFlag){
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            for(int i=0; i<10;i++){
                System.out.println(Thread.currentThread().getName()
                        +": sub thread running loop count --" + i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            subFlag = false;
            notify();
        }
    }
}




