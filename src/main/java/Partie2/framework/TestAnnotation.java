package Partie2.framework;

import Partie2.framework.context.AnnotationApplicationContext;
import Partie2.metier.IMetier;

public class TestAnnotation {
    public static void main(String[] args) {

        AnnotationApplicationContext context = new AnnotationApplicationContext("Partie2.dao","Partie2.metier");

        IMetier metier = context.getBean(IMetier.class);

        System.out.println(metier.calcul());
    }
}