import java.util.*;
import java.util.stream.Collectors;

public class Customer {
    private Integer id;
    private String name;
    private Gender gender;

    public Customer(Integer id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && gender == customer.gender;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void getNumberOfCustomersByGender(List<Customer> cList){
        Map<Gender,Long> map= cList.stream().collect(Collectors.groupingBy(Customer::getGender, Collectors.counting()));

        map.forEach((key, value) -> System.out.println(key.getGenderName() + ": " + value));

//        Map<Gender,Integer> map = new HashMap<>();
//        for(Customer customer :cList){
//            Gender gender = customer.gender;
//            map.put(gender,map.getOrDefault(gender,0)+1);
//        }
//        for (Map.Entry<Gender, Long> entry : map.entrySet()) {
//            System.out.println(entry.getKey().getGenderName() + ": " + entry.getValue());
//        }

    }
    public static List<String> getAllGenderNames() {
        List<String> genderNames = new ArrayList<>();
        for (Gender gender : Gender.values()) {
            genderNames.add(gender.getGenderName());
        }
        return genderNames;
    }

}
