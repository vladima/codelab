package com.codelab;

import com.codelab.prefix.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> n = new Solution().prefix(Arrays.asList("zebra", "dog", "duck", "dove"));
        List<String> n1 = new Solution().prefix(Arrays.asList("bearcat", "bert"));
    }
}
