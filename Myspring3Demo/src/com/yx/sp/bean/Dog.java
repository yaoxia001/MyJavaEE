package com.yx.sp.bean;

import org.springframework.stereotype.Component;

@Component()
public class Dog implements Pet{

	@Override
	public String play() {
		
		return "¹·¹·ºÍÖ÷ÈËÍæ";
	}

}
