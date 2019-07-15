package lesson_1;

import java.util.Arrays;

public class MainTestArrayStorage {
    public static void main(String[] args) {
        ArrayStorage storage = new ArrayStorage();
        storage.save("r1");
        storage.save("r2");
        storage.save("r3");
        storage.save("r4");
        System.out.println(storage.get(3));
        System.out.println(storage.size());
        storage.delete(1);
        System.out.println(Arrays.toString(storage.getAll()));
        storage.clear();
        System.out.println(Arrays.toString(storage.getAll()));
    }
}