package bell.service.rest.FLCart1442.conroller;

import bell.service.rest.FLCart1442.data.WaitTimeGet;
import bell.service.rest.FLCart1442.data.WaitTimeUpdatelink;
import bell.service.rest.FLCart1442.template.TemplatePostFLCart1442;
import bell.service.rest.FLCart1442.template.TemplatePostFLCart1442_2;
import bell.service.rest.FLCart1442.tools.Tools;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Date;


@RestController
public class ControllerFLCard1442 {

    @PostMapping(path = "/api/rb/frsvsc/cspc/v1/updatelink", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost(HttpServletRequest request, HttpServletResponse response) {

        String message="";

        String partyUId="";
        String relatedPartyUId="";

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line).append(System.lineSeparator());

        } catch (Exception e) { /*report an error*/ }

        Date date = new Date();
        System.out.println(date + " FLCard1442 Request Body: " + jb);

        Tools objT = new Tools();
        partyUId = objT.getPartyUId(jb.toString());
        relatedPartyUId = objT.getRelatedPartyUId(jb.toString());

        TemplatePostFLCart1442 objMessage=new TemplatePostFLCart1442();
        message=objMessage.getStrJson(partyUId,relatedPartyUId);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeUpdatelink.timeSleepStubUpdatelink);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " FLCard1442 Response: " + message);

        response.addHeader("server","nginx");
        response.addHeader("expires","0");
        response.addHeader("x-envoy-upstream-service-time","4681");
        response.addHeader("x-ratelimit-limit","-1");
        response.addHeader("end-time","null");
        response.addHeader("jwt","tGzv3JOkF0XG5Qx2TlKWIA");             //random example from web
        response.addHeader("x-frame-options","DENY");
        response.addHeader("x-ratelimit-reset","0");
        response.addHeader("x-ratelimit-remaining","0");
        response.addHeader("pragma","no-cache");
        response.addHeader("strict-transport-security","max-age=31536000 ; includeSubDomains");
        response.addHeader("set-cookie","IG_JSESSIONID=7BE752EB9B09C3E0DACDC4EEB0A302BA; Path=/; Secure; HttpOnly");
        response.addHeader("x-content-type-options","nosniff");
        response.addHeader("x-xss-protection","1; mode=block");
        response.addHeader("cache-control","no-cache, no-store, max-age=0, must-revalidate");

        return new ResponseEntity(message, HttpStatus.OK);

    }

    @PostMapping(path = "/api/rb/frsvsc/cspc/v1/get", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost2(HttpServletRequest request, HttpServletResponse response) {

        String message="";

        String partyUId="";

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line).append(System.lineSeparator());

        } catch (Exception e) { /*report an error*/ }

        Date date2 = new Date();
        System.out.println(date2 + " FLCard1442 Request Body: " + jb);

        Tools objT = new Tools();
        partyUId = objT.getPartyUId(jb.toString());

        TemplatePostFLCart1442_2 objMessage=new TemplatePostFLCart1442_2();
        message=objMessage.getStrJson2(partyUId);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeGet.timeSleepStubGet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date2 + " FLCard1442 Response: " + message);

        response.addHeader("server","nginx");
        response.addHeader("expires","0");
        response.addHeader("x-envoy-upstream-service-time","150");
        response.addHeader("x-ratelimit-limit","-1");
        response.addHeader("end-time","null");
        response.addHeader("jwt","tGzv3JOkF0XG5Qx2TlKWIA");             //random example from web
        response.addHeader("x-frame-options","DENY");
        response.addHeader("x-ratelimit-reset","0");
        response.addHeader("x-ratelimit-remaining","0");
        response.addHeader("pragma","no-cache");
        response.addHeader("strict-transport-security","max-age=31536000 ; includeSubDomains");
        response.addHeader("set-cookie","IG_JSESSIONID=A03D2FEBCA36192DBA38E24B8170A148; Path=/; Secure; HttpOnly");
        response.addHeader("x-content-type-options","nosniff");
        response.addHeader("x-xss-protection","1; mode=block");
        response.addHeader("cache-control","no-cache, no-store, max-age=0, must-revalidate");

        return new ResponseEntity(message, HttpStatus.OK);

    }

    //Установка новой задержек/отклика заглушек
    @GetMapping(value = "/FLCart1442/setTimeSleepUpdatelink/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleepUpdatelink(@PathVariable String timeSleep) {
        WaitTimeUpdatelink.timeSleepStubUpdatelink = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки FL_Card_1442_Updatelink_mock изменено на " + WaitTimeUpdatelink.timeSleepStubUpdatelink);
        return "ok";
    }
    @GetMapping(value = "/FLCart1442/setTimeSleepGet/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleepGet(@PathVariable String timeSleep) {
        WaitTimeGet.timeSleepStubGet = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки FL_Card_1442_Get_mock изменено на " + WaitTimeGet.timeSleepStubGet);
        return "ok";
    }

    //Запросили и вывели в логи текущую задержку
    @GetMapping(value = "/FLCart1442/getTimeSleep", produces = "application/json;charset=UTF-8")
    public String getTimeSleep() {
        Date date = new Date();
        System.out.println(date + " Текущее время задержки FL_Card_1442_Updatelink_mock " + WaitTimeUpdatelink.timeSleepStubUpdatelink);
        System.out.println(date + " Текущее время задержки FL_Card_1442_Get_mock " + WaitTimeGet.timeSleepStubGet);
        return " Текущее время задержки FL_Card_1442_Get_mock (ms) "+WaitTimeGet.timeSleepStubGet + "\n" +
                " Текущее время задержки FL_Card_1442_Updatelink_mock (ms) "+WaitTimeUpdatelink.timeSleepStubUpdatelink;
    }

}