package Hw8;


public class Hw8_1 {


	
	public static void main(String[] args) {
	Warrior warrior = new Warrior("A", 100, 15, 5);
	Mage mage = new Mage("B", 80, 10, 50);
	mage.castSpell (warrior);
	warrior.useShield();
	warrior.attack (mage);
	mage.display();
	warrior.display();
	}
	
	
}

