package submission;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SnakeGame extends JPanel implements KeyListener {
	int iterationCount = 0;
	ISnake snake = null;
	IFoodItems foodItems = null;
	Random prng = new Random();
	final int playingFieldGridSize = 16;
	
	// allows to queue up two button presses
	int inputQueue = 0;

	SnakeGame() {
		// TODO: initialize the snake and food items
		//snake = new Snake();
		//foodItems = new FoodItems();
		
		Position startingPos = new Position(playingFieldGridSize/2, playingFieldGridSize/2);
		Food startingFood = new Food(FoodType.STRAWBERRY, 0);
		
		snake.addPieceAtTail(startingPos, startingFood);
	}

	void nextStep() {
		++iterationCount;
		
		foodItems.spoilAndRemoveOldFood(iterationCount);
		
		// game over
		if (snake.getHead() == null)
			return;
		
		// add food in random places (excluding the snake)
		addNewFood();
		
		// determine the next position
		Position nextPos = snake.computeNextPosition();
		if (nextPos.x == -1 || nextPos.x == playingFieldGridSize || nextPos.y == -1 || nextPos.y == playingFieldGridSize) {
			snake.reverse();
			return;
		}
		
		// after determining the next position, handle the next key press
		// (this allows to "chain" two key presses)
		handleInput();
		
		ISnake cutPieces = snake.cutTailAt(nextPos);
		foodItems.addFoodFromCutSnake(cutPieces);
		
		Food food = foodItems.getFoodAtPos(nextPos);
		foodItems.removeFood(food);
		snake.moveTowards(nextPos, food);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension panelSize = getSize();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, panelSize.width, panelSize.height);
		
		int minDim = panelSize.width < panelSize.height ? panelSize.width : panelSize.height;
		int blockSize = minDim/playingFieldGridSize;
		int totalSize = blockSize*playingFieldGridSize;
		int offsetX = (panelSize.width-totalSize)/2;
		int offsetY = (panelSize.height-totalSize)/2;
		
		g.setColor(Color.GRAY);
		
		// draw grid
		for (int y=0; y<=playingFieldGridSize; ++y)
			g.drawLine(offsetX, offsetY+y*blockSize, offsetX+playingFieldGridSize*blockSize, offsetY+y*blockSize);
		for (int x=0; x<=playingFieldGridSize; ++x)
			g.drawLine(offsetX+x*blockSize, offsetY, offsetX+x*blockSize, offsetY+playingFieldGridSize*blockSize);
		
		// draw food
		for (int i=0; i<foodItems.getNumFoodItems(); ++i) {
			Food food = foodItems.getFoodAt(i);
			Position pos = foodItems.getPositionAt(i);
			
			int spoiledness = 100 - (food.getBestBefore()-iterationCount);
			
			int size = blockSize/2-blockSize*spoiledness/400;
			
			selectFoodColor(g, food.getType());
			g.fillOval(offsetX+pos.x*blockSize+(blockSize-size)/2, offsetY+pos.y*blockSize+(blockSize-size)/2, size, size);
		}
		
		// draw snake
		ISnakePiece head = snake.getHead();
		if (head != null) {
			ISnakePiece current = head;
			while (current != null) {
				Food food = current.getFood();
				selectFoodColor(g, food.getType());
				Position pos = current.getPosition();
				
				g.fillOval(offsetX+pos.x*blockSize+blockSize/8, offsetY+pos.y*blockSize+blockSize/8, blockSize*3/4, blockSize*3/4);
				
				current = current.getNext();
			}
			
			// draw eyes on the head
			Position pos = head.getPosition();
			TravelDirection direction = snake.getDirection();
			g.setColor(Color.BLACK);
			
			// top-left
			if (direction == TravelDirection.LEFT || direction == TravelDirection.UP)
				g.fillOval(offsetX+pos.x*blockSize+blockSize/4, offsetY+pos.y*blockSize+blockSize/4, blockSize/8, blockSize/8);
			// top-right
			if (direction == TravelDirection.RIGHT || direction == TravelDirection.UP)
				g.fillOval(offsetX+pos.x*blockSize+blockSize/2, offsetY+pos.y*blockSize+blockSize/4, blockSize/8, blockSize/8);
			// bottom-left
			if (direction == TravelDirection.LEFT || direction == TravelDirection.DOWN)
				g.fillOval(offsetX+pos.x*blockSize+blockSize/4, offsetY+pos.y*blockSize+blockSize/2, blockSize/8, blockSize/8);
			// bottom-right
			if (direction == TravelDirection.RIGHT || direction == TravelDirection.DOWN)
				g.fillOval(offsetX+pos.x*blockSize+blockSize/2, offsetY+pos.y*blockSize+blockSize/2, blockSize/8, blockSize/8);
		}
		else {
			g.setColor(Color.RED);
			g.setFont(new Font("Comic Sans MS", 0, blockSize*2));
			g.drawString("YOU DIED", panelSize.width/2-blockSize*5, panelSize.height/2);
			g.setColor(Color.GRAY);
			g.setFont(new Font("Comic Sans MS", 0, blockSize/2));
			g.drawString("Thanks for playing - sorry about the shitty graphics.", panelSize.width/2-blockSize*6, panelSize.height/2+blockSize*3/4);
		}
	}
	
	private void selectFoodColor(Graphics g, FoodType type) {
		switch (type) {
		case STRAWBERRY:
			g.setColor(Color.RED);
			break;
		case BANANA:
			g.setColor(Color.YELLOW);
			break;
		case BLUEBERRY:
			g.setColor(Color.BLUE);
			break;
		case CABBAGE:
			g.setColor(Color.GREEN);
			break;
		case SPOILED:
			g.setColor(new Color(128, 96, 0));
			break;
		}
	}
	
	void addNewFood() {
		if (prng.nextInt(iterationCount)%(foodItems.getNumFoodItems()+1) == 0) {
			FoodType newFoodType = FoodType.values()[prng.nextInt(FoodType.values().length)];
			Food newFood = new Food(newFoodType, iterationCount+100);
			
			for (int i=0; i<playingFieldGridSize*playingFieldGridSize; ++i) {
				Position newPos = new Position(prng.nextInt(playingFieldGridSize), prng.nextInt(playingFieldGridSize));
				
				if (foodItems.getFoodAtPos(newPos) != null || snake.getPieceAtPos(newPos) != null)
					continue;
				
				foodItems.addFood(newFood, newPos);
				break;
			}
		}
	}
	
	private void handleInput() {
		switch (inputQueue) {
		case 87:
		case 38:
			snake.setDirection(TravelDirection.UP);
			break;
		case 65:
		case 37:
			snake.setDirection(TravelDirection.LEFT);
			break;
		case 83:
		case 40:
			snake.setDirection(TravelDirection.DOWN);
			break;
		case 68:
		case 39:
			snake.setDirection(TravelDirection.RIGHT);
			break;
		default:
		}
		inputQueue = 0;
	}

	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		if (inputQueue != 0)
			handleInput();
		inputQueue = keyCode;
	}

	@Override
	public void keyReleased(KeyEvent key) {
		// don't care
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// don't care
	}
};

