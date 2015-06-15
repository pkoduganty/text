package com.tdg.search.ner

import org.apache.log4j.Logger;

import com.aliasi.chunk.Chunk
import com.aliasi.chunk.Chunker
import com.aliasi.chunk.Chunking
import com.aliasi.util.AbstractExternalizable

class LingPipeGeniaNamedEntityExtractor {
	private static final Logger logger=Logger.getLogger(LingPipeGeniaNamedEntityExtractor.class)
	
	def chunker	= (Chunker) AbstractExternalizable.readObject(new File(LingPipeGeniaNamedEntityExtractor.class.getClassLoader().getResource('ne-en-bio-genia.TokenShapeChunker').toURI()))
	
	def extract(text) {
		Chunking chunking = chunker.chunk(text);

		Set<Chunk> chunkSet = chunking.chunkSet();
		def entities=[]
		chunking.chunkSet().each { chunk ->
			def start = chunk.start()
			def end = chunk.end();
			def type=chunk.type();

			String token = text.substring(start,end);
			entities << new NamedEntity(token, type, start, end, 0)
		}
		entities
	}
}
