package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Menu menu = new Menu();
        try {
            menu.Options();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
