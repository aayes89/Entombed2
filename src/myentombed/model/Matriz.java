/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myentombed.model;

import java.util.Random;

/**
 *
 * @author AyA
 */
public class Matriz {

    private String patron;
    protected int[][] tablaMaze;

    public Matriz() {
        patron = "";
        tablaMaze = new int[32][5];
        generarTablaMaze();
    }

    public String crearPatron() {
        String pattern = "";
        Random rnd = new Random();
        int col = rnd.nextInt(32);
        for (int i = 0; i < 5; i++) {
            pattern += tablaMaze[col][i] + " ";
        }
        pattern += reversa(pattern);
        System.out.println(pattern);
        return pattern;
    }

    private String reversa(String cad) {
        String rev = "";
        for (int i = cad.length() - 1; i >= 0; i--) {
            rev += cad.charAt(i);
        }
        return rev;
    }

    private String rellenaCeros(String cad) {
        int longitud = cad.length();
        String ncad = "";
        for (int i = 0; i < (5 - longitud); i++) {
            ncad += "0";
        }
        return ncad + cad;
    }

    private void generarTablaMaze() {
        for (int i = 0; i < 32; i++) {
            String binVal = rellenaCeros(Integer.toBinaryString(i));
            for (int j = 0; j < binVal.length(); j++) {
                tablaMaze[i][j] = (binVal.charAt(j) - 48);
            }
        }
    }

    public int[][] getTablaMaze() {
        return tablaMaze;
    }
}
