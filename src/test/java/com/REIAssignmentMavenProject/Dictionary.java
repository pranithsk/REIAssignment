package com.REIAssignmentMavenProject;
import java.util.*;
public class Dictionary {
	
	private static DictionaryService dictService;

	public void setDictionaryService(DictionaryService dictService){
	       this.dictService = dictService;
	   }

	   public static Set<String> getDictionary() {
		   
		   Set<String> dictionary = new HashSet<String>();
		   dictionary.add("work");
		   dictionary.add("ring");
		   dictionary.add("row");
		   dictionary.add("king");
		   dictionary.add("in");
		   dictionary.add("test");
		   dictionary.add("apple");
		   
	       return dictionary;
	   }

	   public boolean isEnglishWord(String word) {
	       return dictService.isEnglishWord(word);
	   }
	   
      // Find all Possible words
	   public static List<String> findPossibleWords(String input) {
	       ArrayList <String> matches = new ArrayList<String>();
	       Set<String> dictionary = getDictionary();
	       input = input.toLowerCase();

	       // for each word in dictionary
	       for (String word : dictionary) {
	           //System.out.println(word);

	           // match flag
	           Boolean nonMatch = true;

	           for (char chWord : word.toCharArray()) {
	               String w = Character.toString(chWord);

	               // if the count of chW in word is equal to its count in input,then they are match
	               
	               if (word.length() - word.replace(w, "").length() != input.length() - input.replace(w, "").length()) 
	               {
	                   nonMatch = false;
	                   break;
	               }
	           }
	           if (nonMatch) {
	               matches.add(word);
	           }
	       }
	       System.out.println("English Words in a given String are: " +matches);
	       return matches;
	   }


	public static void main(String[] args) {
		
		String input="working";

		findPossibleWords(input);
	
	}

}
