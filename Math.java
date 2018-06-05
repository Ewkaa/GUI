package Gui;

public class Math {
    public  Math() {
    }
        public double[][] array = new double[5][5];


        public double[][] get_array () {
            double[][] get_array = new double[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    get_array[i][j] = array[i][j];
                }
            }
            return get_array;
        }

        public void set_array ( double liczba, int a, int b){
            array[a][b] = liczba;
        }


//----------------------MATH - TABLE SUM--------------------
        public double Sum () {
            double wynik = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    wynik = wynik + array[i][j];
                    System.out.print(array[i][j]+" ");
                }
                System.out.println("");
            }
            return wynik;
        }
        //----------------------MATH - TABLE AVERAGE--------------------
        public double Average () {
            double wynik = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    wynik = wynik + array[i][j];
                }
            }
            wynik = wynik / 25;
            return wynik;
        }
    //----------------------MATH - TABLE MAX AND MIN-------------------
        public double[] MaxMin () {
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    if (array[i][j] > max) {
                        max = array[i][j];
                    }

                    if (array[i][j] < min) {
                        min = array[i][j];
                    }
                }
            }
            double[] result = new double[2];
            result[0] = min;
            result[1] = max;
            return result;
        }
    //----------------------WRITE TO TABLE--------------------
        public void write ( int row, int column, String value){
            array[row][column] = Double.parseDouble(value);
        }
    //----------------------CLEAR TABLE--------------------
        public void ClearArray ( int a, int b){
            array[a][b] = 0;
        }

    }