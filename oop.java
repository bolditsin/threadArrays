package oop;

public class oop {
    public static void main(String[] args){
        Cat cat1 = new Cat();
            int age = 2019;

        Cat cat2 = new Cat("Tochka","White",age);

        System.out.println(cat1.name+" "+cat1.getAge()+" "+cat1.color);
        System.out.println(cat2.name+" "+cat2.getAge()+" "+cat2.color);
    }

}
