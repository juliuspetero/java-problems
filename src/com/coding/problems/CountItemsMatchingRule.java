package com.coding.problems;


import java.util.List;

/**
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
 * <p>
 * The ith item is said to match the rule if one of the following is true:
 * <p>
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 * <p>
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 */
public class CountItemsMatchingRule {
    private final String KEY_TYPE = "type";
    private final String KEY_COLOR = "color";
    private final String KEY_NAME = "name";

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matchCount = 0;

        if (KEY_TYPE.equals(ruleKey)) {
            for(List<String> item : items){
                if(ruleValue.equals(item.get(0))){
                    matchCount++;
                }
            }

        } else if (KEY_COLOR.equals(ruleKey)) {
            for(List<String> item : items){
                if(ruleValue.equals(item.get(1))){
                    matchCount++;
                }
            }

        } else if (KEY_NAME.equals(ruleKey)) {
            for(List<String> item : items){
                if(ruleValue.equals(item.get(2))){
                    matchCount++;
                }
            }
        }
        return matchCount;

    }

    public int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int ind = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int ret = 0;
        for(List<String> item : items){
            if(item.get(ind).equals(ruleValue)) ret++;
        }
        return ret;
    }
}
