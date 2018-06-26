package com.springapp.mvc.speech;

import java.io.IOException;

import javax.sound.sampled.*;

import edu.cmu.sphinx.api.*;

public class SpeechRec {

    // Variables
    private String result;

    // Threads
    Thread speechThread;
    Thread resourcesThread;

    // LiveRecognizer
    private LiveSpeechRecognizer recognizer;

    /**
     * Constructor
     */
    public SpeechRec() {

        // Loading Message

        // Configuration
        Configuration configuration = new Configuration();

        // Load model from the jar
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

        // if you want to use LanguageModelPath disable the 3 lines after which
        // are setting a custom grammar->


        // Grammar
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to dictionary.
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        // Set language model.
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");


        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException ex) {
        }

        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);

        // Start the Thread
        startSpeechThread();
        startResourcesThread();
    }

    /**
     * Starting the main Thread of speech recognition
     */
    protected void startSpeechThread() {

        // alive?
        if (speechThread != null && speechThread.isAlive())
            return;

        // initialise
        speechThread = new Thread(() -> {
            try {
                while (true) {
                    /*
                     * This method will return when the end of speech is
                     * reached. Note that the end pointer will determine the end
                     * of speech.
                     */
                    SpeechResult speechResult = recognizer.getResult();
                    if (speechResult != null) {

                        result = speechResult.getHypothesis();
                        System.out.println("You said: [" + result + "]\n");
                        // logger.log(Level.INFO, "You said: " + result + "\n")

                    } else {
                    }

                }
            } catch (Exception ex) {
            }

        });

        // Start
        speechThread.start();

    }

    /**
     * Starting a Thread that checks if the resources needed to the
     * SpeechRecognition library are available
     */
    protected void startResourcesThread() {

        // alive?
        if (resourcesThread != null && resourcesThread.isAlive())
            return;

        resourcesThread = new Thread(() -> {
            try {

                // Detect if the microphone is available
                while (true) {
                    if (AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
                        // logger.log(Level.INFO, "Microphone is available.\n")
                    } else {
                        // logger.log(Level.INFO, "Microphone is not
                        // available.\n")

                    }

                    // Sleep some period
                    Thread.sleep(3500);
                }

            } catch (InterruptedException ex) {
                resourcesThread.interrupt();
            }
        });

        // Start
        resourcesThread.start();
    }

    /**
     * Takes a decision based on the given result
     */
    public void makeDesicion(String result) {
        //implemented in the part 2
    }

    /**
     * Java Main Application Method
     *
     * @param args
     */
    public static void main(String[] args) {

        // // Be sure that the user can't start this application by not giving
        // the
        // // correct entry string
        // if (args.length == 1 && "SPEECH".equalsIgnoreCase(args[0]))
        new SpeechRec();
        // else
        // Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Give me
        // the correct entry string..");

    }

}
