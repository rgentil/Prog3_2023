package tudai.prog3.collections;

public class Node {

	private Integer value;
	private String character;
	private Node left;
	private Node right;

	public Node(Integer value) {
		this.value = value;
		this.setCharacter(null);
		this.left = null;
		this.right = null;
	}
	
	public Node(Integer value, String character) {
		this.value = value;
		this.setCharacter(character);
		this.left = null;
		this.right = null;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public boolean isLeaft() {
		return this.getLeft() == null && this.getRight() == null;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	public boolean hasCharacter() {
		return this.character != null && !this.character.equals("");
	}

}
