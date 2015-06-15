import nltk


def tree_traverse(t):
    entity_names = []
    if hasattr(t, 'node') and t.node:
            if t.node == 'NE':
                entity_names.append(' '.join([child[0] for child in t]))
            else:
                for child in t:
                    entity_names.extend(tree_traverse(child))                
    return entity_names


class NLTKNamedEntityExtractor(object):
    def __init__(self):
        pass    
    
    def extract(self, text):
        sentences = nltk.sent_tokenize(text)
        tokenized_sentences = [nltk.word_tokenize(sentence) for sentence in sentences]
        tagged_sentences = [nltk.pos_tag(sentence) for sentence in tokenized_sentences]
        chunked_sentences = nltk.ne_chunk_sents(tagged_sentences, binary=True)
        
        entity_names = []
        for t in chunked_sentences:
            if hasattr(t, 'node') and t.node:
                if t.node == 'NE':
                    entity_names.append(' '.join([child[0] for child in t]))
                else:
                    for child in t:
                        entity_names.extend(tree_traverse(child))
                
        return entity_names
        
        