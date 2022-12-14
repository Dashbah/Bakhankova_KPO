public class Main {
    public static void main(String[] args) {
        var list = new IntegerList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        list.add(4);
        var index = list.indexOf(5);
        list.add(0, 3);
        list.contains(1);
        var empt = list.isEmpty();
        for (var i = 0; i < 20; ++i) {
            list.add(i);
        }
    }
}
