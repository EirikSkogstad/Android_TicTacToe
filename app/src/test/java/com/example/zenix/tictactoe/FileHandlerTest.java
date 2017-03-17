package com.example.zenix.tictactoe;

import android.content.Context;
import android.test.AndroidTestCase;

import com.example.zenix.tictactoe.datastorage.FileHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(AndroidJunit4.class) // FIXME add AndroidSupportTesing library.
public class FileHandlerTest extends AndroidTestCase {

    private FileHandler fileHandler;

    @Before
    public void setUp() throws Exception {
        Context instrumentationContext = new InstrumentationRegistry().getContext();
        fileHandler = new FileHandler(instrumentationContext);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testWriteHighScore() {
        Map<String, Integer> testData = getTestData();
        try {
            fileHandler.saveHighScores(testData);
            Map<String, Integer> results = fileHandler.readHighScores();

            boolean isEqual = CollectionComparator.isMapContentEquals(testData, results);
            assertEquals(true, isEqual);
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testWriteHighScore_OverwritingExistingEntries() {

    }

    @Test
    public void testReadHighScore() {

    }

    @Test
    public void testReadHighScore_NonExistentEntry() {

    }

    private void deleteFile(String filePath) {

    }

    private Map<String, Integer> getTestData() {
        Map<String, Integer> testData = new HashMap<>();
        testData.put("Bob", 200);
        testData.put("Carl", 13);
        testData.put("Sam", 7);

        return testData;
    }


}