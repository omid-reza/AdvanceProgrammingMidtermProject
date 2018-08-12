package classes;

public class User {
	protected String name,
					Color = "#1bed08";
	
	protected int power,
				level;
	
	public User(String name) {
		this.power = 100;
		this.name = name;
		this.level=1;
	}
	
	public User(String name,String level) {
		this.name = name;
		this.power=100;
		switch (level) {
		case "easy":
			this.level=1;
			break;
		case "normal":
			this.level=2;
			break;
		case "hard":
			this.level=4;
			break;
		default:
			break;
		}
		
	}
		
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (this.level<=14) {
			this.level = level;
		}
	}

	 public int getPower() {
	 	return this.power;
	 }

	 public void setPower(int power) {
	 	if(power<=100) {
	 		this.power = power;
	 	}
	 }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String PowerChangedColor(int power) {
		switch (power){
    	case 80:
    		this.Color="#1bed08";
    		break;
        case 70:
        	this.Color="#7ed72b";
            break;
        case 50:
        	this.Color="#ede108v";
        case 40:
        	this.Color="#ff7f27";
            break;
        case 30:
        	this.Color="#ff2727";
            break;
        case 20:
        	this.Color="#d72b2b";
            break;

		}
		return this.Color;
	}
	
	public void powerChange(int change) {
		this.power=this.power + change;
	}
}
