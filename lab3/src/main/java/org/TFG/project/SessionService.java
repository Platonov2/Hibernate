package org.TFG.project;


import accounts.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class SessionService {
    private static final Map<String, UserProfile> sessionsMap = new HashMap<>();

    public static UserProfile getUserBySessionId(String sessionId) {
        return sessionsMap.get(sessionId);
    }

    public static void addSession(String sessionId, UserProfile userProfile) {
        sessionsMap.put(sessionId, userProfile);
    }

    public static void deleteSession(String sessionId) {
        sessionsMap.remove(sessionId);
    }
}
