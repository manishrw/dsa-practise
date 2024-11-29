package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M2502Test {

        @Test
        void test1() {
            var commands = new String[] {"Allocator","allocate","allocate","allocate","freeMemory"};
            var inputs = new int[][] {{10},{1,1},{1,2},{1,3},{2}};
            var outputs = new int[] {0,0,1,2,1};
            executeTests(commands, inputs, outputs);
        }

        @Test
        void test2() {
            var commands = new String[] {"Allocator","allocate","allocate","allocate","allocate","freeMemory","freeMemory","freeMemory","allocate","allocate","allocate","allocate","freeMemory","freeMemory","freeMemory","freeMemory","freeMemory","freeMemory","freeMemory","allocate","freeMemory","freeMemory","allocate","freeMemory","allocate","allocate","freeMemory","freeMemory","freeMemory","allocate","allocate","allocate","allocate","freeMemory","allocate","freeMemory","freeMemory","allocate","allocate","allocate","allocate","allocate","allocate","allocate","freeMemory","freeMemory","freeMemory","freeMemory"};
            var inputs = new int[][] {{50},{12,6},{28,16},{17,23},{50,23},{6},{10},{10},{16,8},{17,41},{44,27},{12,45},{33},{8},{16},{23},{23},{23},{29},{38,32},{29},{6},{40,11},{16},{22,33},{27,5},{3},{10},{29},{16,14},{46,47},{48,9},{36,17},{33},{14,24},{16},{8},{2,50},{31,36},{17,45},{46,31},{2,6},{16,2},{39,30},{33},{45},{30},{27}};
            var outputs = new int[] {0,0,12,-1,-1,12,0,0,-1,-1,-1,0,0,0,28,0,0,0,0,12,0,0,-1,0,-1,-1,0,0,0,-1,-1,-1,-1,0,-1,0,0,-1,-1,-1,-1,-1,-1,-1,0,12,0,0};
            executeTests(commands, inputs, outputs);
        }

        @Test
        void test3() {
            var commands = new String[]{"Allocator", "freeMemory", "freeMemory", "freeMemory", "freeMemory", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "freeMemory", "freeMemory", "allocate", "allocate", "freeMemory", "freeMemory", "freeMemory", "allocate", "allocate", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "freeMemory", "freeMemory", "freeMemory", "freeMemory", "freeMemory", "freeMemory", "allocate", "freeMemory", "allocate", "freeMemory", "allocate", "allocate", "freeMemory", "allocate", "allocate", "freeMemory", "freeMemory", "allocate", "freeMemory", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "allocate", "allocate", "freeMemory", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "allocate", "allocate", "freeMemory", "freeMemory", "freeMemory", "allocate", "freeMemory", "freeMemory", "freeMemory", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "allocate", "freeMemory", "freeMemory", "allocate", "freeMemory", "allocate", "freeMemory", "freeMemory"};
            var inputs = new int[][] {{100},{27},{12},{53},{61},{80},{21,78},{81,40},{50,76},{40},{76},{63},{25,100},{96,12},{92},{92},{84},{19,71},{22,90},{60},{42,79},{26,41},{59,33},{79},{58},{97},{92},{97},{92},{40},{52,74},{40},{53,17},{17},{36,32},{51,13},{41},{5,87},{44,66},{71},{53},{74,14},{78},{14},{32,54},{45,28},{84,47},{16},{100,78},{5,99},{33},{100},{62,79},{31,32},{85,81},{78},{34,45},{47,7},{7},{84},{6},{35,55},{94},{87},{20},{87},{96,60},{40,66},{28,96},{28},{25,2},{100},{96},{19,35},{16},{92,42},{80},{79}};
            var outputs = new int[] {0,0,0,0,0,0,0,-1,21,0,50,0,21,-1,0,0,0,46,65,0,-1,-1,-1,0,0,0,0,0,0,0,-1,0,-1,0,-1,-1,0,87,-1,19,0,-1,21,0,-1,-1,-1,0,-1,0,0,25,-1,5,-1,0,-1,-1,0,0,0,-1,0,5,0,0,-1,-1,36,0,-1,0,28,36,0,-1,0,0};
        }

        private void executeTests(String[] commands, int[][] inputs, int[] outputs) {
            int n = inputs.length;
            M2502 solution = new M2502(0);
            for (int i = 0; i < n; i++) {
                var command = commands[i];
                var input = inputs[i];
                var output = outputs[i];
                switch (command) {
                    case "Allocator":
                        solution = new M2502(input[0]);
                        break;
                    case "allocate":
                        assertEquals(output, solution.allocate(input[0], input[1]), "i: " + i + ", command: " + command + ", input: " + input[0] + ", " + input[1] + solution);
                        break;
                    case "freeMemory":
                        assertEquals(output, solution.freeMemory(input[0]), "i: " + i + ", command: " + command + ", input: " + input[0] + solution);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid command: " + command);
                }
            }
        }

}