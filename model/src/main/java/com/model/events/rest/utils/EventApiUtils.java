/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.model.events.rest.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EventApiUtils {

    public static String generateEventHash (String publicKey, String privateKey) {

        String eventHash = "";

        try {

            String timeStamp    = getUnixTimeStamp();
            String marvelData   = timeStamp + privateKey + publicKey;

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(marvelData.getBytes());

            StringBuilder stringBuilder = new StringBuilder(2 * hash.length);

            for (byte b : hash)
                stringBuilder.append(String.format("%02x", b&0xff));

            eventHash = stringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {

            System.out.println("[DEBUG]" + " MarvelApiUtils generateMarvelHash - " +
                "NoSuchAlgorithmException");
        }

        return eventHash;
    }

    public static String getUnixTimeStamp () {

        return String.valueOf(System.currentTimeMillis() / 1000L);
    }
}
