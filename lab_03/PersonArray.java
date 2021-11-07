import java.util.Arrays;

public class PersonArray {
    private Person[] people = new Person[0];

    public void addPerson(Person per) {
        if(per == null) return;
        if (Arrays.asList(this.people).contains(per)){
            System.out.println("person is in the array");
            return;
        }


        Person[] tmp = new Person[people.length + 1];
        System.arraycopy(this.people, 0, tmp, 0, people.length);
        tmp[tmp.length - 1] = per;
        this.people = tmp; 
    }

    @Override
    public String toString() {
        return Arrays.toString(this.people);
    }

    public void removePerson(Person per) {
        if(per == null) return;
        if (!Arrays.asList(this.people).contains(per)){
            System.out.println("person is not in the array");
            return;
        }
        Person[] tmp = new Person[people.length -1];
        int ind = Arrays.asList(this.people).indexOf(per);
        System.arraycopy(this.people, 0, tmp, 0, ind);
        System.arraycopy(this.people, ind + 1, tmp, ind, people.length - 1 - ind);
        this.people = tmp; 
    }

    public PersonArray(PersonArray perArr) {
        this.people = perArr.people.clone();
    }

    public PersonArray(){}

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        PersonArray tmp = (PersonArray) o;
        return Arrays.equals(tmp.people, this.people);
    }

     public void sortByAge() {
         Arrays.sort(this.people, (Person x, Person y) -> x.getAge() - y.getAge());
     }
}