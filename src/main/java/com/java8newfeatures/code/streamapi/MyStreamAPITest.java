package com.java8newfeatures.code.streamapi;

import com.java8newfeatures.bean.Person;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8新特性-StreamAPI
 *
 */
public class MyStreamAPITest {

    /**
     * Stream 流的创建
     *      1、Collection接口的提供的方法创建：stream(),paralleStream()并行流
     *      2、数组形式创建Arrays.stream(T[] array)创建
     *      3、由值创建Stream.of(T...values)
     *      4、使用静态方法Stream.iterate()和Stream.generate()创建无限流
     */
    @Test
    public void createStream(){
        //Collectoin接口方法创建
        List<String> list=new ArrayList<>();
        Stream s1=list.stream();
        Stream ps1=list.parallelStream();

        //Arrays.stream()创建
        Stream arrStream= Arrays.stream(new String[]{});

        //Stream.of()
        Stream sof=Stream.of(new String[]{});
    }

    @Test
    public void createStream2(){
        //创建无限流
        //Stream.iterate(0,(x)->x+2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach((e)->{e=e*10;System.out.println(e);});
    }

    /**
     * Stream流的中间操作
     *
     */
    @Test
    public void streamMidOperation(){
        List<Person> persons=new ArrayList<>();
        persons.add(new Person("Lily",18,"北京"));
        persons.add(new Person("Licy",17,"上海"));
        persons.add(new Person("Rose",20,"广州"));
        persons.add(new Person("Jack",18,"深圳"));
        persons.add(new Person("Jack",18,"深圳"));

        //filter过滤
        System.out.println("=======filter=======");
        persons.stream().filter((p)->p.age>18).forEach(System.out::println);
        System.out.println();

        //distinct去重,需要重写hashCode和equals方法
        System.out.println("=======distinct=======");
        persons.stream().distinct().forEach(System.out::println);
        System.out.println();

        //limit截断
        System.out.println("=======limit=======");
        persons.stream().limit(2).forEach(System.out::println);
        System.out.println();

        //skip跳过
        System.out.println("=======skip=======");
        persons.stream().skip(2).forEach(System.out::println);
        System.out.println();

        //map映射对流中的数据进行操作，映射成新的流
        System.out.println("=======map=======");
        persons.stream()
                .map(e->{
                    e.name=e.name+"***";
                    return e;
                })
                .forEach(System.out::println);
        System.out.println();

        //flatMap将每个元素映射成一个新的流，并且将所有流合成一个新的流
        System.out.println("=======flatMap=======");
        List<String> list=Arrays.asList(new String[]{"Friday","Sunday","Monday"});
        Stream flatStream=list.stream().flatMap(e->{
            char[] carr=e.toCharArray();
            return Arrays.asList(carr).stream().map(ecar->{return e.toString();});
        });
        flatStream.forEach(System.out::println);
        System.out.println();

        //sorted排序
        System.out.println("=======sorted=======");
        //自然排序对应的对象需要实现Comparable接口
        persons.stream().sorted().forEach(System.out::println);
        //定制排序
        persons.stream().sorted((p1,p2)->{
            if(p1.age!=p2.age){
                return p1.age-p2.age;
            }else{
                return p1.name.compareTo(p2.name);
            }
        }).forEach(System.out::println);
        System.out.println();
    }

    /**
     * Stream流终止操作
     */
    @Test
    public void streamEndOperations(){
        List<Person> persons=new ArrayList<>();
        persons.add(new Person("Lily",18,"北京"));
        persons.add(new Person("Licy",17,"上海"));
        persons.add(new Person("Rose",20,"广州"));
        persons.add(new Person("Jack",18,"深圳"));
        persons.add(new Person("Jack",18,"深圳"));

        //查找与匹配
        Boolean result1=persons.stream()
                .distinct()
                .filter(e->e.age>18)
                .allMatch(e->e.address.equals("广州"));
        System.out.println("=======allMatch======"+result1);

        Boolean result2=persons.stream()
                .distinct()
                .filter(e->e.age>17)
                .anyMatch(e->e.address.equals("广州"));
        System.out.println("=======anyMatch======"+result2);

        Boolean result3=persons.stream()
                .distinct()
                .filter(e->e.age>17)
                .noneMatch(e->e.address.equals("南昌"));
        System.out.println("=======noneMatch======"+result3);

        Optional<Person> result4=persons.stream()
                .distinct()
                .filter(e->e.age>17).findFirst();
        System.out.println("=======findFirst======"+result4.get());

        Optional<Person> result5=persons.stream()
                .distinct()
                .filter(e->e.age>17).findAny();
        System.out.println("=======findAny======"+result5.get());

        //count(),min(),max(),forEach()
        long count=persons.stream().distinct().count();
        System.out.println("==========count========"+count);
        Optional<Person> pr=persons.stream().distinct().min((p1,p2)->{
            if(p1.age==p2.age){
                return p2.name.compareTo(p1.name);
            }else{
                return p1.age-p2.age;
            }
        });
        System.out.println("=======min======="+pr);
        Optional<Person> pmax=persons.stream().distinct().max((p1,p2)->{
            if(p1.age==p2.age){
                return p2.name.compareTo(p1.name);
            }else{
                return p1.age-p2.age;
            }
        });
        System.out.println("=======max======="+pmax);

        //reduce
        Optional<Integer> ageSum=persons.stream().map(e->e.age).reduce((t1,t2)->t1+t2);
        System.out.println("========reduce======="+ageSum.get());

        //collect收集
        List<String> names=persons.stream().map(e->e.name).collect(Collectors.toList());
        System.out.println("=====Collectors.toList()==="+names);

        Map<Integer,List<Person>> groups=persons.stream().distinct().collect(Collectors.groupingBy(e->e.age));
        System.out.println("======group===="+groups);

        Map<Boolean,List<Person>> g2=persons.stream().distinct()
                .collect(Collectors.groupingBy((e)->e.age>18));
        System.out.println("======partition===="+g2);
    }

}
