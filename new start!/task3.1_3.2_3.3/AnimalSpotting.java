package info2;

public class AnimalSpotting {
	
    // ----------------------------------------------------------------
    // Exercise 1 (b)
    // ----------------------------------------------------------------
    public static Animal[] generateRandomZoo(int n) {
    	
    	Animal[] zoo = new Animal[n];
    	
    	for (int i = 0; i < n; i++) {
    		int r = RandomTools.randomValue(Animal.values().length);
    		zoo[i] = Animal.values()[r];
    	}
    	
    	return zoo;
    }
    // TODO: Implement generateRandomZoo
    
    
    
    // ----------------------------------------------------------------
    // Exercise 1 (c)
    // ----------------------------------------------------------------
    public static void printZoo(Animal[] zoo) {
    	
    	if (zoo == null) {
    		return;
    	}
    	
    	for (Animal animal:zoo) {
    		System.out.println(animal);
    	}
    }
    // TODO: Implement printZoo
    
    
    
    // ----------------------------------------------------------------
    // Exercise 1 (d)
    // ----------------------------------------------------------------
    public static int[] countAnimals(Animal[] zoo) {
    	
    	int[] count = new int [Animal.values().length];
    	
    	if (zoo != null && zoo.length > 0) {
    		for (Animal animal:zoo) {
    			count[animal.ordinal()]++;
    		}
    	}
    	
    	return count;
    }
    // TODO: Implement countAnimals
    
    
    
    // ----------------------------------------------------------------
    // Exercise 1 (e)
    // ----------------------------------------------------------------
    public static Animal mostFrequentAnimal(Animal[] zoo) {
    	
    	if (zoo == null || zoo.length == 0) {
    		return null;
    	}
    	
    	Animal mostFrequent = null;
    	int maxcount = 0;
    	
    	for (Animal animal:zoo) {
    		if (animal != null) {
        		int[] count = countAnimals(zoo);
        		if (count[animal.ordinal()] > maxcount) {
        			maxcount = count[animal.ordinal()];
        			mostFrequent = animal;
        		}
    		}
    	}
    	
    	return mostFrequent;
    }
    // TODO: Implement mostFrequentAnimal

    

    // ----------------------------------------------------------------
    // Exercise 1 (f)
    // ----------------------------------------------------------------
    public static double calculateBiomass(Animal[] zoo) {
    	
    	if (zoo == null) {
    		return 0;
    	}
    	
    	double sumBiomass = 0;
    	for (Animal animal:zoo) {
    		double Biomass = 0;
    		switch(animal) {
    			case ELEPHANT:
    				Biomass = 5000;
    				break;
    			case LION:
    				Biomass = 150;
    				break;
    			case TIGER:
    				Biomass = 200;
    				break;
    			case WASP:
    				Biomass = 6e-5;
    				break;
    			case SNAKE:
    				Biomass = 35;
    				break;
    			case MONKEY:
    				Biomass = 160;
    				break;
    			case EMU:
    				Biomass = 40;
    				break;
    			default:
    				Biomass = 0;
    				break;
    		}
    		sumBiomass += Biomass;
    	}
    	
    	return sumBiomass;
    }
    // TODO: Implement calculateBiomass



    // ----------------------------------------------------------------
    
    public static void main(String[] args) {

        Animal[] zoo = generateRandomZoo(100);
        
        printZoo(zoo);
        
        System.out.println();
        
        int[] counting = countAnimals(zoo);
        System.out.println(ArrayTools.asString(counting));
        System.out.println();
        
        System.out.println(mostFrequentAnimal(zoo));
        
        System.out.println();

        System.out.println(calculateBiomass(zoo));
    }
    
}