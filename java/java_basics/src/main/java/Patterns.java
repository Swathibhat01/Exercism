public class Patterns {


    public void printNumberPiramid(int n) {
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }

    public void printAlphabetPyramid(char character){
        for(char c = 'A' ; c <= character ; c++){
            for(char ch = 'A' ; ch <= c ; ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }


    public void printDollarBox(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("$");
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < size-2; i++) {
            System.out.print("$");
            for (int j = 0; j < size+size-1-2; j++) {
                System.out.print(" ");
            }
            System.out.print("$");
            System.out.println();
        }

        for (int i = 0; i < size; i++) {
            System.out.print("$");
            System.out.print(" ");
        }

    }


    }

