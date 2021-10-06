package e3;
import javax.swing.*;
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
    @Override
    public boolean equals(Object o) {
        if (this == o ){return true;}
        if (o == null){return false;}
        if (this.getClass() != o.getClass()){return false;}

        for (int i = 0; i< list.size(); i++){

            Melody o_mel = ((Melody) o).list.get(i);
            Melody cur_mel = list.get(i);

            if(cur_mel.Note == null){return false;}
            if(o_mel.Note == null){return false;}
            if(cur_mel.Accidental == null){return false;}
            if(o_mel.Accidental == null){return false;}
            if(cur_mel.time <= 0){return false;}
            if(o_mel.time <= 0){return false;}
            if(cur_mel.time != o_mel.time){return false;}

            if((cur_mel.time == o_mel.time)&&(cur_mel.Accidental == o_mel.Accidental)&&(cur_mel.Note==o_mel.Note)){continue;}

            if((((o_mel.Note == Notes.MI)&&(cur_mel.Note == Notes.FA))||((o_mel.Note == Notes.FA)&&(cur_mel.Note == Notes.MI))||
                ((o_mel.Note == Notes.SI)&&(cur_mel.Note == Notes.DO))||((o_mel.Note == Notes.DO)&&(cur_mel.Note== Notes.SI)))){

                    if((((o_mel.Accidental != Accidentals.SHARP)&&(o_mel.Note)== Notes.MI)||
                            ((cur_mel.Accidental != Accidentals. SHARP)&&(cur_mel.Note)==Notes.MI))&&
                            ((((o_mel.Accidental != Accidentals.FLAT)&&(o_mel.Note)== Notes.FA)||
                            ((cur_mel.Accidental != Accidentals. FLAT)&&(cur_mel.Note)==Notes.FA))))
                         return false;

                    if((((o_mel.Accidental != Accidentals.SHARP)&&(o_mel.Note)== Notes.SI)||
                            ((cur_mel.Accidental != Accidentals. SHARP)&&(cur_mel.Note)==Notes.SI))&&
                            (((o_mel.Accidental != Accidentals.FLAT)&&(o_mel.Note)== Notes.DO)||
                            ((cur_mel.Accidental != Accidentals. FLAT)&&(cur_mel.Note)==Notes.DO)))
                        return false;

            }else {
                    if (((o_mel.Accidental != Accidentals.FLAT) || (cur_mel.Accidental != Accidentals.SHARP)) &&
                            ((o_mel.Accidental != Accidentals.SHARP) || (cur_mel.Accidental != Accidentals.FLAT)))
                        return false;

             }
        }
        return true;
    }

    /**
     * Returns an integer that is a hash code representation of the melody.
     * Two melodies m1 , m2 that are equals (m1.equals(m2) == true) must
     * have the same hash code.
     * @return The hash code of this melody.
     */
    @Override
    public int hashCode () {
        return 0;
    }


    /**
     * The string representation of this melody.
     * @return The String representantion of this melody.
     */
    @Override
    public String toString () {

        int i = 1;
        StringBuilder Melody_String = new StringBuilder();

        for (Melody melody : list) {
            Melody_String.append(melody.Note);
            switch (melody.Accidental) {
                case FLAT -> Melody_String.append("b");
                case SHARP -> Melody_String.append("#");
                default -> {}
            }
            Melody_String.append("(");
            Melody_String.append(melody.time);

            if(i< list.size()){ Melody_String.append(") ");}
            else {Melody_String.append(")");}
            i++;
        }
        return Melody_String.toString();
    }



    public static void main(String args[]){}
}