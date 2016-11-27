/* 
 * Copyright (C) 2014 Vladislav Mladenov<vladislav.mladenov@rub.de>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.rub.nds.saml.samllib.verifier;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
import com.google.common.cache.*;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for caching the ID's of received SAML Responses for 5 minutes This
 * class makes usage of the Google guava-libraries Caches IDs are stored within
 * the String tuple (ID, "Recently used!")
 *
 * @author Julian Krautwald <julian.krautwald@rub.de>
 */
public class SAMLIDCache {

    private static final SAMLIDCache INSTANCE = new SAMLIDCache();
    private static LoadingCache<String, String> cachedIDs;
    private static int cacheDuration = 5;
    private static Logger _log = LoggerFactory.getLogger(SAMLIDCache.class);

    private SAMLIDCache() {
    }

    /**
     *
     * @param cacheDuration
     */
    public static void setCacheDuration(int cacheDuration) {
        SAMLIDCache.cacheDuration = cacheDuration;
    }

    /**
     *
     */
    public static void initialize() {
        SAMLIDCache.cachedIDs = CacheBuilder.newBuilder().maximumSize(1000)
                .expireAfterWrite(SAMLIDCache.cacheDuration, TimeUnit.MINUTES)
                .removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> rn) {
                        _log.debug("SAML Response ID " + rn.getKey() + " has been removed from the cache.");
                    }
                }).build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) {
                        return key;
                    }
                });
    }

    /**
     *
     * @return
     */
    public static SAMLIDCache getInstance() {
        if (INSTANCE == null) {
            throw new RuntimeException("No singleton instance available");
        }
        return INSTANCE;
    }

    /**
     *
     * @return
     */
    public static LoadingCache<String, String> getHandler() {
        return cachedIDs;
    }
}
