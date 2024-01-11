/*
 * I used Chat-GPT to get an outline for a turing machine 
 * simulation and then completely reworked it to match my TM. 
 */

public class TuringMachineSimulation {
    public static void main(String args[]) {
        // Test the Turing machine with an input string
        String inputString = args[0];
        turingMachine(inputString);
    }

    public static void turingMachine(String inputString) {
        // Initialize tape, head position, and current state
        char[] tape = inputString.toCharArray();
        char[] tapeWithBlank = new char[tape.length + 1];
        for (int i = 0; i < tape.length; i++) {
            tapeWithBlank[i] = tape[i];
        }
        tapeWithBlank[tape.length] = '_'; // Blank symbol to signify end of tape since TM tape has infinite blanks

        int head = 0; // Read/Write Head at start of Input
        String state = "q0"; // Initial state

        // Run the Turing machine until it halts
        while (!(state.equals("qaccept") || state.equals("qreject"))) {
            System.out.print("State: " + state + "  ");
            System.out.print("Tape: ");

            for (int i = 0; i < tapeWithBlank.length - 1; i++) {
                System.out.print(tapeWithBlank[i]);
            }

            System.out.print("    Tape Head : " + head + "  ");
            System.out.println();
            System.out.println();

            // Perform transitions based on the current state and symbol
            if (state.equals("q0")) {
                if ((tapeWithBlank[head] == 'a')) {
                    head++;
                    state = "q1";
                } else if ((tapeWithBlank[head] == 'b')) {
                    head++;
                    state = "q5";
                } else if ((tapeWithBlank[head] == '_')) {
                    tapeWithBlank[head] = 'a';
                    head++;
                    state = "qaccept";
                }
            } else if (state == "q1") {
                if ((tapeWithBlank[head] == 'a')) {
                    head++;
                    state = "q1";
                } else if ((tapeWithBlank[head] == 'b')) {
                    head++;
                    state = "q1";
                } else if ((tapeWithBlank[head] == '_')) {
                    tapeWithBlank[head] = '_';
                    head--;
                    state = "q2";
                }
            } else if (state == "q2") {
                if ((tapeWithBlank[head] == 'a')) {
                    head++;
                    state = "q3";
                } else if ((tapeWithBlank[head] == 'b')) {
                    head++;
                    state = "q4";
                } else if ((tapeWithBlank[head] == '_')) {
                    tapeWithBlank[head] = '_';
                    head++;
                    state = "qreject";
                }
            } else if (state == "q3") {
                if ((tapeWithBlank[head] == 'a')) {
                    head++;
                    state = "qreject";
                } else if ((tapeWithBlank[head] == 'b')) {
                    head++;
                    state = "qreject";
                } else if ((tapeWithBlank[head] == '_')) {
                    tapeWithBlank[head] = 'a';
                    head++;
                    state = "qaccept";
                }
            } else if (state == "q4") {
                if ((tapeWithBlank[head] == 'a')) {
                    head++;
                    state = "qreject";
                } else if ((tapeWithBlank[head] == 'b')) {
                    head++;
                    state = "qreject";
                } else if ((tapeWithBlank[head] == '_')) {
                    tapeWithBlank[head] = 'b';
                    head++;
                    state = "qaccept";
                }
            } else if (state == "q5") {
                if ((tapeWithBlank[head] == 'a')) {
                    head++;
                    state = "qreject";
                } else if ((tapeWithBlank[head] == 'b')) {
                    head++;
                    state = "qreject";
                } else if ((tapeWithBlank[head] == '_')) {
                    head--;
                    state = "q6";
                }
            } else if (state == "q6") {
                if ((tapeWithBlank[head] == 'a')) {
                    head++;
                    state = "qreject";
                } else if ((tapeWithBlank[head] == 'b')) {
                    tapeWithBlank[head] = ' ';
                    head++;
                    state = "qaccept";
                } else if ((tapeWithBlank[head] == '_')) {
                    head--;
                    state = "qreject";
                }
            } else {
                state = "qreject";
            }
        }
        System.out.println("Final State of TM");
        // Display the final state of the Turing machine
        System.out.println("State: " + state);
        System.out.print("Tape: ");

        for (int i = 0; i < tapeWithBlank.length; i++) {
            System.out.print(tapeWithBlank[i]);
        }
        System.out.print("    Tape Head : " + head + "  ");
        System.out.println();
        System.out.println();
    }
}