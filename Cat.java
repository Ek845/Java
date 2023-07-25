
public class Cat {
    static String family = "Felidae";
    String name;
    int age;
    Character sex;
    double weight;

    public Cat(String name, int age, Character sex, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    public void drink() {
        System.out.println("Кот пьет...");
    }

    public String speak() {
        return "Мяу-мяу...";
    }

    public void aboutCat() {
        if (sex == 'f') {
            System.out.printf("Эту кошку зовут %s, ей %d лет и весит она %.2f кг. \n", name, age, weight);
        } else {
            System.out.printf("Этого кота зовут %s, ему %d лет и весит он %.2f кг.\n", name, age, weight);
        }
    }

}
