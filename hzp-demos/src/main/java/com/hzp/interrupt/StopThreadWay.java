package com.hzp.interrupt;

//实际开发中的两种最佳实践：优先选择：传递中断
public class StopThreadWay implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new StopThreadWay());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {

        while(true && !Thread.currentThread().isInterrupted()){
            System.out.println("hello");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //todo 保存日志，停止服务等操作
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
}

//二：不想或无法传递：恢复中断
//public class StopThreadWay implements Runnable {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        Thread thread = new Thread(new StopThreadWay());
//        thread.start();
//        Thread.sleep(1000);
//        thread.interrupt();
//    }
//
//    @Override
//    public void run() {
//
//        while(true){
//            if(Thread.currentThread().isInterrupted()){
//                System.out.println("程序运行结束");
//                break;
//            }
//            throwInMethod();
//
//        }
//    }
//
//    private void throwInMethod() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            e.printStackTrace();
//        }
//    }
//}





