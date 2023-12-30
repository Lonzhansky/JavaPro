package lesson16.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @Test
    public void testSingleObserverReceivingUpdate() {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver("Observer1");

        subject.addObserver(observer);
        subject.notifyObservers("Test Message");

        assertTrue(observer.receivedUpdate);
    }

    @Test
    public void testMultipleObserversReceivingUpdate() {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver("Observer1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers("Test Message");

        assertTrue(observer1.receivedUpdate);
        assertTrue(observer2.receivedUpdate);
    }

    @Test
    public void testObserverNotReceivingUpdateAfterRemoval() {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver("Observer1");

        subject.addObserver(observer);
        subject.removeObserver(observer);
        subject.notifyObservers("Test Message");

        assertFalse(observer.receivedUpdate);
    }

    @Test
    public void testNoObserversReceiveUpdate() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.notifyObservers("Test Message"); // No observers to receive the update
    }

    @Test
    public void testAnonymousObserverReceivingUpdate() {
        ConcreteSubject subject = new ConcreteSubject();

        // Adding an anonymous observer
        subject.addObserver(new Observer() {
            @Override
            public void update(String message) {
                // Anonymous observer logic
                System.out.println("Anonymous Observer received message: " + message);
            }
        });

        subject.notifyObservers("Anonymous Observer Test Message");
        // Ensure no exceptions occur during notification
    }
}