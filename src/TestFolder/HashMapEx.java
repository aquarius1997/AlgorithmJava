package TestFolder;

import java.util.HashMap;

public class HashMapEx {
    public static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        //이름과 나이가 같으면 true를 리턴하도록 재정의
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Person) {
                Person person = (Person) obj;
                return (this.age == person.age) && (this.name.equals(person.name));
            } else {
                return false;
            }
        }

        //이름과 나이가 같으면 동일한 값을 리턴하도록 재정의
        @Override
        public int hashCode() {
            return name.hashCode() + age;
        }
    }

    public static void main(String[] args) {
        HashMap<Person, Integer> hashMap = new HashMap<Person, Integer>();

        hashMap.put(new Person("김김김", 24), 1);
        hashMap.put(new Person("김김김", 24), 1);

        System.out.println("Entry 수 : " + hashMap.size());
    }
}
