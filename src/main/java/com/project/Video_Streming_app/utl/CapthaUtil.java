package com.project.Video_Streming_app.utl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;

public class CapthaUtil {

	public static Captcha createCaptcha(int width, int height) {
		return new Captcha.Builder(width, height)
				.addBackground().addText()
				.addNoise().build();
	}
	
	public static String encodedDataBase64(Captcha captcha) throws IOException {
		String image=null;
		ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
		ImageIO.write(captcha.getImage(), "png",arrayOutputStream );
		byte[] encode = Base64.getEncoder().encode(arrayOutputStream.toByteArray());
		 image=new String(encode);
		 return image;
	}
}
