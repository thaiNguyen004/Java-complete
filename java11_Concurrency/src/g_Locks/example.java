package g_Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Chương trình sau minh họa việc sử dụng một khóa. Nó tạo ra hai luồng truy cập vào một tài nguyên chung
 * được gọi là `Shared.count`. Trước khi một luồng có thể truy cập `Shared.count`, nó phải giành lấy một khóa.
 * Sau khi giành lấy khóa, `Shared.count` được tăng lên và sau đó, trước khi giải phóng khóa, luồng ngủ.
 * Điều này khiến cho luồng thứ hai cố gắng giành lấy khóa. Tuy nhiên, vì khóa vẫn được giữ bởi luồng thứ nhất,
 * luồng thứ hai phải chờ đến khi luồng thứ nhất ngừng ngủ và giải phóng khóa. Đầu ra cho thấy rằng việc truy cập
 * vào `Shared.count` được đồng bộ bằng khóa.
* */
public class example {
    public static void main(String[] args) {
        //Demo ReentranLock
//        ReentrantLock lock = new ReentrantLock();
//        new Thread(new LockThread(lock, "A")).start();
//        new Thread(new LockThread(lock, "B")).start();

        //Demo ReentranReadWriteLock
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Lock lk = new ReentrantLock();
        new Thread(new NguyenDemoReadWriteLock(lock, lk, "A")).start();
        new Thread(new NguyenDemoReadWriteLock(lock, lk,  "B")).start();
    }
}

class Shared {
    static int count = 0;
}

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread (ReentrantLock lk, String n) {
        lock = lk;
        name = n;
    }
    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            //First, lock count
            System.out.println(name + " is waiting to lock count");
            lock.lock();
            System.out.println(name + " is locking count");
            Shared.count ++;
            System.out.println(name + ": " + Shared.count);
            //Bây giờ hãy cho phép chuyển ngữ cảnh nếu có thể
            System.out.println(name + " is sleeping");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            System.out.println(name + " is unlocking count");
            lock.unlock();
        }
    }
}

class NguyenDemoReadWriteLock implements Runnable {
    ReadWriteLock readWriteLock;
    Lock lk;
    String name;
    NguyenDemoReadWriteLock (ReentrantReadWriteLock o, Lock o2, String n) {
        readWriteLock = o;
        name = n;
        lk = o2;
    }
    @Override
    public void run() {
        System.out.println(name + " is waiting for lock");
//        lk = readWriteLock.readLock();
        // Nếu gọi phương thức readLock sẽ trả về 1 đối tượng lock cho phép nhiều luồng cùng truy cập vào để đọc
//        lk = readWriteLock.writeLock();
        // Nếu gọi phương thức writeLock sẽ trả về 1 đối tượng lock chỉ cho phép 1 luồng được vào
        lk.lock();
        System.out.println(name +" is reading...");
        try {
            for (int i = 0 ; i < 10; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}