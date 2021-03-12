import java.time.ZonedDateTime;

public class GetTime {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); //默认时区
        System.out.println(zbj);

        //2020-10-01T17:17:43.991+08:00[Asia/Shanghai] 
    }
}
