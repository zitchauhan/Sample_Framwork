package javautils;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkUtils {

    private NetworkUtils() {
        // Private constructor to prevent instantiation
    }

    public static boolean isHostReachable(String host, int timeout) {
        try {
            return InetAddress.getByName(host).isReachable(timeout);
        } catch (IOException e) {
            return false;
        }
    }

    public static String getLocalHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (IOException e) {
            return "Unknown";
        }
    }

    public static String getLocalIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (IOException e) {
            return "Unknown";
        }
    }
}
