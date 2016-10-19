package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Substring with Concatenation of All Words
 * 
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * @author jairus
 *
 */
public class Q30 {

	public Map<String, Integer> initMap(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			Integer cnt = map.get(word);
			if (cnt == null) {
				cnt = 0;
			}
			map.put(word, cnt + 1);
		}
		return map;
	}

	// public List<Integer> findSubstring(String s, String[] words) {
	// List<Integer> list = new ArrayList<Integer>();
	// if (s == null || words == null || words.length <= 0) {
	// return list;
	// }
	// int formerI = -1;
	// int wordLen = -1;
	// Set<String> set = new HashSet<>();
	// for (String word : words) {
	// if (wordLen == -1) {
	// wordLen = word.length();
	// } else if (wordLen != word.length()) {
	// return list;
	// }
	// set.add(word);
	// }
	// Map<String, Integer> map = initMap(words);
	// boolean m = false;
	// for (int i = 0; i <= s.length();) {
	// if (map.size() == 0) {
	// list.add(formerI);
	// map = initMap(words);
	// m = false;
	// i = formerI + 1;
	// formerI = -1;
	// }
	// if (i + wordLen > s.length()) {
	// break;
	// }
	// String word = s.substring(i, i + wordLen);
	// if (!word.contains(word)) {
	// if (m)
	// map = initMap(words);
	// m = false;
	// formerI = -1;
	// i++;
	// continue;
	// }
	// if (formerI < 0) {
	// formerI = i;
	// }
	// Integer cnt = map.get(word);
	// if (cnt == null) {
	// map = initMap(words);
	// m = false;
	// i = formerI + 1;
	// formerI = -1;
	// continue;
	// }
	// // System.out.println(word + ": " + cnt + ", " + map);
	// if (cnt <= 1) {
	// map.remove(word);
	// } else {
	// map.put(word, cnt - 1);
	// }
	// m = true;
	// i += wordLen;
	// }
	// if (map.size() == 0) {
	// list.add(formerI);
	// }
	// // System.out.println(map.size());
	// return list;
	// }

	// public List<Integer> findSubstring(String s, String[] words) {
	// List<Integer> list = new ArrayList<Integer>();
	// if (s == null || words == null || words.length <= 0) {
	// return list;
	// }
	// int[] indexes = new int[s.length()];
	// for (int i = 0; i < indexes.length; i++) {
	// indexes[i] = -1;
	// }
	// int wordLen = -1;
	// Set<String> wordSet = new HashSet<String>();
	// for (String word : words) {
	// if (wordLen == -1) {
	// wordLen = word.length();
	// } else if (wordLen != word.length()) {
	// return list;
	// }
	// wordSet.add(word);
	// }
	// words = wordSet.toArray(new String[0]);
	// for (int i = 0; i < words.length; i++) {
	// String word = words[i];
	// int fromIndex = 0;
	// while (true) {
	// int index = s.indexOf(word, fromIndex);
	// if (index < 0) {
	// break;
	// }
	// indexes[index] = i;
	// fromIndex = index + 1;
	// }
	// }
	// // boolean[] exists = new boolean[words.length];
	// int val = 0;
	// final int target = (1 << words.length) - 1;
	// int formerI = -1;
	// for (int i = 0; i < indexes.length;) {
	// if (val == target) {
	// list.add(formerI);
	// val = 0;
	// i = formerI + 1;
	// formerI = -1;
	// continue;
	// }
	// int index = indexes[i];
	// if (index == -1) {
	// val = 0;
	// formerI = -1;
	// i++;
	// continue;
	// }
	// int iVal = 1 << index;
	// if ((val & iVal) > 0) {
	// val = 0;
	// i = formerI + 1;
	// formerI = -1;
	// continue;
	// }
	// val = val | iVal;
	// if (formerI < 0) {
	// formerI = i;
	// }
	// i += wordLen;
	// }
	// if (val == target) {
	// list.add(formerI);
	// }
	// return list;
	//
	// }
	//
	// public class Dir {
	// public Dir[] array = null;
	// public int index = -1;
	// }
	//
	// public List<Integer> findSubstring(String s, String[] words) {
	// List<Integer> list = new ArrayList<Integer>();
	// if (s == null || words == null || words.length <= 0) {
	// return list;
	// }
	//
	// int[] cnts = new int[words.length];
	// int wordLen = -1;
	// int wordCnt = 0;
	// Dir dir = null;
	// Dir cDir = null;
	// for (int i = 0; i < words.length; i++) {
	// String word = words[i];
	// if (wordLen == -1) {
	// wordLen = word.length();
	// } else if (wordLen != word.length()) {
	// return list;
	// }
	// cDir = dir;
	// for (int j = 0; j < wordLen; j++) {
	// if (dir == null) {
	// dir = new Dir();
	// cDir = dir;
	// }
	// if (cDir.array == null) {
	// cDir.array = new Dir[128];
	// }
	// if (cDir.array[word.charAt(j)] == null) {
	// cDir.array[word.charAt(j)] = new Dir();
	// }
	// cDir = cDir.array[word.charAt(j)];
	// }
	// if (cDir.index == -1)
	// cDir.index = wordCnt++;
	// cnts[cDir.index]++;
	// }
	// int[] array = new int[words.length];
	// // Set<Integer> set = new HashSet<>();
	// for (int i = 0; i < s.length(); i++) {
	// System.arraycopy(cnts, 0, array, 0, array.length);
	// boolean match = true;
	// for (int j = 0; j < words.length; j++) {
	// cDir = dir;
	// for (int k = 0; k < wordLen && cDir != null; k++) {
	// int index = i + j * wordLen + k;
	// if (index >= s.length()) {
	// return list;
	// }
	// cDir = cDir.array[s.charAt(index)];
	// }
	// if (cDir == null) {
	// match = false;
	// break;
	// }
	// array[cDir.index]--;
	// if (array[cDir.index] < 0) {
	// match = false;
	// break;
	// }
	// }
	// if (match) {
	// list.add(i);
	// }
	// }
	// return list;
	// }

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ret = new ArrayList<Integer>();
		int slen = S.length(), llen = L.length;
		if (slen <= 0 || llen <= 0)
			return ret;
		int wlen = L[0].length();

		// get the words' map
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		for (String str : L) {
			if (words.containsKey(str)) {
				words.put(str, words.get(str) + 1);
			} else {
				words.put(str, 1);
			}
		}

		for (int i = 0; i < wlen; ++i) {
			int left = i, count = 0;
			HashMap<String, Integer> tmap = new HashMap<String, Integer>();

			for (int j = i; j <= slen - wlen; j += wlen) {
				String str = S.substring(j, j + wlen);

				if (words.containsKey(str)) {
					if (tmap.containsKey(str)) {
						tmap.put(str, tmap.get(str) + 1);
					} else {
						tmap.put(str, 1);
					}

					if (tmap.get(str) <= words.get(str)) {
						count++;
					} else {
						// too many words, push the 'left' forward
						while (tmap.get(str) > words.get(str)) {
							String tmps = S.substring(left, left + wlen);
							tmap.put(tmps, tmap.get(tmps) - 1);
							if (tmap.get(tmps) < words.get(tmps)) {
								// if affect the count
								count--;
							}
							left += wlen;
						}
					}

					// get the answer
					if (count == llen) {
						ret.add(left);
						// it's better to push forward once
						String tmps = S.substring(left, left + wlen);
						tmap.put(tmps, tmap.get(tmps) - 1);
						count--;
						left += wlen;
					}
				} else {
					// not any match word
					tmap.clear();
					count = 0;
					left = j + wlen;
				}
			}
		}
		return ret;
	}

	public static void main(String... strings) {
		Q30 q = new Q30();
		String s1 = "goodbestwordgoodgoodgoodbestwordgood,,,,,goodgoodbestword,,,,goodbestwordgoodgood,goosdbestwdordgoodgood";
		String[] words1 = { "word", "good", "best", "good" };
		List<Integer> indexs1 = q.findSubstring(s1, words1);
		for (int i : indexs1) {
			System.out.println(i);
		}

		long t1 = System.nanoTime();
		String s = "ttqupktjvqeeylzkyirjnnjuhyrmrhwkaoepyzavshbquaasltdyimtpmmddtzotnsknsnkkumcooeizxmyfyrwlfbqyaetpzdetsodmahcpllqizopzhnmmodkqhdfijjbbxgqansryfhiewzgfmsscvcsfizntkpukvkkjfbjmkutitzoirgmpkfuughnrykbuwnfbqqqckjlgizqbhcqtjkosudlunookbvntodvymggwhyaodqkodygzbrtpfkbifodtszughcdpdffgvpwapdzrwtiefjomxsirrcyygdpjixrfmogctfvpafvfqksncchtgftmklysipxudfyynvoncjvsvpixrpsxumlexjyfbxbgdcfqzvfcgcuctczmtsjngxtdgtkjrnqwrxorsvvyaratwcgpurfaoyfxurgneylyvzrpwmowdqqzsyropwqewvbqojfvkqtfrkxowlmbdcdycumssdwoazhpkmkufdcwpzmnmzopdtngpcyhfwyfxhuhvecajexyfjlrkcioxywnauwfsumpbhwxnazzgwzlincurnioleblaysssejwngvdgucntdadqdxhqgwdmxonxghsmrqazldhfhuakvdbabksjgvvglkdtuxhlnhkymtgtogglmhnnrhwaetgrelkyjrlwbxxnqfjgnptzygmrpkrtezkklwiwqvursrgkyrrmgklgtaykmpgqpsacpkyhfsazmgkkadygnmnioltaczrtrtvigvpnqrncazoacpirbvapivpnwigpeeykzpxphmtjlkjnzrhaphrxeimartpxxphyheoqtjzetiuszbuokloowaqnvhkuzttgzjwssxxmftggubxeoluknkzjtldsgyygjwyctxqaqwhmzeqqrmcewepsrvkyvjgfhehbezbwxkjxqbphoromxfepappwavdhzkkflociynhpowycqmrnsveumtsmovwqhgxsuzdvmkkdjihzxyoruvlioevfbtvjzsdwugritblcltdkrtbnonydtvkwofhnzljvtceodrqrktbendtdstinosjczrsbedwzgcolugcgagmpliudbdqqvbuxumyyquawxqhtwmzwsondwiizlapibmfyyfyoaymzouulivjajzfhhnhunyeqkmojrnztnmuciopqkyqtxxbgkkczihrttiemxdgkpaoxpdnzefudcxkohmpsvjlqrpdoujykjpjaszbygycjvozfarxyakorbrhvchhowtorsqpyotjlhlskcricbwveqecsllgiexbwpsxfmgqttldvcnzgmwkcaowmafwecxdrpcwdkoxezczeqbkexwiyleknlgtnfwgwaealtzpuboytrkxphfnumxhxfanmztizykktjbpnsqgjagyhnldzkkzpnmdohmpfwcaidqvvidhilfszrvadibvxnynvkccjgftmxqhftqnhwfgpdislmnkzmxwybbjigcudsdkouxvqfdhinzvzphbdezdfanpirjnmnxcjxxbccimpjjraqsdwrhbuwtencsbrrdaocdqenewxnpzfhdbamfwkybxatbumewbjatnnylmlamrjrumfzkpxloagputwqufsnuiliwzkkswbmiimszlgolmfhhdabisrfcenzfzjxvnmfxayxlgnzssgayidibwnfbceicqizfufcwfzjlmidhrffzlpchdikhotlgbllxsotxncicnnletsdehinmsyugthnuuyrmomjeoridfthannguvvhntdvomkkhjbtzpfdgyljfgrftgnqbjzqecltqwdxhhtgwymcyzoegfjblxrogqekurflpjkwqdfodttcuhgamrezqxpyovlkoqvezgcrljgpcztxizzwsfvjdmhthsdvlbbmjeeunmjsnervdsryyohbaqwjlzgwaiijmogbcrtpwmmbffzdtggvzcgkbngexqplfvmhpizlulmztmeoukmtmsdohlugclrjhgsyorjkfvmajqogbazntfdcsxjwlcfuiasytbjayvaklpqmprckwfppfynqctklvcjofupfpppbgfpwzrivzxmexawavglqkwgprxwgnmjttbrssaqrxexvetvbbitleacvxzcmnnigozbj";
		s = s + s + s + s + s + s;
		s = s + s + s;
		String[] words = { "wxnazzgwzlincurnioleblays", "txwrtqcaciunqdaskqbxjgqsa", "vdhzkkflociynhpowycqmrnsv",
				"sondwiizlapibmfyyfyoaymzo", "advmnlciojurgbfdohaworgir", "gbwpprhetfmjddaqxqwmeshas",
				"vmjcjlzasgtnrazmvfbnrfkuf", "zjxvnmfxayxlgnzssgayidibw", "xmsdwclozzurtesskdrofufkc",
				"gglmhnnrhwaetgrelkyjrlwbx", "galldybmwzrsozbnxyvfniqyl", "ofrbxnxgnefbaueghcbqldetf",
				"ltaczrtrtvigvpnqrncazoacp", "psacpkyhfsazmgkkadygnmnio", "mztmeoukmtmsdohlugclrjhgs",
				"gjdaqjsxphojgoihlowfxoyih", "gpcztxizzwsfvjdmhthsdvlbb", "bksjgvvglkdtuxhlnhkymtgto",
				"mewbjatnnylmlamrjrumfzkpx", "orsqpyotjlhlskcricbwveqec", "wsrdidpuytslzhtiheegjpskp",
				"zehikwbrcaqagjrahnbgozsve", "lzjoyehxbbttftvpqifviafad", "phyyfungiyxvignkjkboavlgu",
				"zdadsqaumdqnykozmbaerbiac", "zxyoruvlioevfbtvjzsdwugri", "xtvotgutpmetmoiwcxidgwwkx",
				"cpvxtcnnvmaisoucjvehwdxst", "jfgzacxstacwrwxnrkmagvhkz", "nubrhcnrqxizwdiropfpmrmpt",
				"rwahikxnbanqyveeafgxloepq", "zncxvbeiaxcombypgriszdywt", "ottznlgmljvbcwzxqvouezeop",
				"rqguzqyfuclhgvoixbotkylmp", "zdsvpffvubvrhlrjkrgecxbjk", "kqbvgarsjtduvdobyduyfhumk",
				"azhkdexxiqgkgzcfjccmmtdcy", "igcudsdkouxvqfdhinzvzphbd", "igylpaqhxlavtemfrkfbcgtzz",
				"ezdfanpirjnmnxcjxxbccimpj", "hwydjosbxvsuqcijkiovbfvcf", "lzgwaiijmogbcrtpwmmbffzdt",
				"fsqgolcvbncttmriivgagppbp", "hsqbiaauxzqeogwrarpfuipmp", "mxonxghsmrqazldhfhuakvdba",
				"legajnsmaqdhfrsednjrlrhch", "eebwbgifcrjdyunprrhgzamjz", "suxzpxiruizscmubdapkvgoen",
				"uvnekcbtcfreqywtrjiwymeqb", "pquuuvmknvsafawymztykfphw", "bhxfwbssquhcmpkwupzpuetih",
				"pshdpvvkotfzcjrrzbarpljus", "edgdulxyofngciphxznwqnghi", "pwzrivzxmexawavglqkwgprxw",
				"wimiohxvhtlhnzvmxdzokohbx", "sjcqalwynbjaksrcjnvccwgry", "qwfkyjeabdcrihatdbwhmzodh",
				"thmqsvaywlqwdxuozpjddrvpw", "jdpuawgqycxavrjqxflavpzyj", "xphftvkfkvtdnskbvdaauujow",
				"mwkcaowmafwecxdrpcwdkoxez", "rrlbbvietzvkhbeonpsqpiogh", "gyglgplsphtjuarwldnhnkrlc",
				"sqshgljhutkbtjjjrvrtzxcdb", "ihvnmwectywomjdibfnddnsfh", "dymvirpvsqarzwiqnymiodjpn",
				"evrocfhbeuleghbkdsobdbjdm", "sbbfnsxujdnkeyqziptzkpemt", "gmlucsfhiscphrwbvforsvnur",
				"nfbceicqizfufcwfzjlmidhrf", "tbqxanffjiubddidfrgbyeemr", "fszmebvmvdsuiiprxkpbemcuf",
				"ziwqcqzawkinvbcewnawezkhm", "dmolmtryfobswfrujsckykhva", "ewcflmhhprotrtnzcnbxyufad",
				"qcebmfvorruiawoqyqrotlgnb", "qdnwpemljzmudmyiqpqxpjcsf", "xhaewbjgsdrmpencismzrqlyt",
				"iyrrcbxvwgjwcdfagcqybywjm", "rhezwydtrswwbzavkfdriqwbe", "kljmfvnkyseotzcyrpwcfyoiy",
				"xtygncsqeramomcgwupanqmng", "uzoegsotzycktizwzswrvmles", "fzlpchdikhotlgbllxsotxnci",
				"rrwrxwqqzahgwhhjcvmlswdne", "xtckpftazltocgvisvhihjmsu", "aovdhambtnkvpguoyyeewwhql",
				"qenewxnpzfhdbamfwkybxatbu", "wqvursrgkyrrmgklgtaykmpgq", "ezbwxkjxqbphoromxfepappwa",
				"mzeqqrmcewepsrvkyvjgfhehb", "ulzbezgwrroowtoraaifaaucf", "rdxzzkdbnzyodndqvjhwmqyds",
				"qtryvjjcrnoiirnlqdewcgvkp", "slemeueamiapngfbuskzbfaxc", "ssejwngvdgucntdadqdxhqgwd",
				"lhgdmptbdbyptezaxgjshsnxn", "qheoqszaxbvfnshrsjtqkcwhq", "twwkkamuxcwpbylngylhcpgps",
				"fszrvadibvxnynvkccjgftmxq", "hftqnhwfgpdislmnkzmxwybbj", "iimszlgolmfhhdabisrfcenzf",
				"mztizykktjbpnsqgjagyhnldz", "eacvxzcmnnigozbjzrazvauct", "hkhkjjteoarrapbouggbahhiw",
				"uknkzjtldsgyygjwyctxqaqwh", "lduheaglipveqogteizobzxoc", "ggvzcgkbngexqplfvmhpizlul",
				"omjeoridfthannguvvhntdvom", "uulivjajzfhhnhunyeqkmojrn", "npofvbdqwtjfnewcjpozzmbwx",
				"altzpuboytrkxphfnumxhxfan", "scbdcfpqodxmqikioadndchsy", "jfontgnoftejlunfuzvidcezt",
				"pvohffrkmslopfhpigigfvzpi", "kkhjbtzpfdgyljfgrftgnqbjz", "sllgiexbwpsxfmgqttldvcnzg",
				"exyfjlrkcioxywnauwfsumpbh", "hkuzttgzjwssxxmftggubxeol", "gftdpsshhaciduhwdmljinuae",
				"uzktepjafqccyqbsqtoyvnnad", "fnzrunpwibfrtkhsfvqkjowpz", "gpvtlmokhpjxwvzxkvfhyfgrn",
				"hgamrezqxpyovlkoqvezgcrlj", "qslmbbunhudqnahuqqcgylroh", "otchmbxeounavgfrkuzqkbqex",
				"lcczifvmosisjerymaqvpieoq", "ljvtceodrqrktbendtdstinos", "jlkjnzrhaphrxeimartpxxphy",
				"judhldzyjmfdqfsbfhonpqihc", "lxrogqekurflpjkwqdfodttcu", "firujuknynbfkrwblhdhvuhnn",
				"cnnletsdehinmsyugthnuuyrm", "stqcybdfqomliditbuvhvavqy", "ckzjmubfhcgdmmwoijxjplxed",
				"ttiemxdgkpaoxpdnzefudcxko", "jiuqtnpnhgmyxnmcejjdzbafa", "eumtsmovwqhgxsuzdvmkkdjih",
				"irbvapivpnwigpeeykzpxphmt", "czeqbkexwiyleknlgtnfwgwae", "eklxclicwwcbfbeiuxpquficm",
				"xatbwbssbbcnapobehzzlfcsm", "ztnmuciopqkyqtxxbgkkczihr", "heoqtjzetiuszbuokloowaqnv",
				"vbdhkekufkwkqdqumhhzynawt", "fjrqhknearpcukfaclsahmrsw", "xlxxweposbstyfasishkbdbrf",
				"qfrftyzjgtkzrrtwcacaqmxrd", "ljcofosioagvqgyjxyhwabkdk", "ecygwfqaaqqayzasmchpcciyg",
				"lwnzokqggkdeavfdelbmsmopa", "vzvzzohlabnugucaztiqpjnuz", "hmpsvjlqrpdoujykjpjaszbyg",
				"qecltqwdxhhtgwymcyzoegfjb", "kkzpnmdohmpfwcaidqvvidhil", "yorjkfvmajqogbazntfdcsxjw",
				"ozmjrlijrcavpdquxgxsspdck", "pbmnhemixfnnrxyehtvrgmcgj", "hmjnhmsbeyqrclsrqnkcgvnbb",
				"gnmjttbrssaqrxexvetvbbitl", "mjeeunmjsnervdsryyohbaqwj", "dbdqqvbuxumyyquawxqhtwmzw",
				"pqlvjmbsdtcnigpzxsukzwmko", "khfcvgkvzcacbvyjgxljcnsef", "gttinaushwdwqszgvgnmyrrna",
				"jawziwsmzxpemhvrehhmrpdrt", "jraqsdwrhbuwtencsbrrdaocd", "wcumhjpeoxtnyfmyjgidwdygz",
				"zsupwrrbmfqxhznqvgzwncnuc", "isxoessjaxelwczdrfgzvpzuf", "mkvcyneoihyivzdjjyarvpptt",
				"tblcltdkrtbnonydtvkwofhnz", "bvdiheadshixavlsgzhljyvrh", "wgyfxnvpdglythhclicnaspmk",
				"jczrsbedwzgcolugcgagmpliu", "hbtaozfiyuncpbxttubdjuawl", "ysesrelasduqdvmqlivkemjwv",
				"dvegpzylwacuitqstkwhexmfm", "qpohxkseifqgjvzhtpvcudgbs", "xnqfjgnptzygmrpkrtezkklwi",
				"loagputwqufsnuiliwzkkswbm", "qmaygqwpoluqgnluswyiqtkii", "kfkgujfjnceqgnrfrhruhjbyt",
				"hhuiezfqtimvwcuxzntfhlrne", "fppfynqctklvcjofupfpppbgf", "zhnjfvuqxiwlcgzdmvvvtgutp",
				"wfojhsgkxnucxqjhotzsluesd", "debcenekfzbmgwhhrapdtanmh", "yjyndatsvodjcqstzrpwtohot",
				"eahsjdyjpjmnkyjmrcarfpqfn", "neawoysnozwgnpfntrgescdna", "amyvbulegalkpvjwiwqiwupsr",
				"orniwvnuhieayasqajpythnst", "ckaaadehgciomnrgzwevjvncc", "syvymkadfzwiolfaoovcixofd",
				"dssksvddztfkrdasocdhthqic", "vcivwcpuxpghqjprhzgteihsd", "lcfuiasytbjayvaklpqmprckw",
				"ycjvozfarxyakorbrhvchhowt", "fpvstyicqmnyykqyqxrxhlxlj", "puofavimwtasugazodnbbblky",
				"nhqeihlxsygethktxbwlvnbja", "xbstdokilljvqkkrjauydntpw" };
		List<Integer> indexs = q.findSubstring(s, words);
		// for (int i : indexs) {
		// System.out.println(i);
		// }
		long t2 = System.nanoTime();
		System.out.println("cost: " + (double) (t2 - t1) / 1000000);
	}
}
