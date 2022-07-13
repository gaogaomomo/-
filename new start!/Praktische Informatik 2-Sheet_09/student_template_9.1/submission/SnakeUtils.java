package submission;

enum FoodType {
	STRAWBERRY, BANANA, BLUEBERRY, CABBAGE, SPOILED
};

class Food {
	private FoodType type;
	private int bestBefore;
	
	Food(FoodType type, int bestBefore) {
		this.type = type;
		this.bestBefore = bestBefore;
	}
	
	FoodType getType() { return type; }
	int getBestBefore() { return bestBefore; }
	
	void spoil() { this.type = FoodType.SPOILED; }
	
	boolean equals(Food other) {
		return other != null && type == other.type && bestBefore == other.bestBefore;
	}
	
	public String toString() {
		return "["+type.toString()+", best before "+bestBefore+"]";
	}
};

enum TravelDirection {
	UP, DOWN, LEFT, RIGHT
}

class Position {
	int x;
	int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	boolean equals(Position other) {
		return other != null && x == other.x && y == other.y;
	}
	
	public String toString() {
		return "["+x+", "+y+"]";
	}
};
