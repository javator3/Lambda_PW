package pl.sda.lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        AddInterface add = (a, b) -> a + b;
        add.calc(4, 2);
        System.out.println(add.calc(4, 2));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer integer : numbers) {
            System.out.println(integer);
        }
        System.out.println();


        System.out.println("Iteracja funkcyjna");
        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);
        System.out.println();

        numbers.forEach(System.out::println);

        //z wykorzystaniem klasy anonimowej:
//        AddInterface add2 = new AddInterface() {
//            @Override
//            public int calc(int a, int b) {
//                return a + b;
//            }
//        };


        List<Movie> movies = Arrays.asList(
                new Movie("Tytuł", "Jan", LocalDate.of(2012, 02, 12), 60.00, Arrays.asList("Michał", "Maciek")),
                new Movie("Tytuł2", "Janek", LocalDate.of(2012, 02, 12), 20.00, Arrays.asList("Michał", "Maciek"))
        );

        //pokazuje tytuły za pomocą tradycyjnej pętli:
        System.out.println("iteracja wg pętli for (kolekcja)");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
            System.out.println(movie.getDirector());
        }
        System.out.println();


        List<String> titles = movies
                .stream()
                .map(f -> f.getTitle())
                .collect(Collectors.toList());
        List<String> directors = movies
                .stream()
                .map(f -> f.getDirector())
                .collect(Collectors.toList());


        titles.forEach(System.out::println);
        directors.forEach(System.out::println);

        System.out.println(directors);
        System.out.println(titles);


        //zmieniono ceny filmów (info dla Marcina :)
        //robimy listę obiektów z filmami o cenie >50zł
        List<Movie> movieList = movies.stream()
                .filter(f -> f.getPrice() > 50)
//                .filter(f->f.getTitle().length()>5)   //dodatkowo filtr dla tytułów o dł.większej niż 5 znaków
                .collect(Collectors.toList());


    }
}
