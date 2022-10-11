import java.util.ArrayList;

public class Trie {
//    ArrayList<String> list;
//    public Trie() {
//        list=new ArrayList<>();
//    }
//
//    public void insert(String word) {
//        list.add(word);
//    }
//
//    public boolean search(String word) {
//        for (String str:list)
//        {
//            if (str.equals(word))
//                return true;
//        }
//        return false;
//    }
//
//    public boolean startsWith(String prefix) {
//        for (String str:list)
//        {
//            if (str.startsWith(prefix))
//                return true;
//        }
//        return false;
//    }

    Trie[] ch;
    boolean end=false;
    public Trie() {
        ch=new Trie[26];
    }

    public void insert(String word) {
        Trie temp=this;
        for (int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            int index = c - 'a';
            if (temp.ch[index]==null)
            {
                temp.ch[index]=new Trie();
            }
            temp=temp.ch[index];
        }
        temp.end=true;
    }

    public boolean search(String word) {
        Trie trie = searchPre(word);
        if (trie==null) return false;
        else return trie.end;
    }

    public boolean startsWith(String prefix) {
        return searchPre(prefix)!=null;
    }
    public Trie searchPre(String prefix) {
        Trie trie=this;
        for (int i=0;i<prefix.length();i++)
        {
            int index=prefix.charAt(i)-'a';
            if (trie.ch[index]==null)
            {
                return null;
            }
            trie=trie.ch[index];
        }
        return trie;
    }
}
