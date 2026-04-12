import java.util.*;
class Pokemon{
    private String name;
    private String element;
    private int health;
    public Pokemon(String name, String element, int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }
    public String toString(){
        return this.name + " - " + this.element + " - " + this.health;
    }
    public String getElement(){
        return this.element;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }
}
class Trainer{
    private String name;
    private int numberOfBudget;
    private List<Pokemon> pokemons;
    public Trainer(String name, List<Pokemon> pokemons){
        this.name = name; 
        //this.numberOfBudget = numberOfBudget;
        this.pokemons = pokemons;
    }
    public void addPokemon(Pokemon p){
        pokemons.add(p);
    }
    public List<Pokemon> getPokemon(){
        return this.pokemons;
    }
    public int getNumberOfBudget(){
        return this.numberOfBudget;
    }
    public void setNumberOfBudget(int numberOfBudget){
        this.numberOfBudget = numberOfBudget;
    }
    public static Comparator<Trainer> getTrainer(){
        return new Comparator<Trainer>(){
            @Override
            public int compare(Trainer o1, Trainer o2){
                return o2.getNumberOfBudget() - o1.getNumberOfBudget();
            }
        };
    }
    public String toString(){
        return this.name + " " + this.numberOfBudget + " " + pokemons.size();
    }
}
public class COLLECTION007 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>(); // phai su dung LinkedHashMap vi de bao toan thu tu vao trainers
        while(true){
            String line = sc.nextLine();
            if(line.equals("Tournament")) break;
            String [] parts = line.split("\\s+");
            String TrainerName = parts[0], PokemonName = parts[1], PokemonElement = parts[2];
            int PokemonHealth = Integer.parseInt(parts[3]);
            Pokemon p = new Pokemon(PokemonName, PokemonElement, PokemonHealth);
            if(!trainers.containsKey(TrainerName)){// lay String cua Map trainers
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(p);
                Trainer t = new Trainer(TrainerName, pokemons);
                trainers.put(TrainerName, t); // tao 1 cap moi
            }
            else{// neu trainer da ton tai
                trainers.get(TrainerName).addPokemon(p);
            }
        }
        while(true){
            String line = sc.nextLine();
            if(line.equals("End")) break;
            int numberOfBudget = 0;
            for(Trainer t : trainers.values()){
                boolean hasElement = false;
                for(Pokemon p : t.getPokemon()){
                    if(p.getElement().equals(line)){
                        hasElement = true;
                        break;
                    }
                }
                if(hasElement){
                    t.setNumberOfBudget(t.getNumberOfBudget() + 1);
                }
                else{
                    for(Pokemon p : t.getPokemon()){
                        p.setHealth(p.getHealth() - 10);
                    }
                }
                // pokemon chet
                t.getPokemon().removeIf(p -> p.getHealth() <= 0);
            }
        }
        List<Trainer> list = new ArrayList<>();
        for(Trainer t : trainers.values()){
            list.add(t);
        }
        list.sort(Trainer.getTrainer());
        for(Trainer t : list){
            System.out.println(t);
        }
    }
}