package com.desmond.datamigrate.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MigrationTaskUtil {
	
	public static String getLocalIpAddress() throws Exception {
		String ipAddress = null;
		
		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		
		while(en.hasMoreElements()) {
			NetworkInterface e = en.nextElement();
			Enumeration<InetAddress> addresses = e.getInetAddresses();
			while(addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				if(!address.isLoopbackAddress() && address.isSiteLocalAddress()) {
					ipAddress = address.getHostName();
					break;
				}
			}
		}
		
		if(ipAddress == null) {
			ipAddress = InetAddress.getLocalHost().getHostAddress();
		}
		
		return ipAddress;
	}
}
