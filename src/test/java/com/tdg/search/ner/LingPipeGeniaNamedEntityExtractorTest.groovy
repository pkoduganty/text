package com.tdg.search.ner

import org.apache.log4j.Logger;


class LingPipeGeniaNamedEntityExtractorTest extends GroovyTestCase {
	private static final Logger logger=Logger.getLogger(LingPipeGeniaNamedEntityExtractorTest.class)

	def text1=LingPipeGeniaNamedEntityExtractorTest.class.getClassLoader().getResource('autoregulation-bacteriophage.txt').text
	def text2=LingPipeGeniaNamedEntityExtractorTest.class.getClassLoader().getResource('cortical-potentials-spinal-surgery.txt').text

	def ner=new LingPipeGeniaNamedEntityExtractor()

	void testText1() {
		def entities=ner.extract(text1)
		assert entities!=null
		logger.info(entities)
	}
	
	void testText2() {
		def entities=ner.extract(text2)
		assert entities!=null
		logger.info(entities)
	}
}
