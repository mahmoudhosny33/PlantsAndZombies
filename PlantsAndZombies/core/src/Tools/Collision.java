/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author Family
 */
public class Collision {
	
	float x, y;
	int width, height;
	
	public Collision (float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void move (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean collidesWith (Collision rect) {
		return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height > rect.y;
	}
	
}