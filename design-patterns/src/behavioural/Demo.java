package behavioural;

public class Demo {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();
        Subscriber subscriber1 = new Subscriber(" chinmay");
        Subscriber subscriber2 = new Subscriber(" anvi");
        Subscriber subscriber3 = new Subscriber(" raj");

        youtubeChannel.subscribe(subscriber1);
        youtubeChannel.subscribe(subscriber2);
        youtubeChannel.subscribe(subscriber3);

        youtubeChannel.notifyObservers();
    }
}
