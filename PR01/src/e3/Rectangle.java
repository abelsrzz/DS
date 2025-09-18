package e3;

import java.util.Objects;

public class Rectangle {
    private int base;
    private int height;
    // Initializes a new rectangle with the values passed by parameter .
    // Throws IllegalArgumentException if a negative value is passed to any of
    // the dimensions .
    public Rectangle ( int base , int height ) {
        if ( base < 0 || height < 0 ) {
            throw new IllegalArgumentException( "Base and height must be positive" );
        }
        this.base = base;
        this.height = height;
    }

    // Copy constructor
    public Rectangle ( Rectangle r ) {
        this.base = r.base;
        this.height = r.height;
    }

    // Getters
    public int getBase () {
        return this.base;
    }

    public int getHeight () {
        return this.height;
    }

    // Setters . Throw IllegalArgumentException if the parameters are negative .
    public void setBase ( int base ) {
        if ( base < 0 ) {
            throw new IllegalArgumentException( "Base must be positive" );
        }
        this.base = base;
    }

    public void setHeight ( int height ) {
        if ( height < 0 ) {
            throw new IllegalArgumentException( "Height must be positive" );
        }
        this.height = height;
    }

    // Return true if the rectangle is a square
    public boolean isSquare () {
        return (this.base == this.height);
    }

    // Calculate the area of the rectangle .
    public int area () {
        return (this.base * this.height);
    }

    // Calculate the perimeter of the rectangle .
    public int perimeter () {
        return (2*this.base + 2*this.height);
    }

    // Calculate the length of the diagonal
    public double diagonal () {
        return (Math.sqrt(Math.pow(this.base, 2) + Math.pow(this.height, 2)));
    }

    // Turn this rectangle 90 degrees ( changing base by height ).
    public void turn () {
        int aux = this.base;
        this.base = this.height;
        this.height = aux;
    }

    // Ensure that this rectangle is oriented horizontally ( the base is greater
    // or equal than the height ).
    public void putHorizontal () {
        if ( this.base < this.height ) {
            int aux = this.base;
            this.base = this.height;
            this.height = aux;
        }
    }

    // Ensure that this rectangle is oriented vertically ( the height is greater
    // or equal than the base ).
    public void putVertical () {
        if ( this.base > this.height ) {
            int aux = this.base;
            this.base = this.height;
            this.height = aux;
        }
    }

    // Two rectangles are equal if the base and the height are the same .
    // It does not take into account if the rectangle is rotated .
    public boolean equals ( Object obj ) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Rectangle r = (Rectangle) obj;
        return (this.base == r.base && this.height == r.height) ||
                (this.base == r.height && this.height == r.base);
    }

    // It complies with the hashCode contract and is consistent with the equals .
    public int hashCode () {
        int result;
        int base = Math.min(this.base, this.height);
        int height = Math.max(this.height, this.base);
        result = base;
        result = 31 * result + height;
        return result;
    }

    public static void main(String[] args) {
        int base = 12;
        int height = 12;

        Rectangle a = new Rectangle(base, height);
        Rectangle b = new Rectangle(height, base);

        //System.out.println(a.equals(b));
        //System.out.println(a.hashCode() == b.hashCode());
        //System.out.println(r.isSquare());

    }
}
