package com.image.imageComparison.compare;


public class Family {
	int minX;
	int minY;
	int maxX;
	int maxY;
	int approximationFactor = 20;
	
	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public Family(int minX, int minY, int maxX, int maxY) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	boolean isMember(int x, int y){
		double d1 = Math.sqrt((minX-x)*(minX-x)+(minY-y)*(minY-y));
		double d2 = Math.sqrt((minX-x)*(minX-x)+(maxY-y)*(maxY-y));
		double d3 = Math.sqrt((maxX-x)*(maxX-x)+(minY-y)*(minY-y));
		double d4 = Math.sqrt((maxX-x)*(maxX-x)+(maxY-y)*(maxY-y));
		//int minDistX = Math.min(Math.abs(minX-x),Math.abs(maxX-x));
		//int minDisY = Math.min(Math.abs(minY-y),Math.abs(maxY-y));
		double min = Math.min(Math.min(d1,d2),Math.min(d3,d4));
		return min<=approximationFactor;
	}
	
	public void reset(int x, int y){
		if(minX > x)
			minX = x;
		if(maxX < x)
			maxX = x;
		if(minY > y)
			minY = y;
		if(maxY < y)
			maxY = y;
	}

	@Override
	public String toString() {
		return "Family [minX=" + minX + ", minY=" + minY + ", maxX=" + maxX
				+ ", maxY=" + maxY + "]";
	}
	
	
	
}
