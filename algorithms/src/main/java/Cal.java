import org.junit.Test;

/**
 * Created by hxchen on 2018/6/27.
 */
public class Cal {

    @Test
    public void cal() {
        int sum = 0;
        for (int i = 1; i < 20; i++) {
            if (i % 2 == 1) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

    @Test
    public void cal2() {
        int sum = 0;
        for (int i = 1; i < 20; i++) {
            if (i % 2 == 1) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
