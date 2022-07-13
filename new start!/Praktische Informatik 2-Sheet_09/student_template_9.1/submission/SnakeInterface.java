package submission;

interface ISnake {
	// 9.1.1 a)
	ISnakePiece getHead();
	ISnakePiece getTail();
	void addPieceAtTail(Position pos, Food food);
	
	// 9.1.1 b)
	ISnakePiece getPieceAtPos(Position pos);
	
	// 9.1.2 a)
	TravelDirection getDirection();
	void setDirection(TravelDirection newDirection);
	// 9.1.2 b)
	Position computeNextPosition();
	
	// 9.1.2 c) + 9.1.4 a) + 9.1.4 b)
	void moveTowards(Position pos, Food food);
	// 9.1.2 d)
	void reverse();
	
	// 9.1.4 c)
	ISnake cutTailAt(Position pos);
};

interface ISnakePiece {
	// 9.1.1 a)
	Food getFood();
	Position getPosition();
	void setPosition(Position newPos);
	ISnakePiece getNext();
	void setNext(ISnakePiece next);
};

interface IFoodItems {
	// 9.1.3 a)
	int getNumFoodItems();
	Food getFoodAt(int i);
	Position getPositionAt(int i);
	void addFood(Food newFood, Position newFoodPos);
	
	// 9.1.3 b)
	Food getFoodAtPos(Position pos);
	void removeFood(Food food);
	
	// 9.1.3 c) + 9.1.3 d)
	void spoilAndRemoveOldFood(int iterationCount);
	
	// 9.1.4 c)
	void addFoodFromCutSnake(ISnake cutSnake);
};
