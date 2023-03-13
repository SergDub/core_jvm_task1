public class JvmComprehension {// Класс JvmComprehension загружается в ClassLoader и перемещается в Metaspace для сохранения данных о классе


    public static void main(String[] args) { // При вызове метода main создается фрейм в Stack memory.

        int i = 1;                      // 1 Во фрейме main создается переменная i, ей присваивается значение 1.
        Object o = new Object();        // 2 В Heap создается объект Object, во фрейме main создается переменная o, которой присваивается ссылка на этот объект

        Integer ii = 2;                 // 3 В Heap создается объект Integer со значением 2, во фрейме main появляется переменная ii со ссылкой на этот объект

        printAll(o, i, ii);             // 4 В Stack memory создается фрейм printAll, в котором создаются переменные, значениями которых будут являться ссылки на объекты o, i и ii

        System.out.println("finished"); // 7 В Stack memory создается фрейм println, которому передается ссылка на созданный в Heap объект String со значением "finished".

    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В Heap создается объект Integer со значением 700, во фрейме printAll появляется переменная uselessVar со ссылкой на этот объект.

        System.out.println(o.toString() + i + ii);  // 6 В Stack memory создается фрейм println, куда передаются ссылки на Object o, int i и Integer ii.
        // В Stack memory создается фрейм toString.
    }
    // Во время работы программы работает сборщик мусора
}