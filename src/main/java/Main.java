public class Main {

    public static void main(String[] args) throws InterruptedException {
        Center center = new Center();
        new Thread(null, center::inputCall, "звонок №").start();

        for (int i = 1; i <= Constant.SPEC; i++) {
            Thread.sleep(Constant.SPEC_PAUSE);
            new Thread(null, center::getCall, "Спец <" + i + "> ").start();
        }
    }
}