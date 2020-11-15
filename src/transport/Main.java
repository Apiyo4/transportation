package transport;
import java.util.*;
public class Main{
    private static List<AbstractVehicle> filterVehicle(List<AbstractVehicle> vehicles, CheckVehicle tester){
        List<AbstractVehicle> tempList =  new ArrayList<>();
        for(AbstractVehicle v : vehicles){
            if(tester.test(v)){
                tempList.add(v);
            }
        }
        return tempList;
    }
    public static void main(String[] args){
        System.out.println("Welcome to Java Day2!");
        System.out.println("\n\n ***Interface****");
        Horse joe = new Horse("Joe");
        joe.eat(25);
        for(int i = 0; i<3 ; i++){
            joe.move();
        }
        System.out.println("Joe " + joe.getFuelLevel());

        HorseFromVehicle secretariat =  new HorseFromVehicle("Secretariat", 10);
        secretariat.addFuel(10);
        System.out.println("Secretariat " + secretariat.getFuelLevel());
        HorseFromVehicle eclipse = new HorseFromVehicle("Eclipse");
        eclipse.move(10);
        HorseFromVehicle trigger = new HorseFromVehicle("Trigger", 10);
        HorseFromVehicle seattleSlew =  new HorseFromVehicle("Seattle Slew", 10);
        HorseFromVehicle americanPharoah = new HorseFromVehicle("American Pharaoh");

        Auto vw = new Auto(1, "Eurovan", 2000);
        Auto toyota =  new Auto(10, "Tundra", 1998);
        Auto honda = new Auto(5, "Accord", 2003);
        
        vw.move();
        vw.move(5);
        System.out.println(vw.getFuelLevel());

        List<AbstractVehicle> myList =  new ArrayList<>();
        myList.add(secretariat);
        myList.add(vw);
        myList.add(eclipse);
        myList.add(trigger);
        myList.add(seattleSlew);
        myList.add(americanPharoah);
        myList.add(vw);
        myList.add(toyota);
        myList.add(honda);
        System.out.println(myList);

        System.out.println();
        System.out.println("\n ***Sort List***");
        myList.sort((v1, v2)-> v1.getName().compareToIgnoreCase(v2.getName()));
        myList.forEach((v)-> System.out.println(v.getName()));
        System.out.println("\n\n ***List Negative Fuel Levels***");
        List<AbstractVehicle> filteredList =  filterVehicle(myList, v-> v.getFuelLevel() < 0);
        filteredList.sort((v1,v2)->v2.getFuelLevel() - v1.getFuelLevel() );
        filteredList.forEach((v)-> System.out.println(v));
        System.out.println("\nHorse with positive fuel level");
        filteredList = filterVehicle(myList, v-> (v.getFuelLevel() > 0) && (v instanceof HorseFromVehicle)) ;
        filteredList.forEach((v)-> System.out.println(v));
    }
    
}