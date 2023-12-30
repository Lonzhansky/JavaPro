package lesson16.task1;

public class ConcreteObserver implements Observer {
    private String name;
    public boolean receivedUpdate;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        receivedUpdate = true;
        System.out.println(name + " отримав повідомлення: " + message);
    }
}