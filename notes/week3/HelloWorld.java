public class HelloWorld {
    public static void main(String[] args) {
        int loopCount = 4;
        double score = 88.5;
        boolean isComplete = true;
        if (isComplete && score >= 80) {
            System.out.println("作业完成，当前得分：" + score);
        } else {
            System.out.println("作业未达标，需要修改完善");
        }
        System.out.println("\n循环输出：");
        for (int i = 1; i <= loopCount; i++) {
            printLine(i);
        }
    }
    private static void printLine(int num) {
        System.out.println("第" + num + "次循环打印");
    }
}