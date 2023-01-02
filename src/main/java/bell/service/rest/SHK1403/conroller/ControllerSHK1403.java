package bell.service.rest.SHK1403.conroller;

import bell.service.rest.SHK1403.data.WaitTimeSHK1403ExpirationDate;
import bell.service.rest.SHK1403.data.WaitTimeSHK1403Files;
import bell.service.rest.SHK1403.data.WaitTimeSHK1403Transfer;
import bell.service.rest.SHK1403.template.TemplateSHK1403;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@RestController
public class ControllerSHK1403 {

    @DeleteMapping(path = "/files-info/{uuid}/expiration-date", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost(@PathVariable String uuid, HttpServletResponse response) {

        String message="";

        Date date = new Date();
        System.out.println(date + " SHK1403 DELETE "+uuid+"/expiration-date ");

        TemplateSHK1403 objMessage=new TemplateSHK1403();
        message=objMessage.getStrJson(uuid);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeSHK1403ExpirationDate.timeSleepStubSHK1403ExpirationDate);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " SHK1403 Response: " + message);

        response.addHeader("server","istio-envoy");
        response.addHeader("expires","0");
        response.addHeader("x-envoy-upstream-service-time","41");
        response.addHeader("transfer-encoding","chunked");
        response.addHeader("x-content-type-options","nosniff");
        response.addHeader("x-xss-protection","1; mode=block");
        response.addHeader("x-frame-options","DENY");
        response.addHeader("cache-control","no-cache, no-store, max-age=0, must-revalidate");
        response.addHeader("pragma","no-cache");
        response.addHeader("strict-transport-security","max-age=31536000 ; includeSubDomains");

        return new ResponseEntity(message, HttpStatus.OK);

    }

    @PutMapping(path = "/folder/DOSE/files", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost2(@RequestParam String uuids,@RequestParam String folderOwner, HttpServletResponse response) {

        Date date = new Date();
        System.out.println(date + " SHK1403 Request: PUT \"uuids\":\""+uuids+"\",\"folderOwner\":\""+folderOwner+"\" ");

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeSHK1403Files.timeSleepStubSHK1403Files);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " SHK1403 Response: 204 PUT \"uuids\":\""+uuids+"\",\"folderOwner\":\""+folderOwner+"\" ");

        response.addHeader("server","istio-envoy");
        response.addHeader("expires","0");
        response.addHeader("x-envoy-upstream-service-time","71");
        response.addHeader("x-content-type-options","nosniff");
        response.addHeader("x-xss-protection","1; mode=block");
        response.addHeader("x-frame-options","DENY");
        response.addHeader("cache-control","no-cache, no-store, max-age=0, must-revalidate");
        response.addHeader("pragma","no-cache");
        response.addHeader("strict-transport-security","max-age=31536000 ; includeSubDomains");

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping(path = "/permission-sharings/transfer", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost3(@RequestParam String serviceTo,@RequestParam String uuid, HttpServletResponse response) {

        Date date = new Date();
        System.out.println(date + " SHK1403 Request: Post \"serviceTo\":\""+serviceTo+"\",\"uuid\":\""+uuid+"\" ");

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeSHK1403Transfer.timeSleepStubSHK1403Transfer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " SHK1403 Response: 204 Post \"serviceTo\":\""+serviceTo+"\",\"uuid\":\""+uuid+"\" ");

        response.addHeader("server","istio-envoy");
        response.addHeader("expires","0");
        response.addHeader("x-envoy-upstream-service-time","31");
        response.addHeader("x-content-type-options","nosniff");
        response.addHeader("x-xss-protection","1; mode=block");
        response.addHeader("x-frame-options","DENY");
        response.addHeader("cache-control","no-cache, no-store, max-age=0, must-revalidate");
        response.addHeader("pragma","no-cache");
        response.addHeader("strict-transport-security","max-age=31536000 ; includeSubDomains");

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    //Установка новой задержек/отклика заглушек
    @GetMapping(value = "/SHK1403ExpirationDate/setTimeSleep/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleepExpirationDate(@PathVariable String timeSleep) {
        WaitTimeSHK1403ExpirationDate.timeSleepStubSHK1403ExpirationDate = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки SHK1403ExpirationDate_mock изменено на " + WaitTimeSHK1403ExpirationDate.timeSleepStubSHK1403ExpirationDate);
        return "ok";
    }

    @GetMapping(value = "/SHK1403Files/setTimeSleep/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleepFiles(@PathVariable String timeSleep) {
        WaitTimeSHK1403Files.timeSleepStubSHK1403Files = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки SHK1403Files_mock изменено на " + WaitTimeSHK1403Files.timeSleepStubSHK1403Files);
        return "ok";
    }

    @GetMapping(value = "/SHK1403Transfer/setTimeSleep/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleepTransfer(@PathVariable String timeSleep) {
        WaitTimeSHK1403Transfer.timeSleepStubSHK1403Transfer = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки SHK1403Transfer_mock изменено на " + WaitTimeSHK1403Transfer.timeSleepStubSHK1403Transfer);
        return "ok";
    }

    //Запросили и вывели в логи текущую задержку
    @GetMapping(value = "/SHK1403/getTimeSleep", produces = "application/json;charset=UTF-8")
    public String getTimeSleep() {
        Date date = new Date();
        System.out.println(date + " Текущее время задержки SHK1403ExpirationDate_mock " + WaitTimeSHK1403ExpirationDate.timeSleepStubSHK1403ExpirationDate);
        System.out.println(date + " Текущее время задержки SHK1403Files_mock " + WaitTimeSHK1403Files.timeSleepStubSHK1403Files);
        System.out.println(date + " Текущее время задержки SHK1403Transfer_mock " + WaitTimeSHK1403Transfer.timeSleepStubSHK1403Transfer);
        return " Текущее время задержки SHK1403ExpirationDate_mock (ms) " + WaitTimeSHK1403ExpirationDate.timeSleepStubSHK1403ExpirationDate + "\n" +
                " Текущее время задержки SHK1403Files_mock (ms) " + WaitTimeSHK1403Files.timeSleepStubSHK1403Files + "\n" +
                " Текущее время задержки SHK1403Transfer_mock (ms) " + WaitTimeSHK1403Transfer.timeSleepStubSHK1403Transfer;
    }

}