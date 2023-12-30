package lesson16.task1;

public class MainApp {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        // Додавання анонімного спостерігача
        subject.addObserver(new Observer() {
            @Override
            public void update(String message) {
                System.out.println("Анонімний спостерігач отримав повідомлення: " + message);
            }
        });

        // Додавання ще одного конкретного спостерігача
        ConcreteObserver concreteObserver = new ConcreteObserver("Об'єкт1");
        subject.addObserver(concreteObserver);

        // Повідомлення спостерігачів
        subject.notifyObservers("Нове повідомлення!");

        // Видалення спостерігача
        subject.removeObserver(concreteObserver);

        // Знову повідомлення спостерігачів
        subject.notifyObservers("Ще одне повідомлення!");
    }
}