package com.skyline.leetcode.solution;

/**
 * Valid Number
 * 
 * @author jairus
 *
 */
public class Q65 {

	private class Ret {
		boolean succ;
		boolean e;
		int end;

		Ret(boolean succ, boolean e, int end) {
			this.succ = succ;
			this.e = e;
			this.end = end;
		}
	}

	public Ret isNumber(String s, int start, boolean isE) {
		if (start >= s.length()) {
			return new Ret(false, false, start);
		}
		boolean type = false;
		boolean isFloat = false;
		boolean v = false;
		boolean e = false;
		int i = start;
		for (; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '-' || c == '+') {
				if (type) {
					return new Ret(false, e, i);
				} else if (i != start) {
					return new Ret(false, e, i);
				}
				type = true;
			} else if (c == '.') {
				if (isE) {
					// 10.e
					return new Ret(false, e, i);
				} else if (isFloat) {
					// 000.0.
					return new Ret(false, e, i);
				}
				isFloat = true;
			} else if (c == 'e') {
				if (isE) {
					return new Ret(false, e, i);
				}
				e = true;
				break;
			} else if (c < '0' || c > '9') {
				return new Ret(false, e, i);
			} else {
				v = true;
			}
		}
		return new Ret(v, e, i);
	}

	public boolean isNumber(String s) {
		if (s == null) {
			return false;
		}
		s = s.trim();
		if (s.length() <= 0) {
			return false;
		}
		Ret f = this.isNumber(s, 0, false);
		if (!f.succ) {
			return false;
		} else if (!f.e) {
			return true;
		}
		f = this.isNumber(s, f.end + 1, true);
		return f.succ;
	}

	// public boolean isNumber(String s) {
	// if (s == null) {
	// return false;
	// }
	// s = s.trim();
	// if (s.length() <= 0) {
	// return false;
	// }
	// boolean negitive = false;
	// boolean eNegitive = false;
	// boolean isFloat = false;
	// boolean e = false;
	// boolean v = false;
	// for (int i = 0; i < s.length(); i++) {
	// char c = s.charAt(i);
	// if (c == '.') {
	// if (isFloat) {
	// // .11.1
	// return false;
	// } else if (e) {
	// // 100e111.0
	// return false;
	// } else if (i < s.length() - 1 && (s.charAt(i + 1) > '9' || s.charAt(i +
	// 1) < '0')) {
	// // 10.e
	// return false;
	// }
	// isFloat = true;
	// } else if (c == 'e') {
	// if (i == 0) {
	// // e10
	// return false;
	// } else if (e) {
	// return false;
	// } else if (i >= s.length() - 1 || s.charAt(i + 1) > '9' || s.charAt(i +
	// 1) < '0') {
	// // 10e
	// // 10ee
	// return false;
	// }
	// e = true;
	// } else if (c > '9' || c < '0') {
	// return false;
	// } else {
	// v = true;
	// }
	// }
	// return v;
	// }

	public static void main(String... strings) {
		Q65 q = new Q65();

		Object[][] map = { { " 0.1", true }, { " 0.1 ", true }, { "0.1", true }, { "0", true }, { "00", true },
				{ "72389147983217594734298573214975912", true }, { ".0", true },
				{ ".07328914789327489732189478904879897234879432892347892341789", true }, { "1.0", true },
				{ "3243214321.372891547329187493279147327490321", true }, { ".08903280194.0043201432", false },
				{ ".", false }, { "1.", true }, { "1.324321423.", false }, { "1.0e100", true }, { "1e100", true },
				{ ".1e100", true }, { ".e10", false }, { "100e", false }, { "99e99e", false }, { "0e0.1", false },
				{ "e.0", false }, { "5555ddd", false }, { "e10", false }, { "10.", true }, { "-10.", true },
				{ "-10", true }, { "-.1", true }, { "-.1e-100", true }, { "-.1-", false },{ "-.1+", false },{ "-.1e+200", true } };
		boolean r = true;
		for (int i = 0; i < map.length; i++) {
			String str = (String) map[i][0];
			boolean ret = (boolean) map[i][1];
			boolean aRet = (q.isNumber(str) == ret);
			System.out.println(aRet + ":\t" + str);
			r = aRet & r;
		}
		System.out.println(r);

	}

}
