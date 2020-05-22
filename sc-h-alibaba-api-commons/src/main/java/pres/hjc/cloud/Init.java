package pres.hjc.cloud;

import java.util.Arrays;
import java.util.stream.DoubleStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/10
 * @time 19:52
 */
public class Init {


    private static double f(char f,double ... num){
        DoubleStream stream = Arrays.stream(num);
        switch (f){
            case '+':
                return stream.sum();
            case '-':
                return num[0] - num[1];
            case '*':
                return num[0] * num[1];
            case '/':
                return num[0] / num[1];
            default:
                return 0;
        }
    }
}
