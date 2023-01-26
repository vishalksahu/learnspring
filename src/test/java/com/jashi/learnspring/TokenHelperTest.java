package com.jashi.learnspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TokenHelperTest {

    @Test
    public void testmixupKeySuccess() {

        String result = TokenHelper.mixUpKey("vishal"); // lahsiv6
        Assertions.assertEquals("lahsiv6", result, "the method returns reversed value with length appended");
        Assertions.assertInstanceOf(String.class, result);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testmixupKeyFailure() {
       Assertions.assertThrows(NullPointerException.class, () -> TokenHelper.mixUpKey(null) );
    }
}
