package com.keyin;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine = new SuggestionEngine();

    @Mock
    private SuggestionsDatabase mockSuggestionDB;
    private boolean testInstanceSame = false;



    @Test
    void testSuggestionsForNonAlphabeticCharacters(){
        String input = "123";
        String suggestions = suggestionEngine.generateSuggestions(input);
        Assertions.assertFalse(suggestionEngine.generateSuggestions("123").contains(" "));
    }
    @Test
    void testSuggestionAccuracy() {

        String input = "exampl";
        String suggestions = suggestionEngine.generateSuggestions(input);
        Assertions.assertTrue(suggestionEngine.generateSuggestions(suggestions).contains("example"));
    }

    @Test
    void stressTest() {
        for (int i = 0; i < 1000; i++) {
            String input = "sampel" + i;
            suggestionEngine.generateSuggestions(input);
        }
    }
}
