package com.example.bagic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;

class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S> {

    public T info;
    public S id;

    Person(T info, S id) {
        this.info = info;
        this.id = id;
    }

    public <U> void printInfo(U info) {
        if (info instanceof EmployeeInfo) {
            System.out.println("EmployeeInfo : " + ((EmployeeInfo) info).rank); // EmployeeInfo : 1
        } else if (info instanceof StudentInfo) {
            System.out.println("StudentInfo : " + ((StudentInfo) info).grade); // StudentInfo : 99
        }
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);

        /* EmployeeInfo 의 id 값을 integer 로 변환하여, generics 형태인 Person 객체 생성 */
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        System.out.println("p1.info.rank : " + p1.info.rank); // rank : 1
        System.out.println("p1.id.intValue() : " + p1.id.intValue()); // id : 10

        /* EmployeeInfo 형태의 Person 생성하여, print */
        Person p2 = new Person(e, i);
        p2.<EmployeeInfo>printInfo(e);

        /* StudentInfo 형태의 Person 생성하여, print */
        Person p3 = new Person(new StudentInfo(99), new Integer(11));
        p3.printInfo(new StudentInfo(99));

        /* 와일드 카드를 사용 하여 sumOfList의 param 값을 Integer, Double 로 제한 할 수 있다. */
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Sum : " + sumOfList(lists)); // Sum : 55

        /* Generic를 사용한 copyOf 예제 */
        String[] movies = {"킹덤", "하우스오브카드","종이의집"};
        String[] copyList = Arrays.copyOf(movies, 2);

        for (String movie : copyList) {
            System.out.println("movie : " + movie);
        }
    }

    double sumOfList(List<? extends Number> lists) {
        double number = 0.0;
        for (Number n : lists) {
            number += n.doubleValue();
        }
        return number;
    }
}