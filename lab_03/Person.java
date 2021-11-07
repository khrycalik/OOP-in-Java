public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;

    private Person() {

    }

    public static final class Builder{
        private String firstName;
        private String lastName;
        private int age;
        private int height;
        private int weight;

        public Builder firstName(String name){
            this.firstName = name;
            return this;
        }

        public Builder lastName (String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder height(int height) {
            this.height = height ;
            return this;
        }
        public Person build() {
            if(firstName == null || lastName == null || age == 0 || height == 0 || weight == 0){
               System.out.println("Can not create");
               return null;
            }

            Person per = new Person();
            per.firstName = this.firstName;
            per.lastName = this.lastName;
            per.age = this.age;
            per.weight = this.weight;
            per.height = this.height;
            return per;
        }
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person{firstName= " + this.firstName + ", lastName= " + this.lastName + ", age= " + this.age + ",weight= " + this.weight + ", height= " + this.height + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        Person tmp = (Person) o;
        if (this.firstName == tmp.firstName || this.lastName == tmp.lastName || this.age == tmp.age || this.weight == tmp.weight || this.height == tmp.height) {
            return true;
        }
        return false;
    }


}
