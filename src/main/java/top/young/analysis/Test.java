package top.young.analysis;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Test {
    public static void main(String[] args) {

    }

    public static Comparator<Car> getComparator(){
        return comparing((Car car) -> car.getInfo());
    }

    class Car{
        String getInfo(){
            return null;
        }
    }
}
