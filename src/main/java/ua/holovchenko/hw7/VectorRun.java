package ua.holovchenko.hw7;

public class VectorRun {
    public static void main(String[] args) {
        Vector[] vectors = Vector.rndVectorsGenerator(2);
        System.out.println(vectors[0].toString() + " " + vectors[1].toString());
        System.out.println("Lengths:" + vectors[0].getLength() + " " + vectors[1].getLength());
        System.out.println("Sum " + vectors[0].add(vectors[1]));
        System.out.println("Diff " + vectors[0].subtract(vectors[1]));
        System.out.println("Scalar Product " + vectors[0].scalarProduct(vectors[1]));
        System.out.println("Vector Product " + vectors[0].vectorProduct(vectors[1]).toString());
        System.out.println("Angle Cos " + vectors[0].cosBetween(vectors[1]));
    }
}
