package recursion;

import java.util.ArrayList;
import java.util.List;

public class Box {

	private String name;
	private List<Box> boxes;
	private boolean there_are_key;
	
	public Box(String name, boolean there_are_key) {
		this.name = name;
		this.there_are_key = there_are_key;
		this.boxes = new ArrayList<Box>();
	}
	
	public void addBox(Box box) {
		this.boxes.add(box);
	}
	
	public boolean thereAreKey() {
		return this.there_are_key;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Box> getBoxes(){
		return this.boxes;
	}
	
	public boolean hasBoxesInside() {
		return !this.boxes.isEmpty();
	}
}
