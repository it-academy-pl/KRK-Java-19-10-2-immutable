package pl.itacademy.immutability;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ImmutableTester {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //System.setSecurityManager(new SecurityManager());
        Address krakow = new Address("Krakow", "Szpitalna");
        System.out.printf("Krakow hashCode: %d%n", krakow.hashCode());
        Address wroclaw = new Address("Wrocław", "Jana Pawła II");

        String kowalskiLastName = "Kowalski";
        Person kowalski = new Person("Jan", kowalskiLastName, krakow);
        System.out.printf("Kowalski hashCode: %d%n", kowalski.hashCode());
        Person nowak = new Person("Kinga", "Nowak", wroclaw);

        Map<Person, String> beerLowers = new HashMap<>();
        beerLowers.put(kowalski, "Jasne");
        beerLowers.put(nowak, "Ciemne");

        System.out.println(beerLowers);

        String kowalskisFavoriteBeer = beerLowers.get(kowalski);
        System.out.println("Kowalski's favorite beer is - " + kowalskisFavoriteBeer);

        String nowaksFavoriteBeer = beerLowers.get(nowak);
        System.out.printf("Nowak's favorite beer is - %s%n", nowaksFavoriteBeer);

//        nowak.setLastName("Nowak-Kowalski");
//        System.out.println(beerLowers);
//
//        nowaksFavoriteBeer = beerLowers.get(nowak);
//        System.out.printf("Nowak's favorite beer is - %s%n", nowaksFavoriteBeer);

        krakow.setCity("Kraków miastem królów polskich");
        System.out.println(beerLowers);
        System.out.printf("Krakow hashCode: %d%n", krakow.hashCode());
        System.out.printf("Kowalski hashCode: %d%n", kowalski.hashCode());

        kowalskisFavoriteBeer = beerLowers.get(kowalski);
        System.out.println("Kowalski's favorite beer is - " + kowalskisFavoriteBeer);

        Address kowalskiAddress = kowalski.getAddress();
        kowalskiAddress.setStreet("Floriańska");
        System.out.printf("Kowalski hashCode: %d%n", kowalski.hashCode());

//        Student duda = new Student("Andrzej", "Duda", krakow, "Java");
//        beerLowers.put(duda, "kraftowe");
//
//        System.out.println(beerLowers);
//
//        duda.setGroupName("Java-advanced");
//        System.out.println(beerLowers.get(duda));

        Field lastNameFromReflection = kowalski.getClass().getDeclaredField("lastName");
        lastNameFromReflection.setAccessible(true);
        lastNameFromReflection.set(kowalski, "Kowalski-Nowak");
        System.out.printf("Kowalski hashCode: %d%n", kowalski.hashCode());
        System.out.println(kowalski);
    }
}
