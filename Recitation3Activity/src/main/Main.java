package main;
class Main {
    public static void main(String[] args) {

        Element[] elements = {
                new Element("apple"),
                new Element("banana"),
                new Element("cherry"),
                new Element("date"),
                new Element("elderberry"),
                new Element("fig"),
                new Element("grape"),
                new Element("kiwi")
        };

        AlphabeticList list = new AlphabeticList();

        for (Element element : elements) {
            Node node = new Node(element);
        }

        Controller controller = new Controller(list);
        controller.runBinarySearch();
    }
}