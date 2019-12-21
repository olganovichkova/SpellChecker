package edu.isu.cs2235;

import edu.isu.cs2235.structure.impl.Trie;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {
    private Trie fixture;
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new Trie();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createNode method, of class LinkedBinaryTree.
     */


    @Test
    public void searchTest(){
        fixture.insert("apple");
        fixture.insert("app");
        assertTrue(fixture.search("app"));
    }

    @Test
    public void searchTest_1(){
        fixture.insert("apple");
        fixture.insert("app");
        assertFalse(fixture.search("and"));
    }

    @Test
    public void searchTest_2(){
        fixture.insert("a");
        fixture.insert("am");
        assertTrue(fixture.search("a"));
    }

    @Test
    public void searchCapitalLetter(){
        fixture.insert("ABCD");
        fixture.insert("abcd");

        assertEquals(1, fixture.findSuggestion("ABCD").size());
        assertEquals("ABCD", fixture.findSuggestion("ABCD").get(0));
    }

    @Test
    public void searchLowerCaseLetter(){
        fixture.insert("ABCD");
        fixture.insert("abcd");

        assertEquals(1, fixture.findSuggestion("abcd").size());
        assertEquals("abcd", fixture.findSuggestion("abcd").get(0));
    }

    @Test
    public void findSuggestion() {
        fixture.insert("and");
        fixture.insert("apple");
        fixture.insert("app");
        fixture.insert("application");

        List<String> words = fixture.findSuggestion("ap");

        assertEquals("app", words.get(0));
        assertEquals("apple", words.get(1));
        assertEquals("application", words.get(2));

        assertNotNull("test");
    }

    @Test
    public void findSuggestion_1(){
        fixture.insert("apple");
        fixture.insert("app");

        assertEquals(0, fixture.findSuggestion("on").size());
    }

    @Test
    public void findSuggestion_2(){
        fixture.insert("finally");
        fixture.insert("finalize");
        fixture.insert("finalized");
        fixture.insert("fin");

        assertEquals("finalize", fixture.findSuggestion("finaly").get(0));
        assertEquals("finalized", fixture.findSuggestion("finaly").get(1));
        assertEquals("finally", fixture.findSuggestion("finaly").get(2));
        assertEquals(3, fixture.findSuggestion("finaly").size());
    }

    @Test
    public void findSuggestion_3(){
        fixture.insert("hello");
        fixture.insert("hey");
        fixture.insert("heels");
        fixture.insert("heeps");
        fixture.insert("help");

        assertEquals(3, fixture.findSuggestion("he").size());
    }


}
