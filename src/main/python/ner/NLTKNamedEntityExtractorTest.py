import unittest
import sys
from ner import NLTKNamedEntityExtractor

class NLTKNamedEntityExtractorTest(unittest.TestCase):
    def testText1(self):
        self.extractor=NLTKNamedEntityExtractor.NLTKNamedEntityExtractor()
        entities=self.extractor.extract(open("../../../test/resources/autoregulation-bacteriophage.txt").read())
        print entities
    
    def testText2(self):
        self.extractor=NLTKNamedEntityExtractor.NLTKNamedEntityExtractor()
        entities=self.extractor.extract(open("../../../test/resources/cortical-potentials-spinal-surgery.txt").read())
        print entities
        

if __name__ == "__main__":    
    sys.argv = ['', 'nltk_ner_test.testText1','nltk_ner_test.testText2']
    unittest.main()