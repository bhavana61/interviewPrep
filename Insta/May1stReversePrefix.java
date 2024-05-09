package Insta;

public class May1stReversePrefix {
    public String reversePrefix(String word, char ch) {
        int occurrence=word.indexOf(ch);
        if(occurrence==-1)
            return word;
        else{
            StringBuilder sb= new StringBuilder(word.substring(0, occurrence+1));
            sb.reverse().append(word.substring(occurrence+1));
            return sb.toString();
        }
    }
}
