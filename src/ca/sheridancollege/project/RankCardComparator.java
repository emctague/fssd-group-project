/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author munoj
 */
public class RankCardComparator implements CardComparator{
    @Override
    public int compare(Card a, Card b) {        
        // Assumes a and b are not null (we already guard before calling)
        return Integer.compare(a.getRank().getValue(), b.getRank().getValue());

    }
}
