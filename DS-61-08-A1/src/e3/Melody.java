package e3;
import java.util.*;




public class Melody {

//ATTRIBUTES:

    public enum Notes {DO, RE, MI, FA, SOL, LA, SI}
    public enum Accidentals {SHARP, FLAT}
    float time;


//METHODS:

    /**
     * Creates an empty Melody instance.
     */
    public Melody () {
        List<Melody> list = new ArrayList<Melody>();
    }


    /**
     * Add a note at the end of this melody.
     * @param note The note to add
     * @param accidental The accidental of the note
     * @param time The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     * or the time are not valid values.
     */
    public void addNote(Notes note, Accidentals accidental, float time) {
        Notes readyStatus = Notes.valueOf("note");
    }
    /**
     * Returns the note on the given position
     * @param index The position of the note to get.
     * @return The note on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */
    public Notes getNote(int index) { /* ... */ }
    /**
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get.
     * @return The accidental on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */
    public Accidentals getAccidental(int index) { /* ... */ }
    /**
     * Returns the duration of the note on the given position
     * @param index The position of the time to get.
     * @return The time on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */
    public float getTime(int index) { /* ... */ }
    /**
     * Returns the number of notes in this melody.
     * @return The number of notes in this melody.
     */
    public int size() { /* ... */ }
    /**
     * Returns the duration of this melody.
     * @return The duration of this melody in milliseconds.
     */
    public float getDuration () { /* ... */ }
    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter. Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes.
     * @param o The melody to be compared with the current melody.
     * @return true if the melodies are equals , false otherwise.
     */
    @Override
    public boolean equals(Object o) { /* ... */ }
    /**
     * Returns an integer that is a hash code representation of the melody.
     * Two melodies m1 , m2 that are equals (m1.equals(m2) == true) must
     * have the same hash code.
     * @return The hash code of this melody.
     */
    @Override
    public int hashCode () { /* ... */ }
    /**
     * The string representation of this melody.
     * @return The String representantion of this melody.
     */
    @Override
    public String toString () { /* ... */ }
}