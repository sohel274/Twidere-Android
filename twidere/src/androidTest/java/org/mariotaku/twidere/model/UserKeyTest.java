package org.mariotaku.twidere.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mariotaku on 16/3/9.
 */
public class UserKeyTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("abc@twitter.com", new UserKey("abc", "twitter.com").toString());
        assertEquals("\\@user@twitter.com", new UserKey("@user", "twitter.com").toString());
        assertEquals("\\@u\\\\ser@twitter.com", new UserKey("@u\\ser", "twitter.com").toString());
    }

    @Test
    public void testValueOf() throws Exception {
        assertEquals(new UserKey("abc", "twitter.com"), UserKey.valueOf("abc@twitter.com"));
        assertEquals(new UserKey("abc@", "twitter.com"), UserKey.valueOf("abc\\@@twitter.com"));
        assertEquals(new UserKey("abc@", "twitter.com"), UserKey.valueOf("a\\bc\\@@twitter.com"));
        assertEquals(new UserKey("a\\bc@", "twitter.com"), UserKey.valueOf("a\\\\bc\\@@twitter.com"));
    }
}