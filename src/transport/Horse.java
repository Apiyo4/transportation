package transport;

public class Horse implements Animal, Vehicle {
    private int fuel = 0;
    private String name;
    public Horse(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public void move(){
        fuel =  fuel - 1;
    };
    @Override
    public void eat(int i){
        fuel = fuel + i ;
    };
    @Override
    public String speak(){
        return "Nay";
    };
    @Override
    public String getPath(){
        return "Grass";
    };
    @Override
    public int getFuelLevel(){
        return fuel;
    };
    @Override
    public void addFuel(int i){
        eat(i);
    };
}
