package com.pfe.Nlp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
public class Pipeline {
    private static Properties properties;
    private static  String proportiename="tokenize,ssplit,pos,lemma,ner,parse,sentiment";
   
    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() {

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", proportiename);
    }

    @Bean(name = "stanfordCoreNLP")
    public static StanfordCoreNLP getInstance() {
        if(stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
      
}
