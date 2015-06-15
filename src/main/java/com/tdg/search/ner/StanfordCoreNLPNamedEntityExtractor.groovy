package com.tdg.search.ner

import org.apache.log4j.Logger;

import com.aliasi.chunk.Chunk
import com.aliasi.chunk.Chunker
import com.aliasi.chunk.Chunking
import com.aliasi.util.AbstractExternalizable

import edu.stanford.nlp.pipeline.Annotation
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import edu.stanford.nlp.util.CoreMap
import edu.stanford.nlp.ling.CoreLabel
import edu.stanford.nlp.ling.CoreAnnotations.*

class StanfordCoreNLPNamedEntityExtractor {
	private static final Logger logger=Logger.getLogger(StanfordCoreNLPNamedEntityExtractor.class)
	
	def pipeline

	StanfordCoreNLPNamedEntityExtractor() {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner")
		this.pipeline = new StanfordCoreNLP(props)
	}


	def extract(text) {
		Annotation document = new Annotation(text);
		pipeline.annotate(document);

		List<CoreMap> sentences = document.get(SentencesAnnotation.class)
		def entities=[]
		for(CoreMap sentence: sentences) {
			for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
				def word = token.get(TextAnnotation.class)
				def start = token.get(CharacterOffsetBeginAnnotation.class)
				def end = token.get(CharacterOffsetEndAnnotation.class)
				def ne = token.get(NamedEntityTagAnnotation.class)
				
				if(ne?.length()>0)
					entities<<new NamedEntity(word, ne, start, end, 0)
			}
		}
		entities
	}
}
