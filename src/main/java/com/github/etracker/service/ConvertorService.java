/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.service;

import com.github.etracker.model.LocationAndTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import nz.co.eroad.domain.TimeZoneMapper;

/**
 *
 * @author Ali
 */
public class ConvertorService {
    
    public void update(LocationAndTime data) {
        double lat = data.getLat();
        double lang = data.getLang();
        String utc = data.getUtc();
        String timezone = TimeZoneMapper.latLngToTimezoneString(lat, lang);
        String localTime = convert(utc, timezone);
        //build result
        data.setTimezone(timezone);
        data.setLocal(localTime);
        //return data;
    }
    
    public String convert(String d, String timezone) {
		SimpleDateFormat utcFormat = new SimpleDateFormat(
				"yyyy-MM-dd' 'HH:mm:ss");
		utcFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = null;
                try {
                    date = utcFormat.parse(d);
                } catch (ParseException ex) {
                    Logger.getLogger(ConvertorService.class.getName()).log(Level.SEVERE, null, ex);
                }
		DateFormat localFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		localFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//		Date date1 = offsetTimeZone(date,"UTC", timezone );
		return localFormat.format(date);
	}
}
