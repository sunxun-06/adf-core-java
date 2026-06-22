public class HelloWorld {
    public static void printTip(String text){
        System.out.println("自定义方法："+text);
    }
    public static void main(String[] args) {
        int count=5;
        double score=95.0;
        String course="Java第三周学习";
        if(score>90){
            System.out.println(course+"成绩优秀");
        }
        else{
            System.out.println(course+"成绩良好");
        }
        System.out.println("循环打印数字");
        for (i=0;<=count;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        printTip("本周作业全部写完");
    }
}