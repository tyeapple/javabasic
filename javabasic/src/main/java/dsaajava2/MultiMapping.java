package dsaajava2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MultiMapping {

	public static void main(String[] args) {
		
//		List<String> theWords = Arrays.asList(new String[]{"a","b","c"});
//		String[] words = new String[theWords.size()];
//		theWords.toArray(words);
//		
//		for(int i=0; i<words.length; i++)
//			System.out.println(words[i]);
		
//		String aa = "abcdef";
//		int groupNum = aa.length();
//		for(int i=0; i<groupNum; i++) {
//			String rep = aa.substring(0, i) + aa.substring(i+1);
//			System.out.println(rep);
//		}
		
		
		System.out.println(Integer.BYTES);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.TYPE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		long i = -1&0x0FFFFFFF;
		System.out.println(i);
		
	}

	public static void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {
		for(Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
			List<String> words = entry.getValue();
			if(words.size() >= minWords) {
				System.out.println(entry.getKey() + " (");
				System.out.println(words.size() + "):");
				for(String w : words)
					System.out.print(" " + w);
				System.out.println();
			}
		}
	}
	
	private static boolean oneCharOff(String word1, String word2) {
		if(word1.length() != word2.length())
			return false;
		int diffs = 0;
		for(int i=0; i<word1.length(); i++)
			if(word1.charAt(i) != word2.charAt(i))
				if(++diffs > 1)
					return false;
		return diffs == 1;
	}
	
	private static <KeyType> void update(Map<KeyType, List<String>> m,
										KeyType key, String value) {
		List<String> lst = m.get(key);
		if(lst == null) {
			lst = new ArrayList<String>();
			m.put(key, lst);
		}
		lst.add(value);
	}
	
	public static Map<String, List<String>> computeAdjacentWords1(List<String> theWords) {
		
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
		String[] words = new String[theWords.size()];
		
		theWords.toArray(words);
		for(int i = 0; i<words.length; i++)
			for(int j = i+1; j < words.length; j++)
				if(oneCharOff(words[i], words[j])) {
					update(adjWords, words[i], words[j]);
					update(adjWords, words[j], words[i]);
				}
		
		return adjWords;
	}
	
	public static Map<String, List<String>> computeAdjacentWords2(List<String> theWords) {
		
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
		Map<Integer, List<String>> wordsByLength = new TreeMap<Integer, List<String>>();
		
		for(String w : theWords) {
			update(wordsByLength, w.length(), w);
		}
		
		for(List<String> groupsWords : wordsByLength.values()) {
			String[] words = new String[groupsWords.size()];
			groupsWords.toArray(words);
			for(int i=0; i<words.length; i++)
				for(int j=i+1; j<words.length; j++)
				if(oneCharOff(words[i], words[j])) {
					update(adjWords, words[i], words[j]);
					update(adjWords, words[j], words[i]);
				}
		}
		return adjWords;
	}
	
	public static Map<String, List<String>> computeAdjacentWords3(List<String> words) {
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
		Map<Integer, List<String>> wordsByLength = new TreeMap<Integer, List<String>>();
		
		for(String w : words)
			update(wordsByLength, w.length(), w);
		
		for(Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
			List<String> groupsWords = entry.getValue();
			int groupNum = entry.getKey();
			
			//work on each position in each group
			for(int i = 0; i < groupNum; i++) {
				
				Map<String, List<String>> repToWord = new TreeMap<String, List<String>>();
				
				for(String str : groupsWords) {
					String rep = str.substring(0, i) + str.substring(i+1);
					update(repToWord, rep, str);
				}
				
				//and then look for map values with more than one string
				for(List<String> wordClique : repToWord.values())
					if(wordClique.size() >= 2) 
						for(String s1 : wordClique)
							for(String s2 : wordClique)
								if(s1 != s2)
									update(adjWords, s1, s2);
			}
			
			
			
		}
		
		return adjWords;
	}
}
