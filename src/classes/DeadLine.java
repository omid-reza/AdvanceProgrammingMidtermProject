package classes;

public  class DeadLine {
    protected int timer=1000;

	public int getTimer() {
		return timer;
	}

	public void setTimer(int level){
        switch (level){
            case 1:
                timer=1000;
                break;
            case 2:
                timer=1000;
                break;
            case 3:
                timer=900;
                break;
            case 4:
                timer=800;
                break;
            case 5:
                timer=700;
                break;
            case 6:
                timer=600;
                break;
            case 7:
                timer=500;
                break;
            case 8:
                timer=400;
                break;
            case 9:
                timer=400;
                break;
            case 10:
                timer=300;
                break;
            case 11:
                timer=200;
                break;
            case 12:
                timer=100;
                break;
            case 13:
                timer=100;
                break;
            case 14:
                timer=50;
                break;
        }

	}

	public  String lessTime() {
		this.timer=this.timer-1;
		return this.timer+"";
	}
}
