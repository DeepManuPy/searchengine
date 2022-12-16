package org.example;

import java.util.HashMap;

public class Node<t>{
    char key;
    t value;
    HashMap<Character, Node<t>> children;

    public Node() {
        this.children = new HashMap<Character, Node<t>>();

    }

    public Node(char key) {
        this.key = key;
        this.children = new HashMap<Character, Node<t>>();
    }
}
