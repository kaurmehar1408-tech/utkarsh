import java.util.*;
interface Notification {
    void send(String message);
}
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("PUSH: " + message);
    }
}
class NotificationService {
    void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}
public class extensiblenotificationservice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        NotificationService service = new NotificationService();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String message = sc.nextLine().trim();
            Notification notification = null;
            if (type.equalsIgnoreCase("EMAIL")) {
                notification = new EmailNotification();
            } else if (type.equalsIgnoreCase("SMS")) {
                notification = new SMSNotification();
            } else if (type.equalsIgnoreCase("PUSH")) {
                notification = new PushNotification();
            }
            if (notification != null) {
                service.sendNotification(notification, message);
            }
        }
    }
}