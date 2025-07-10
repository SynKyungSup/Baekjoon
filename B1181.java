// 1181번. 단어 정렬
//길이가 짧은 것부터, 사전 순으로

import java.util.LinkedList;
import java.io.*;
import java.util.Collections;

public class B1181{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
        int N = Integer.parseInt(br.readLine()); int duplication=0;
        LinkedList<Word> words = new LinkedList<>();
        LinkedList<String> st = new LinkedList<>();
        for(int i=0;i<N;i++){
            String[] now = br.readLine().split(" ");
            if(!st.contains(now[0])){
                words.add(new Word(now[0]));
                st.add(now[0]);
            } else{
                duplication++;
            }
        }
        Collections.sort(words);
        for(int i=0;i<words.size();i++){
            bw.write(words.get(i).content + "\n");
        }
        bw.flush();
        bw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
class Word implements Comparable<Word>{
    String content;
    int length;
    public Word(String content){
        this.content = content;
        this.length = content.length();
    }
    public int compareTo(Word other){
        if(this.length==other.length) return this.content.compareTo(other.content);
        return this.length-other.length;
    }
}