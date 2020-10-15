package threadLesson;

public class Main {

    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public static void main(String s[]) {
        Main exe = new Main();
        exe.runOneThread();
        exe.runTwoThreads();
    }



    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("Расчёт однопоточного массива занял " + (System.currentTimeMillis() - a)+" миллисекунд");
    }

    public void runTwoThreads() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        calculate(arr);
        System.out.println("Просчёт первой половины массива был завершен после "+(System.currentTimeMillis() - a)+" миллисекунд");
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);
        calculate(arr);
        System.out.println("Просчёт второй половины массива был завершен после "+(System.currentTimeMillis() - a)+" миллисекунд");
        System.out.println("Деление целого массива на два было завершено "+(System.currentTimeMillis() - a)+" миллисекунд");


        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("Склейка двух массивов воедино была завершена в "+(System.currentTimeMillis() - a)+" миллисекунд");
;

    }


}
