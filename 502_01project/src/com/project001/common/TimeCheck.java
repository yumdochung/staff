package com.project001.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeCheck {
public String timeCheck(String date) {

		SimpleDateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentTime = new Date();
		String status;
		String dTime = fomatter.format (currentTime);
		if(dTime.equals(date)) status="1";
		else status = "0";
		return status;
	}
}
