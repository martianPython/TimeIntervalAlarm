import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class AppMain {
    public static void main(String[] args) {

        long delay=5000L;
        String startTime="",currentTime="";long diffMinutes=0;
        while (true){
            System.out.println("Testing the alarm after time interval........................................................");
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


            if(LocalDateTime.now().getHour()%23==0)  {
                if(startTime.isEmpty()){
                    startTime= format.format(new Date());
                }else {
                    currentTime=format.format(new Date());
                    Date d1 = null;
                    Date d2 = null;
                    try {
                        d1 = format.parse(startTime);
                        d2 = format.parse(currentTime);
                        long diff = d2.getTime() - d1.getTime();
                         diffMinutes = diff / (60 * 1000) % 60;
                        if(diffMinutes==3){
                           // System.out.println();
                            startTime= format.format(new Date());
                            File file = new File(FileUtils.getUserDirectoryPath() + "/Desktop/test.txt");
                            FileUtils.writeStringToFile(file, " Will send email now !!!  " + format.format(new Date())+"\n",true);
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }


         //;  System.out.println("The dateTime : " + nowTime);
            System.out.println("The start time " + startTime + "     The curent time " + currentTime + "  The differnce    " + diffMinutes );
            delay(delay);
        }
    }
    private static void delay(long delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
