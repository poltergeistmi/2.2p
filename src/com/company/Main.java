package com.company;


        import java.io.*;
        import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader br = null;
        Map wordCountMap = new HashMap();
        System.out.print("Введіть назву файлу: ");
        String fileName = in.next();
        System.out.println("Введіть текст:");
        String text = in.nextLine();

        try{
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println(in.nextLine());
                pw.close();
            }

        }catch (IOException e){
            System.out.println("Помлка: "+ e);
        }

        FileReader reader = new FileReader(fileName);
        br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();

        String str[] = line.split(" ");
        List<String> al = new ArrayList<String>();
        al = Arrays.asList(str);

        ListIterator<String> listIterator = al.listIterator();
        while(listIterator.hasNext()){
            String word = (String) listIterator.next();
            String word_lowercase = word.toLowerCase();

            char[] charArray = word_lowercase.toCharArray();
            for(char ch : charArray){
                Integer frequency = (Integer)wordCountMap.get(ch);
                if(frequency == null){
                    frequency = new Integer(1);
                }else {
                    int value = frequency.intValue();
                    frequency = new Integer(value + 1);
                }
                wordCountMap.put(ch, frequency);
            }
        }
        System.out.println(wordCountMap);

    }
}
