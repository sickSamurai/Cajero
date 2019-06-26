package presentation.constant;

import java.awt.Color;

public class ColorConstant {
	
	private ColorConstant() {}
	
	public static Color getBlack() {
		return new Color(Integer.parseInt("191919", 16));
	}

	public static Color getWhite() {
		return new Color(Integer.parseInt("eeeeee", 16));
	}
}
