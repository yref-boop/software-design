package e3;
import java.util.*;

public class Melody {

//ATTRIBUTES:

    public enum Notes {DO, RE, MI, FA, SOL, LA, SI}
    public enum Accidentals {NATURAL, SHARP, FLAT}
    float time;

    public Notes Note;
    public Accidentals Accidental;

//METHODS:


    //Constructor method:
    public Melody(Notes Note, Accidentals Accidental, float time){
        this.Note = Note;
        this.Accidental = Accidental;
        this.time = time;
    }

    List<Melody> list = new ArrayList<>();

    /**
     * Creates an empty Melody instance.
     */
    public Melody () {List<Melody> list = new ArrayList<>();}


    /**
     * Add a note at the end of this melody.
     * @param note The note to add
     * @param accidental The accidental of the note
     * @param time The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     * or the time are not valid values.
     */
    public void addNote(Notes note, Accidentals accidental, float time) {
        list.add(new Melody(note, accidental, time));
    }


    /**
     * Returns the note on the given position
     * @param index The position of the note to get.
     * @return The note on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */
    public Notes getNote(int index) {return(list.get(index)).Note;}
    /**
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get.
     * @return The accidental on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */
    public Accidentals getAccidental(int index) {return(list.get(index)).Accidental;}
    /**
     * Returns the duration of the note on the given position
     * @param index The position of the time to get.
     * @return The time on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */
    public float getTime(int index) {return(list.get(index)).time;}
    /**
     * Returns the number of notes in this melody.
     * @return The number of notes in this melody.
     */
    public int size() {
        int i = 0;
        for (Melody melody : list){i++;}
        return i;
    }


    /**
     * Returns the duration of this melody.
     * @return The duration of this melody in milliseconds.
     */
    public float getDuration () {

        float total_time = 0;
        int size = list.size();

        for (Melody melody : list) {
            total_time = total_time + melody.time;
        }
        return total_time;
    }


    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter. Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes.
     * @param o The melody to be compared with the current melody.
     * @return true if the melodies are equals , false otherwise.
     */
  //  @Override
  //  public boolean equals(Melody o) {}


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
    public String toString () {

        StringBuilder Melody_String = new StringBuilder();

        for (Melody melody : list) {
            Melody_String.append(melody.Note);
        }

        return Melody_String.toString();
    }



    public static void main(String args[]){
    }




}