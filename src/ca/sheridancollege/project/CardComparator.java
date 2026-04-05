/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author munoj
 */
public interface CardComparator {
     /**
     * @return positive if a > b, negative if a < b, 0 if equal
     */
    int compare(Card a, Card b);
}
