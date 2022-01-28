package com.humorous.elevate.leetcode;

public class MagicDictionaryII {

    boolean isEnd;
    MagicDictionaryII[] children;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionaryII() {
        isEnd = false;
        children = new MagicDictionaryII[26];
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            MagicDictionaryII cur = this;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new MagicDictionaryII();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        MagicDictionaryII cur = this;
        return search(searchWord, 0, cur, false);
    }

    private boolean search(String searchWord, int index, MagicDictionaryII cur, boolean flag) {
        for (int i = index; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);

            if (cur.children[ch - 'a'] == null) {
                if (!flag) {
                    for (int j = 0; j < 26; j++) {
                        if (cur.children[j] != null && search(searchWord, i + 1, cur.children[j], true)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return false;
                }
            } else {

                cur = cur.children[ch - 'a'];
            }
        }

        return cur.isEnd && flag;
    }

    public static void main(String[] args) {
        MagicDictionaryII magicDictionary = new MagicDictionaryII();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hhllo"));
    }
}
