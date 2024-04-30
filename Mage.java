package Hw8;

public class Mage extends Character {
	
	private int mana;
	
	public Mage(String name, int health, int attackPower, int mana) {
		super(name, health, attackPower);
		this.mana = mana;
		}
	public void castSpell(Character other) {
		
		if (mana >= 20) {
			
			int spellDamage=attackPower * 2;
			other.takeDamage (spellDamage);
			mana-=20;
			System.out.println(name + "施放法術,造成" + spellDamage +"傷害");
		}else {
			System.out.println(name +"法力不足");
		}
	}
	
	public void display() {
		System.out.println("法師名稱:"+ name +",生命值:"+ health +",攻擊力:"+ attackPower +"法力值:" + mana);
	}
}