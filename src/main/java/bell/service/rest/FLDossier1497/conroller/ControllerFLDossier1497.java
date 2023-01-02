package bell.service.rest.FLDossier1497.conroller;

import bell.service.rest.FLDossier1497.data.WaitTimeFLDossier1497Find;
import bell.service.rest.FLDossier1497.data.WaitTimeFLDossier1497Register;
import bell.service.rest.FLDossier1497.template.TemplatePostFLDossier1497;
import bell.service.rest.FLDossier1497.template.TemplatePostFLDossier1497_2;
import bell.service.rest.FLDossier1497.tools.ToolsFLDossier1497;
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
public class ControllerFLDossier1497 {

    @PostMapping(path = "/api/cross/dose/document-search-person/v1/find", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost(HttpServletRequest request, HttpServletResponse response) {

        String message="";

        String requestID="";

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line).append(System.lineSeparator());

        } catch (Exception e) { /*report an error*/ }

        Date date = new Date();
        System.out.println(date + " FLDossier1497 Request Body: " + jb);

        ToolsFLDossier1497 objT = new ToolsFLDossier1497();
        requestID = objT.getRequestId(jb.toString());

        TemplatePostFLDossier1497 objMessage=new TemplatePostFLDossier1497();
        message=objMessage.getStrJson(requestID);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeFLDossier1497Find.timeSleepStubFind);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " FLDossier1497 Response: " + message);

        response.addHeader("server","nginx");
        response.addHeader("expires","0");
        response.addHeader("x-ratelimit-limit","-1");
        response.addHeader("end-time","null");
        response.addHeader("jwt","tGzv3JOkF0XG5Qx2TlKWIA");             //random example from web
        response.addHeader("x-frame-options","DENY");
        response.addHeader("x-ratelimit-reset","0");
        response.addHeader("x-ratelimit-remaining","0");
        response.addHeader("pragma","no-cache");
        response.addHeader("strict-transport-security","max-age=63072000; includeSubDomains; preload");
        response.addHeader("set-cookie","IG_JSESSIONID=2F541BB1D136B20781AA8EB07BA12269; Path=/; Secure; HttpOnly");
        response.addHeader("x-content-type-options","nosniff");
        response.addHeader("x-xss-protection","1; mode=block");
        response.addHeader("cache-control","no-cache, no-store, max-age=0, must-revalidate");

        return new ResponseEntity(message, HttpStatus.OK);

    }

    @PostMapping(path = "/api/cross/dose/checkin-universal-person/v1/register", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost2(HttpServletRequest request, HttpServletResponse response) {

        String message="";

        String requestId="";

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line).append(System.lineSeparator());

        } catch (Exception e) { /*report an error*/ }

        Date date2 = new Date();
        System.out.println(date2 + " FLDossier1497 Request Body: " + jb);

        ToolsFLDossier1497 objT = new ToolsFLDossier1497();
        requestId = objT.getRequestId(jb.toString());

        TemplatePostFLDossier1497_2 objMessage=new TemplatePostFLDossier1497_2();
        message=objMessage.getStrJson2(requestId);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeFLDossier1497Register.timeSleepStubRegister);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date2 + " FLDossier1497 Response: " + message);

        response.addHeader("server","nginx");
        response.addHeader("expires","0");
        response.addHeader("x-ratelimit-limit","-1");
        response.addHeader("end-time","null");
        response.addHeader("jwt","tGzv3JOkF0XG5Qx2TlKWIA");             //random example from web
        response.addHeader("x-frame-options","DENY");
        response.addHeader("x-ratelimit-reset","0");
        response.addHeader("x-ratelimit-remaining","0");
        response.addHeader("pragma","no-cache");
        response.addHeader("strict-transport-security","max-age=63072000; includeSubDomains; preload");
        response.addHeader("set-cookie","IG_JSESSIONID=3F32BCC750EB0E06598DB77C89ACF7EF; Path=/; Secure; HttpOnly");
        response.addHeader("x-content-type-options","nosniff");
        response.addHeader("x-xss-protection","1; mode=block");
        response.addHeader("cache-control","no-cache, no-store, max-age=0, must-revalidate");

        return new ResponseEntity(message, HttpStatus.OK);

    }

    //Установка новой задержек/отклика заглушек
    @GetMapping(value = "/FLDossier1497/setTimeSleepFind/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleepFind(@PathVariable String timeSleep) {
        WaitTimeFLDossier1497Find.timeSleepStubFind = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки FLDossier1497_Find_mock изменено на " + WaitTimeFLDossier1497Find.timeSleepStubFind);
        return "ok";
    }

    @GetMapping(value = "/FLDossier1497/setTimeSleepRegister/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleepRegister(@PathVariable String timeSleep) {
        WaitTimeFLDossier1497Register.timeSleepStubRegister = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки FLDossier1497_Register_mock изменено на " + WaitTimeFLDossier1497Register.timeSleepStubRegister);
        return "ok";
    }

    //Запросили и вывели в логи текущую задержку
    @GetMapping(value = "/FLDossier1497/getTimeSleep", produces = "application/json;charset=UTF-8")
    public String getTimeSleep() {
        Date date = new Date();
        System.out.println(date + " Текущее время задержки FLDossier1497_Find_mock " + WaitTimeFLDossier1497Find.timeSleepStubFind);
        System.out.println(date + " Текущее время задержки FLDossier1497_Register_mock " + WaitTimeFLDossier1497Register.timeSleepStubRegister);
        return " Текущее время задержки FLDossier1497_Find_mock " + WaitTimeFLDossier1497Find.timeSleepStubFind + "\n" + " Текущее время задержки FLDossier1497_Register_mock " + WaitTimeFLDossier1497Register.timeSleepStubRegister;
    }

}