package classes;

public class Time {
	protected int min
				,second
				,millisecond;
	
	public Time(int min, int second, int millisecond) {
		super();
		this.min = min;
		this.second = second;
		this.millisecond = millisecond;
	}
	
	public int getMin() {
		return min;
	}

	public int getSecond() {
		return second;
	}

	public int getMillisecond() {
		return millisecond;
	}

	public void Timer() {
		millisecond--;
		if (millisecond<0) {
			millisecond=999;
			second--;
			if (second<0) {
				second=59;
				min--;
			}
		}
	}
}
