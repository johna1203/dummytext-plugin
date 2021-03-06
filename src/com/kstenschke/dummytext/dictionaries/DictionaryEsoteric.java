/*
 * Copyright 2013 Kay Stenschke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kstenschke.dummytext.dictionaries;

public class DictionaryEsoteric extends Dictionary {

	/**
	 * Constructor
	 */
	public DictionaryEsoteric() {

	}

	/**
	 * @param   amountWords
	 * @param   amountSentences
	 * @return  Random line(s) of text, consisting from the given amount of words (1 line) or lines
	 */
	public String getRandomLine(Integer amountWords, Integer amountSentences) {
			// Esoteric wisdom creates mostly long sentences, so only one per line.
		String sentence   = getSentenceStructure(amountWords);

		while( sentence.matches(".*[0-9].*") ) {
			while(sentence.contains("1")) sentence = sentence.replaceFirst("1", getNounConcrete() );
			while(sentence.contains("2")) sentence = sentence.replaceFirst("2", getNounAbstract() );
			while(sentence.contains("3")) sentence = sentence.replaceFirst("3", getVerbTransitive() );
			while(sentence.contains("4")) sentence = sentence.replaceFirst("4", getVerbIntransitive() );
			while(sentence.contains("5")) sentence = sentence.replaceFirst("5", getAdjective() );
			while(sentence.contains("6")) sentence = sentence.replaceFirst("6", getAdverb() );
			while(sentence.contains("7")) sentence = sentence.replaceFirst("7", getInterjection() );
			while(sentence.contains("8")) sentence = sentence.replaceFirst("8", getPlaceAbstract() );
			while(sentence.contains("9")) sentence = sentence.replaceFirst("9", getPlaceConcrete() );
		}

		sentence = fixIndefiniteArticles(sentence);

		sentence = sentence.replaceAll("loves",      "love");
		sentence = sentence.replaceAll("manys",      "many");
		sentence = sentence.replaceAll("peaces",     "peace");
		sentence = sentence.replaceAll("sexs",       "sex");
		sentence = sentence.replaceAll("the peace",  "peace");

		sentence = sentence.replaceAll("becomeing ",  "becoming ");
		sentence = sentence.replaceAll("desireing ",  "desiring ");
		sentence = sentence.replaceAll("emergeing ",  "emerging ");
		sentence = sentence.replaceAll("forgeting ",  "forgetting ");
		sentence = sentence.replaceAll("illuminate ", "illuminating ");
		sentence = sentence.replaceAll("riseing ",    "rising ");
		sentence = sentence.replaceAll("siting ",     "sitting ");
		sentence = sentence.replaceAll("dos ",        "does ");

		return ucfirst(sentence);
	}

	/**
	 * @param   amountWords
	 * @return  Random sentence structure with numbers as word type placeholders
	 */
	private static String getSentenceStructure(Integer amountWords) {
		if( amountWords != null && amountWords == 1 ) {
			String[] structures  = {"1", "2", "8"};
			return pickRandomString(structures);
		}

		String[] structures = {
			"the 1 3s.",
			"the 2 is a 5 1.",
			"all 5 1s 3s each other, only 5 1s have a 2.",
			"one must 3 the 1 in order to 3 the 1 of 5 2.",
			"Who can 3 the 2 and 2 of a 1 if he has the 5 2 of the 1.",
			"Never 3 the 1, for you can’t 3 it.",
			"Always 6 3 the 5 1.",
			"the 1 has 2, but not everyone 3s it.",
			"7.", "confucius says: 7.",
			"the 9 is full of 2.",
			"2, 2 and a 6 9.",
			"8 is not the 6 2 of the 1.",
			"not 8 or 8, 3 2.",
			"yes, there is 8, it 4s with 2."
		};

		return pickRandomString(structures, amountWords);
	}

	/**
	 * @return  Word of group 1:  concrete noun
	 */
	private static String getNounConcrete() {
		String[] words = {
			"believer", "cow", "ego", "explosion of the 2", "follower", "guru", "individual", "karma",
			"lama", "love", "lover", "man", "master", "monkey", "moon", "one", "scholar", "seeker", "sinner",
			"source", "sun", "teacher", "therapist", "thing", "visitor", "yogi", "aspect"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 2:  abstract noun
	 */
	private static String getNounAbstract() {
		String[] words = {
			"advice", "afterlife", "anger", "attitude", "attraction", "awareness", "beauty", "blessing", "bliss",
			"career", "chaos", "control", "core", "courage", "death", "definition", "density", "dimension", "emptiness",
			"energy", "enlightenment", "enlightenment", "everything", "extend", "faith", "fear", "freedom",
			"grace", "happiness", "heaven", "heaven", "history", "hypnosis", "issue", "life", "living",
			"meditation", "milk", "mind", "mineral", "money", "pain", "peace", "purpose", "relativity",
			"samadhi", "satori", "sex", "silence", "solitude", "suffering", "surrender", "tantra", "totality",
			"trust", "uniqueness", "vision", "volume", "zen", "manifestation"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 3:  transitive verb
	 */
	private static String getVerbTransitive() {
		String[] words = {
			"absorb", "acquire", "avoid", "balance", "capture", "contact", "desire", "discover", "disturb",
			"do", "empower", "experience", "feel", "fly", "forget", "gain", "handle", "hear", "illuminate",
			"know", "love", "meet", "praise", "receive", "remember", "synthesise", "travel", "understand", "view",
			"yearn"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 4:  intransitive verb
	 */
	private static String getVerbIntransitive() {
		String[] words = {
			"appear", "become", "convert", "die", "disappear", "emerge", "exist", "experiment", "meet", "occur",
			"remain", "rise", "sit"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 5:  adjective
	 */
	private static String getAdjective() {
		String[] words = {
			"alchemistic", "ancient", "atomic", "calm", "celestine", "crystal", "enlightened", "further", "great",
			"hermetic", "holographic", "important", "magical", "mysterious", "new", "parallel", "pictorial",
			"powerful", "psychic", "remarkable", "secret", "separate", "small", "strange", "superior", "true",
			"ultimate", "united", "unveiled", "wonderful", "beloved", "sincere", "private", "secret", "abstruse",
			"inner", "outer", "synthetic", "occult", "imminent"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 6:  adverb
	 */
	private static String getAdverb() {
		String[] words = {
			"agreeable", "authorative", "balanced", "cosmically", "earthly", "oddly", "sincerely",
			"qabalistic", "silently", "solitary", "theosophical", "truly", "wisely", "wonderfully",
			"spiritually", "confidently", "esoterically", "essentially"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 7:  interjection
	 */
	private static String getInterjection() {
		String[] words ={
			"the 1 is like the 1", "2 and om",
			"stop to 3 and 4", "confused by 2s, the 1 is",
			"the 2 of 2 leads to 2", "2, 2, 2", "2, 2 and 4",
			"never 3 for others what you would not 3 for the 2 of it",
			"6 2 is to 3 the 2 of the 1\'s ignorance",
			"i 4 and i 4. i 4 and i 4. i 4 and i 4",
			"the 5 1 is 4ing, the 5 1 is 4ing",
			"in 8 all 1s 3 2", "in the 9 all 1s 3 2",
			"in 8 4s 6 2"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 8: abstract place (usable w/o article: "going to 8")
	 */
	private static String getPlaceAbstract() {
		String[] words ={
			"5 places", "chaos", "heavens", "hell", "nirvana", "order", "paradise", "shangri-la", "upstairs",
			"wonderland", "zion"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 9: abstract place (usable with article: "entering the 9")
	 */
	private static String getPlaceConcrete() {
		String[] words ={
			"5 mind", "5 world", "afterworld", "body of 2", "great unknown", "heavens of 2", "home", "kingdom",
			"material world", "mind", "monastery", "next world", "pit", "pyramid", "realm of 2", "state of 2",
			"underworld"
		};

		return pickRandomString(words);
	}



}