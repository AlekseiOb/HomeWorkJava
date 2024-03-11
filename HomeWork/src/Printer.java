import java.util.*;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> phoneNums = new ArrayList<>();
            phoneNums.add(phoneNum);
            phoneBook.put(name, phoneNums);
        }
    }

    public List<Map.Entry<String, ArrayList<Integer>>> sortByPhoneCount() {
        Set<Map.Entry<String, ArrayList<Integer>>> entries = phoneBook.entrySet();
        List<Map.Entry<String, ArrayList<Integer>>> entryList = new ArrayList<>(entries);
        Collections.sort(entryList, (entry1, entry2) -> {
            int size1 = entry1.getValue().size();
            int size2 = entry2.getValue().size();
            return Integer.compare(size2, size1);
        });
        return entryList;
    }
}

public class Printer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook myPhoneBook = new PhoneBook();

        System.out.println("Введите имена и номера телефонов (для завершения введите 'exit'):");

        while (true) {
            System.out.print("Имя: ");
            String name = scanner.nextLine();
            if (name.equals("exit")) {
                break;
            }
            System.out.print("Номер телефона: ");
            int phoneNum = Integer.parseInt(scanner.nextLine());
            myPhoneBook.add(name, phoneNum);
        }

        System.out.println("Телефонная книга:");
        for (Map.Entry<String, ArrayList<Integer>> entry : myPhoneBook.sortByPhoneCount()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}

