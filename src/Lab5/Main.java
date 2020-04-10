package Lab5;




public class Main {

    public static void main(String[] args) {

        App app;
        try {
            app = new App(args[0]);
        } catch (IndexOutOfBoundsException e) {
            app = new App("");
        }
        app.start();
    }

}






