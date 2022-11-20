import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Center {
    static final Queue<String> phoneCalls = new ArrayBlockingQueue<>(Constant.CALL_LIMIT);

    public void inputCall() {
        for (int i = 1; i <= Constant.CALL_LIMIT; i++) {
            try {
                phoneCalls.offer(Thread.currentThread().getName() + i);
                System.out.println("Поступил " + Thread.currentThread().getName() + i);
                Thread.sleep(Constant.CALL_PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getCall() {
        while (!phoneCalls.isEmpty()) {
            try {
                Thread.sleep(Constant.SPEC_PAUSE);
                if (!phoneCalls.isEmpty())
                    System.out.println(Thread.currentThread().getName() + "ответил на " + phoneCalls.poll());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
