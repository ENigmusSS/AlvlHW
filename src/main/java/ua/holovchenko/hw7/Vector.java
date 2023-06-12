package ua.holovchenko.hw7;

import java.util.Random;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector[] rndVectorsGenerator(int count) {
        Vector[] vectors = new Vector[count];
        Random random = new Random();
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(random.nextInt(100), random.nextInt(100), random.nextInt(100));
        }
        return vectors;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector add(Vector modifier) {
        return new Vector(this.x + modifier.x, this.y + modifier.y, this.z + modifier.z);
    }

    public Vector subtract(Vector modifier) {
        return new Vector(this.x - modifier.x, this.y - modifier.y, this.z - modifier.z);
    }

    public Vector vectorProduct(Vector modifier) {
        return new Vector(this.z * modifier.y - this.y * modifier.z, this.x * modifier.z - this.z * modifier.x, this.y * modifier.x - this.x * modifier.y);
    }

    public double scalarProduct(Vector modifier) {
        return this.x * modifier.x + this.y * modifier.y + this.z * modifier.z;
    }

    public double cosBetween(Vector modifier) {
        return scalarProduct(modifier) / (this.getLength() * modifier.getLength());
    }

    @Override
    public String toString() {
        return "Vector{" + x + " " + y + " " + z + "}";
    }
}
