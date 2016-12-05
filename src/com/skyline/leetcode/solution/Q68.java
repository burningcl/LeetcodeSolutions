package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Text Justification
 * 
 * https://leetcode.com/problems/text-justification/
 * 
 * @author jairus
 *
 */
public class Q68 {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<>();
		if (words == null || words.length <= 0) {
			return list;
		}
		int curStart = 0;
		int curWordCnt = 0;
		int curLen = 0;
		for (int i = 0; i <= words.length; i++) {
			if (i < words.length && curLen + words[i].length() + curWordCnt <= maxWidth) {
				curLen += words[i].length();
				curWordCnt++;
			} else {
				int curBlanks = 0;
				StringBuilder sb = new StringBuilder();
				boolean lastLine = i >= words.length;
				for (int j = curStart; j < i; j++) {
					sb.append(words[j]);
					int blanks = 0;
					if (curWordCnt <= 1 || j >= i - 1) {
						blanks = 0;
					} else if (lastLine) {
						blanks = 1;
					} else {
						int wordsLeft = i - j - 1;
						blanks = (maxWidth - curLen - curBlanks) / wordsLeft;
						if((maxWidth - curLen - curBlanks) % wordsLeft!=0){
							blanks++;
						}
					}
					curBlanks += blanks;
					this.appendBlanks(sb, blanks);
				}
				int lastWidth = maxWidth - sb.length();
				this.appendBlanks(sb, lastWidth);
				list.add(sb.toString());
				if (i < words.length) {
					curStart = i;
					curWordCnt = 1;
					curLen = words[i].length();
				}
			}
		}
		return list;
	}

	private void appendBlanks(StringBuilder sb, int blanks) {
		for (int k = 0; k < blanks; k++) {
			sb.append(" ");
		}
	}

	// int blankWidth = 1;
	// int lastBlankWidth = 1;
	// int tailBlankWidth = 0;
	// if (curWordCnt == 1 || words[i - 1].endsWith(".")) {
	// tailBlankWidth = maxWidth - curLen - ();
	// } else {
	// blankWidth = (maxWidth - curLen) / (curWordCnt - 1);
	// if ((maxWidth - curLen) % (curWordCnt - 1) == 0) {
	// lastBlankWidth = blankWidth;
	// } else {
	// blankWidth += 1;
	// lastBlankWidth = maxWidth - curLen - (curWordCnt - 2) * blankWidth;
	// }
	// }
	// for (int j = curStart; j < i; j++) {
	// sb.append(words[j]);
	// int blanks = 0;
	// if (j < i - 2) {
	// blanks = blankWidth;
	// } else if (j == i - 2) {
	// blanks = lastBlankWidth;
	// }
	// this.appendBlanks(sb, blanks);
	// }
	// this.appendBlanks(sb, tailBlankWidth);
	// list.add(sb.toString());
	// if (i < words.length) {
	// curStart = i;
	// curWordCnt = 1;
	// curLen = words[i].length();
	// }

	public static void main(String[] args) {
		Q68 q = new Q68();

		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(q.fullJustify(words, 16));

		String[] words2 = { "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(q.fullJustify(words2, 12));

		String[] words3 = { "What", "must", "be", "shall", "be." };
		System.out.println(q.fullJustify(words3, 12));

		String[] words4 = { "My", "momma", "always", "said,", "\"Life", "was", "like", "a", "box", "of", "chocolates.",
				"You", "never", "know", "what", "you're", "gonna", "get." };
		System.out.println(q.fullJustify(words4, 20));
	}

}
