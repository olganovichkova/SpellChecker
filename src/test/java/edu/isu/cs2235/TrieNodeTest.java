package edu.isu.cs2235;

import edu.isu.cs2235.structure.impl.TrieNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrieNodeTest {

    private TrieNode fixture;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new TrieNode(null, false);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createNode method, of class LinkedBinaryTree.
     */
    @Test
    public void testCreateNode() {
        assertEquals(null, fixture.getLetter());
    }

}

