package com.codestates.section1.unit9.collections;

import java.util.HashMap;

// 2023.7.8(토) 21h25
public class HashMap22 {
    public boolean isMember(HashMap<String, String> members, String username, String password) {
        if (members.containsKey(username)) {
            if (members.get(username).equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean isMemberReference(HashMap<String, String> member, String username, String password) {
        if (!member.containsKey(username)) {
            return false;
        }
        return member.get(username).equals(password);
    }
}
