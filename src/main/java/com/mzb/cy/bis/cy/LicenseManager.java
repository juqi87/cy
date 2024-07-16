package com.mzb.cy.bis.cy;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class LicenseManager {
    private static final String SECRET_KEY = "cy20240715";

    public static String generateLicense(String userId, long durationInDays) throws Exception {
        long currentTime = System.currentTimeMillis();
        long expiryTime = currentTime + TimeUnit.DAYS.toMillis(durationInDays);
        String data = userId + ":" + expiryTime;
        Mac sha256HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");
        sha256HMAC.init(secretKey);
        String hash = Base64.getEncoder().encodeToString(sha256HMAC.doFinal(data.getBytes()));
        return Base64.getEncoder().encodeToString((data + ":" + hash).getBytes());
    }

    public static boolean validateLicense(String license) throws Exception {
        String decodedLicense = new String(Base64.getDecoder().decode(license));
        String[] parts = decodedLicense.split(":");
        if (parts.length != 3) return false;

        String data = parts[0] + ":" + parts[1];
        String hash = parts[2];

        Mac sha256HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");
        sha256HMAC.init(secretKey);
        String calculatedHash = Base64.getEncoder().encodeToString(sha256HMAC.doFinal(data.getBytes()));

        if (!calculatedHash.equals(hash)) return false;

        long expiryTime = Long.parseLong(parts[1]);
        return System.currentTimeMillis() <= expiryTime;
    }

}
